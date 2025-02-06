package unidad04.ejemplos.ejemplo01;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EjemploUrlConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com/search");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
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
