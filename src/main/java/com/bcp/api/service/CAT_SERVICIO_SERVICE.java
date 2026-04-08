package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_SERVICIO;

public interface CAT_SERVICIO_SERVICE {
    List<CAT_SERVICIO> listarTodos();
    CAT_SERVICIO guardar(CAT_SERVICIO objeto);
}