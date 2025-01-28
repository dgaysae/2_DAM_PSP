package unidad03.ejemplos03b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author Alejandro López Martínez
 */
public class ClienteChat {

    public static void main(String[] args) {
        String nomCliente = System.getProperty("user.name");

        try (Socket socketCliente = new Socket()) {

            socketCliente.connect(
                    new InetSocketAddress(
                            ServidorChat.HOST_SERVER,
                            ServidorChat.HOST_PORT
                    )
            );
            System.out.println("Se ha establecido conexión con el servidor!");
            System.out.println("Escriba sus mensajes:");
            BufferedReader recibirDelServidor = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream())
            );
            PrintWriter enviarAlServidor = new PrintWriter(
                    socketCliente.getOutputStream(),
                    true
            );
            try (BufferedReader leerDeTeclado = new BufferedReader(
                    new InputStreamReader(System.in)
            )) {
                String textoTeclado = "";
                while (hasNotFinished(textoTeclado)) {
                    
                    System.out.printf("%s>> ", nomCliente);
                    textoTeclado = leerDeTeclado.readLine();
                    
                    if (hasNotFinished(textoTeclado)) {
                        enviarAlServidor.printf("%s: %s%n", nomCliente, textoTeclado);
                        System.out.println(recibirDelServidor.readLine());
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("ClienteChat ERROR! Error de conexión: " + ex.getMessage());

            // TODO: quitar esto
            ex.printStackTrace();
        }
    }
    
    private static boolean hasNotFinished(String textoTeclado) {
        return !textoTeclado.equals(ServidorChat.HOST_COMMAND_FIN);
    }
}
