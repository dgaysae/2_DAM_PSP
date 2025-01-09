package unidad03.ejemplos01;



import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase más sencilla es la InetAddress, que representa una dirección IP.
 * 
 * @author diego
 */
public class Main {
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
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
