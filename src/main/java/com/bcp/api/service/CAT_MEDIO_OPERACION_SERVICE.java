package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_MEDIO_OPERACION;

public interface CAT_MEDIO_OPERACION_SERVICE {
    List<CAT_MEDIO_OPERACION> listarTodos();
    CAT_MEDIO_OPERACION guardar(CAT_MEDIO_OPERACION objeto);
}