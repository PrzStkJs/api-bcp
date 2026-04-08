package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.T_AGENCIA;

public interface T_AGENCIA_SERVICE {
    List<T_AGENCIA> listarTodos();
    T_AGENCIA guardar(T_AGENCIA objeto);
}