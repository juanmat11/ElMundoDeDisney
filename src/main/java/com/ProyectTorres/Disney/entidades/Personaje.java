package com.ProyectTorres.Disney.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Juan Manuel
 */
@Entity
@Data
public class Personaje {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String imagenPersonaje;
    private String nombre;
    private Integer edad;
    private Integer peso;
    private String historia;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "personajes_peliculas",
            joinColumns = {
                @JoinColumn(name = "Personaje_id", nullable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "Pelicula_id", nullable = false)})

    private List<Pelicula> peliculas;

}
