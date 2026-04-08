package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_SERVICIO_TRANSACCION;

public interface CAT_SERVICIO_TRANSACCION_SERVICE {
    List<CAT_SERVICIO_TRANSACCION> listarTodos();
    CAT_SERVICIO_TRANSACCION guardar(CAT_SERVICIO_TRANSACCION objeto);
}