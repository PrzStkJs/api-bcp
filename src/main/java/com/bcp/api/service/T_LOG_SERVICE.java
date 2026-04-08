package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.T_LOG;

public interface T_LOG_SERVICE {
    List<T_LOG> listarTodos();
    T_LOG guardar(T_LOG objeto);
}