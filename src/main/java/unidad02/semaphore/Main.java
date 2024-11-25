package unidad02.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author diego
 */
public class Main {
    
    public static void main(String[] args) {
        Semaphore asientos = new Semaphore(4, true);
        Semaphore s = new Semaphore(1, true);
        
        for(int i = 0; i < 10; i++) {
            new Visitante(s, asientos, "Pepe" + i).start();
        }
    }
    
}
