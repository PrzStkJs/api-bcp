package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.api.model.CAT_ACCION_AUDITORIA;
import com.bcp.api.repository.CAT_ACCION_AUDITORIA_REPOSITORY;

@Service
public class CAT_ACCION_AUDITORIA_SERVICE_IMPL implements CAT_ACCION_AUDITORIA_SERVICE {

    @Autowired
    private CAT_ACCION_AUDITORIA_REPOSITORY repository;

    @Override
    public List<CAT_ACCION_AUDITORIA> listarTodos() {
        // Aquí usamos el repositorio para traer los datos de Oracle
        return repository.findAll();
    }

    @Override
    public CAT_ACCION_AUDITORIA guardar(CAT_ACCION_AUDITORIA objeto) {
        // Aquí usamos el repositorio para guardar en Oracle
        return repository.save(objeto);
    }
}