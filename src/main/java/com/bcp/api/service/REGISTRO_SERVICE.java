package com.bcp.api.service;

import com.bcp.api.dto.RegistroTemporalDTO;

public interface REGISTRO_SERVICE {
    // Este método recibirá el paquete de Swing y devolverá true si todo sale bien
    boolean procesarRegistro(RegistroTemporalDTO dto);
}