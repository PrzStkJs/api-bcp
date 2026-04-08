package com.bcp.api.service;

import java.util.List;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.USUARIO_ROL;
import com.bcp.api.repository.USUARIO_ROL_REPOSITORY;

@Service
public class USUARIO_ROL_SERVICE_IMPL implements USUARIO_ROL_SERVICE {

    @Autowired
    private USUARIO_ROL_REPOSITORY repository;

    @Override
    public List<USUARIO_ROL> listarTodos() {
        return repository.findAll();
    }

    @Override
    public USUARIO_ROL guardar(USUARIO_ROL usuarioRol) {
        return repository.save(usuarioRol);
    }

    // ============================================================
    // IMPLEMENTACIÓN CORREGIDA PARA EVITAR EL ERROR DE PROPIEDAD
    // ============================================================
    @Override
    public Optional<USUARIO_ROL> buscarPorDni(String dni) {
        // CAMBIO: Ahora llamamos al método buscarPorDniReal
        // que definiremos en el Repository con @Query
        return repository.buscarPorDniReal(dni);
    }
}