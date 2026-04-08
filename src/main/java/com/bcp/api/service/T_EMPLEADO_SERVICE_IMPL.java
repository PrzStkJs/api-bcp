package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.T_EMPLEADO;
import com.bcp.api.repository.T_EMPLEADO_REPOSITORY;

@Service
public class T_EMPLEADO_SERVICE_IMPL implements T_EMPLEADO_SERVICE {

    @Autowired
    private T_EMPLEADO_REPOSITORY repository;

    @Override
    public List<T_EMPLEADO> listarTodos() {
        return repository.findAll();
    }

    @Override
    public T_EMPLEADO guardar(T_EMPLEADO objeto) {
        return repository.save(objeto);
    }
}