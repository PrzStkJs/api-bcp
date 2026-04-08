package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_PARAMETRO_COMISION;

@Repository
public interface CAT_PARAMETRO_COMISION_REPOSITORY extends JpaRepository<CAT_PARAMETRO_COMISION, Integer> {
}