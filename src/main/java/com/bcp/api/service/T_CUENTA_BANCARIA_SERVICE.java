package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.T_CUENTA_BANCARIA;

public interface T_CUENTA_BANCARIA_SERVICE {
    List<T_CUENTA_BANCARIA> listarTodos();
    T_CUENTA_BANCARIA guardar(T_CUENTA_BANCARIA objeto);
}