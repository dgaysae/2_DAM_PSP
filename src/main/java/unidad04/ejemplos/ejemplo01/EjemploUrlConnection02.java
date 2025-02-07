package unidad04.ejemplos.ejemplo01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/**
 * En esta ocasión vamos a hacer la descarga de una imagen.
 */
public class EjemploUrlConnection02 {
    public static final int BUFFER_LENGTH = 1024;

    public static void main(String[] args) {
        try {
            URL url = new URI("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Dlieja_sacun_Urtij%C3%ABi_Santa_Dorotea.JPG/800px-Dlieja_sacun_Urtij%C3%ABi_Santa_Dorotea.JPG").toURL();
            URLConnection connection = url.openConnection();
            
            InputStream is = connection.getInputStream();
            OutputStream escribirFichero = new FileOutputStream("imagen.JPG");
            
            int byteLeido;
            byte[] buffer = new byte[BUFFER_LENGTH];
            
            while ((byteLeido = is.read(buffer)) != -1) {
                escribirFichero.write(buffer, 0, byteLeido);
            }
            
            is.close();
            
        } catch (URISyntaxException | MalformedURLException e) {
            System.out.println("ERROR! URL con formato incorrecto: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR! Han surgido problemas en la conexión: " + e.getMessage());
        }
    }
}
