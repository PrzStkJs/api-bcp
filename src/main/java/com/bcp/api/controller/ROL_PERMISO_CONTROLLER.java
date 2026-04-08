package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.ROL_PERMISO;
import com.bcp.api.service.ROL_PERMISO_SERVICE;

@RestController
@RequestMapping("/api/rol-permiso")
public class ROL_PERMISO_CONTROLLER {

    @Autowired
    private ROL_PERMISO_SERVICE service;

    @GetMapping
    public List<ROL_PERMISO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ROL_PERMISO guardar(@RequestBody ROL_PERMISO objeto) {
        return service.guardar(objeto);
    }
}