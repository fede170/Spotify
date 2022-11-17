package modelo;

import java.util.*;
import javax.persistence.*;


@Entity
public class Artista {
    
    @Id
    @SequenceGenerator(name = "sec_artista", initialValue = 1, allocationSize = 1)//Esto es un auto incremental para el id de la base de datos
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sec_artista")
    
    private Long id;//id no va a tener geters ni seters por cuetiones de seguridad
    
    private String nombre;
    
        
    @OneToMany(mappedBy = "artista")
    private Set<Album> albumes;
    
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Spotify spotify;
    
    
    public Artista(){
        
    }
    
    public Artista(String nombre, Spotify spotify){
        this.nombre = nombre;
        this.spotify = spotify;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

        
    public Set<Album> getAlbumes(){
        return this.albumes;
    }
    
    public void setAlbumes(Set<Album> albumes){
        this.albumes = albumes;
    }
    
    public void agregarAlbum(Album album){
        this.albumes.add(album);
    }

    @Override
    public String toString(){
        return this.nombre;
    }
    
    
    
    
    
    
}
