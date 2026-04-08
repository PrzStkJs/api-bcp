package com.bcp.api.service;

import java.util.List;
import java.util.Optional; // Importante para manejar si el DNI no existe
import com.bcp.api.model.USUARIO_ROL;

public interface USUARIO_ROL_SERVICE {
    List<USUARIO_ROL> listarTodos();
    USUARIO_ROL guardar(USUARIO_ROL usuarioRol);
    
    // NUEVO: Método para buscar los datos de recuperación por DNI
    Optional<USUARIO_ROL> buscarPorDni(String dni);
}