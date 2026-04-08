package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.dto.PrestamoSolicitudDTO;
import com.bcp.api.model.T_PRESTAMO;
import com.bcp.api.service.T_PRESTAMO_SERVICE;

@RestController
@RequestMapping("/api/t-prestamo")
@CrossOrigin(origins = "*") 
public class T_PRESTAMO_CONTROLLER {

    @Autowired
    private T_PRESTAMO_SERVICE service;

    @GetMapping
    public List<T_PRESTAMO> listar() {
        return service.listarTodos();
    }

    // Este es el método que usaremos desde Swing para la lógica pesada
    @PostMapping("/solicitar")
    public ResponseEntity<?> solicitarPrestamo(@RequestBody PrestamoSolicitudDTO dto) {
        try {
            String resultado = service.procesarSolicitudPrestamo(dto);
            return ResponseEntity.ok().body("{\"mensaje\": \"" + resultado + "\"}");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @PostMapping
    public T_PRESTAMO guardar(@RequestBody T_PRESTAMO objeto) {
        return service.guardar(objeto);
    }
}