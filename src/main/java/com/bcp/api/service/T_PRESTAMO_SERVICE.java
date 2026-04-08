package com.bcp.api.service;

import java.util.List;

import com.bcp.api.dto.PrestamoSolicitudDTO;
import com.bcp.api.model.T_PRESTAMO;

public interface T_PRESTAMO_SERVICE {
    List<T_PRESTAMO> listarTodos();
    T_PRESTAMO guardar(T_PRESTAMO objeto);
    String procesarSolicitudPrestamo(PrestamoSolicitudDTO dto);
}