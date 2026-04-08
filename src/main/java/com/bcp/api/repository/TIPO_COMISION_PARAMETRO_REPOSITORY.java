package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.TIPO_COMISION_PARAMETRO;
import com.bcp.api.model.TIPO_COMISION_PARAMETRO_ID;

@Repository
public interface TIPO_COMISION_PARAMETRO_REPOSITORY extends JpaRepository<TIPO_COMISION_PARAMETRO, TIPO_COMISION_PARAMETRO_ID> {
}