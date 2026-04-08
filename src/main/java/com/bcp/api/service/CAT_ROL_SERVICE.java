package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_ROL;

public interface CAT_ROL_SERVICE {
    List<CAT_ROL> listarTodos();
    CAT_ROL guardar(CAT_ROL objeto);
}