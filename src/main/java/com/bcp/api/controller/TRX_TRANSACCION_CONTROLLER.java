package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bcp.api.dto.MovimientoDTO;
import com.bcp.api.model.TRX_TRANSACCION;
import com.bcp.api.service.TRX_TRANSACCION_SERVICE;

@RestController
@RequestMapping("/api/transaccion")
public class TRX_TRANSACCION_CONTROLLER {

    @Autowired
    private TRX_TRANSACCION_SERVICE service;

    @GetMapping
    public List<TRX_TRANSACCION> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public TRX_TRANSACCION guardar(@RequestBody TRX_TRANSACCION transaccion) {
        return service.guardar(transaccion);
    }
    
    @GetMapping("/movimientos/{numeroCuenta}")
    public List<MovimientoDTO> listarMovimientos(@PathVariable("numeroCuenta") String numeroCuenta) {
        return service.listarMovimientosPorCuenta(numeroCuenta);
    }
}