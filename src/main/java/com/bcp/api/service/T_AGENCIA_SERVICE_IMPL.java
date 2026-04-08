package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.T_AGENCIA;
import com.bcp.api.repository.T_AGENCIA_REPOSITORY;

@Service
public class T_AGENCIA_SERVICE_IMPL implements T_AGENCIA_SERVICE {

    @Autowired
    private T_AGENCIA_REPOSITORY repository;

    @Override
    public List<T_AGENCIA> listarTodos() {
        return repository.findAll();
    }

    @Override
    public T_AGENCIA guardar(T_AGENCIA objeto) {
        return repository.save(objeto);
    }
}