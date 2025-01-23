package unidad03.ejemplos03b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author Alejandro López Martínez
 */
public class ServidorChat {
    public static final String HOST_SERVER = "localhost";
    public static final int HOST_PORT = 4444;
    public static final String HOST_COMMAND_FIN = "#exit";
    

    public static void main(String[] args) {
        System.out.println("Iniciando servidor");
        
        try (ServerSocket serverSocket = new ServerSocket(HOST_PORT)) {
            System.out.println("El servidor se ha arrancado.");
            System.out.println("Esperando al cliente...");
            
            Socket socketCliente = serverSocket.accept();
            System.out.println("Cliente conectado!");
            System.out.println("Esperando mensajes del cliente...");
            
            BufferedReader recibirDelCliente = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream())
            );
            
            PrintWriter enviarAlCliente = new PrintWriter(
                    socketCliente.getOutputStream(),
                    true
            );

            String msg;
            while((msg = recibirDelCliente.readLine()) != null) {
                System.out.println(msg);
                enviarAlCliente.println("Servidor: mensaje recibido");
            }
            
        } catch (IOException ex) {
            System.out.println("ServidorChat ERROR! Error de conexión: " + ex.getMessage());
        }
    }
}
