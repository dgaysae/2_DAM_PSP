package unidad02.ejemplos05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author diego
 */
public class ColaConcurrente implements Runnable {
    public static Queue<Integer> cola = new ConcurrentLinkedQueue<>();
    private int numero;

    public ColaConcurrente(int numero) {
        this.numero = numero;
    }
    
    @Override
    public void run() {
        cola.add(numero);
        System.out.println("Begin ******** " + numero);
        
        for(Integer i : cola) {
            System.out.print(i + " - ");
        }
        System.out.println("Tamaño de la cola = " + cola.size());
        System.out.println("End ******** " + numero);
    }
    
    
}
