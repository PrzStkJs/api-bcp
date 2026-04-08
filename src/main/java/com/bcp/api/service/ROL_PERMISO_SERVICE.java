package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.ROL_PERMISO;

public interface ROL_PERMISO_SERVICE {
    List<ROL_PERMISO> listarTodos();
    ROL_PERMISO guardar(ROL_PERMISO objeto);
}