package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_MONEDA;

@Repository
public interface CAT_MONEDA_REPOSITORY extends JpaRepository<CAT_MONEDA, Integer> {
}