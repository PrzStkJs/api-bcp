package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_ROL;
import com.bcp.api.service.CAT_ROL_SERVICE;

@RestController
@RequestMapping("/api/cat-rol")
public class CAT_ROL_CONTROLLER {

    @Autowired
    private CAT_ROL_SERVICE service;

    @GetMapping
    public List<CAT_ROL> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_ROL guardar(@RequestBody CAT_ROL objeto) {
        return service.guardar(objeto);
    }
}