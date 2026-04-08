package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_TIPO_TRANSACCION;

public interface CAT_TIPO_TRANSACCION_SERVICE {
    List<CAT_TIPO_TRANSACCION> listarTodos();
    CAT_TIPO_TRANSACCION guardar(CAT_TIPO_TRANSACCION objeto);
}