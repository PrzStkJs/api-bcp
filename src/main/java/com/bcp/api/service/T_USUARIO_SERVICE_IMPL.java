package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.T_USUARIO;
import com.bcp.api.repository.T_USUARIO_REPOSITORY;



@Service
public class T_USUARIO_SERVICE_IMPL implements T_USUARIO_SERVICE {

    @Autowired
    private T_USUARIO_REPOSITORY repository;


    @Override
    public List<T_USUARIO> listarTodos() {
        return repository.findAll();
    }


    @Override
    public T_USUARIO guardar(T_USUARIO objeto) {
        return repository.save(objeto);

    }

}