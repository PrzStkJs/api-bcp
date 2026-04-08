package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_TIPO_TARJETA;
import com.bcp.api.service.CAT_TIPO_TARJETA_SERVICE;

@RestController
@RequestMapping("/api/cat-tipo-tarjeta")
public class CAT_TIPO_TARJETA_CONTROLLER {

    @Autowired
    private CAT_TIPO_TARJETA_SERVICE service;

    @GetMapping
    public List<CAT_TIPO_TARJETA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_TIPO_TARJETA guardar(@RequestBody CAT_TIPO_TARJETA objeto) {
        return service.guardar(objeto);
    }
}