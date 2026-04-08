package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.SERVICIO_AGENCIA;
import com.bcp.api.model.SERVICIO_AGENCIA_ID;

@Repository
public interface SERVICIO_AGENCIA_REPOSITORY extends JpaRepository<SERVICIO_AGENCIA, SERVICIO_AGENCIA_ID> {
}