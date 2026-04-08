package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_SERVICIO_TRANSACCION;

@Repository
public interface CAT_SERVICIO_TRANSACCION_REPOSITORY extends JpaRepository<CAT_SERVICIO_TRANSACCION, Integer> {
}