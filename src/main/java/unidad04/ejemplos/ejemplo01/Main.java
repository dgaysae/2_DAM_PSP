package unidad04.ejemplos.ejemplo01;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author diego
 */
public class Main {
    public static void main(String[] args) {
        try {
            
            URL url = new URI("https://www.google.es/").toURL();
            URLConnection conexion = url.openConnection();
            
            System.out.println("Clase: " + conexion.getClass());
            
            InputStream leerWeb = conexion.getInputStream();
            
            int bytesLeidos;
            byte[] array = new byte[1024];
            while((bytesLeidos = leerWeb.read(array)) != -1) {
                System.out.println(array);
            }
            
            
            
        } catch (URISyntaxException | MalformedURLException e) {
            System.out.println("ERROR! URL incorrecta: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR! No se ha podido conectar: " + e.getMessage());
        }
    }
}
