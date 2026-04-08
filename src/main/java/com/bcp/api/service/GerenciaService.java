package com.bcp.api.service;

import com.bcp.api.dto.ReporteGerenciaDTO;
import java.util.List;

public interface GerenciaService {
    List<ReporteGerenciaDTO> listarTodoParaGerencia();
    
    // AGREGA ESTA LÍNEA
    void desactivarCliente(int id); 
}