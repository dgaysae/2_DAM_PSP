package unidad02.exchanger;

import java.util.concurrent.Exchanger;

/**
 *
 * @author diego
 */
public class QueTeDen implements Runnable {
    private Exchanger<String> exchanger;
    
    public QueTeDen(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
            
    public void run() {
        try {
            String mensajeEnviado = "Saludos desde QueTeDen";
            String mensajeRecibido;
            mensajeRecibido = exchanger.exchange(mensajeEnviado);
            System.out.println("QueTeDen. Mensaje recibido: " + mensajeRecibido);
        } catch (InterruptedException ex) {
            System.out.println("ERROR! Hilo interrumpido!");
        }
    }
    
}
