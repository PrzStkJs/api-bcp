package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.api.model.CAT_MARCA_TARJETA;
import com.bcp.api.service.CAT_MARCA_TARJETA_SERVICE;

@RestController
@RequestMapping("/api/cat-marca-tarjeta")
public class CAT_MARCA_TARJETA_CONTROLLER {

    @Autowired
    private CAT_MARCA_TARJETA_SERVICE service;

    @GetMapping
    public List<CAT_MARCA_TARJETA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_MARCA_TARJETA guardar(@RequestBody CAT_MARCA_TARJETA objeto) {
        return service.guardar(objeto);
    }
}