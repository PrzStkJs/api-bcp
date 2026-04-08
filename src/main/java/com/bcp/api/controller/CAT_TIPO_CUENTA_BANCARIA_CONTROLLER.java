package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_TIPO_CUENTA_BANCARIA;
import com.bcp.api.service.CAT_TIPO_CUENTA_BANCARIA_SERVICE;

@RestController
@RequestMapping("/api/cat-tipo-cuenta-bancaria")
public class CAT_TIPO_CUENTA_BANCARIA_CONTROLLER {

    @Autowired
    private CAT_TIPO_CUENTA_BANCARIA_SERVICE service;

    @GetMapping
    public List<CAT_TIPO_CUENTA_BANCARIA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_TIPO_CUENTA_BANCARIA guardar(@RequestBody CAT_TIPO_CUENTA_BANCARIA objeto) {
        return service.guardar(objeto);
    }
}