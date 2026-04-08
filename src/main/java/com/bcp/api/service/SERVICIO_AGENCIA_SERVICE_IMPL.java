package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.SERVICIO_AGENCIA;
import com.bcp.api.repository.SERVICIO_AGENCIA_REPOSITORY;

@Service
public class SERVICIO_AGENCIA_SERVICE_IMPL implements SERVICIO_AGENCIA_SERVICE {

    @Autowired
    private SERVICIO_AGENCIA_REPOSITORY repository;

    @Override
    public List<SERVICIO_AGENCIA> listarTodos() {
        return repository.findAll();
    }

    @Override
    public SERVICIO_AGENCIA guardar(SERVICIO_AGENCIA objeto) {
        return repository.save(objeto);
    }
}