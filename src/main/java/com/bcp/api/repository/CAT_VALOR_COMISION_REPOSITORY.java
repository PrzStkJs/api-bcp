package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_VALOR_COMISION;

@Repository
public interface CAT_VALOR_COMISION_REPOSITORY extends JpaRepository<CAT_VALOR_COMISION, Integer> {
}