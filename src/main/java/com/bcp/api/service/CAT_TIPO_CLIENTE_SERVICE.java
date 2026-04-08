package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_TIPO_CLIENTE;

public interface CAT_TIPO_CLIENTE_SERVICE {
    List<CAT_TIPO_CLIENTE> listarTodos();
    CAT_TIPO_CLIENTE guardar(CAT_TIPO_CLIENTE objeto);
}