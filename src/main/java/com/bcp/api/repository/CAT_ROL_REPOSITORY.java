package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_ROL;

@Repository
public interface CAT_ROL_REPOSITORY extends JpaRepository<CAT_ROL, Integer> {
}