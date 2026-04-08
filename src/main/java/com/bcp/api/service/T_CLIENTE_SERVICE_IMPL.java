package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.T_CLIENTE;
import com.bcp.api.repository.T_CLIENTE_REPOSITORY;

@Service
public class T_CLIENTE_SERVICE_IMPL implements T_CLIENTE_SERVICE {

    @Autowired
    private T_CLIENTE_REPOSITORY repository;

    @Override
    public List<T_CLIENTE> listarTodos() {
        return repository.findAll();
    }

    @Override
    public T_CLIENTE guardar(T_CLIENTE objeto) {
        return repository.save(objeto);
    }
}