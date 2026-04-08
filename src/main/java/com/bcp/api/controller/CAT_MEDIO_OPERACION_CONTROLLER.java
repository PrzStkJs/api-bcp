package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_MEDIO_OPERACION;
import com.bcp.api.service.CAT_MEDIO_OPERACION_SERVICE;

@RestController
@RequestMapping("/api/cat-medio-operacion")
public class CAT_MEDIO_OPERACION_CONTROLLER {

    @Autowired
    private CAT_MEDIO_OPERACION_SERVICE service;

    @GetMapping
    public List<CAT_MEDIO_OPERACION> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_MEDIO_OPERACION guardar(@RequestBody CAT_MEDIO_OPERACION objeto) {
        return service.guardar(objeto);
    }
}