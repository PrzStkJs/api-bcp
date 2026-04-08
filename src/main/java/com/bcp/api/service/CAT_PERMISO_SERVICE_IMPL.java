package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.CAT_PERMISO;
import com.bcp.api.repository.CAT_PERMISO_REPOSITORY;

@Service
public class CAT_PERMISO_SERVICE_IMPL implements CAT_PERMISO_SERVICE {

    @Autowired
    private CAT_PERMISO_REPOSITORY repository;

    @Override
    public List<CAT_PERMISO> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CAT_PERMISO guardar(CAT_PERMISO objeto) {
        return repository.save(objeto);
    }
}