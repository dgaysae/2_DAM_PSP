package unidad02.ejemplos03;

/**
 * 
 * @author diego
 */
public class Contador {
    private int contador = 0;
    
    synchronized public int getContador() {
        return contador;
    }
    
    synchronized public int incrementa() {
        int cont = contador++;
        return cont;
    }
}
