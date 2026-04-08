package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.T_PERSONA;
import com.bcp.api.repository.T_PERSONA_REPOSITORY;

@Service
public class T_PERSONA_SERVICE_IMPL implements T_PERSONA_SERVICE {

    @Autowired
    private T_PERSONA_REPOSITORY repository;

    @Override
    public List<T_PERSONA> listarTodos() {
        return repository.findAll();
    }

    @Override
    public T_PERSONA guardar(T_PERSONA objeto) {
        return repository.save(objeto);
    }
}