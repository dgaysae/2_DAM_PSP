package unidad03.ejemplos01;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * La clase más sencilla es la InetAddress, que representa una dirección IP.
 * 
 * @author diego
 */
public class Ejemplo01InetAddress {
    public static void main(String[] args) {
        String[] direcciones = {
            "www.iescelia.org",
            "www.google.es",
            "docs.oracle.com"
        };
        InetAddress direccion;
        try {
            for (String url : direcciones) {
                direccion = InetAddress.getByName(url);
                System.out.println("Dirección: " + direccion);
            }
        } catch (UnknownHostException ex) {
            System.out.println("ERROR! No se ha encontrado el host indicado: " + ex.getMessage());
        }
    }
}
