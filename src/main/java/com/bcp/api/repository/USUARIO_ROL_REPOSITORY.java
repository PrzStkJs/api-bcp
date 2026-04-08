package com.bcp.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.USUARIO_ROL;
import com.bcp.api.model.USUARIO_ROL_ID;

@Repository
public interface USUARIO_ROL_REPOSITORY extends JpaRepository<USUARIO_ROL, USUARIO_ROL_ID> {
    
    // Usamos @Query para decirle exactamente qué buscar sin que Spring se confunda con los nombres
    @Query("SELECT ur FROM USUARIO_ROL ur WHERE ur.usuario.persona.PER_V_NUMERO_DOCUMENTO = :dni")
    Optional<USUARIO_ROL> buscarPorDniReal(@Param("dni") String dni);
}