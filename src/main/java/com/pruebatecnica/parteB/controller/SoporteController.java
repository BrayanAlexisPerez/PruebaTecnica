package com.pruebatecnica.parteB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.parteB.model.Soporte;
import com.pruebatecnica.parteB.repository.SoporteRepository;
import com.pruebatecnica.parteB.service.AsignacionService;

@RestController
@RequestMapping("/soporte")
public class SoporteController {
    @Autowired
    private SoporteRepository soporteRepository;

    @Autowired
    private AsignacionService asignacionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear")
    public String  crearSoporte(@RequestBody Soporte soporte) {
        return asignacionService.asignarSoporte(soporte);
    }

    @GetMapping("/all")
    public List<Soporte> obtenerSoportes() {
        return soporteRepository.findAll();
    }
}
