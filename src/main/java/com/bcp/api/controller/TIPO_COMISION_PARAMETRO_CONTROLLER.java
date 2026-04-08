package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.TIPO_COMISION_PARAMETRO;
import com.bcp.api.service.TIPO_COMISION_PARAMETRO_SERVICE;

@RestController
@RequestMapping("/api/tipo-comision-parametro")
public class TIPO_COMISION_PARAMETRO_CONTROLLER {

    @Autowired
    private TIPO_COMISION_PARAMETRO_SERVICE service;

    @GetMapping
    public List<TIPO_COMISION_PARAMETRO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public TIPO_COMISION_PARAMETRO guardar(@RequestBody TIPO_COMISION_PARAMETRO objeto) {
        return service.guardar(objeto);
    }
}