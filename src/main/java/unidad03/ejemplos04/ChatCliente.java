package unidad03.ejemplos04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatCliente {
    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("localhost", 12345); // Conecta al servidor en el puerto 12345

        BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        String mensaje;
        while ((mensaje = teclado.readLine()) != null) {
            out.println(mensaje);
            System.out.println("Servidor: " + in.readLine());
        }

        cliente.close();
    }
}
