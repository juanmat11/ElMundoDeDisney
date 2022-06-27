package com.ProyectTorres.Disney.repositorios;

import com.ProyectTorres.Disney.entidades.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Manuel
 */
@Repository
public interface GeneroRepository extends JpaRepository<Genero, String>{
    
}
