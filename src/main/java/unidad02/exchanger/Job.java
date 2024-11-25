package unidad02.exchanger;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author diego
 */
public class Job implements Runnable {
    private Exchanger<String> exchanger;
    
    public Job(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    
    public void run() {
        try {
            String mensajeEnviado = "Job te saluda";
            String mensajeRecibido = exchanger.exchange(mensajeEnviado);
            
            System.out.println("Job. Mensaje recibido: " + mensajeRecibido);
        } catch (InterruptedException ex) {
            System.out.println("ERROR! Hilo interrumpido");
        }
    }
}
