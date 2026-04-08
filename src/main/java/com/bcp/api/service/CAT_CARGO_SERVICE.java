package com.bcp.api.service;

import java.util.List;
import com.bcp.api.model.CAT_CARGO;

public interface CAT_CARGO_SERVICE {
    List<CAT_CARGO> listarTodos();
    CAT_CARGO guardar(CAT_CARGO objeto);
}