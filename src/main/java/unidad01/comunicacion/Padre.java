package unidad01.comunicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Este ejemplo es una muestra de cómo pueden comunicarse varios procesos.
 * En este caso todos ellos son programas en java, pero podrían ser scripts en shell de Linux, etc.
 * El programa funciona compilando todos los ficheros java (Padre, Hijo1 e Hijo2) y lanzando el padre.
 */
public class Padre {
    public static void main(String[] args) throws IOException, InterruptedException {
        //******************************************
        //  Creación de procesos hijos
        //******************************************
        ProcessBuilder pb1 = new ProcessBuilder("java", "Hijo1");
        ProcessBuilder pb2 = new ProcessBuilder("java", "Hijo2");
        Process hijo1 = pb1.start();
        Process hijo2 = pb2.start();

        //******************************************
        //  Establecemos los flujos de entrada y salida con esos procesos
        //******************************************
        PrintWriter hijo1Out = new PrintWriter(hijo1.getOutputStream(), true);
        BufferedReader hijo1In = new BufferedReader(new InputStreamReader(hijo1.getInputStream()));
        PrintWriter hijo2Out = new PrintWriter(hijo2.getOutputStream(), true);
        BufferedReader hijo2In = new BufferedReader(new InputStreamReader(hijo2.getInputStream()));

        //******************************************
        //  Comunicación con los hijos
        //******************************************
        // Enviar datos al primer hijo
        String mensajePadre = "Hola, Hijo1. Este es un mensaje del padre.";
        System.out.println("Padre envía a Hijo1: " + mensajePadre);
        hijo1Out.println(mensajePadre);

        // Recibir datos del primer hijo...
        String mensajeHijo1 = hijo1In.readLine();
        System.out.println("Padre recibe de Hijo1: " + mensajeHijo1);
        // ... y enviarlos al segundo hijo
        System.out.println("Padre envía a Hijo2: " + mensajeHijo1);
        hijo2Out.println(mensajeHijo1);

        // Recibir datos del segundo hijo
        String mensajeHijo2 = hijo2In.readLine();
        System.out.println("Padre recibe de Hijo2: " + mensajeHijo2);

        // Esperar a que los hijos terminen
        int retornoHijo1 = hijo1.waitFor();
        int retornoHijo2 = hijo2.waitFor();

        System.out.println("Hijo1 terminó con código: " + retornoHijo1);
        System.out.println("Hijo2 terminó con código: " + retornoHijo2);
    }
}
