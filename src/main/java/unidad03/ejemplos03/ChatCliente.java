package unidad03.ejemplos03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatCliente {
    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket(
                ChatServer.SERVER_HOSTNAME,
                ChatServer.SERVER_PORT
        );

        BufferedReader recibir = new BufferedReader(
                new InputStreamReader(cliente.getInputStream())
        );
        PrintWriter enviar = new PrintWriter(
                cliente.getOutputStream(),
                true
        );

        BufferedReader leerTeclado = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String mensaje;
        while ((mensaje = leerTeclado.readLine()) != null
                && !mensaje.equals(ChatServer.COMMAND_CHAT_END)) {
            enviar.println(mensaje);
            System.out.println("Servidor: " + recibir.readLine());
        }

        cliente.close();
    }
}
