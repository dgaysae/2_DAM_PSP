package unidad02.examen.waitNotify;

/**
 *
 * @author diego
 */
public class Main {

    public static void main(String[] args) {
        PaqueteDeRed paquete = new PaqueteDeRed();
        ProtocoloEnvio protocolo = new ProtocoloEnvio(paquete);

        protocolo.start();

        for (int i = 0; i <= 15; i++) {
            try {
                synchronized (paquete) {
                    Thread.sleep(1000);
                    if (paquete.estaCompleto()) {
                        System.out.println("Paquete completo!!!!!!!!!!!");
                        paquete.notify();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Interrumpido");
            }

            paquete.addDatoAlPaquete("Dato " + i);
            System.out.println("Tamaño del paquete: " + paquete.getSize());
        }
        protocolo.currentThread().interrupt();
    }
}
