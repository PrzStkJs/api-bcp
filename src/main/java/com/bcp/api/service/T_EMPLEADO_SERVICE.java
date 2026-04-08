package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.T_EMPLEADO;

public interface T_EMPLEADO_SERVICE {
    List<T_EMPLEADO> listarTodos();
    T_EMPLEADO guardar(T_EMPLEADO objeto);
}