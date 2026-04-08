package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_PERMISO;

@Repository
public interface CAT_PERMISO_REPOSITORY extends JpaRepository<CAT_PERMISO, Integer> {
}