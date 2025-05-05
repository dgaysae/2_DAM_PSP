package unidad01.comunicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Hijo2 {
    public static void main(String[] args) throws IOException {
        BufferedReader leerDePadre = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter enviarAPadre = new PrintWriter(System.out, true);

        // Leer el mensaje del padre (enviado originalmente por Hijo1)
        String mensajePadre = leerDePadre.readLine();
        System.out.println("Hijo2 recibe del padre: " + mensajePadre);

        // Mostrar el mensaje recibido
        System.out.println("Hijo2 muestra: " + mensajePadre);

        // Enviar una respuesta al padre
        enviarAPadre.println("Hijo2 recibió el mensaje.");
    }
}
