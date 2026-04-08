package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_PERMISO;

public interface CAT_PERMISO_SERVICE {
    List<CAT_PERMISO> listarTodos();
    CAT_PERMISO guardar(CAT_PERMISO objeto);
}