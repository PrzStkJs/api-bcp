package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.T_AUDITORIA;

public interface T_AUDITORIA_SERVICE {
    List<T_AUDITORIA> listarTodos();
    T_AUDITORIA guardar(T_AUDITORIA objeto);
}