package unidad02.ejemplos01;

/**
 *
 * @author diego
 */
public class Main {
    
    public static void main(String[] args) {
        Mouse jerry = new Mouse("Jerry", 2);
        Mouse ratoncitoPerez = new Mouse("Ratoncito Pérez", 5);
        Mouse mickey = new Mouse("Mickey", 4);
        Mouse stuart = new Mouse("Stuart Little", 1);
        
        long ini = System.currentTimeMillis();
        
        jerry.comer();
        ratoncitoPerez.comer();
        mickey.comer();
        stuart.comer();

        long fin = System.currentTimeMillis();
        double tiempoTranscurrido = (fin - ini) / 1000d;
        System.out.printf("Han transcurrido %.2f segundos \n", tiempoTranscurrido);
    }
    
}
