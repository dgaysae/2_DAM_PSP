package unidad02.ejemplos04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Main {

    public static void main(String[] args) {
        //Thread t = new Thread(new Hilo());
        Thread t = new Hilo2();
        System.out.println("Estado hilo: " + t.getState());

        t.start();
        System.out.println("Estado hilo: " + t.getState());

        t.interrupt();
        
        try {
            t.join();
        } catch (InterruptedException ex) {}
        
        System.out.println("Estado hilo: " + t.getState());

    }

}
