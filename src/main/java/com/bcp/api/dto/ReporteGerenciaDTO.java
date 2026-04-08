package com.bcp.api.dto;

public class ReporteGerenciaDTO {
    public Integer id;
    public String cliente;
    public String documento;
    public Double balance;
    public String estado;

    public ReporteGerenciaDTO() {}

    public ReporteGerenciaDTO(Integer id, String cliente, String documento, Double balance, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.documento = documento;
        this.balance = balance;
        this.estado = estado;
    }
}