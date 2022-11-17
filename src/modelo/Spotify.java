package modelo;

import java.util.Set;
import javax.persistence.*;
import persistencia.Persistencia;

@Entity //De esta forma se convirtio en una entidad
public class Spotify { //spotify va a ser mi clase patriarca(la clase que va a conocer a todas las otras clases de mi sistema)
    
    @Id
    private Long id;
    
    private String nombre;
    
    private static Persistencia persistencia;
    
    @OneToMany(mappedBy = "spotify")
    private Set<Artista> artistas;
    
    @OneToMany(mappedBy = "spotify")
    private Set<Album> albumes;
    
    public Spotify(){
        
    }
    
    public Spotify(Long id, String nombre){
        this.id = id;
        this.nombre = nombre;
        Spotify.persistencia.insertar(this);
    }
    
    static {
        persistencia = new Persistencia();
    }
    
    public static Persistencia getPersistencia(){
        return persistencia;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }    
        
    public Set<Artista> getArtistas(){
        return this.artistas;
    }
    
    public void setArtistas(Set<Artista> artistas){
        this.artistas = artistas;
    }

    public void crearArtista(String nombre) {
        Artista a = new Artista(nombre, this);
        this.artistas.add(a);
        Spotify.getPersistencia().insertar(a);
    }
    
    
    public void modificarArtista(Artista a, String nombre) {
        if (a != null){
            a.setNombre(nombre);
            Spotify.getPersistencia().moficar(a);
        }
    }
    

    public void eliminarArtista(Artista a) {
        if (a != null){
            Spotify.getPersistencia().eliminar(a);
        }
    }
    
    public Set<Album> getAlbumes(){
        return this.albumes;
    }
    
    public void setAlbumes(Set<Album> albumes){
        this.albumes = albumes;
    }

    public void crearAlbum(String nombre, Artista ar) {
        Album al = new Album(nombre, ar, this);
        this.albumes.add(al);
        Spotify.getPersistencia().insertar(al);
        
        ar.agregarAlbum(al);
        Spotify.getPersistencia().moficar(ar);

    }
    
    
    public void modificarAlbum(Album al, String nombre, Artista ar) {
        if (al != null){
            al.setNombre(nombre);
            al.setArtista(ar);
            Spotify.getPersistencia().moficar(al);
        }
    }
    

    public void eliminarAlbum(Album al) {
        if (al != null){
            Spotify.getPersistencia().eliminar(al);
        }
    }
    
}