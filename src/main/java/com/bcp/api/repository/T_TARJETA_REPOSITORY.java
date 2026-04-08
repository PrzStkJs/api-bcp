package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.T_TARJETA;

@Repository
public interface T_TARJETA_REPOSITORY extends JpaRepository<T_TARJETA, Integer> {
}