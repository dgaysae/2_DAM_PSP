package unidad02.ejemplos04;

/**
 * 
 * @author diego
 */
public class Hilo2 extends Thread {
    
    public void run() {
        int i = 0;
        
        while(i < 1000000000) {
            if (Thread.interrupted()) {
                System.out.println("Interrumpido. " + i);
            }
            
            i++;
        }
        System.out.println("EStado hilo: " + this.getState());
    }
    
}
