package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.api.model.CAT_MARCA_TARJETA;
import com.bcp.api.repository.CAT_MARCA_TARJETA_REPOSITORY;

@Service
public class CAT_MARCA_TARJETA_SERVICE_IMPL implements CAT_MARCA_TARJETA_SERVICE {

    @Autowired
    private CAT_MARCA_TARJETA_REPOSITORY repository;

    @Override
    public List<CAT_MARCA_TARJETA> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CAT_MARCA_TARJETA guardar(CAT_MARCA_TARJETA objeto) {
        return repository.save(objeto);
    }
}