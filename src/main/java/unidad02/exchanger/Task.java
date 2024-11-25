package unidad02.exchanger;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Task implements Runnable {
    private Exchanger<String> exchanger;
    
    public Task(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
            
    public void run() {
        try {
            String mensajeEnviado = "Saludos desde Task";
            String mensajeRecibido;
            mensajeRecibido = exchanger.exchange(mensajeEnviado);
            System.out.println("Task. Mensaje recibido: " + mensajeRecibido);
        } catch (InterruptedException ex) {
            System.out.println("ERROR! Hilo interrumpido!");
        }
    }
    
}
