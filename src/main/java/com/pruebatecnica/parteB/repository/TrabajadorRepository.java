package com.pruebatecnica.parteB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pruebatecnica.parteB.model.Trabajador;
import java.util.List;


public interface TrabajadorRepository extends JpaRepository<Trabajador, Long>{

    List<Trabajador> findByNombre(String nombre);
    List<Trabajador> findByPesoAcumulado(int peso_acumulado);
}
