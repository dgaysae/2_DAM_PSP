package unidad01.comunicacion.ejemplo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Hijo1 {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader leerDePadre = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter enviarAPadre = new PrintWriter(System.out, true))
        {
            // Leer mensaje del padre
            String mensajePadre = leerDePadre.readLine();
            if (mensajePadre != null) {
                System.out.println("Hijo1 recibe del padre: " + mensajePadre);

                // Procesar el mensaje (ejemplo: convertir a mayúsculas)
                String mensajeProcesado = mensajePadre.toUpperCase();
                System.out.println("Hijo1 procesa y envía a padre: " + mensajeProcesado);

                // Enviar el mensaje procesado al padre (y el padre se lo enviará a Hijo2)
                enviarAPadre.println(mensajeProcesado);
            }
            else {
                System.err.println("Error: No se recibió mensaje del padre.");
            }
        }
        catch (IOException e) {
            System.err.println("Error de E/S en Hijo1: " + e.getMessage());
        }
    }
}
