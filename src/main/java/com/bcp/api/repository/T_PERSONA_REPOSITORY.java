package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.T_PERSONA;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface T_PERSONA_REPOSITORY extends JpaRepository<T_PERSONA, Long> {
    
    @Query("SELECT COUNT(p) > 0 FROM T_PERSONA p WHERE p.PER_V_NUMERO_DOCUMENTO = :dni")
    boolean existsByPER_V_NUMERO_DOCUMENTO(@Param("dni") String dni);
    
    // Lo dejamos simple, sin FETCH, para no romper el inicio de la app
    @Query("SELECT p FROM T_PERSONA p WHERE p.PER_V_NUMERO_DOCUMENTO = :dni")
    T_PERSONA findByPER_V_NUMERO_DOCUMENTO(@Param("dni") String dni);

}