package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.TIPO_COMISION_PARAMETRO;

public interface TIPO_COMISION_PARAMETRO_SERVICE {
    List<TIPO_COMISION_PARAMETRO> listarTodos();
    TIPO_COMISION_PARAMETRO guardar(TIPO_COMISION_PARAMETRO objeto);
}