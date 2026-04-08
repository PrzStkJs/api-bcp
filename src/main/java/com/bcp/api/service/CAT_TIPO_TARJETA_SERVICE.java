package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_TIPO_TARJETA;

public interface CAT_TIPO_TARJETA_SERVICE {
    List<CAT_TIPO_TARJETA> listarTodos();
    CAT_TIPO_TARJETA guardar(CAT_TIPO_TARJETA objeto);
}