package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.T_AUDITORIA;
import com.bcp.api.service.T_AUDITORIA_SERVICE;

@RestController
@RequestMapping("/api/t-auditoria")
public class T_AUDITORIA_CONTROLLER {

    @Autowired
    private T_AUDITORIA_SERVICE service;

    @GetMapping
    public List<T_AUDITORIA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public T_AUDITORIA guardar(@RequestBody T_AUDITORIA objeto) {
        return service.guardar(objeto);
    }
}