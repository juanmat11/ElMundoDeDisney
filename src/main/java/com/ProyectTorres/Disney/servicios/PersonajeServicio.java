package com.ProyectTorres.Disney.servicios;

import com.ProyectTorres.Disney.entidades.Pelicula;
import com.ProyectTorres.Disney.entidades.Personaje;
import com.ProyectTorres.Disney.repositorios.PeliculaRepository;
import com.ProyectTorres.Disney.repositorios.PersonajeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Manuel
 */
@Service
public class PersonajeServicio {

    @Autowired
    PersonajeRepository personajeRepository;
    @Autowired
    PeliculaRepository peliculaRepository;

    public List<Personaje> obtenerPersonajes() {

        return personajeRepository.findAll();
    }

    public Personaje guardarPersonaje(Personaje personaje) {

        if (personaje.getId() != null && !personaje.getId().isEmpty()) {
            personaje.setEdad(personaje.getEdad());
            personaje.setNombre(personaje.getNombre());
            personaje.setImagenPersonaje(personaje.getImagenPersonaje());
            personaje.setHistoria(personaje.getHistoria());
            personaje.setPeso(personaje.getPeso());
            return personajeRepository.save(personaje);
        }

        personaje.setPeliculas(personaje.getPeliculas());
        return personajeRepository.save(personaje);
    }

    public void eliminarPersonaje(String nombre) {
        if (nombre != null) {
            Personaje personaje = personajeRepository.buscarPersonajePorNombre(nombre);
            personajeRepository.deleteById(personaje.getId());
            System.out.println("Se elimino el personaje correctamente: " + nombre);
        }

    }

    public ArrayList<Personaje> obtenerPorNombre(String nombre) {

        return personajeRepository.findByNombre(nombre);
    }

    public ArrayList<Personaje> obtenerPorEdad(Integer edad) {
        return personajeRepository.findByEdad(edad);
    }

    public List<Personaje> buscarPorIdMovie(String id) throws Exception {
        Optional<Pelicula> respuesta = peliculaRepository.findById(id);
        if (respuesta.isPresent()) {
            Pelicula pelicula = respuesta.get();
            List<Personaje> personajes = pelicula.getPersonajes();
            return personajes;
        } else {
            throw new Exception("No se encontro pelicula con ese id");
        }

    }
}
