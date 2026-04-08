package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.T_EMPLEADO;

@Repository
public interface T_EMPLEADO_REPOSITORY extends JpaRepository<T_EMPLEADO, Integer> {
}