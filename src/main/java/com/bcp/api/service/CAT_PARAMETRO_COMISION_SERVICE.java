package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_PARAMETRO_COMISION;


public interface CAT_PARAMETRO_COMISION_SERVICE {
    List<CAT_PARAMETRO_COMISION> listarTodos();
    CAT_PARAMETRO_COMISION guardar(CAT_PARAMETRO_COMISION objeto);
}