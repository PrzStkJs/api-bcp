package com.bcp.api.service;

import com.bcp.api.dto.ReporteGerenciaDTO;
import com.bcp.api.repository.T_CLIENTE_REPOSITORY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Importante para UPDATES
import java.util.ArrayList;
import java.util.List;

@Service
public class GerenciaServiceImpl implements GerenciaService {

    @Autowired
    private T_CLIENTE_REPOSITORY clienteRepo;

    @Override
    public List<ReporteGerenciaDTO> listarTodoParaGerencia() {
        List<Object[]> dataCerrada = clienteRepo.obtenerDatosNativosGerencia();
        List<ReporteGerenciaDTO> listaReporte = new ArrayList<>();

        for (Object[] fila : dataCerrada) {
            ReporteGerenciaDTO dto = new ReporteGerenciaDTO();
            dto.id = ((Number) fila[0]).intValue();
            dto.cliente = (String) fila[1];
            dto.documento = (String) fila[2];
            dto.balance = ((Number) fila[3]).doubleValue();
            dto.estado = (fila[4] != null && fila[4].toString().equals("A")) ? "ACTIVO" : "INACTIVO";
            
            listaReporte.add(dto);
        }
        return listaReporte;
    }
    
    @Override // AGREGA EL OVERRIDE AQUÍ
    @Transactional // Agrega esto para asegurar que el cambio se guarde en Oracle
    public void desactivarCliente(int id) {
        clienteRepo.desactivarClienteNativo(id);
    }
}