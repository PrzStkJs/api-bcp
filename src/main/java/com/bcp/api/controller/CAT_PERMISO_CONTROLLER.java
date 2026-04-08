package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_PERMISO;
import com.bcp.api.service.CAT_PERMISO_SERVICE;

@RestController
@RequestMapping("/api/cat-permiso")
public class CAT_PERMISO_CONTROLLER {

    @Autowired
    private CAT_PERMISO_SERVICE service;

    @GetMapping
    public List<CAT_PERMISO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_PERMISO guardar(@RequestBody CAT_PERMISO objeto) {
        return service.guardar(objeto);
    }
}