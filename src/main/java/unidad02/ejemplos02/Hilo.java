package unidad02.ejemplos02;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Hilo implements Runnable {
    
    private String nombreHilo;
    private int repeticiones;

    public Hilo(String nombreHilo,
            int repeticiones) {
        this.nombreHilo = nombreHilo;
        this.repeticiones = repeticiones;
    }

    @Override
    public void run() {
        for(int i = 0; i < repeticiones; i++) {
            try {
                System.out.println("Hilo " + nombreHilo + " - " + i);
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println("ERROR! ");
            }
        }
        System.out.println("--->>> Cerrando hilo " + nombreHilo);
    }    
}
