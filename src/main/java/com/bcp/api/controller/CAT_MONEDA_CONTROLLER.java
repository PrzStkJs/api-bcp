package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_MONEDA;
import com.bcp.api.service.CAT_MONEDA_SERVICE;

@RestController
@RequestMapping("/api/cat-moneda")
public class CAT_MONEDA_CONTROLLER {

    @Autowired
    private CAT_MONEDA_SERVICE service;

    @GetMapping
    public List<CAT_MONEDA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_MONEDA guardar(@RequestBody CAT_MONEDA objeto) {
        return service.guardar(objeto);
    }
}