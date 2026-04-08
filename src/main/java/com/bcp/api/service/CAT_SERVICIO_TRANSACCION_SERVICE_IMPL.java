package com.bcp.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcp.api.model.CAT_SERVICIO_TRANSACCION;
import com.bcp.api.repository.CAT_SERVICIO_TRANSACCION_REPOSITORY;

@Service
public class CAT_SERVICIO_TRANSACCION_SERVICE_IMPL implements CAT_SERVICIO_TRANSACCION_SERVICE {

    @Autowired
    private CAT_SERVICIO_TRANSACCION_REPOSITORY repository;

    @Override
    public List<CAT_SERVICIO_TRANSACCION> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CAT_SERVICIO_TRANSACCION guardar(CAT_SERVICIO_TRANSACCION objeto) {
        return repository.save(objeto);
    }
}