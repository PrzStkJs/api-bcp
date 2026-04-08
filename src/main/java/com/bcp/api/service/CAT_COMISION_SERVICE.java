package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_COMISION;

public interface CAT_COMISION_SERVICE {
    List<CAT_COMISION> listarTodos();
    CAT_COMISION guardar(CAT_COMISION objeto);
}