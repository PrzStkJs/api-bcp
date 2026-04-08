package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_TIPO_CUENTA_BANCARIA;

public interface CAT_TIPO_CUENTA_BANCARIA_SERVICE {
    List<CAT_TIPO_CUENTA_BANCARIA> listarTodos();
    CAT_TIPO_CUENTA_BANCARIA guardar(CAT_TIPO_CUENTA_BANCARIA objeto);
}