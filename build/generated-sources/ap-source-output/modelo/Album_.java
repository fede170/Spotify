package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Artista;
import modelo.Spotify;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-10-29T18:32:46", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Album.class)
public class Album_ { 

    public static volatile SingularAttribute<Album, Artista> artista;
    public static volatile SingularAttribute<Album, Spotify> spotify;
    public static volatile SingularAttribute<Album, Long> id;
    public static volatile SingularAttribute<Album, String> nombre;

}