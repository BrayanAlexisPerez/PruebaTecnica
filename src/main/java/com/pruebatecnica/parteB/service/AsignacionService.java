package com.pruebatecnica.parteB.service;

import java.util.Random;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.parteB.model.Asignacion;
import com.pruebatecnica.parteB.model.Soporte;
import com.pruebatecnica.parteB.model.Trabajador;
import com.pruebatecnica.parteB.repository.AsignacionRepository;
import com.pruebatecnica.parteB.repository.SoporteRepository;
import com.pruebatecnica.parteB.repository.TrabajadorRepository;

import jakarta.transaction.Transactional;

@Service
public class AsignacionService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private SoporteRepository soporteRepository;

    @Autowired
    private AsignacionRepository asignacionRepository;


    @Transactional
    public String asignarSoporte(Soporte soporte) {

        Trabajador trabajador = seleccionarTrabajador();

        soporte.setTrabajador(trabajador);
        trabajador.setPesoAcumulado(trabajador.getPesoAcumulado() + soporte.getPeso_trabajo());

        soporteRepository.save(soporte);
        trabajadorRepository.save(trabajador);

        Asignacion asignacion = new Asignacion();
        asignacion.setSoporte(soporte);
        asignacion.setTrabajador(trabajador);
        asignacion.setFecha_asignacion(new Date());
        asignacionRepository.save(asignacion);

        return "El soporte fue asignado a "+ trabajador.getNombre();
    }

    private Trabajador seleccionarTrabajador(){
        List<Trabajador> candidatos = trabajadorRepository.findByPesoAcumulado(
                trabajadorRepository.findAll()
                        .stream()
                        .mapToInt(Trabajador::getPesoAcumulado)
                        .max()
                        .orElse(0)
        );

        Trabajador trabajador = candidatos.get(new Random().nextInt(candidatos.size()));

        System.out.println("\n\nEl soporte esta siendo asignado a :"+trabajador.getNombre() );

        return trabajador;
    }

    
}
