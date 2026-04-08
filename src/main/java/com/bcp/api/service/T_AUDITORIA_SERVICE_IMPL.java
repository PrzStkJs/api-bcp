package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.T_AUDITORIA;
import com.bcp.api.repository.T_AUDITORIA_REPOSITORY;

@Service
public class T_AUDITORIA_SERVICE_IMPL implements T_AUDITORIA_SERVICE {

    @Autowired
    private T_AUDITORIA_REPOSITORY repository;

    @Override
    public List<T_AUDITORIA> listarTodos() {
        return repository.findAll();
    }

    @Override
    public T_AUDITORIA guardar(T_AUDITORIA objeto) {
        return repository.save(objeto);
    }
}