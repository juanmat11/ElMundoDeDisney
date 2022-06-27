package com.ProyectTorres.Disney.servicios;

import com.ProyectTorres.Disney.entidades.Pelicula;
import com.ProyectTorres.Disney.repositorios.PeliculaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Manuel
 */
@Service
public class PeliculaServicio {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    GeneroServicio generoServicio;

    public List<Pelicula> obtenerPeliculas() {

        return peliculaRepository.findAll();
    }

    public Pelicula guardarPelicula(Pelicula pelicula) {

        if (pelicula.getId() != null && !pelicula.getId().isEmpty()) {
            pelicula.setTitulo(pelicula.getTitulo());
            pelicula.setImagenPeli(pelicula.getImagenPeli());
            pelicula.setFechaCreacion(pelicula.getFechaCreacion());
            pelicula.setCalificacion(pelicula.getCalificacion());
            return peliculaRepository.save(pelicula);
        }

        pelicula.setPersonajes(pelicula.getPersonajes());
        return peliculaRepository.save(pelicula);
    }

    public void eliminarPelicula(String nombre) {
        if (nombre != null) {
            Pelicula pelicula = peliculaRepository.buscarUnaPeliculaPorTitulo(nombre);
            peliculaRepository.deleteById(pelicula.getId());
            System.out.println("Se elimino la pelicula correctamente: " + nombre);
        }

    }

    public ArrayList<Pelicula> obtenerPorTitulo(String titulo) {

        return peliculaRepository.buscarPorTitulo(titulo);
    }

    public List<Pelicula> buscarYOrdenar(String order) {
        if (order == "ASC") {
            return peliculaRepository.buscarPeliculaPorOrdenAsc();
        }
        if (order == "DESC") {
            return peliculaRepository.buscarPeliculaPorOrdenDesc();
        }
        return null;
    }

    public List<Pelicula> obtenerPorIdGenero(String id) throws Exception {
        return generoServicio.buscarPeliPorIdGenero(id);
    }
}
