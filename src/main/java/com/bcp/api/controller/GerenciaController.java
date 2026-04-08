package com.bcp.api.controller;

import com.bcp.api.dto.ReporteGerenciaDTO;
import com.bcp.api.service.GerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gerencia")
@CrossOrigin(origins = "*") 
public class GerenciaController {

    @Autowired
    private GerenciaService gerenciaService;

    @GetMapping("/reporte")
    public ResponseEntity<?> obtenerReporte() {
        try {
            List<ReporteGerenciaDTO> lista = gerenciaService.listarTodoParaGerencia();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            System.err.println("=== ERROR EN EL REPORTE GERENCIAL ===");
            e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error en el servidor: " + e.getMessage());
        }
    }

 // --- MÉTODO PARA DESACTIVAR CUENTA CORREGIDO ---
    @PutMapping("/desactivar/{id}")
    public ResponseEntity<?> desactivarCuenta(@PathVariable("id") int id) {
        try {
            // Llamamos al servicio para que haga el UPDATE en Oracle
            gerenciaService.desactivarCliente(id);
            return ResponseEntity.ok("Cliente " + id + " desactivado correctamente.");
        } catch (Exception e) {
            System.err.println("=== ERROR AL DESACTIVAR CUENTA ===");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("No se pudo desactivar: " + e.getMessage());
        }
    }
}