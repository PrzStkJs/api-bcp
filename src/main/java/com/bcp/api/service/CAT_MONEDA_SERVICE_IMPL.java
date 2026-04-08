package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.CAT_MONEDA;
import com.bcp.api.repository.CAT_MONEDA_REPOSITORY;

@Service
public class CAT_MONEDA_SERVICE_IMPL implements CAT_MONEDA_SERVICE {

    @Autowired
    private CAT_MONEDA_REPOSITORY repository;

    @Override
    public List<CAT_MONEDA> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CAT_MONEDA guardar(CAT_MONEDA objeto) {
        return repository.save(objeto);
    }
}