package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.CAT_SERVICIO_TRANSACCION;
import com.bcp.api.service.CAT_SERVICIO_TRANSACCION_SERVICE;

@RestController
@RequestMapping("/api/cat-servicio-transaccion")
public class CAT_SERVICIO_TRANSACCION_CONTROLLER {

    @Autowired
    private CAT_SERVICIO_TRANSACCION_SERVICE service;

    @GetMapping
    public List<CAT_SERVICIO_TRANSACCION> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_SERVICIO_TRANSACCION guardar(@RequestBody CAT_SERVICIO_TRANSACCION objeto) {
        return service.guardar(objeto);
    }
}