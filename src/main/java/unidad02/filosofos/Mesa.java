package unidad02.filosofos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Esta clase sirve para configurar el escenario. Es decir, los filósofos que se
 * van a sentar a cenar y los respectivos palillos.
 *
 * @author Alejandro
 */
public class Mesa {

    List<Filosofo> filosofos;
    List<Semaphore> palillos;

    public Mesa(int n) {
        filosofos = new ArrayList<>();
        palillos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            palillos.add(new Semaphore(1, true));
        }

        for (int i = 0; i < n; i++) {
            filosofos.add(
                    new Filosofo(
                            i,
                            palillos.get(i),
                            palillos.get((i + 1) % n)
                    )
            );
        }
    }
}
