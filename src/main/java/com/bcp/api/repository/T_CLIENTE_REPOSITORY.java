package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.T_CLIENTE;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface T_CLIENTE_REPOSITORY extends JpaRepository<T_CLIENTE, Integer> {
    
    @Query("SELECT c FROM T_CLIENTE c WHERE c.persona.PER_N_ID = :personaId")
    T_CLIENTE findByPersonaId(@Param("personaId") Integer personaId);

    // NUEVA CONSULTA PARA GERENCIA - CORREGIDA
    @Query(value = "SELECT " +
            "    c.CLI_N_ID, " +
            "    p.PER_V_NOMBRE || ' ' || p.PER_V_APELLIDO, " +
            "    p.PER_V_NUMERO_DOCUMENTO, " + 
            "    COALESCE(SUM(cu.CUE_N_SALDO), 0), " +
            "    c.CLI_V_ESTADO " +
            "FROM T_CLIENTE c " +
            "INNER JOIN T_PERSONA p ON c.PER_N_ID = p.PER_N_ID " +
            "LEFT JOIN T_CUENTA_BANCARIA cu ON c.CLI_N_ID = cu.CLI_N_ID " +
            "GROUP BY " +
            "    c.CLI_N_ID, " +
            "    p.PER_V_NOMBRE, " +
            "    p.PER_V_APELLIDO, " +
            "    p.PER_V_NUMERO_DOCUMENTO, " + 
            "    c.CLI_V_ESTADO " +
            "ORDER BY c.CLI_N_ID ASC", nativeQuery = true) // <--- AGREGA ESTA LÍNEA
List<Object[]> obtenerDatosNativosGerencia();

@Modifying
@Transactional
@Query(value = "UPDATE T_CLIENTE SET CLI_V_ESTADO = 'I' WHERE CLI_N_ID = :id", nativeQuery = true)
void desactivarClienteNativo(@Param("id") int id);
}