package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.api.model.CAT_COMISION;
import com.bcp.api.repository.CAT_COMISION_REPOSITORY;

@Service
public class CAT_COMISION_SERVICE_IMPL implements CAT_COMISION_SERVICE {

    @Autowired
    private CAT_COMISION_REPOSITORY repository;

    @Override
    public List<CAT_COMISION> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CAT_COMISION guardar(CAT_COMISION objeto) {
        return repository.save(objeto);
    }
}