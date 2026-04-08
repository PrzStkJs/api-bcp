package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.api.model.CAT_COMISION;
import com.bcp.api.service.CAT_COMISION_SERVICE;

@RestController
@RequestMapping("/api/cat-comision")
public class CAT_COMISION_CONTROLLER {

    @Autowired
    private CAT_COMISION_SERVICE service;

    @GetMapping
    public List<CAT_COMISION> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_COMISION guardar(@RequestBody CAT_COMISION objeto) {
        return service.guardar(objeto);
    }
}