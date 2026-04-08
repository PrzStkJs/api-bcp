package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.T_TARJETA;
import com.bcp.api.model.T_CUENTA_BANCARIA;
import com.bcp.api.model.CAT_TIPO_TARJETA;
import com.bcp.api.model.CAT_MARCA_TARJETA;
import com.bcp.api.service.T_TARJETA_SERVICE;
import com.bcp.api.dto.TarjetaDTO;
import com.bcp.api.dto.SolicitudTarjetaDTO; // 🔥 El nuevo DTO

@RestController
@RequestMapping("/api/t-tarjeta")
public class T_TARJETA_CONTROLLER {

    @Autowired
    private T_TARJETA_SERVICE service;

    @GetMapping
    public List<T_TARJETA> listar() {
        return service.listarTodos();
    }

    // Mantenemos este igual para no romper otras funciones
    @PostMapping
    public T_TARJETA guardar(@RequestBody T_TARJETA objeto) {
        return service.guardar(objeto);
    }

    // 🔥 NUEVO MÉTODO: Específico para tu MisTarjetasPanel
    @PostMapping("/guardar")
    public T_TARJETA solicitarDesdeApp(@RequestBody com.bcp.api.dto.SolicitudTarjetaDTO dto) {
        T_TARJETA nueva = new T_TARJETA();
        
        // 1. Vincular Cuenta usando el ID del wrapper
        com.bcp.api.model.T_CUENTA_BANCARIA cta = new com.bcp.api.model.T_CUENTA_BANCARIA();
        cta.setCUE_N_ID(dto.cuentaBancaria.cue_n_id);
        nueva.setCuentaBancaria(cta);
        
        // 2. Vincular Tipo
        com.bcp.api.model.CAT_TIPO_TARJETA tipo = new com.bcp.api.model.CAT_TIPO_TARJETA();
        tipo.setTTJ_N_ID(dto.tipoTarjeta.ttj_n_id);
        nueva.setTipoTarjeta(tipo);
        
        // 3. Vincular Marca
        com.bcp.api.model.CAT_MARCA_TARJETA marca = new com.bcp.api.model.CAT_MARCA_TARJETA();
        marca.setMAR_N_ID(dto.marcaTarjeta.mar_n_id);
        nueva.setMarcaTarjeta(marca);
        
        // Guardar usando el service que ya tienes
        return service.guardar(nueva);
    }

    

    @GetMapping("/cuenta/{numeroCuenta}")
    public List<TarjetaDTO> listarPorCuenta(@PathVariable("numeroCuenta") String numeroCuenta) {
        return service.listarTarjetasPorCuenta(numeroCuenta);
    }
}