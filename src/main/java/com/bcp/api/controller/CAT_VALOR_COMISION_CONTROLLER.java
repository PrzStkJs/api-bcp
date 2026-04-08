package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_VALOR_COMISION;
import com.bcp.api.service.CAT_VALOR_COMISION_SERVICE;

@RestController
@RequestMapping("/api/cat-valor-comision")
public class CAT_VALOR_COMISION_CONTROLLER {

    @Autowired
    private CAT_VALOR_COMISION_SERVICE service;

    @GetMapping
    public List<CAT_VALOR_COMISION> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_VALOR_COMISION guardar(@RequestBody CAT_VALOR_COMISION objeto) {
        return service.guardar(objeto);
    }
}