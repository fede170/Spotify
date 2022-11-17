package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Album;
import modelo.Spotify;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-10-29T18:32:46", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Artista.class)
public class Artista_ { 

    public static volatile SingularAttribute<Artista, Spotify> spotify;
    public static volatile SingularAttribute<Artista, Long> id;
    public static volatile SingularAttribute<Artista, String> nombre;
    public static volatile SetAttribute<Artista, Album> albumes;

}