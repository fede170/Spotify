package modelo;


public class Album {

    private Long id;//id no va a tener geters ni seters por cuetiones de seguridad
    
    private String nombre;
    
    private Artista artista;
    
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
