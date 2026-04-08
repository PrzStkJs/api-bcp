package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_TIPO_PRESTAMO;

public interface CAT_TIPO_PRESTAMO_SERVICE {
    List<CAT_TIPO_PRESTAMO> listarTodos();
    CAT_TIPO_PRESTAMO guardar(CAT_TIPO_PRESTAMO objeto);
}