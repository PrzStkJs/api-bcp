package com.bcp.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcp.api.dto.CuentaDetalleDTO; // 🔥 Asegúrate de tener este DTO creado
import com.bcp.api.dto.HomeResumenDTO;
import com.bcp.api.dto.PagoServicioDTO;
import com.bcp.api.dto.TransferenciaDTO;
import com.bcp.api.model.T_CUENTA_BANCARIA;
import com.bcp.api.model.T_PERSONA;
import com.bcp.api.model.T_CLIENTE; // 🔥 Importamos el modelo Cliente
import com.bcp.api.model.T_TARJETA; 
import com.bcp.api.model.CAT_TIPO_CUENTA_BANCARIA;
import com.bcp.api.model.CAT_TIPO_TRANSACCION;
import com.bcp.api.model.TRX_TRANSACCION;
import com.bcp.api.model.CAT_MEDIO_OPERACION;
import com.bcp.api.model.CAT_MONEDA;
import com.bcp.api.model.CAT_SERVICIO_TRANSACCION;
import com.bcp.api.repository.T_CUENTA_BANCARIA_REPOSITORY;
import com.bcp.api.repository.T_PERSONA_REPOSITORY;
import com.bcp.api.repository.TRX_TRANSACCION_REPOSITORY;
import com.bcp.api.repository.T_CLIENTE_REPOSITORY; // 🔥 Importamos el nuevo repo

@Service
public class HomeServiceImpl {

    @Autowired
    private T_PERSONA_REPOSITORY personaRepo;

    @Autowired
    private T_CUENTA_BANCARIA_REPOSITORY cuentaRepo; 

    @Autowired
    private T_CLIENTE_REPOSITORY clienteRepo; 
    
    @Autowired
    private TRX_TRANSACCION_REPOSITORY transaccionRepo;

    // =========================================================================
    // 1. OBTENER RESUMEN (LECTURA DE TODAS LAS CUENTAS)
    // =========================================================================
    public HomeResumenDTO obtenerResumen(String dni) {
        HomeResumenDTO resumen = new HomeResumenDTO();
        
        T_PERSONA persona = personaRepo.findByPER_V_NUMERO_DOCUMENTO(dni);
        
        if (persona != null) {
        	resumen.per_n_id = persona.getPER_N_ID();
            resumen.CLI_V_NOMBRE = persona.getPER_V_NOMBRE() + " " + persona.getPER_V_APELLIDO();
            resumen.cuentas = new ArrayList<>(); 
            
            // 🔥 CAMBIO CRÍTICO: Usamos el método optimizado que trae todo de un solo golpe
            List<T_CUENTA_BANCARIA> listaCuentas = cuentaRepo.findTodoByPersonaId(persona.getPER_N_ID());
            
            if (listaCuentas != null && !listaCuentas.isEmpty()) {
                for (T_CUENTA_BANCARIA cta : listaCuentas) {
                    CuentaDetalleDTO detalle = new CuentaDetalleDTO();
                    detalle.CUE_N_ID = cta.getCUE_N_ID();
                    detalle.CUE_V_NUMERO = cta.getCUE_V_NUMERO(); 
                    detalle.CUE_N_SALDO = cta.getCUE_N_SALDO(); 
                    
                    // Como usamos JOIN FETCH, estos "get" ya no disparan nuevas consultas a Oracle
                    if (cta.getTipoCuentaBancaria() != null) {
                        detalle.TIPO_CUENTA = cta.getTipoCuentaBancaria().getTCB_N_ID(); 
                    }

                    if (cta.getTarjetas() != null && !cta.getTarjetas().isEmpty()) {
                        T_TARJETA tarjeta = cta.getTarjetas().get(0);
                        detalle.TAR_V_NUMERO = tarjeta.getTAR_V_NUMERO(); 
                        detalle.TAR_V_ESTADO = tarjeta.getTAR_V_ESTADO(); 
                    } else {
                        detalle.TAR_V_NUMERO = "Sin tarjeta vinculada"; 
                        detalle.TAR_V_ESTADO = "I"; 
                    }
                    resumen.cuentas.add(detalle);
                }
            }
            resumen.movimientos = new ArrayList<>(); 
        } else {
            resumen.CLI_V_NOMBRE = "DNI no registrado";
        }
        return resumen;
    }

    // =========================================================================
    // 2. APERTURAR CUENTA CORRIENTE (ESCRITURA CON EL ID 2)
    // =========================================================================
    public String aperturarCuentaCorriente(String dni) {
        T_PERSONA persona = personaRepo.findByPER_V_NUMERO_DOCUMENTO(dni);
        if (persona == null) {
            return "Error: Persona no encontrada";
        }

        String ultimoNum = cuentaRepo.findMaxNumeroCuenta();
        long proximoNum = (ultimoNum != null) ? Long.parseLong(ultimoNum) + 1 : 1000000001L;

        T_CUENTA_BANCARIA nuevaCta = new T_CUENTA_BANCARIA();
        nuevaCta.setCUE_V_NUMERO(String.valueOf(proximoNum));
        nuevaCta.setCUE_N_SALDO(0.00); 
        nuevaCta.setCUE_D_FECHA_CREACION(new Date()); 
        nuevaCta.setCUE_V_ESTADO("A"); 

        CAT_TIPO_CUENTA_BANCARIA tipoCorriente = new CAT_TIPO_CUENTA_BANCARIA();
        tipoCorriente.setTCB_N_ID(2); 
        nuevaCta.setTipoCuentaBancaria(tipoCorriente);

        CAT_MONEDA monedaSoles = new CAT_MONEDA();
        monedaSoles.setMON_N_ID(1); 
        nuevaCta.setMoneda(monedaSoles);

        // 🔥 LA SOLUCIÓN MAESTRA:
        // Buscamos al cliente por el ID de la persona usando el nuevo repositorio
        T_CLIENTE clienteActivo = clienteRepo.findByPersonaId(persona.getPER_N_ID());

        if (clienteActivo != null) {
            nuevaCta.setCliente(clienteActivo);
        } else {
            return "Error: La persona no tiene un perfil de cliente asociado.";
        }

        cuentaRepo.save(nuevaCta);
        
        return "OK";
    }
    
    @Transactional 
    public String ejecutarTransferencia(TransferenciaDTO dto) {
        // 1. Buscar cuentas en la base de datos
        T_CUENTA_BANCARIA origen = cuentaRepo.findByCUE_V_NUMERO(dto.cuentaOrigen)
                .orElseThrow(() -> new RuntimeException("Cuenta origen no encontrada"));
        
        T_CUENTA_BANCARIA destino = cuentaRepo.findByCUE_V_NUMERO(dto.cuentaDestino)
                .orElseThrow(() -> new RuntimeException("Cuenta destino no encontrada"));

        // 2. Lógica de montos y conversión
        double tipoCambio = 3.75; 
        double montoDigitado = dto.monto.doubleValue(); // El "1.00" que pones en la App
        
        double montoParaDescontar;
        double montoParaDepositar;

        // --- LA LÓGICA DE CONVERSIÓN ---
        if (dto.moneda == 2) { // Si el usuario seleccionó "Dólares"
            double conversion = montoDigitado * tipoCambio;
            montoParaDescontar = conversion; // Ejemplo: 1.00 * 3.75 = 3.75 Soles
            montoParaDepositar = conversion; // Se le suma 3.75 Soles al destino
            dto.referencia += " (TC: " + tipoCambio + ")";
        } else {
            // Si es Soles (ID 1), el monto no cambia
            montoParaDescontar = montoDigitado;
            montoParaDepositar = montoDigitado;
        }

        // 3. Validar si el cliente tiene dinero suficiente (Validamos contra el monto convertido)
        if (origen.getCUE_N_SALDO() < montoParaDescontar) {
            throw new RuntimeException("Saldo insuficiente. Necesitas S/ " + montoParaDescontar);
        }

        // 4. Aplicar cambios de saldo en las entidades
        origen.setCUE_N_SALDO(origen.getCUE_N_SALDO() - montoParaDescontar);
        destino.setCUE_N_SALDO(destino.getCUE_N_SALDO() + montoParaDepositar);

        // Guardar saldos actualizados en Oracle
        cuentaRepo.save(origen);
        cuentaRepo.save(destino);

        // 5. REGISTRAR LA TRANSACCIÓN (Historial)
        TRX_TRANSACCION trx = new TRX_TRANSACCION(); 
        
        trx.setCuentaOrigen(origen);
        trx.setCuentaDestino(destino);
        
        // Guardamos el monto que el usuario escribió (ej. 1.00) para que en su 
        // historial vea "1.00" y no "3.75", ya que la moneda dirá "Dólares"
        trx.setTRX_N_MONTO(montoDigitado); 
        
        trx.setTRX_V_REFERENCIA(dto.referencia);
        trx.setTRX_D_FECHA_HORA(new Date()); 
        trx.setTRX_V_ESTADO("A"); 

        // Moneda dinámica (Soles o Dólares)
        CAT_MONEDA mon = new CAT_MONEDA();
        mon.setMON_N_ID(dto.moneda); 
        trx.setMoneda(mon);

        // Catálogos obligatorios
        CAT_TIPO_TRANSACCION ttx = new CAT_TIPO_TRANSACCION();
        ttx.setTTX_N_ID(1); 
        trx.setTipoTransaccion(ttx);

        CAT_SERVICIO_TRANSACCION stx = new CAT_SERVICIO_TRANSACCION();
        stx.setSTX_N_ID(1); 
        trx.setServicioTransaccion(stx);

        CAT_MEDIO_OPERACION mop = new CAT_MEDIO_OPERACION();
        mop.setMOP_N_ID(3); 
        trx.setMedioOperacion(mop);

        // Guardar en BD
        transaccionRepo.save(trx);

        return "Transferencia exitosa";
    }
    
 // =========================================================================
    // 3. EJECUTAR PAGO DE SERVICIO O RECARGA
    // =========================================================================
    @Transactional
    public String ejecutarPagoServicio(PagoServicioDTO dto) {
        // 1. Buscar la cuenta origen (la que va a soltar la plata)
        // Usamos findById porque el DTO trae el int idOrigen
    	T_CUENTA_BANCARIA origen = cuentaRepo.findByCUE_V_NUMERO(dto.cuentaOrigen)
                .orElseThrow(() -> new RuntimeException("Cuenta de origen no encontrada"));

        // 2. Validar si tiene saldo suficiente
    	if (origen.getCUE_N_SALDO() < dto.monto) {
            throw new RuntimeException("Saldo insuficiente. El servicio cuesta S/ " + dto.monto);
        }

        // 3. Descontar el saldo
        origen.setCUE_N_SALDO(origen.getCUE_N_SALDO() - dto.monto);
        cuentaRepo.save(origen);

        // 4. Registrar la transacción "malcriada" ya educada
        TRX_TRANSACCION trx = new TRX_TRANSACCION();
        
        trx.setCuentaOrigen(origen);
        trx.setCuentaDestino(null); // Obligatorio NULL para pagos y recargas
        trx.setTRX_N_MONTO(dto.monto);
        trx.setTRX_V_REFERENCIA(dto.referencia);
        trx.setTRX_D_FECHA_HORA(new Date());
        trx.setTRX_V_ESTADO("A");

        // Moneda: Siempre Soles (ID 1) como quedamos
        CAT_MONEDA mon = new CAT_MONEDA();
        mon.setMON_N_ID(1); 
        trx.setMoneda(mon);

        // Tipo de Transacción: Viene de la UI (Pago=2, Recarga=6)
        CAT_TIPO_TRANSACCION ttx = new CAT_TIPO_TRANSACCION();
        ttx.setTTX_N_ID(dto.ttxId);
        trx.setTipoTransaccion(ttx);

        // Servicio: Viene de la UI (Luz=1, Agua=2, Recarga=5, etc.)
        CAT_SERVICIO_TRANSACCION stx = new CAT_SERVICIO_TRANSACCION();
        stx.setSTX_N_ID(dto.stxId);
        trx.setServicioTransaccion(stx);

        // Medio de Operación: ¡Siempre 3 (App)!
        CAT_MEDIO_OPERACION mop = new CAT_MEDIO_OPERACION();
        mop.setMOP_N_ID(3);
        trx.setMedioOperacion(mop);

        // Guardar historial en la tabla TRX_TRANSACCION
        transaccionRepo.save(trx);

        return "OK";
    }
}