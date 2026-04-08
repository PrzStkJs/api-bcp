package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_ACCION_AUDITORIA;

@Repository
public interface CAT_ACCION_AUDITORIA_REPOSITORY extends JpaRepository<CAT_ACCION_AUDITORIA, Integer> {
    // Usamos Integer porque tu ID (ACU_N_ID) es de tipo int
}