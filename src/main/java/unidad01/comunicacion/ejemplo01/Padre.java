package unidad01.comunicacion.ejemplo01;

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
    public static void main(String[] args) {
        try {
            //******************************************
            //  Creación de procesos hijos
            //******************************************
            ProcessBuilder pb1 = new ProcessBuilder("java", "Hijo1");
            ProcessBuilder pb2 = new ProcessBuilder("java", "Hijo2");
            Process procesoHijo1 = null;
            procesoHijo1 = pb1.start();
            Process procesoHijo2 = pb2.start();

            //******************************************
            //  Establecemos los flujos de entrada y salida con esos procesos
            //******************************************
            try(
                    PrintWriter enviarAHijo1 = new PrintWriter(procesoHijo1.getOutputStream(), true);
                    BufferedReader recibirDeHijo1 = new BufferedReader(new InputStreamReader(procesoHijo1.getInputStream()));
                    PrintWriter enviarAHijo2 = new PrintWriter(procesoHijo2.getOutputStream(), true);
                    BufferedReader recibirDeHijo2 = new BufferedReader(new InputStreamReader(procesoHijo2.getInputStream()))) {

                //******************************************
                //  Comunicación con los hijos
                //******************************************
                // Enviar datos al primer hijo
                String mensajePadre = "Hola, Hijo1. Este es un mensaje del padre.";
                System.out.println("Padre envía a Hijo1: " + mensajePadre);
                enviarAHijo1.println(mensajePadre);

                // Recibir datos del primer hijo...
                String mensajeHijo1 = recibirDeHijo1.readLine();
                if (mensajeHijo1 != null) {
                    System.out.println("Padre recibe de Hijo1: " + mensajeHijo1);
                    // ... y enviarlos al segundo hijo
                    System.out.println("Padre envía a Hijo2: " + mensajeHijo1);
                    enviarAHijo2.println(mensajeHijo1);
                }
                else {
                    System.err.println("Error: Hijo1 no envió respuesta.");
                }

                // Recibir datos del segundo hijo
                String mensajeHijo2 = recibirDeHijo2.readLine();
                if (mensajeHijo2 != null) {
                    System.out.println("Padre recibe de Hijo2: " + mensajeHijo2);
                }
                else {
                    System.err.println("Error: Hijo2 no envió respuesta.");
                }
            }

            // Esperar a que los hijos terminen
            try {
                int retornoHijo1 = procesoHijo1.waitFor();
                int retornoHijo2 = procesoHijo2.waitFor();

                System.out.println("Hijo1 terminó con código: " + retornoHijo1);
                System.out.println("Hijo2 terminó con código: " + retornoHijo2);
            } catch (InterruptedException e) {
                System.err.println("Error esperando a los hijos: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
