package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.TCB_MONEDA;
import com.bcp.api.service.TCB_MONEDA_SERVICE;

@RestController
@RequestMapping("/api/tcb-moneda")
public class TCB_MONEDA_CONTROLLER {

    @Autowired
    private TCB_MONEDA_SERVICE service;

    @GetMapping
    public List<TCB_MONEDA> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public TCB_MONEDA guardar(@RequestBody TCB_MONEDA objeto) {
        return service.guardar(objeto);
    }
}