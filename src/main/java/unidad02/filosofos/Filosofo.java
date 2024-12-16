package unidad02.filosofos;

import java.util.concurrent.Semaphore;

/**
 * Esta clase es una de las posibles soluciones al problema de los filósofos.
 * Se ha añadido un punto adicional: los filósofos tomarán sólo 3 platos.
 * Cuando hayan comido 3 veces, finalizarán.
 * 
 * @author Alejandro López Martínez
 */
public class Filosofo implements Runnable {
    /**
     * Hilo que envolverá a esta clase para su ejecución.
     */
    private final Thread t;

    /**
     * Controlarán el acceso a los palillos izquierdo y derecho del filósofo.
     */
    private final Semaphore izdo, dcho;

    /**
     * Lleva la cuenta de los platos comidos por el filósofo.
     */
    private int comidasHechas;

    public Filosofo(int id, Semaphore izdo, Semaphore dcho) {
        t = new Thread(this, String.valueOf(id));
        this.izdo = izdo;
        this.dcho = dcho;
        comidasHechas = 0;
        t.start();
    }

    @Override
    public void run() {
        while (!t.isInterrupted()) {
            pensar();
            if (comidasHechas < 3) {
                comer();
            } else {
                t.interrupt();
            }
        }
    }

    private void comer() {
        try {
            System.out.printf("El filósofo %s tiene hambre%n", t.getName());
            if (Integer.parseInt(t.getName()) % 2 == 0) {
                izdo.acquire();
                dcho.acquire();
            } else {
                dcho.acquire();
                izdo.acquire();
            }
            int time = getRandomTime();
            System.out.printf("El filósofo %s coge los palillos%n", t.getName());
            System.out.printf("El filósofo %s come durante %d segundos (comida número %d)%n",
                    t.getName(), time / 1000, ++comidasHechas);
            Thread.sleep(time);
            System.out.printf("El filósofo %s terminó de comer%n", t.getName());
            System.out.printf("El filósofo %s deja los palillos%n", t.getName());
            izdo.release();
            dcho.release();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private void pensar() {
        int time = getRandomTime();
        System.out.printf("El filósofo %s está pensando durante %d segundos%n",
                t.getName(), time / 1000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private int getRandomTime() {
        return (int) ((Math.random() * 5) + 1) * 1000;
    }

}
