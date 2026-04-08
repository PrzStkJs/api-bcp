package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_PARAMETRO_COMISION;
import com.bcp.api.service.CAT_PARAMETRO_COMISION_SERVICE;

@RestController
@RequestMapping("/api/cat-parametro-comision")
public class CAT_PARAMETRO_COMISION_CONTROLLER {

    @Autowired
    private CAT_PARAMETRO_COMISION_SERVICE service;

    @GetMapping
    public List<CAT_PARAMETRO_COMISION> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_PARAMETRO_COMISION guardar(@RequestBody CAT_PARAMETRO_COMISION objeto) {
        return service.guardar(objeto);
    }
}