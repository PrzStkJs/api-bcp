package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_MONEDA;

public interface CAT_MONEDA_SERVICE {
    List<CAT_MONEDA> listarTodos();
    CAT_MONEDA guardar(CAT_MONEDA objeto);
}