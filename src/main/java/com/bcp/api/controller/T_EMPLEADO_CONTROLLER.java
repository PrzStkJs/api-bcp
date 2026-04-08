package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.T_EMPLEADO;
import com.bcp.api.service.T_EMPLEADO_SERVICE;

@RestController
@RequestMapping("/api/t-empleado")
public class T_EMPLEADO_CONTROLLER {

    @Autowired
    private T_EMPLEADO_SERVICE service;

    @GetMapping
    public List<T_EMPLEADO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public T_EMPLEADO guardar(@RequestBody T_EMPLEADO objeto) {
        return service.guardar(objeto);
    }
}