package com.ProyectTorres.Disney.controladores;

import com.ProyectTorres.Disney.entidades.Genero;
import com.ProyectTorres.Disney.servicios.GeneroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Manuel
 */
@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    GeneroServicio generoServicio;

    @GetMapping()
    public List<Genero> listarGeneros() {
        return generoServicio.listarGeneros();
    }

    @PostMapping()
    public Genero guardarGenero(@RequestBody Genero genero) {
        return generoServicio.guardarGenero(genero);
    }
}
