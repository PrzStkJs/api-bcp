package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_TIPO_TARJETA;

@Repository
public interface CAT_TIPO_TARJETA_REPOSITORY extends JpaRepository<CAT_TIPO_TARJETA, Integer> {
}