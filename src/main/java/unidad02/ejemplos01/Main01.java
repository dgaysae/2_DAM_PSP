package unidad02.ejemplos01;

/**
 *
 * @author diego
 */
public class Main01 {
    
    public static void main(String[] args) {
        Mouse01 jerry = new Mouse01("Jerry", 2);
        Mouse01 ratoncitoPerez = new Mouse01("Ratoncito Pérez", 5);
        Mouse01 mickey = new Mouse01("Mickey", 4);
        Mouse01 stuart = new Mouse01("Stuart Little", 1);

        long ini = System.currentTimeMillis();
        
        jerry.start();
        ratoncitoPerez.start();
        mickey.start();
        stuart.start();
        
        new Mouse01("Antonio", 1).start();

        long fin = System.currentTimeMillis();
        double tiempoTranscurrido = (fin - ini) / 1000d;
        System.out.printf("Han transcurrido %.2f segundos \n", tiempoTranscurrido);
    }
    
}
