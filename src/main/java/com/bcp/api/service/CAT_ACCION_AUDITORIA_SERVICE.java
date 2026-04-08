package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_ACCION_AUDITORIA;

public interface CAT_ACCION_AUDITORIA_SERVICE {
    List<CAT_ACCION_AUDITORIA> listarTodos();
    CAT_ACCION_AUDITORIA guardar(CAT_ACCION_AUDITORIA objeto);
}