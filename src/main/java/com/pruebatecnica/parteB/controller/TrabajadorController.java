package com.pruebatecnica.parteB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.parteB.model.Trabajador;
import com.pruebatecnica.parteB.repository.TrabajadorRepository;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @GetMapping("/all")
    public List<Trabajador> obtenerTrabajadores() {
        return trabajadorRepository.findAll();
    }

    @PostMapping("/reiniciar")
    public void resetPesos() {
        List<Trabajador> trabajadores = trabajadorRepository.findAll();
        for (Trabajador trabajador : trabajadores) {
            trabajador.setPesoAcumulado(0);
        }
        trabajadorRepository.saveAll(trabajadores);
    }
}
