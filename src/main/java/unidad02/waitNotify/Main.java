package unidad02.waitNotify;

/**
 * 
 * @author diego
 */
public class Main {
    
    public static void main(String[] args) {
        Plato plato = new Plato();
        Camarero camarero = new Camarero(plato);
        Comensal comensal = new Comensal(plato);
        
        comensal.start();
        camarero.start();
        
    }
    
}
