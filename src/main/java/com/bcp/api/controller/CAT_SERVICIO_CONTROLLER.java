package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_SERVICIO;
import com.bcp.api.service.CAT_SERVICIO_SERVICE;

@RestController
@RequestMapping("/api/cat-servicio")
public class CAT_SERVICIO_CONTROLLER {

    @Autowired
    private CAT_SERVICIO_SERVICE service;

    @GetMapping
    public List<CAT_SERVICIO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_SERVICIO guardar(@RequestBody CAT_SERVICIO objeto) {
        return service.guardar(objeto);
    }
}