package unidad03.ejemplos01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejemplo02InetAddress {
    static final String HOST_NAME = "www.google.es";
    static final String HOST_ADDRESS = "8.8.8.8";
    static final int PORT = 80;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST_NAME, PORT)){
            System.out.println("***********************");
            System.out.println("Obtener IP - InetAddress");
            System.out.println("***********************");
            InetAddress ip = InetAddress.getByName(HOST_NAME);
            System.out.printf("Dirección de %s: %s", HOST_NAME, ip.getHostAddress());

            System.out.println();

            ip = InetAddress.getByName(HOST_ADDRESS);
            System.out.printf("Dominio de %s: %s", HOST_ADDRESS, ip.getHostName());

            System.out.println();
            System.out.println();

            System.out.println("***********************");
            System.out.println("Obtener IP - Socket");
            System.out.println("***********************");

            ip = socket.getInetAddress();
            System.out.printf("Dirección de %s: %s", HOST_NAME, ip.getHostAddress());

            System.out.println();
            System.out.println();
            System.out.println("***********************");
            System.out.println("Obtener IP Local - InetAddress");
            System.out.println("***********************");

            ip = InetAddress.getLocalHost();
            System.out.printf("Localhost %s: %s", ip.getHostName(), ip.getHostAddress());
        } catch (UnknownHostException ex) {
            System.out.println("ERROR! No se ha podido conectar al host indicado: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERROR! Ha habido algún problema en la conexión: " + ex.getMessage());
        }
    }
}

