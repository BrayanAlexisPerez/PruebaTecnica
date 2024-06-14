package com.pruebatecnica.parteB.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignacion;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha_asignacion;

    @ManyToOne
    @JoinColumn(name = "id_soporte")
    @JsonIgnore
    private Soporte soporte;

    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    @JsonIgnore
    private Trabajador trabajador;

    public Asignacion() {
    }

    public Asignacion(Long id_asignacion, Date fecha_asignacion, Soporte soporte, Trabajador trabajador) {
        this.id_asignacion = id_asignacion;
        this.fecha_asignacion = fecha_asignacion;
        this.soporte = soporte;
        this.trabajador = trabajador;
    }

    public Long getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(Long id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public Date getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public Soporte getSoporte() {
        return soporte;
    }

    public void setSoporte(Soporte soporte) {
        this.soporte = soporte;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    
    
}
