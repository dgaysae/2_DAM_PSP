package unidad02.waitNotify;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Comensal implements Runnable {

    private Plato plato;
    private Thread thread;

    public Comensal(Plato p) {
        this.plato = p;
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Comensal - CAmarero, por favor, unos huevos con chorizo.");
        try {
            synchronized (plato) {
                plato.wait();
            }
            System.out.println("Comensal - ñam ñam");
            plato.comer();
            System.out.println("Comensal - Estaba delicioso");
            
        } catch (InterruptedException ex) {
            System.out.println("Comansal interrumpido");
        }
    }
}
