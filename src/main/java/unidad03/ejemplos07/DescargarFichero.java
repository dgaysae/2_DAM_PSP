package unidad03.ejemplos07;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Vamos a descargar un fichero HTML (una página web) de un servidor usando
 * un objeto URLConnection.
 * Es más sencillo que con los sockets.
 */
public class DescargarFichero {
    public static String URL = "https://esviernes.com/";
    public static String FILE_NAME = "index.html";
    public static int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws Exception {
        URL obj = new URL(URL + FILE_NAME);
        URLConnection conectarAWeb = obj.openConnection();

        InputStream leerDeWeb = conectarAWeb.getInputStream();
        FileOutputStream escribirEnFichero = new FileOutputStream(FILE_NAME);

        byte[] buffer = new byte[BUFFER_SIZE];
        int length;
        while ((length = leerDeWeb.read(buffer)) > 0) {
            escribirEnFichero.write(buffer, 0, length);
        }

        // Cerrar los streams
        leerDeWeb.close();
        escribirEnFichero.close();

        System.out.println("Fichero descargado correctamente: " + FILE_NAME);
    }
}
