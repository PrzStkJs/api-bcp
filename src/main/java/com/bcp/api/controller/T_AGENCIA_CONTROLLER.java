package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.T_AGENCIA;
import com.bcp.api.service.T_AGENCIA_SERVICE;

@RestController
@RequestMapping("/api/t-agencia")
public class T_AGENCIA_CONTROLLER {

    @Autowired
    private T_AGENCIA_SERVICE service;

    @GetMapping
    public List<T_AGENCIA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public T_AGENCIA guardar(@RequestBody T_AGENCIA objeto) {
        return service.guardar(objeto);
    }
}