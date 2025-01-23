package unidad03.ejemplos03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static final String COMMAND_CHAT_END = "/fin";
    public static final String SERVER_HOSTNAME = "localhost";
    public static final int SERVER_PORT = 5555;

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(SERVER_PORT);
            System.out.printf("Servidor iniciado en el puerto %d%n", SERVER_PORT);

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");

            BufferedReader recibir = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter enviar = new PrintWriter(cliente.getOutputStream(), true);

            String mensaje;
            while ((mensaje = recibir.readLine()) != null) {
                System.out.println("Cliente: " + mensaje);
                enviar.println("mensaje recibido");
            }

            cliente.close();
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
