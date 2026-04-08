package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_TIPO_PRESTAMO;
import com.bcp.api.service.CAT_TIPO_PRESTAMO_SERVICE;

@RestController
@RequestMapping("/api/cat-tipo-prestamo")
public class CAT_TIPO_PRESTAMO_CONTROLLER {

    @Autowired
    private CAT_TIPO_PRESTAMO_SERVICE service;

    @GetMapping
    public List<CAT_TIPO_PRESTAMO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_TIPO_PRESTAMO guardar(@RequestBody CAT_TIPO_PRESTAMO objeto) {
        return service.guardar(objeto);
    }
}