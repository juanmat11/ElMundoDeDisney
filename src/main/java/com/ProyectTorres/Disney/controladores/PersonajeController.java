package com.ProyectTorres.Disney.controladores;

import com.ProyectTorres.Disney.entidades.Personaje;
import com.ProyectTorres.Disney.servicios.PersonajeServicio;
import java.util.ArrayList;
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
@RequestMapping("/characters")
public class PersonajeController {

    @Autowired
    PersonajeServicio personajeServicio;

    @GetMapping()
    public List<Personaje> mostrarPersonajes() {
        return personajeServicio.obtenerPersonajes();
    }

    @PostMapping()
    public Personaje guardarPersonaje(@RequestBody Personaje personaje) {
        return personajeServicio.guardarPersonaje(personaje);
    }

    @GetMapping(params = "age")
    public ArrayList<Personaje> busquedaPorEdad(@RequestParam(name = "age", required = false) Integer edad) {

        return personajeServicio.obtenerPorEdad(edad);
    }

    @GetMapping(params = "name")
    public ArrayList<Personaje> busquedaPorNombre(@RequestParam(name = "name", required = false) String nombre) {

        return personajeServicio.obtenerPorNombre(nombre);

    }

    @GetMapping(params = "idMovie")
    public List<Personaje> busquedaPorIdMovie(@RequestParam(name = "idMovie", required = false) String id) throws Exception {
        return personajeServicio.buscarPorIdMovie(id);
    }

    @DeleteMapping(path = "/{nombre}")
    public void eliminarPersonaje(@PathVariable("nombre") String nombre) {
        personajeServicio.eliminarPersonaje(nombre);
    }

}
