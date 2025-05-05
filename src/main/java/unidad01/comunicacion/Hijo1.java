package unidad01.comunicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Hijo1 {
    public static void main(String[] args) throws IOException {
        BufferedReader padreIn = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter padreOut = new PrintWriter(System.out, true);

        // Leer mensaje del padre
        String mensajePadre = padreIn.readLine();
        System.out.println("Hijo1 recibe del padre: " + mensajePadre);

        // Procesar el mensaje (ejemplo: convertir a mayúsculas)
        String mensajeProcesado = mensajePadre.toUpperCase();
        System.out.println("Hijo1 procesa y envía a padre: " + mensajeProcesado);

        // Enviar el mensaje procesado al padre (y el padre se lo enviará a Hijo2)
        padreOut.println(mensajeProcesado);
    }
}
