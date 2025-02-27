package unidad03.ejemplos02;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author diego
 */
public class SocketServidor {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket()) {
            System.out.println("Creando socket servidor");

            System.out.println("Realizando el bind");
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket socketCliente = serverSocket.accept();

            System.out.println("Conexión recibida");
            InputStream is = socketCliente.getInputStream();
            //OutputStream os = socketCliente.getOutputStream();

            byte[] mensaje = new byte[25];
            int numBytesLeidos = is.read(mensaje);

            System.out.printf("Mensaje recibido: %s %n Bytes: %d",
                    new String(mensaje),
                    numBytesLeidos);

            System.out.println("Cerrando el nuevo socket");

            socketCliente.close();

            System.out.println("Cerrando el socket servidor");

            System.out.println("Terminado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
