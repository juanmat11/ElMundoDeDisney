package com.ProyectTorres.Disney.servicios;

import com.ProyectTorres.Disney.entidades.Genero;
import com.ProyectTorres.Disney.entidades.Pelicula;
import com.ProyectTorres.Disney.repositorios.GeneroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Manuel
 */
@Service
public class GeneroServicio {

    @Autowired
    GeneroRepository generoRepository;

    public Genero guardarGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    public List<Pelicula> buscarPeliPorIdGenero(String id) throws Exception {

        Optional<Genero> respuesta = generoRepository.findById(id);
        if (respuesta.isPresent()) {
            Genero genero = respuesta.get();
            return genero.getPeliculas();
        } else {
            throw new Exception("No se encontro el genero");
        }
    }

    public List<Genero> listarGeneros() {
        return generoRepository.findAll();
    }

}
