package unidad02.examen.waitNotify;

/**
 * Este hilo se encarga de enviar el paquete de datos cuando está completo.
 * 
 * @author diego
 */
public class ProtocoloEnvio implements Runnable {

    /**
     * Paquete que enviará a la red.
     */
    final private PaqueteDeRed paquete;
    
    /**
     * Hilo en el que este protocolo va a envolverse.
     */
    private final Thread t;

    /**
     * Constructor que recoge la referencia del paquete que va a enviar.
     * También inicializa el hilo en el que va a envolverse.
     * 
     * @param paquete 
     */
    public ProtocoloEnvio(PaqueteDeRed paquete) {
        this.paquete = paquete;
        t = new Thread(this);
    }

    /**
     * Mostrará por pantalla un mensaje indicando que está enviando el paquete de
     * red con el tamaño (nº elementos) de dicho paquete.
     * El envío, obviamente, es fictitio. Por lo que una vez mostrado el mensaje,
     * vaciará el paquete.
     */
    public void enviarPaquete() {
        System.out.println("Enviando el paquete de red con " + paquete.getSize() + " elementos");
        System.out.println(paquete);
        paquete.vaciar();
    }

    /**
     * Devuelve una referencia al hilo que envuelve a este protocolo.
     * @return 
     */
    public Thread currentThread() {
        return t;
    }

    /**
     * Ejecuta el método start() del hilo de este objeto.
     */
    public void start() {
        this.t.start();
    }

    /**
     * Mientras el hilo no haya sido interrumpido, ejecutará un bloque de código
     * sincronizado donde comprobará si el paquete está completo.
     * Si no lo está, el hilo esperará a que se le notifique que puede enviarlo.
     * Si es interrumpido mientras espera, mostrará un mensaje indicando que ha
     * sido interrumpido y, si no está vacío, enviará el paquete con lo que tenga
     * (aunque no esté completo).
     * En cualquier otro caso, cuando se le notifique, el hilol enviará el
     * paquete. 
     */
    @Override
    public void run() {
        while (!t.isInterrupted()) {
            synchronized (paquete) {
                if (!paquete.estaCompleto()) {
                    try {
                        paquete.wait();
                    } catch (InterruptedException e) {
                        System.out.println("ProtocoloEnvio ha sido interrumpido");
                        if (!paquete.estaVacio()) {
                            enviarPaquete();
                        }
                        return;
                    }
                }
            }
            enviarPaquete();
        }
        System.out.println("El protocolo finaliza su ejecucion");
    }
}
