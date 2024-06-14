package com.pruebatecnica.parteB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_trabajador;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int pesoAcumulado;

    public Trabajador() {
    }

    public Trabajador(Long id_trabajador, String nombre, int peso_acumulado) {
        this.id_trabajador = id_trabajador;
        this.nombre = nombre;
        this.pesoAcumulado = peso_acumulado;
    }

    public Long getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(Long id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPesoAcumulado() {
        return pesoAcumulado;
    }

    public void setPesoAcumulado(int pesoAcumulado) {
        this.pesoAcumulado = pesoAcumulado;
    }

    
}

