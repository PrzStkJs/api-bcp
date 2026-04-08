package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.T_PRESTAMO;

@Repository
public interface T_PRESTAMO_REPOSITORY extends JpaRepository<T_PRESTAMO, Integer> {
}