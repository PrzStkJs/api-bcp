package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.T_CUENTA_BANCARIA;
import com.bcp.api.service.T_CUENTA_BANCARIA_SERVICE;

@RestController
@RequestMapping("/api/t-cuenta-bancaria")
public class T_CUENTA_BANCARIA_CONTROLLER {

    @Autowired
    private T_CUENTA_BANCARIA_SERVICE service;

    @GetMapping
    public List<T_CUENTA_BANCARIA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public T_CUENTA_BANCARIA guardar(@RequestBody T_CUENTA_BANCARIA objeto) {
        return service.guardar(objeto);
    }
}