package com.bcp.api.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_PERSONA")
public class T_PERSONA {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "per_generator")
    @SequenceGenerator(
        name = "per_generator", 
        sequenceName = "T_PERSONA_PER_N_ID_SEQ",
        allocationSize = 1
    )
    @Column(name = "PER_N_ID")
    @JsonProperty("PER_N_ID")
    private Integer PER_N_ID;

    @Column(name = "PER_V_NOMBRE")
    @JsonProperty("PER_V_NOMBRE")
    private String PER_V_NOMBRE;

    @Column(name = "PER_V_APELLIDO")
    @JsonProperty("PER_V_APELLIDO")
    private String PER_V_APELLIDO;

    @Column(name = "PER_V_ESTADO")
    @JsonProperty("PER_V_ESTADO")
    private String PER_V_ESTADO;

    @Column(name = "PER_V_NUMERO_DOCUMENTO")
    @JsonProperty("PER_V_NUMERO_DOCUMENTO")
    private String PER_V_NUMERO_DOCUMENTO;

    @Column(name = "PER_V_TELEFONO")
    @JsonProperty("PER_V_TELEFONO")
    private String PER_V_TELEFONO;

    @Column(name = "PER_V_DIRECCION")
    @JsonProperty("PER_V_DIRECCION")
    private String PER_V_DIRECCION;

    @Column(name = "PER_D_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    @JsonProperty("PER_D_NACIMIENTO")
    private Date PER_D_NACIMIENTO;

    @Column(name = "PER_ID_N_REFERENTE")
    @JsonProperty("PER_ID_N_REFERENTE")
    private Integer PER_ID_N_REFERENTE;
    
    @ManyToOne
    @JoinColumn(name = "TDC_N_ID")
    @JsonProperty("tipoDocumento")// FK hacia CAT_TIPO_DOCUMENTO
    private CAT_TIPO_DOCUMENTO tipoDocumento; 

    public T_PERSONA() {}

    public T_PERSONA(int PER_N_ID, String PER_V_NOMBRE, String PER_V_APELLIDO, String PER_V_ESTADO, 
                     String PER_V_NUMERO_DOCUMENTO, String PER_V_TELEFONO, String PER_V_DIRECCION, 
                     Date PER_D_NACIMIENTO, Integer PER_ID_N_REFERENTE, CAT_TIPO_DOCUMENTO tipoDocumento) {
        this.PER_N_ID = PER_N_ID;
        this.PER_V_NOMBRE = PER_V_NOMBRE;
        this.PER_V_APELLIDO = PER_V_APELLIDO;
        this.PER_V_ESTADO = PER_V_ESTADO;
        this.PER_V_NUMERO_DOCUMENTO = PER_V_NUMERO_DOCUMENTO;
        this.PER_V_TELEFONO = PER_V_TELEFONO;
        this.PER_V_DIRECCION = PER_V_DIRECCION;
        this.PER_D_NACIMIENTO = PER_D_NACIMIENTO;
        this.PER_ID_N_REFERENTE = PER_ID_N_REFERENTE;
        this.tipoDocumento = tipoDocumento;
    }

    public int getPER_N_ID() { return PER_N_ID; }
    public void setPER_N_ID(int pER_N_ID) { PER_N_ID = pER_N_ID; }

    public String getPER_V_NOMBRE() { return PER_V_NOMBRE; }
    public void setPER_V_NOMBRE(String pER_V_NOMBRE) { PER_V_NOMBRE = pER_V_NOMBRE; }

    public String getPER_V_APELLIDO() { return PER_V_APELLIDO; }
    public void setPER_V_APELLIDO(String pER_V_APELLIDO) { PER_V_APELLIDO = pER_V_APELLIDO; }

    public String getPER_V_ESTADO() { return PER_V_ESTADO; }
    public void setPER_V_ESTADO(String pER_V_ESTADO) { PER_V_ESTADO = pER_V_ESTADO; }

    public String getPER_V_NUMERO_DOCUMENTO() { return PER_V_NUMERO_DOCUMENTO; }
    public void setPER_V_NUMERO_DOCUMENTO(String pER_V_NUMERO_DOCUMENTO) { PER_V_NUMERO_DOCUMENTO = pER_V_NUMERO_DOCUMENTO; }

    public String getPER_V_TELEFONO() { return PER_V_TELEFONO; }
    public void setPER_V_TELEFONO(String pER_V_TELEFONO) { PER_V_TELEFONO = pER_V_TELEFONO; }

    public String getPER_V_DIRECCION() { return PER_V_DIRECCION; }
    public void setPER_V_DIRECCION(String pER_V_DIRECCION) { PER_V_DIRECCION = pER_V_DIRECCION; }

    public Date getPER_D_NACIMIENTO() { return PER_D_NACIMIENTO; }
    public void setPER_D_NACIMIENTO(Date pER_D_NACIMIENTO) { PER_D_NACIMIENTO = pER_D_NACIMIENTO; }

    public Integer getPER_ID_N_REFERENTE() { return PER_ID_N_REFERENTE; }
    public void setPER_ID_N_REFERENTE(Integer pER_ID_N_REFERENTE) { PER_ID_N_REFERENTE = pER_ID_N_REFERENTE; }

    public CAT_TIPO_DOCUMENTO getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(CAT_TIPO_DOCUMENTO tipoDocumento) { this.tipoDocumento = tipoDocumento; }
}