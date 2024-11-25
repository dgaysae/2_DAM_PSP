package unidad02.waitNotify;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author diego
 */
public class Camarero implements Runnable {
    private final Plato plato;
    private Thread thread;
    
    public Camarero(Plato p) {
        this.plato = p;
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }
    
    @Override
    public void run() {
        System.out.println("Oido cocina. En seguida sale su comanda");
        try {
            Thread.sleep(3000);
            plato.llenarPlato("Huevos con chorizo");

            synchronized (plato) {
                plato.notify();
            }
        } catch (InterruptedException ex) {
            System.out.println("Camarero interrumpido");
        }
        
        System.out.println("Camarero - Aquí tiene su comida");
    }
}
