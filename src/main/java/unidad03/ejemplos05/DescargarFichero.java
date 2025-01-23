package unidad03.ejemplos05;

import java.io.*;
import java.net.*;

/**
 * Vamos a descargar un fichero HTML (una página web) de un servidor usando sockets.
 * Para ello lanzaremos una petición GET como la siguiente:
 *
 * GET /index.html HTTP/1.1
 * Host: www.esviernes.com
 *
 */
public class DescargarFichero {
    public static String URL = "www.esviernes.com";
    public static String FILE_NAME = "index.html";
    public static int PUERTO = 80;
    public static int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        // Nos conectamos con un socket a una web.
        try (Socket socket = new Socket(URL, PUERTO);) {
            OutputStream enviarAlServidor = socket.getOutputStream();

            // Le decimos al servidor web qué petición queremos realizar:
            String request = "GET /" + FILE_NAME
                    + " HTTP/1.1\r\n"
                    + "Host: " + URL + "\r\n" + "\r\n";

            enviarAlServidor.write(request.getBytes());

            System.out.println("Petición enviada: " + request);

            BufferedReader recibirDeServidor = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String line;
            boolean contenido = false;
            FileOutputStream enviarAFichero = new FileOutputStream(FILE_NAME);

            while ((line = recibirDeServidor.readLine()) != null) {
                if (line.isEmpty()) {
                    contenido = true;
                } else if (contenido) {
                    enviarAFichero.write(line.getBytes());
                }
            }

            // Cerrar los streams y el socket
            enviarAFichero.close();
            recibirDeServidor.close();
            socket.close();

            System.out.println("Fichero descargado correctamente: " + FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
