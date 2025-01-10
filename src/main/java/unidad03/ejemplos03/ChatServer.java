package unidad03.ejemplos03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor iniciado en el puerto 12345");

            Socket cliente = servidor.accept(); // Acepta una conexión
            System.out.println("Un cliente se ha conectado");

            BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);

            String mensaje;
            while ((mensaje = in.readLine()) != null) {
                System.out.println("Cliente: " + mensaje);
                out.println("Servidor: Mensaje recibido");
            }

            cliente.close();
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
