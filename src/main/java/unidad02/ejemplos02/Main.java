package unidad02.ejemplos02;

/**
 * 
 * @author diego
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Hilo("Pepe", 3));
        Thread t2 = new Thread(new Hilo("Jose", 6));
        
        System.out.println("Lanzamiento de hilo:");
        t1.start();
        t2.start();
        
        t1.join();
        
        System.out.println("Soy el MAIN y digo que t1 ha acabado");
        
        t2.join();

        
        System.out.println("Fin del programa.");
    }
    
}
