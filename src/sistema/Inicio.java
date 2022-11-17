//Esta clase complia dos funciones principales:1, 2
package sistema;

import modelo.Spotify;
import vistas.Principal;

public class Inicio { //este va a ser el punto de inicio del sistema
    
    public static void main(String[] args) {
        //1: buscar a l objeto spotify que conocia a todos los otros elementos de nuestra base de datos
        Spotify s = (Spotify) Spotify.getPersistencia().buscar(Spotify.class, 1L);//la L al final significa Long
        
        if (s == null) {//Este if tiene sentido la primera vez, porque si no existe spotify, lo creamos
            s = new Spotify(1L, "Spotify misionero");  
        }
        //2: instanciar una ventana, que era la ventana de inicio de nuestro sistema
        Principal ventana = new Principal(s);
        ventana.setVisible(true);//muestra la ventana en pantalla
    }
}
