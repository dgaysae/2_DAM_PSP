package unidad03.ejemplos04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteChat {
    public static void main(String[] args) throws IOException {
        // Nos conectamos al servidor:
        Socket cliente = new Socket(
                "localhost",
                ChatServerMultiUser.SERVER_DEFAULT_PORT
        );
        BufferedReader recibirDeServidor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        PrintWriter enviarAServidor = new PrintWriter(cliente.getOutputStream(), true);

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = teclado.readLine();
        enviarAServidor.println(nombreUsuario);

        System.out.println("Seleccione una sala:");
        String sala = teclado.readLine();
        enviarAServidor.println(sala);

        // El hilo se encargará de escribir en pantalla lo que llegue del servidor:
        new Thread(new HiloRecogeDeServidor(recibirDeServidor)).start();

        String mensaje = "";
        do {
            mensaje = teclado.readLine();
            enviarAServidor.println(mensaje);
        } while(!mensaje.equals(ChatServerMultiUser.COMMAND_CHAT_END));
    }
}
