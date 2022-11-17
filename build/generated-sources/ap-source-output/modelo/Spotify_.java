package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Album;
import modelo.Artista;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-10-29T18:32:46", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Spotify.class)
public class Spotify_ { 

    public static volatile SetAttribute<Spotify, Artista> artistas;
    public static volatile SingularAttribute<Spotify, Long> id;
    public static volatile SingularAttribute<Spotify, String> nombre;
    public static volatile SetAttribute<Spotify, Album> albumes;

}