package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.api.model.CAT_CARGO;
import com.bcp.api.service.CAT_CARGO_SERVICE;

@RestController
@RequestMapping("/api/cat-cargo")
public class CAT_CARGO_CONTROLLER {

    @Autowired
    private CAT_CARGO_SERVICE service;

    @GetMapping
    public List<CAT_CARGO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CAT_CARGO guardar(@RequestBody CAT_CARGO objeto) {
        return service.guardar(objeto);
    }
}