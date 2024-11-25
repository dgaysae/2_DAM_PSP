package unidad02.ejemplos04;

/**
 * 
 * @author diego
 */
public class Hilo implements Runnable {
    
    @Override
    public void run() {
        int i = 0;
        
        //Thread.interrupted()
        while(i < 1000000000) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrumpido. " + i);
                break;
            }
            
            i++;
        }
    }
}
