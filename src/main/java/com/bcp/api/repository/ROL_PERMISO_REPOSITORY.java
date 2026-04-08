package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.ROL_PERMISO;
import com.bcp.api.model.ROL_PERMISO_ID; // Importamos la llave compuesta

@Repository
public interface ROL_PERMISO_REPOSITORY extends JpaRepository<ROL_PERMISO, ROL_PERMISO_ID> {
}