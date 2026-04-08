package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.ROL_PERMISO;
import com.bcp.api.repository.ROL_PERMISO_REPOSITORY;

@Service
public class ROL_PERMISO_SERVICE_IMPL implements ROL_PERMISO_SERVICE {

    @Autowired
    private ROL_PERMISO_REPOSITORY repository;

    @Override
    public List<ROL_PERMISO> listarTodos() {
        return repository.findAll();
    }

    @Override
    public ROL_PERMISO guardar(ROL_PERMISO objeto) {
        return repository.save(objeto);
    }
}