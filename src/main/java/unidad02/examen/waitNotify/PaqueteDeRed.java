package unidad02.examen.waitNotify;

import java.util.HashSet;

/**
 * Esta clase represente, de forma muy básica, un paquete de red.
 * Como tal, tiene una cantidad limitada de datos que puede transportar (en este
 * caso serán 10 datos).
 * Los datos no necesitan guardarse de forma ordenada, pero sí identificando cada
 * uno de ellos.
 * 
 * @author diego
 */
public class PaqueteDeRed {

    /**
     * Longitud máxima de datos que admite el paquete.
     */
    private static final int MAX_DATOS_POR_PAQUETE = 10;

    /**
     * Conjunto de elementos del paquete, que en este ejercicio serán textos.
     */
    private final HashSet<String> listaDatosDelPaquete = new HashSet<>();

    /**
     * Añade un nuevo dato al paquete de red, siempre que éste no esté completo.
     * Mostrará también por pantalla un mensaje indicando que el dato se ha
     * añadido.
     * 
     * @param datoNuevo 
     */
    public void addDatoAlPaquete(String datoNuevo) {

        if (!estaCompleto()) {
            listaDatosDelPaquete.add(datoNuevo);
            System.out.println("Añadido " + datoNuevo);

        }
    }

    /**
     * Devuelve la lista de datos del paquete.
     * @return El conjunto de datos.
     */
    public HashSet<String> getDatosDelPaquete() {
        return listaDatosDelPaquete;
    }

    /**
     * Indica el tamaño del paquete. Es decir, cuántos datos contiene.
     * 
     * @return Nº de datos contenidos en el paquete.
     */
    public int getSize() {
        return listaDatosDelPaquete.size();
    }

    /**
     * Comprueba si el paquete está lleno.
     * 
     * @return true si está completo.
     */
    public boolean estaCompleto() {
        return listaDatosDelPaquete.size() >= MAX_DATOS_POR_PAQUETE;
    }

    /**
     * Comprueba si el paquete está vacío.
     * 
     * @return true si no contiene datos.
     */
    public boolean estaVacio() {
        return listaDatosDelPaquete.isEmpty();
    }

    /**
     * Limpia la colección de datos del paquete de red.
     */
    public void vaciar() {
        listaDatosDelPaquete.clear();
    }

    /**
     * Devuelve una representación textual del paquete de red.
     * 
     * @return Texto con el estado del paquete.
     */
    @Override
    public String toString() {
        return "PaqueteDeRed {\nlistaDatosDelPaquete="
                + listaDatosDelPaquete
                + "\n}";
    }
}
