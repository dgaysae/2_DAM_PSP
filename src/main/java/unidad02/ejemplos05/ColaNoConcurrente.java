package unidad02.ejemplos05;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author diego
 */
public class ColaNoConcurrente implements Runnable {
    public static Queue<Integer> cola = new LinkedList<>();
    private int numero;

    public ColaNoConcurrente(int numero) {
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
