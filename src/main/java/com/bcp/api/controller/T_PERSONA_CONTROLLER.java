package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.T_PERSONA;
import com.bcp.api.service.T_PERSONA_SERVICE;

@RestController
@RequestMapping("/api/t-persona")
public class T_PERSONA_CONTROLLER {

    @Autowired
    private T_PERSONA_SERVICE service;

    @GetMapping
    public List<T_PERSONA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public T_PERSONA guardar(@RequestBody T_PERSONA objeto) {
        return service.guardar(objeto);
    }
}