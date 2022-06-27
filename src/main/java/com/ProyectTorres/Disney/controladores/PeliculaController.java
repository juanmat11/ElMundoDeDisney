package com.ProyectTorres.Disney.controladores;

import com.ProyectTorres.Disney.entidades.Pelicula;
import com.ProyectTorres.Disney.servicios.PeliculaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Manuel
 */
@RestController
@RequestMapping("/movies")
public class PeliculaController {

    @Autowired
    PeliculaServicio peliculaServicio;

    @GetMapping()
    public List<Pelicula> mostrarPeliculas() {
        return peliculaServicio.obtenerPeliculas();
    }

    @PostMapping()
    public Pelicula guardarPelicula(@RequestBody Pelicula pelicula) {
        return peliculaServicio.guardarPelicula(pelicula);
    }

    @GetMapping(params = "name")
    public List<Pelicula> mostrarPorTitulo(@RequestParam("name") String titulo) {
        return peliculaServicio.obtenerPorTitulo(titulo);
    }

    @GetMapping(params = "order")
    public List<Pelicula> ordenarPeliculas(@RequestParam("order") String orden) {
        return peliculaServicio.buscarYOrdenar(orden);
    }

    @GetMapping(params = "genre")
    public List<Pelicula> buscarPorIdGenero(@RequestParam("genre") String id) throws Exception {
        return peliculaServicio.obtenerPorIdGenero(id);
    }

    @DeleteMapping(path = "/{titulo}")
    public void eliminarPersonaje(@PathVariable("titulo") String titulo) {
        peliculaServicio.eliminarPelicula(titulo);

    }
}
