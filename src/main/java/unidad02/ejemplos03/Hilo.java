package unidad02.ejemplos03;

/**
 *
 * @author diego
 */
public class Hilo implements Runnable {
    private int numHilo, miParte, miCuenta = 0;
    private Contador contador;
    
    public Hilo(int numHilo, int miParte, Contador cont) {
        this.numHilo = numHilo;
        this.miParte = miParte;
        this.contador = cont;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < miParte; i++) {
            contador.incrementa();
            miCuenta++;
        }
        System.out.printf("Hilo %d - miCuenta = %d, y el contador = %d \n",
                numHilo,
                miCuenta,
                contador.getContador());
    }
    
}
