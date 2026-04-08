package com.bcp.api.service;

import java.util.List;
import com.bcp.api.dto.TarjetaDTO;
import com.bcp.api.model.T_TARJETA;

public interface T_TARJETA_SERVICE {
    List<T_TARJETA> listarTodos(); // Arreglado el nombre del modelo
    T_TARJETA guardar(T_TARJETA objeto);
    
    // Debe ser String para que coincida con la solución rápida
    public List<TarjetaDTO> listarTarjetasPorCuenta(String numeroCuenta);
}