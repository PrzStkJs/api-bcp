package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_COMISION;

@Repository
public interface CAT_COMISION_REPOSITORY extends JpaRepository<CAT_COMISION, Integer> {
}