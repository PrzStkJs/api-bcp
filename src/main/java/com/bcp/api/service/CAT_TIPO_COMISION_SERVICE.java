package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_TIPO_COMISION;

public interface CAT_TIPO_COMISION_SERVICE {
    List<CAT_TIPO_COMISION> listarTodos();
    CAT_TIPO_COMISION guardar(CAT_TIPO_COMISION objeto);
}