package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional; 

import com.bcp.api.model.T_USUARIO;

@Repository
public interface T_USUARIO_REPOSITORY extends JpaRepository<T_USUARIO, Integer> {

    
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = "INSERT INTO USUARIO_ROL (USR_N_ID, ROL_N_ID) VALUES (:usuarioId, :rolId)", nativeQuery = true)
    void asignarRolDefault(@Param("usuarioId") Integer usuarioId, @Param("rolId") Integer rolId);
    
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = "INSERT INTO T_CLIENTE (CLI_D_FECHA_REGISTRO, CLI_V_ESTADO, PER_N_ID, TCL_N_ID) VALUES (SYSDATE, 'A', :personaId, :tipoClienteId)", nativeQuery = true)
    void registrarComoCliente(@Param("personaId") Integer personaId, @Param("tipoClienteId") Integer tipoClienteId);
    
    @Query("SELECT COUNT(u) > 0 FROM T_USUARIO u WHERE u.USR_V_CORREO = :correo")
    boolean existsByUSR_V_CORREO(@Param("correo") String correo);
    
    @Modifying
    @Query(value = "INSERT INTO T_CUENTA_BANCARIA (CUE_V_NUMERO, CUE_N_SALDO, CUE_D_FECHA_CREACION, CUE_V_ESTADO, CLI_N_ID, TCB_N_ID, MON_N_ID) " +
                   "VALUES (:numeroCuenta, 0.00, CURRENT_DATE, 'A', " +
                   "(SELECT CLI_N_ID FROM T_CLIENTE WHERE PER_N_ID = :personaId), 1, 1)", nativeQuery = true)
    void crearCuentaNueva(@Param("personaId") Integer personaId, @Param("numeroCuenta") String numeroCuenta);
}
