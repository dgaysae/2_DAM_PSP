package unidad02.semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author diego
 */
public class Visitante implements Runnable {
    
    Thread hilo;
    Semaphore timbre;
    Semaphore asientos;
    
    public Visitante(Semaphore sentarseEnPorche,
            Semaphore entrarEnCasa,
            String name) {
//        hilo = new Thread(this, name);
        hilo = new Thread(this);
        hilo.setName(name);
        this.timbre = entrarEnCasa;
        this.asientos = sentarseEnPorche;
    }

    @Override
    public void run() {
        System.out.println(hilo.getName() + " - Llegando a casa");
        
        try {
            /*
            En el porche de la casa pueden entrar hasta 4 personas.
            */
            asientos.acquire();
            System.out.println(hilo.getName() + " - se sienta en el porche.");
            
            /*
            La primera de las 4 personas del porche que haya pedido tocar el timbre,
            tocará el timbre y entrará en la casa. En el porche quedarán 3 personas,
            PERO seguimos teniendo 4 personas en total en la casa: 1 dentro y 3 en el porche.
            */
            timbre.acquire();
            System.out.println(hilo.getName() + " - Tocando el timbre");
            Thread.sleep(1000);
            System.out.println(hilo.getName() + " - Fin tocar timbre");
            timbre.release();

            /*
            La persona ha salido de la casa, pero aún no ha salido del porche, por lo que no
            puede acceder una nueva persona.
            */

            System.out.println(hilo.getName() + " - deja libre un asiento en el porche.");
            System.out.println(hilo.getName() + " - entra en casa.");
            asientos.release();

            /*
            Ahora si que la persona ha abandonado la casa y otra de las que estaban esperando
            fuera puede acceder al porche.
            */
            
        } catch (InterruptedException ex) {}

        System.out.println(hilo.getName() + " - se marcha");
    }

    public void start() {
        hilo.start();
    }
}
