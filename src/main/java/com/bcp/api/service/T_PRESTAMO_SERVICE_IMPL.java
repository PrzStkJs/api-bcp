package com.bcp.api.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.api.dto.PrestamoSolicitudDTO;
import com.bcp.api.model.CAT_MEDIO_OPERACION;
import com.bcp.api.model.CAT_MONEDA;
import com.bcp.api.model.CAT_SERVICIO_TRANSACCION;
import com.bcp.api.model.TRX_TRANSACCION;
import com.bcp.api.model.T_CLIENTE;
import com.bcp.api.model.T_PRESTAMO;
import com.bcp.api.model.T_CUENTA_BANCARIA;
import com.bcp.api.model.CAT_TIPO_PRESTAMO;
import com.bcp.api.model.CAT_TIPO_TRANSACCION;
import com.bcp.api.repository.CAT_TIPO_PRESTAMO_REPOSITORY;
import com.bcp.api.repository.TRX_TRANSACCION_REPOSITORY;
import com.bcp.api.repository.T_CLIENTE_REPOSITORY;
import com.bcp.api.repository.T_CUENTA_BANCARIA_REPOSITORY;
import com.bcp.api.repository.T_PRESTAMO_REPOSITORY;

import jakarta.transaction.Transactional;

@Service
public class T_PRESTAMO_SERVICE_IMPL implements T_PRESTAMO_SERVICE {

    @Autowired
    private T_PRESTAMO_REPOSITORY repository;

    @Autowired
    private T_CUENTA_BANCARIA_REPOSITORY cuentaRepo;

    @Autowired
    private T_CLIENTE_REPOSITORY clienteRepo;

    @Autowired
    private TRX_TRANSACCION_REPOSITORY transaccionRepo;

    @Autowired
    private CAT_TIPO_PRESTAMO_REPOSITORY tipoPrestamoRepo;

    @Override
    public List<T_PRESTAMO> listarTodos() {
        return repository.findAll();
    }

    @Override
    public T_PRESTAMO guardar(T_PRESTAMO objeto) {
        return repository.save(objeto);
    }

    @Override
    @Transactional
    public String procesarSolicitudPrestamo(PrestamoSolicitudDTO dto) {

        System.out.println("DEBUG: Iniciando préstamo para Persona ID: " + dto.per_n_id);

        if (dto.per_n_id == null || dto.per_n_id == 0) {
            return "ERROR_FRONT: El campo per_n_id llegó vacío a la API";
        }

        // 1. BUSCAR ENTIDADES
        T_CUENTA_BANCARIA cuentaReal = cuentaRepo.findByCUE_V_NUMERO(dto.numeroCuentaDestino)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        CAT_TIPO_PRESTAMO tipoReal = tipoPrestamoRepo.findById(dto.tipoPrestamoId)
                .orElseThrow(() -> new RuntimeException("Tipo de préstamo no válido"));

        T_CLIENTE clienteReal = clienteRepo.findByPersonaId(dto.per_n_id);
        
        if (clienteReal == null) {
            throw new RuntimeException("El cliente no existe para esta persona");
        }

        // 2. LÓGICA DE MONEDA Y CÁLCULOS
        double tipoCambio = 3.80; 
        double montoFinalParaDeposito = dto.monto; 
        String prefijoTrx = "PEN";
        String simbolo = "S/";

        if (dto.monedaId != null && dto.monedaId == 2) {
            montoFinalParaDeposito = dto.monto * tipoCambio;
            prefijoTrx = "USD a PEN";
            simbolo = "$";
        }

        double tasaAnual = 12.0; 
        double tasaMensual = (tasaAnual / 100) / 12;
        double cuota = (dto.monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -dto.meses));

        // 3. CALCULAR FECHA DE VENCIMIENTO
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, dto.meses);
        Date fechaVencimientoFinal = cal.getTime();

        // 4. MAPEAR EL PRÉSTAMO
        T_PRESTAMO nuevoPrestamo = new T_PRESTAMO();
        nuevoPrestamo.setPRE_N_MONTO(dto.monto);
        nuevoPrestamo.setPRE_N_TASA_INTERES(tasaAnual);
        nuevoPrestamo.setPRE_N_PLAZO_MESES(dto.meses);
        nuevoPrestamo.setPRE_N_CUOTA_MENSUAL(cuota);
        nuevoPrestamo.setPRE_V_ESTADO("A");
        nuevoPrestamo.setPRE_V_GARANTIA(dto.garantia);
        nuevoPrestamo.setPRE_D_FECHA_INICIO(new Date());
        nuevoPrestamo.setPRE_D_FECHA_VENCIMIENTO(fechaVencimientoFinal); // <--- FECHA LISTA
        
        nuevoPrestamo.setCliente(clienteReal);
        nuevoPrestamo.setTipoPrestamo(tipoReal);
        
        CAT_MONEDA monedaSeleccionada = new CAT_MONEDA();
        monedaSeleccionada.setMON_N_ID(dto.monedaId); 
        nuevoPrestamo.setMoneda(monedaSeleccionada);

        // 5. GUARDAR PRÉSTAMO Y ACTUALIZAR SALDO (Una sola vez)
        repository.save(nuevoPrestamo);
        
        cuentaReal.setCUE_N_SALDO(cuentaReal.getCUE_N_SALDO() + montoFinalParaDeposito);
        cuentaRepo.save(cuentaReal);

        // 6. REGISTRAR HISTORIAL (TRX_TRANSACCION)
        TRX_TRANSACCION trx = new TRX_TRANSACCION();
        trx.setCuentaDestino(cuentaReal);
        trx.setCuentaOrigen(cuentaReal);
        trx.setTRX_N_MONTO(montoFinalParaDeposito);
        trx.setTRX_V_REFERENCIA("DESEMBOLSO " + prefijoTrx + ": " + tipoReal.getTPR_V_NOMBRE());
        trx.setTRX_D_FECHA_HORA(new Date());
        trx.setTRX_V_ESTADO("A");
        
        // Catálogos obligatorios para evitar ORA-01400
        CAT_TIPO_TRANSACCION ttx = new CAT_TIPO_TRANSACCION();
        ttx.setTTX_N_ID(1); 
        trx.setTipoTransaccion(ttx);

        CAT_SERVICIO_TRANSACCION stx = new CAT_SERVICIO_TRANSACCION();
        stx.setSTX_N_ID(1); 
        trx.setServicioTransaccion(stx);

        CAT_MEDIO_OPERACION mop = new CAT_MEDIO_OPERACION();
        mop.setMOP_N_ID(3); 
        trx.setMedioOperacion(mop);

        CAT_MONEDA mon = new CAT_MONEDA();
        mon.setMON_N_ID(1); 
        trx.setMoneda(mon);
        
        transaccionRepo.save(trx);

     // 6. PREPARAR MENSAJE DE SALIDA TIPO VOUCHER
        String fechaVenc = nuevoPrestamo.getPRE_D_FECHA_VENCIMIENTO().toString();
        
        String baucher = "\n" +
                "==============================\n" +
                "       BCP - CONFIRMACIÓN      \n" +
                "==============================\n" +
                "ESTADO:      EXITOSO\n" +
                "OPERACIÓN:   DESEMBOLSO\n" +
                "------------------------------\n" +
                "MONTO:       " + simbolo + " " + dto.monto + "\n" + // <--- AQUÍ USA EL SÍMBOLO DINÁMICO
                "CUOTA:       " + simbolo + " " + String.format("%.2f", cuota) + "\n" + // <--- AQUÍ TAMBIÉN
                "VENCE:       " + fechaVenc + "\n" +
                "CUENTA:      " + cuentaReal.getCUE_V_NUMERO() + "\n" +
                "------------------------------\n" +
                "¡Gracias por usar banca BCP!";

        return baucher;
    }
}