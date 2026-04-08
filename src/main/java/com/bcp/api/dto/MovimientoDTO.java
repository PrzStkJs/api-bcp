package com.bcp.api.dto;

import java.util.Date;

public class MovimientoDTO {
    public Long id;
    public Date fecha;
    public String operacion; // Aquí diremos "PRÉSTAMO", "TRANSFERENCIA", etc.
    public String referencia;
    public double monto;
    public String moneda;
}