package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.api.model.CAT_ACCION_AUDITORIA;
import com.bcp.api.service.CAT_ACCION_AUDITORIA_SERVICE;

@RestController
@RequestMapping("/api/cat-accion-auditoria")
public class CAT_ACCION_AUDITORIA_CONTROLLER {

    @Autowired
    private CAT_ACCION_AUDITORIA_SERVICE service;

    @GetMapping
    public List<CAT_ACCION_AUDITORIA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_ACCION_AUDITORIA guardar(@RequestBody CAT_ACCION_AUDITORIA objeto) {
        return service.guardar(objeto);
    }
}