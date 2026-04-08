package com.bcp.api.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_CLIENTE")
public class T_CLIENTE {

    @Id
    @Column(name = "CLI_N_ID")
    @JsonProperty("CLI_N_ID")
    private int CLI_N_ID;

    @Column(name = "CLI_D_FECHA_REGISTRO")
    @Temporal(TemporalType.DATE)
    @JsonProperty("CLI_D_FECHA_REGISTRO")
    private Date CLI_D_FECHA_REGISTRO;

    @Column(name = "CLI_V_ESTADO")
    @JsonProperty("CLI_V_ESTADO")
    private String CLI_V_ESTADO;
    
    @ManyToOne
    @JoinColumn(name = "PER_N_ID")
    @JsonProperty("persona")
    private T_PERSONA persona;

    @ManyToOne
    @JoinColumn(name = "TCL_N_ID")
    @JsonProperty("tipoCliente")
    private CAT_TIPO_CLIENTE tipoCliente;

    public T_CLIENTE() {}

    public T_CLIENTE(int CLI_N_ID, Date CLI_D_FECHA_REGISTRO, String CLI_V_ESTADO, 
                     T_PERSONA persona, CAT_TIPO_CLIENTE tipoCliente) {
        this.CLI_N_ID = CLI_N_ID;
        this.CLI_D_FECHA_REGISTRO = CLI_D_FECHA_REGISTRO;
        this.CLI_V_ESTADO = CLI_V_ESTADO;
        this.persona = persona;
        this.tipoCliente = tipoCliente;
    }

    public int getCLI_N_ID() { return CLI_N_ID; }
    public void setCLI_N_ID(int cLI_N_ID) { CLI_N_ID = cLI_N_ID; }

    public Date getCLI_D_FECHA_REGISTRO() { return CLI_D_FECHA_REGISTRO; }
    public void setCLI_D_FECHA_REGISTRO(Date cLI_D_FECHA_REGISTRO) { CLI_D_FECHA_REGISTRO = cLI_D_FECHA_REGISTRO; }

    public String getCLI_V_ESTADO() { return CLI_V_ESTADO; }
    public void setCLI_V_ESTADO(String cLI_V_ESTADO) { CLI_V_ESTADO = cLI_V_ESTADO; }

    public T_PERSONA getPersona() { return persona; }
    public void setPersona(T_PERSONA persona) { this.persona = persona; }

    public CAT_TIPO_CLIENTE getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(CAT_TIPO_CLIENTE tipoCliente) { this.tipoCliente = tipoCliente; }
}