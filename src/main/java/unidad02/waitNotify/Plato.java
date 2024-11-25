package unidad02.waitNotify;

/**
 * 
 * @author diego
 */
public class Plato {
    private String comida = null;
    
    public void llenarPlato(String comida) {
        this.comida = comida;
    }
    
    public String comer() {
        if (comida == null) throw new IllegalStateException("No hay comida!!! Plato vacío!!!");
        return comida;
    }
}
