package unidad02.exchanger;

import java.util.concurrent.Exchanger;

/**
 *
 * @author diego
 */
public class ATiTAmbien implements Runnable {
    private Exchanger<String> exchanger;
    
    public ATiTAmbien(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
            
    public void run() {
        try {
            String mensajeEnviado = "Saludos desde ATiTAmbien";
            String mensajeRecibido;
            mensajeRecibido = exchanger.exchange(mensajeEnviado);
            System.out.println("ATiTAmbien. Mensaje recibido: " + mensajeRecibido);
        } catch (InterruptedException ex) {
            System.out.println("ERROR! Hilo interrumpido!");
        }
    }
}
