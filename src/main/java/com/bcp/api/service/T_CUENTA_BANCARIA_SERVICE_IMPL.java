package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.T_CUENTA_BANCARIA;
import com.bcp.api.repository.T_CUENTA_BANCARIA_REPOSITORY;

@Service
public class T_CUENTA_BANCARIA_SERVICE_IMPL implements T_CUENTA_BANCARIA_SERVICE {

    @Autowired
    private T_CUENTA_BANCARIA_REPOSITORY repository;

    @Override
    public List<T_CUENTA_BANCARIA> listarTodos() {
        return repository.findAll();
    }

    @Override
    public T_CUENTA_BANCARIA guardar(T_CUENTA_BANCARIA objeto) {
        return repository.save(objeto);
    }
}