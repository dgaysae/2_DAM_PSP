package unidad02.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Este es un ejemplo de clase sobre semáforos anidados.
 * Consiste en controlar a los visitantes que quieren entrar
 * en una casa.
 * La casa tiene un porche con 4 asientos para que 4 visitantes
 * esperen a entrar.
 * Sólo puede entrar un visitante a la casa y no entrará otro
 * hasta que el anterior salga.
 * @author diego
 */
public class Main {
    
    public static void main(String[] args) {
        Semaphore sentarseEnAsiento = new Semaphore(4, true);
        Semaphore entrarACasa = new Semaphore(1, true);
        
        for(int i = 0; i < 10; i++) {
            new Visitante(entrarACasa, sentarseEnAsiento, "Pepe" + i).start();
        }
    }
    
}
