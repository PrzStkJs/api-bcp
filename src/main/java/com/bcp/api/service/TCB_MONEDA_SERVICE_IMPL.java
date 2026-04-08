package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.TCB_MONEDA;
import com.bcp.api.repository.TCB_MONEDA_REPOSITORY;

@Service
public class TCB_MONEDA_SERVICE_IMPL implements TCB_MONEDA_SERVICE {

    @Autowired
    private TCB_MONEDA_REPOSITORY repository;

    @Override
    public List<TCB_MONEDA> listarTodos() {
        return repository.findAll();
    }

    @Override
    public TCB_MONEDA guardar(TCB_MONEDA objeto) {
        return repository.save(objeto);
    }
}