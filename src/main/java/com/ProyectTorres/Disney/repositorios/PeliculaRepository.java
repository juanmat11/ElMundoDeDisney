package com.ProyectTorres.Disney.repositorios;

import com.ProyectTorres.Disney.entidades.Pelicula;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Manuel
 */
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, String>{
    
    @Query("SELECT p FROM Pelicula p WHERE p.titulo LIKE %:titulo%")
    public ArrayList<Pelicula> buscarPorTitulo(@Param("titulo") String titulo);
    
    @Query("SELECT p FROM Pelicula p WHERE p.titulo = :titulo")
    public Pelicula buscarUnaPeliculaPorTitulo(@Param("titulo") String titulo);
    
     @Query("SELECT p FROM Pelicula p ORDER BY p.titulo ASC")
    public List<Pelicula> buscarPeliculaPorOrdenAsc();

    @Query("SELECT p FROM Pelicula p ORDER BY p.titulo DESC ")
    public List<Pelicula> buscarPeliculaPorOrdenDesc();
            
}
