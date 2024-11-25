package unidad02.ejemplos05;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Main {
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            new Thread(new ColaConcurrente(i)).start();
        }
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {}
        
        System.out.println("TAMAÑO FINAL DE LA COLA: " + ColaConcurrente.cola.size());
        System.out.println(ColaConcurrente.cola);
    }
    
}
