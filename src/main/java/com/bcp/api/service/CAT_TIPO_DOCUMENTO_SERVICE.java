package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_TIPO_DOCUMENTO;

public interface CAT_TIPO_DOCUMENTO_SERVICE {
    List<CAT_TIPO_DOCUMENTO> listarTodos();
    CAT_TIPO_DOCUMENTO guardar(CAT_TIPO_DOCUMENTO objeto);
}