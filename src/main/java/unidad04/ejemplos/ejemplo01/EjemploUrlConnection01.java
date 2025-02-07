package unidad04.ejemplos.ejemplo01;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * Usando un objeto URL podemos establecer una conexión con un sitio remoto.
 * Esta conexión además eligen el objeto URLConnection adecuado en base a los
 * datos de dicha URL.
 * Abrimos un InputStream para traer datos desde esa web hasta nuestro programa.
 * Como es texto, lo transformamos en caracteres haciendo el casting pertinente.
 */
public class EjemploUrlConnection01 {
    public static void main(String[] args) {
        try {
            //URL url = URL("https://www.google.com/search");
            URL url = URI("https://www.google.com/search").toURL();;
            URLConnection conexion = url.openConnection();

            // Tipo de conexión
            System.out.println("Clase URLConnection en base a la URL: " + conexion.getClass());

            InputStream is = conexion.getInputStream();
            int byteLeido;
            while ((byteLeido = is.read()) != -1) {
                System.out.print((char) byteLeido);
            }

        } catch (MalformedURLException e) {
            System.out.println("ERROR! URL con formato incorrecto: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR! Han surgido problemas en la conexión: " + e.getMessage());
        }
    }
}