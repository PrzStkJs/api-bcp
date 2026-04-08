package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.CAT_TIPO_TRANSACCION;
import com.bcp.api.repository.CAT_TIPO_TRANSACCION_REPOSITORY;

@Service
public class CAT_TIPO_TRANSACCION_SERVICE_IMPL implements CAT_TIPO_TRANSACCION_SERVICE {

    @Autowired
    private CAT_TIPO_TRANSACCION_REPOSITORY repository;

    @Override
    public List<CAT_TIPO_TRANSACCION> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CAT_TIPO_TRANSACCION guardar(CAT_TIPO_TRANSACCION objeto) {
        return repository.save(objeto);
    }
}