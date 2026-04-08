package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.CAT_MEDIO_OPERACION;
import com.bcp.api.repository.CAT_MEDIO_OPERACION_REPOSITORY;

@Service
public class CAT_MEDIO_OPERACION_SERVICE_IMPL implements CAT_MEDIO_OPERACION_SERVICE {

    @Autowired
    private CAT_MEDIO_OPERACION_REPOSITORY repository;

    @Override
    public List<CAT_MEDIO_OPERACION> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CAT_MEDIO_OPERACION guardar(CAT_MEDIO_OPERACION objeto) {
        return repository.save(objeto);
    }
}