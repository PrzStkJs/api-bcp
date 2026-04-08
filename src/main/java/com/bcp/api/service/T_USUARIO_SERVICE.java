package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.T_USUARIO;

public interface T_USUARIO_SERVICE {
    List<T_USUARIO> listarTodos();
    T_USUARIO guardar(T_USUARIO objeto);
}