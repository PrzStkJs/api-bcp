package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.TRX_TRANSACCION;
import java.util.List;

@Repository
public interface TRX_TRANSACCION_REPOSITORY extends JpaRepository<TRX_TRANSACCION, Long> {
    
    @Query("SELECT t FROM TRX_TRANSACCION t WHERE t.cuentaOrigen.CUE_V_NUMERO = :num " +
           "OR t.cuentaDestino.CUE_V_NUMERO = :num ORDER BY t.TRX_D_FECHA_HORA DESC")
    List<TRX_TRANSACCION> listarMovimientos(@Param("num") String numeroCuenta);
}