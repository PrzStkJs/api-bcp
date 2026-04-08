package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.CAT_SERVICIO;
import com.bcp.api.repository.CAT_SERVICIO_REPOSITORY;

@Service
public class CAT_SERVICIO_SERVICE_IMPL implements CAT_SERVICIO_SERVICE {

    @Autowired
    private CAT_SERVICIO_REPOSITORY repository;

    @Override
    public List<CAT_SERVICIO> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CAT_SERVICIO guardar(CAT_SERVICIO objeto) {
        return repository.save(objeto);
    }
}