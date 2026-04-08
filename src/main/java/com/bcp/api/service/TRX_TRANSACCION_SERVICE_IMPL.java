package com.bcp.api.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.api.dto.MovimientoDTO;
import com.bcp.api.model.TRX_TRANSACCION;
import com.bcp.api.repository.TRX_TRANSACCION_REPOSITORY;

@Service
public class TRX_TRANSACCION_SERVICE_IMPL implements TRX_TRANSACCION_SERVICE {

    @Autowired
    private TRX_TRANSACCION_REPOSITORY repository;

    @Override
    public List<TRX_TRANSACCION> listarTodas() {
        return repository.findAll();
    }

    @Override
    public TRX_TRANSACCION guardar(TRX_TRANSACCION transaccion) {
        return repository.save(transaccion);
    }

    @Override
    public List<MovimientoDTO> listarMovimientosPorCuenta(String numeroCuenta) {
        List<TRX_TRANSACCION> transacciones = repository.listarMovimientos(numeroCuenta);
        List<MovimientoDTO> dtos = new ArrayList<>();

        for (TRX_TRANSACCION t : transacciones) {
            MovimientoDTO dto = new MovimientoDTO();
            
            // Ajustado a tus getters exactos:
            dto.id = (long) t.getTRX_N_ID(); // Casteamos int a long para el DTO
            dto.fecha = t.getTRX_D_FECHA_HORA();
            dto.monto = t.getTRX_N_MONTO();
            dto.referencia = t.getTRX_V_REFERENCIA();
            
            // Lógica de operación
            if (dto.referencia != null && dto.referencia.contains("DESEMBOLSO")) {
                dto.operacion = "PRÉSTAMO";
            } else if (dto.referencia != null && dto.referencia.contains("RECARGA")) {
                dto.operacion = "PAGO / RECARGA";
            } else {
                dto.operacion = "TRANSFERENCIA";
            }

            dto.moneda = "S/"; 
            
            dtos.add(dto);
        }
        return dtos;
    }
}