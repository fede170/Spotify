package persistencia;

import javax.persistence.*;

public class Persistencia {
    
    private final EntityManagerFactory emf;
    private final EntityManager em;
    
    public Persistencia(){
        this.emf = Persistence.createEntityManagerFactory("SpotifyPU");
        this.em = emf.createEntityManager();
    }
    
    public void insertar(Object o){ //lo que hace este modulo es insertar un nuevo objeto/entidad en la base de datos
        this.em.getTransaction().begin();
        this.em.persist(o);
        this.em.getTransaction().commit();
        
    }
    
        
    public void moficar(Object o){
        this.em.getTransaction().begin();
        this.em.merge(o); //lo que hace es mezclar los datos nuevos con los datos viejos
        this.em.getTransaction().commit(); 
    }
    
    
    public void eliminar(Object o){
        this.em.getTransaction().begin();
        this.em.remove(o); 
        this.em.getTransaction().commit(); 
    }
    
    
    public Object buscar (Class clase, Object id){//Este busca en la base de datos un objeto de una clase puntual lo guarda en la variable o y lo devuelve
        Object o = em.find(clase, id);
        return o;
    }
    
    
    public void refrescar(Object o){
        this.em.refresh(o);
    }
}

