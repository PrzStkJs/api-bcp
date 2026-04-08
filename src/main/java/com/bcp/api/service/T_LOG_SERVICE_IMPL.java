package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.T_LOG;
import com.bcp.api.repository.T_LOG_REPOSITORY;

@Service
public class T_LOG_SERVICE_IMPL implements T_LOG_SERVICE {

    @Autowired
    private T_LOG_REPOSITORY repository;

    @Override
    public List<T_LOG> listarTodos() {
        return repository.findAll();
    }

    @Override
    public T_LOG guardar(T_LOG objeto) {
        return repository.save(objeto);
    }
}