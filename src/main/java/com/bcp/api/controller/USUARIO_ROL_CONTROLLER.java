package com.bcp.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bcp.api.model.USUARIO_ROL;
import com.bcp.api.service.USUARIO_ROL_SERVICE;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api") 
public class USUARIO_ROL_CONTROLLER {

    @Autowired
    private USUARIO_ROL_SERVICE service;

    // Mantenemos la caché para el listado general si lo necesitas
    private List<USUARIO_ROL> cacheLista = null;

    @GetMapping("/usuario-rol")
    public List<USUARIO_ROL> listar() {
        if (cacheLista == null) {
            cacheLista = service.listarTodos();
        }
        return cacheLista;
    }

    @GetMapping("/login")
    public ResponseEntity<USUARIO_ROL> loginDirecto(
            @RequestParam("dni") String dni, 
            @RequestParam("pass") String pass) {
        
        System.out.println("[API] Intento de login. Leyendo datos frescos de Oracle...");
        
        // No usamos 'cacheLista'. Obligamos al Service a ir a Oracle por datos nuevos.
        List<USUARIO_ROL> listaFresca = service.listarTodos();
        
        // Buscamos sobre la lista recién traída de Oracle
        for (USUARIO_ROL ur : listaFresca) {
            if (ur.getUsuario() != null && ur.getUsuario().getPersona() != null) {
                String dniDB = ur.getUsuario().getPersona().getPER_V_NUMERO_DOCUMENTO().trim();
                String passDB = ur.getUsuario().getUSR_V_PASSWORD().trim();

                if (dniDB.equals(dni.trim()) && passDB.equals(pass.trim())) {
                    System.out.println("[API] Login exitoso para el DNI: " + dni);
                    return ResponseEntity.ok(ur); 
                }
            }
        }
        
        System.out.println("[API] Credenciales incorrectas para el DNI: " + dni);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // ============================================================
    // NUEVO: ENDPOINT PARA RECUPERAR CONTRASEÑA
    // Este es el que llama tu ApiService.java desde el Swing
    // ============================================================
    @GetMapping("/recuperar")
    public ResponseEntity<USUARIO_ROL> recuperarClave(@RequestParam("dni") String dni) {
        System.out.println("[API] Petición de recuperación recibida para DNI: " + dni);
        
        // Usamos el método buscarPorDni que ya tiene la @Query en el Repository
        return service.buscarPorDni(dni)
                .map(record -> {
                    System.out.println("[API] Usuario encontrado. Enviando datos a la App...");
                    return ResponseEntity.ok(record);
                })
                .orElseGet(() -> {
                    System.err.println("[API] No se encontró el DNI: " + dni);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                });
    }
}