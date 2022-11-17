package modelo;

import javax.persistence.*;


@Entity
public class Album {
    
    @Id
    @SequenceGenerator(name = "sec_album", initialValue = 1, allocationSize = 1)//Esto es un auto incremental para el id de la base de datos
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sec_album")
    
    private Long id;//id no va a tener geters ni seters por cuetiones de seguridad
    
    private String nombre;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Artista artista;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Spotify spotify;
    
    
    public Album(){
        
    }
    
    public Album(String nombre, Artista artista, Spotify spotify){
        this.nombre = nombre;
        this.artista = artista;
        this.spotify = spotify;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public Artista getArtista(){
        return this.artista;
    }
    
    public void setArtista(Artista artista){
        this.artista = artista;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
    
    
    
    
}
