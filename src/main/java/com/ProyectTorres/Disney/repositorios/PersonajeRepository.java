package com.ProyectTorres.Disney.repositorios;

import com.ProyectTorres.Disney.entidades.Personaje;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Manuel
 */
@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, String> {
    
    @Query("SELECT p FROM Personaje p WHERE p.nombre = :nombre")
    public Personaje buscarPersonajePorNombre(@Param("nombre") String nombre);

    @Query("SELECT p FROM Personaje p WHERE p.nombre LIKE %:nombre%")
    public ArrayList<Personaje> findByNombre(@Param("nombre") String nombre);
    
    public ArrayList<Personaje> findByEdad(Integer edad);
    
    
    

// controlar esta Query
//    @Query("SELECT p FROM Personaje p WHERE p.pelicula.id = :id")
//    public ArrayList<Personaje> findByPelicula(@Param("id") String id);
}
