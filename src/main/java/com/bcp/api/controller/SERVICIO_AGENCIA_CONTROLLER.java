package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.SERVICIO_AGENCIA;
import com.bcp.api.service.SERVICIO_AGENCIA_SERVICE;

@RestController
@RequestMapping("/api/servicio-agencia")
public class SERVICIO_AGENCIA_CONTROLLER {

    @Autowired
    private SERVICIO_AGENCIA_SERVICE service;

    @GetMapping
    public List<SERVICIO_AGENCIA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public SERVICIO_AGENCIA guardar(@RequestBody SERVICIO_AGENCIA objeto) {
        return service.guardar(objeto);
    }
}