package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_MARCA_TARJETA;

public interface CAT_MARCA_TARJETA_SERVICE {
    List<CAT_MARCA_TARJETA> listarTodos();
    CAT_MARCA_TARJETA guardar(CAT_MARCA_TARJETA objeto);
}