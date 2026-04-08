package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.SERVICIO_AGENCIA;

public interface SERVICIO_AGENCIA_SERVICE {
    List<SERVICIO_AGENCIA> listarTodos();
    SERVICIO_AGENCIA guardar(SERVICIO_AGENCIA objeto);
}