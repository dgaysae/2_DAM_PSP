package unidad01.comunicacion.ejemplo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Hijo2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader leerDePadre = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter enviarAPadre = new PrintWriter(System.out, true))
        {
            // Leer el mensaje del padre (enviado originalmente por Hijo1)
            String mensajePadre = leerDePadre.readLine();
            if (mensajePadre != null) {
                System.out.println("Hijo2 recibe del padre: " + mensajePadre);

                // Mostrar el mensaje recibido
                System.out.println("Hijo2 muestra: " + mensajePadre);

                // Enviar una respuesta al padre
                enviarAPadre.println("Hijo2 recibió el mensaje.");
            }
            else
                System.err.println("Error: No se recibió mensaje del padre en Hijo2.");
        }
        catch (IOException e) {
            System.err.println("Error de E/S en Hijo2: " + e.getMessage());
        }
    }
}
