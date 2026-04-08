package com.bcp.api.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.T_CUENTA_BANCARIA;

@Repository
public interface T_CUENTA_BANCARIA_REPOSITORY extends JpaRepository<T_CUENTA_BANCARIA, Integer> {

    // Usamos los nombres exactos de tus variables: tipoCuentaBancaria y tarjetas
    @Query("SELECT c FROM T_CUENTA_BANCARIA c " +
           "LEFT JOIN FETCH c.tipoCuentaBancaria tcb " + 
           "LEFT JOIN FETCH c.tarjetas t " +             
           "JOIN FETCH c.cliente cli " +
           "WHERE cli.persona.PER_N_ID = :personaId")
    List<T_CUENTA_BANCARIA> findTodoByPersonaId(@Param("personaId") Integer personaId);

    @Query("SELECT c FROM T_CUENTA_BANCARIA c WHERE c.cliente.persona.PER_N_ID = :personaId")
    List<T_CUENTA_BANCARIA> findAllByPersonaId(@Param("personaId") Integer personaId);
    
    @Query(value = "SELECT MAX(CUE_V_NUMERO) FROM T_CUENTA_BANCARIA", nativeQuery = true)
    String findMaxNumeroCuenta();
    
    @Query("SELECT c FROM T_CUENTA_BANCARIA c WHERE c.CUE_V_NUMERO = :numero")
    Optional<T_CUENTA_BANCARIA> findByCUE_V_NUMERO(@Param("numero") String numero);
}