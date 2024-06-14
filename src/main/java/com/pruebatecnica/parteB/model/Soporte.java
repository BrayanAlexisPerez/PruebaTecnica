package com.pruebatecnica.parteB.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Soporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_soporte;

    @Column(nullable = false)
    private String nombre;
    
    private String descripcion;

    @Column(nullable = false)
    private int prioridad;

    @Column(nullable = false)
    private int peso_trabajo;

    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    @JsonIgnore
    private Trabajador trabajador;

    public Soporte() {
    }

    public Soporte(Long id_soporte, String nombre, String description, int prioridad, int peso_trabajo,
            Trabajador trabajador) {
        this.id_soporte = id_soporte;
        this.nombre = nombre;
        this.descripcion = description;
        this.prioridad = prioridad;
        this.peso_trabajo = peso_trabajo;
        this.trabajador = trabajador;
    }

    public Long getId_soporte() {
        return id_soporte;
    }

    public void setId_soporte(Long id_soporte) {
        this.id_soporte = id_soporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String description) {
        this.descripcion = description;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPeso_trabajo() {
        return peso_trabajo;
    }

    public void setPeso_trabajo(int peso_trabajo) {
        this.peso_trabajo = peso_trabajo;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    
}
