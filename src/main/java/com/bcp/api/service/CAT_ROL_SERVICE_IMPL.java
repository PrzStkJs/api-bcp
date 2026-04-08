package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.CAT_ROL;
import com.bcp.api.repository.CAT_ROL_REPOSITORY;

@Service
public class CAT_ROL_SERVICE_IMPL implements CAT_ROL_SERVICE {

    @Autowired
    private CAT_ROL_REPOSITORY repository;

    @Override
    public List<CAT_ROL> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CAT_ROL guardar(CAT_ROL objeto) {
        return repository.save(objeto);
    }
}