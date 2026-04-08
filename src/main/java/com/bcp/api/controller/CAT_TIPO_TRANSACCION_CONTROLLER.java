package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_TIPO_TRANSACCION;
import com.bcp.api.service.CAT_TIPO_TRANSACCION_SERVICE;

@RestController
@RequestMapping("/api/cat-tipo-transaccion")
public class CAT_TIPO_TRANSACCION_CONTROLLER {

    @Autowired
    private CAT_TIPO_TRANSACCION_SERVICE service;

    @GetMapping
    public List<CAT_TIPO_TRANSACCION> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_TIPO_TRANSACCION guardar(@RequestBody CAT_TIPO_TRANSACCION objeto) {
        return service.guardar(objeto);
    }
}