package com.bcp.api.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_EMPLEADO")
public class T_EMPLEADO {

    @Id
    @Column(name = "EMP_N_ID")
    @JsonProperty("EMP_N_ID")
    private int EMP_N_ID;

    @Column(name = "EMP_N_SUELDO")
    @JsonProperty("EMP_N_SUELDO")
    private double EMP_N_SUELDO;

    @Column(name = "EMP_D_FECHA_CONTRATACION")
    @Temporal(TemporalType.DATE)
    @JsonProperty("EMP_D_FECHA_CONTRATACION")
    private Date EMP_D_FECHA_CONTRATACION;

    @Column(name = "EMP_V_ESTADO")
    @JsonProperty("EMP_V_ESTADO")
    private String EMP_V_ESTADO;

    @ManyToOne
    @JoinColumn(name = "PER_N_ID")
    @JsonProperty("persona")
    private T_PERSONA persona;

    @ManyToOne
    @JoinColumn(name = "AGE_N_ID")
    @JsonProperty("agencia")
    private T_AGENCIA agencia;

    @ManyToOne
    @JoinColumn(name = "EMP_N_SUPERVISOR_ID")
    @JsonProperty("supervisor")
    private T_EMPLEADO supervisor;

    @ManyToOne
    @JoinColumn(name = "CAR_N_ID")
    @JsonProperty("cargo")
    private CAT_CARGO cargo;

    public T_EMPLEADO() {}

    public T_EMPLEADO(int EMP_N_ID, double EMP_N_SUELDO, Date EMP_D_FECHA_CONTRATACION, 
                      String EMP_V_ESTADO, T_PERSONA persona, T_AGENCIA agencia, 
                      T_EMPLEADO supervisor, CAT_CARGO cargo) {
        this.EMP_N_ID = EMP_N_ID;
        this.EMP_N_SUELDO = EMP_N_SUELDO;
        this.EMP_D_FECHA_CONTRATACION = EMP_D_FECHA_CONTRATACION;
        this.EMP_V_ESTADO = EMP_V_ESTADO;
        this.persona = persona;
        this.agencia = agencia;
        this.supervisor = supervisor;
        this.cargo = cargo;
    }

    // Getters y Setters
    public int getEMP_N_ID() { return EMP_N_ID; }
    public void setEMP_N_ID(int eMP_N_ID) { EMP_N_ID = eMP_N_ID; }
    public double getEMP_N_SUELDO() { return EMP_N_SUELDO; }
    public void setEMP_N_SUELDO(double eMP_N_SUELDO) { EMP_N_SUELDO = eMP_N_SUELDO; }
    public Date getEMP_D_FECHA_CONTRATACION() { return EMP_D_FECHA_CONTRATACION; }
    public void setEMP_D_FECHA_CONTRATACION(Date eMP_D_FECHA_CONTRATACION) { EMP_D_FECHA_CONTRATACION = eMP_D_FECHA_CONTRATACION; }
    public String getEMP_V_ESTADO() { return EMP_V_ESTADO; }
    public void setEMP_V_ESTADO(String eMP_V_ESTADO) { EMP_V_ESTADO = eMP_V_ESTADO; }
    public T_PERSONA getPersona() { return persona; }
    public void setPersona(T_PERSONA persona) { this.persona = persona; }
    public T_AGENCIA getAgencia() { return agencia; }
    public void setAgencia(T_AGENCIA agencia) { this.agencia = agencia; }
    public T_EMPLEADO getSupervisor() { return supervisor; }
    public void setSupervisor(T_EMPLEADO supervisor) { this.supervisor = supervisor; }
    public CAT_CARGO getCargo() { return cargo; }
    public void setCargo(CAT_CARGO cargo) { this.cargo = cargo; }
}