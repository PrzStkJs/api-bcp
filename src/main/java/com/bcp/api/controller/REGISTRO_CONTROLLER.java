package com.bcp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bcp.api.dto.RegistroTemporalDTO;
import com.bcp.api.service.REGISTRO_SERVICE;

@RestController
@RequestMapping("/api/registro") // Esta es la URL que usaremos en Swing
@CrossOrigin(origins = "*") // Permite que tu app de escritorio se conecte sin bloqueos
public class REGISTRO_CONTROLLER {

    @Autowired
    private REGISTRO_SERVICE registroService;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody RegistroTemporalDTO dto) {
        try {
            // Llamamos al servicio pro que armamos antes
            registroService.procesarRegistro(dto);
            
            // Si el método no tiró ninguna excepción, significa que todo salió bien
            return new ResponseEntity<>("Registro exitoso en Oracle", HttpStatus.CREATED);
            
        } catch (RuntimeException e) {
            String msg = e.getMessage();
            
            // Filtramos por el mensaje exacto que configuramos en el Service
            if ("ERROR_DNI_REPETIDO".equals(msg)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El DNI ya está registrado.");
            }
            
            if ("ERROR_CORREO_REPETIDO".equals(msg)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo ya está en uso.");
            }
            
            // Si fue cualquier otro fallo de base de datos o nulos
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar el registro");
        }
    }
}