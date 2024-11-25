package unidad02.semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author diego
 */
public class Visitante implements Runnable {
    
    Thread hilo;
    Semaphore timbre;
    Semaphore asientos;
    
    public Visitante(Semaphore semaforo,
            Semaphore asientos,
            String name) {
//        hilo = new Thread(this, name);
        hilo = new Thread(this);
        hilo.setName(name);
        this.timbre = semaforo;
        this.asientos = asientos;
    }

    @Override
    public void run() {
        System.out.println(hilo.getName() + " - Llegando a casa");
        
        try {
            asientos.acquire();
            System.out.println(hilo.getName() + " - se sienta en el porche.");
            
            timbre.acquire();
            System.out.println(hilo.getName() + " - Tocando el timbre");
            Thread.sleep(1000);
            System.out.println(hilo.getName() + " - Fin tocar timbre");
            timbre.release();
            
            System.out.println(hilo.getName() + " - deja libre un asiento en el porche.");
            System.out.println(hilo.getName() + " - entra en casa.");
            asientos.release();
            
        } catch (InterruptedException ex) {}
        
        
        
    }

    public void start() {
        hilo.start();
    }
}
