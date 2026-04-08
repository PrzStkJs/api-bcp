package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.T_PERSONA;

public interface T_PERSONA_SERVICE {
    List<T_PERSONA> listarTodos();
    T_PERSONA guardar(T_PERSONA objeto);
}