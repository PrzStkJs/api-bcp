package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.TIPO_COMISION_PARAMETRO;
import com.bcp.api.repository.TIPO_COMISION_PARAMETRO_REPOSITORY;

@Service
public class TIPO_COMISION_PARAMETRO_SERVICE_IMPL implements TIPO_COMISION_PARAMETRO_SERVICE {

    @Autowired
    private TIPO_COMISION_PARAMETRO_REPOSITORY repository;

    @Override
    public List<TIPO_COMISION_PARAMETRO> listarTodos() {
        return repository.findAll();
    }

    @Override
    public TIPO_COMISION_PARAMETRO guardar(TIPO_COMISION_PARAMETRO objeto) {
        return repository.save(objeto);
    }
}