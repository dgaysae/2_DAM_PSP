package unidad02.exchanger;

import java.util.concurrent.Exchanger;

/**
 *
 * @author diego
 */
public class Main {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new Task(exchanger)).start();
        new Thread(new Job(exchanger)).start();
        new Thread(new QueTeDen(exchanger)).start();
        new Thread(new ATiTAmbien(exchanger)).start();
    }
}
