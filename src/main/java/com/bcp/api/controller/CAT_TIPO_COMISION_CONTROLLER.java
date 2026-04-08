package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_TIPO_COMISION;
import com.bcp.api.service.CAT_TIPO_COMISION_SERVICE;

@RestController
@RequestMapping("/api/cat-tipo-comision")
public class CAT_TIPO_COMISION_CONTROLLER {

    @Autowired
    private CAT_TIPO_COMISION_SERVICE service;

    @GetMapping
    public List<CAT_TIPO_COMISION> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_TIPO_COMISION guardar(@RequestBody CAT_TIPO_COMISION objeto) {
        return service.guardar(objeto);
    }
}