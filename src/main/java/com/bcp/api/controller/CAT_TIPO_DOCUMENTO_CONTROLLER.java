package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_TIPO_DOCUMENTO;
import com.bcp.api.service.CAT_TIPO_DOCUMENTO_SERVICE;

@RestController
@RequestMapping("/api/cat-tipo-documento")
public class CAT_TIPO_DOCUMENTO_CONTROLLER {

    @Autowired
    private CAT_TIPO_DOCUMENTO_SERVICE service;

    @GetMapping
    public List<CAT_TIPO_DOCUMENTO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_TIPO_DOCUMENTO guardar(@RequestBody CAT_TIPO_DOCUMENTO objeto) {
        return service.guardar(objeto);
    }
}