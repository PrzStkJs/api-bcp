package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.T_CLIENTE;

public interface T_CLIENTE_SERVICE {
    List<T_CLIENTE> listarTodos();
    T_CLIENTE guardar(T_CLIENTE objeto);
}