package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.T_USUARIO;
import com.bcp.api.service.T_USUARIO_SERVICE;

@RestController
@RequestMapping("/api/t-usuario")
public class T_USUARIO_CONTROLLER {

    @Autowired
    private T_USUARIO_SERVICE service;

    @GetMapping
    public List<T_USUARIO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public T_USUARIO guardar(@RequestBody T_USUARIO objeto) {
        return service.guardar(objeto);
    }
}