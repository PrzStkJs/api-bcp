package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.T_LOG;

@Repository
public interface T_LOG_REPOSITORY extends JpaRepository<T_LOG, Integer> {
}