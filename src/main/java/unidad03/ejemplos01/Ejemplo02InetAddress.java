package unidad03.ejemplos01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejemplo02InetAddress {

    public static void main(String[] args) {
        String hostName = "www.google.es";
        String hostAddress = "8.8.8.8";
        int puertoDestino = 80;

        try (Socket socket = new Socket(hostName, puertoDestino)){
            System.out.println("***********************");
            System.out.println("Obtener IP - InetAddress");
            System.out.println("***********************");
            InetAddress ip = InetAddress.getByName(hostName);
            System.out.printf("Dirección de %s: %s", hostName, ip.getHostAddress());

            System.out.println();
            System.out.println();

            ip = InetAddress.getByName(hostAddress);
            System.out.printf("Dominio de %s: %s", hostAddress, ip.getHostName());

            System.out.println();
            System.out.println();

            System.out.println("***********************");
            System.out.println("Obtener IP - Socket");
            System.out.println("***********************");

            ip = socket.getInetAddress();
            System.out.printf("Dirección de %s: %s", hostName, ip.getHostAddress());

            System.out.println();
            System.out.println();
            System.out.println("***********************");
            System.out.println("Obtener IP Local - InetAddress");
            System.out.println("***********************");

            System.out.println();
            System.out.println();
            ip = InetAddress.getLocalHost();
            System.out.printf("Localhost %s: %s", ip.getHostName(), ip.getHostAddress());
        } catch (UnknownHostException ex) {
            System.out.println("ERROR! No se ha podido conectar al host indicado: " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Ejemplo02InetAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

