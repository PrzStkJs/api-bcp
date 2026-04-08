package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_MEDIO_OPERACION;

@Repository
public interface CAT_MEDIO_OPERACION_REPOSITORY extends JpaRepository<CAT_MEDIO_OPERACION, Integer> {
}