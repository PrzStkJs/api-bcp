package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.T_LOG;
import com.bcp.api.service.T_LOG_SERVICE;

@RestController
@RequestMapping("/api/t-log")
public class T_LOG_CONTROLLER {

    @Autowired
    private T_LOG_SERVICE service;

    @GetMapping
    public List<T_LOG> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public T_LOG guardar(@RequestBody T_LOG objeto) {
        return service.guardar(objeto);
    }
}