package com.bcp.api.service;

import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import java.util.Date; // Usamos util.Date como tu Entidad
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bcp.api.model.T_CUENTA_BANCARIA;
import com.bcp.api.model.T_TARJETA;
import com.bcp.api.repository.CAT_MARCA_TARJETA_REPOSITORY;
import com.bcp.api.repository.CAT_TIPO_CUENTA_BANCARIA_REPOSITORY;
import com.bcp.api.repository.CAT_TIPO_TARJETA_REPOSITORY;
import com.bcp.api.repository.T_CUENTA_BANCARIA_REPOSITORY;
import com.bcp.api.repository.T_TARJETA_REPOSITORY; // Ajusta si tu repo se llama diferente
import com.bcp.api.dto.TarjetaDTO;

@Service
public class T_TARJETA_SERVICE_IMPL implements T_TARJETA_SERVICE {

    @Autowired
    private T_TARJETA_REPOSITORY repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private T_CUENTA_BANCARIA_REPOSITORY cuentaRepo; 
    @Autowired
    private CAT_TIPO_CUENTA_BANCARIA_REPOSITORY tipoRepo;
    @Autowired
    private CAT_TIPO_TARJETA_REPOSITORY tipoTarjetaRepo;
    @Autowired
    private CAT_MARCA_TARJETA_REPOSITORY marcaRepo;
    
    
    @Override
    public List<T_TARJETA> listarTodos() {
        return repository.findAll();
    }

    @Override
    public T_TARJETA guardar(T_TARJETA objeto) {
        Random rand = new Random();

        // 1. OBTENER LOS OBJETOS REALES DE LA BD
        // Esto soluciona el error "TransientPropertyValueException"
        var cuentaReal = cuentaRepo.findById(objeto.getCuentaBancaria().getCUE_N_ID())
                .orElseThrow(() -> new RuntimeException("Cuenta bancaria no encontrada"));
        
        var tipoReal = tipoTarjetaRepo.findById(objeto.getTipoTarjeta().getTTJ_N_ID())
                .orElseThrow(() -> new RuntimeException("Tipo de tarjeta no encontrado"));
                
        var marcaReal = marcaRepo.findById(objeto.getMarcaTarjeta().getMAR_N_ID())
                .orElseThrow(() -> new RuntimeException("Marca de tarjeta no encontrada"));

        // 2. VINCULAR LAS ENTIDADES REALES AL OBJETO
        objeto.setCuentaBancaria(cuentaReal);
        objeto.setTipoTarjeta(tipoReal);
        objeto.setMarcaTarjeta(marcaReal);

        // 3. GENERACIÓN DE DATOS DINÁMICOS
        // Prefijo según marca: 4 para Visa (ID 1), 5 para Mastercard (ID 2)
        String prefijo = (marcaReal.getMAR_N_ID() == 1) ? "4" : "5";
        StringBuilder sb = new StringBuilder(prefijo);
        for (int i = 0; i < 15; i++) {
            sb.append(rand.nextInt(10));
        }
        objeto.setTAR_V_NUMERO(sb.toString());

        // CVV de 3 dígitos con ceros a la izquierda si es necesario
        objeto.setTAR_C_CVV(String.format("%03d", rand.nextInt(1000)));

        // Fechas de emisión y vencimiento
        LocalDate hoy = LocalDate.now();
        objeto.setTAR_D_FECHA_EMISION(java.sql.Date.valueOf(hoy));
        objeto.setTAR_D_FECHA_VENCIMIENTO(java.sql.Date.valueOf(hoy.plusYears(3)));

        // Estado y Saldo inicial
        objeto.setTAR_V_ESTADO("A");
        objeto.setTAR_N_SALDO(0.0);
        objeto.setTAR_V_NUMERO_EMISION("EMI-" + (100 + rand.nextInt(900)));

        // 4. GUARDAR EN LA BASE DE DATOS
        return repository.save(objeto);
    }

    @Override
    public List<TarjetaDTO> listarTarjetasPorCuenta(String numeroCuenta) {
        String sql = "SELECT t.TAR_V_NUMERO, t.TAR_N_SALDO, m.MAR_V_NOMBRE, tp.TTJ_V_NOMBRE " +
                     "FROM T_TARJETA t " +
                     "INNER JOIN T_CUENTA_BANCARIA c ON t.CUE_N_ID = c.CUE_N_ID " + 
                     "LEFT JOIN CAT_MARCA_TARJETA m ON t.MAR_N_ID = m.MAR_N_ID " +
                     "LEFT JOIN CAT_TIPO_TARJETA tp ON t.TTJ_N_ID = tp.TTJ_N_ID " +
                     "WHERE c.CUE_V_NUMERO = ?";

        return jdbcTemplate.query(sql, new Object[]{numeroCuenta}, (rs, rowNum) -> 
            new TarjetaDTO(
                rs.getString("TAR_V_NUMERO"),
                rs.getDouble("TAR_N_SALDO"),
                rs.getString("MAR_V_NOMBRE"),
                rs.getString("TTJ_V_NOMBRE")
            )
        );
    }
}