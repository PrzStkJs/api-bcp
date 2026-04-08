package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_TIPO_CLIENTE;
import com.bcp.api.service.CAT_TIPO_CLIENTE_SERVICE;

@RestController
@RequestMapping("/api/cat-tipo-cliente")
public class CAT_TIPO_CLIENTE_CONTROLLER {

    @Autowired
    private CAT_TIPO_CLIENTE_SERVICE service;

    @GetMapping
    public List<CAT_TIPO_CLIENTE> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_TIPO_CLIENTE guardar(@RequestBody CAT_TIPO_CLIENTE objeto) {
        return service.guardar(objeto);
    }
}