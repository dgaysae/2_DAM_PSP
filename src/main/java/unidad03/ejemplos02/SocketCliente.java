package unidad03.ejemplos02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 
 * @author diego
 */
public class SocketCliente {
    
    public static final String STRING_HOST = "localhost";
    public static final int INT_PUERTO = 5555;

    public static void main(String[] args) {
        System.out.println("Creando socket cliente");
        
        try (Socket socketCliente = new Socket()){

            System.out.println("Estableciendo la conexión");
            InetSocketAddress direccionServidor =
                    new InetSocketAddress(STRING_HOST, INT_PUERTO);
            socketCliente.connect(direccionServidor);

            OutputStream enviarAServidor = socketCliente.getOutputStream();
            
            System.out.println("Enviando mensaje");
            String mensaje = "mensaje desde el cliente";
            enviarAServidor.write(mensaje.getBytes());
            System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket cliente");
            socketCliente.close();
            
            System.out.println("Terminado");
        } catch (IOException e) {
            System.out.println("ERROR! " + e.getMessage());
        }
    }
}
