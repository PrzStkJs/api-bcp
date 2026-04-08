package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.api.model.CAT_CARGO;
import com.bcp.api.repository.CAT_CARGO_REPOSITORY;

@Service
public class CAT_CARGO_SERVICE_IMPL implements CAT_CARGO_SERVICE {

    @Autowired
    private CAT_CARGO_REPOSITORY repository;

    @Override
    public List<CAT_CARGO> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CAT_CARGO guardar(CAT_CARGO objeto) {
        return repository.save(objeto);
    }
}