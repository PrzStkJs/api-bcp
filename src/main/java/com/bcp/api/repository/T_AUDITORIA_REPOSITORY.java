package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.T_AUDITORIA;

@Repository
public interface T_AUDITORIA_REPOSITORY extends JpaRepository<T_AUDITORIA, Integer> {
}