package unidad02.ejemplos01;

/**
 *
 * @author diego
 */
public class Mouse {
    private String nombre;
    private int tiempoComiendo;
    
    public Mouse(String nombre, int tiempoComiendo) {
        this.nombre = nombre;
        this.tiempoComiendo = tiempoComiendo;
    }
    
    public void comer() {
        try {
            
            System.out.printf("El ratón %s va a comer \n", nombre);
            Thread.sleep(tiempoComiendo * 1000);
            System.out.printf("--> El ratón %s ya ha comido \n", nombre);
        
        } catch (InterruptedException ex) {
            System.out.println("ERROR! El proceso se ha interrumpido! - "
                    + ex.getMessage());
        }
    }
    
}
