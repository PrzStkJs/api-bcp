package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_VALOR_COMISION;

public interface CAT_VALOR_COMISION_SERVICE {
    List<CAT_VALOR_COMISION> listarTodos();
    CAT_VALOR_COMISION guardar(CAT_VALOR_COMISION objeto);
}