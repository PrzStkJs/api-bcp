package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.TCB_MONEDA;

public interface TCB_MONEDA_SERVICE {
    List<TCB_MONEDA> listarTodos();
    TCB_MONEDA guardar(TCB_MONEDA objeto);
}