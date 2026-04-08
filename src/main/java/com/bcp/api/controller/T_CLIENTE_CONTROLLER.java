package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.T_CLIENTE;
import com.bcp.api.service.T_CLIENTE_SERVICE;

@RestController
@RequestMapping("/api/t-cliente")
public class T_CLIENTE_CONTROLLER {

    @Autowired
    private T_CLIENTE_SERVICE service;

    @GetMapping
    public List<T_CLIENTE> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public T_CLIENTE guardar(@RequestBody T_CLIENTE objeto) {
        return service.guardar(objeto);
    }
}