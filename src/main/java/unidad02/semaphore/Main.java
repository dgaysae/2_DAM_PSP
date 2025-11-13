package unidad02.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Este es un ejemplo de clase sobre semáforos anidados.
 * Consiste en controlar a los visitantes que quieren entrar en una casa.
 * La casa tiene un porche con 4 asientos para que 4 visitantes esperen
 * a entrar.
 * Solo puede entrar un visitante a la casa y no entrará otro hasta que
 * el anterior salga.
 * Es importante tener cuidado al anidar
 * @author diego
 */
public class Main {

    static String[] nombres = {"Pepe", "Anselmo", "Federica", "Olegario", "Fernanda",
            "Filomeno", "Otilio", "Mortadelo", "Pancho", "Paca"};
    
    public static void main(String[] args) {
        /*
        Solo pueden sentarse 4 personas en el porche. El resto debe esperar.
        Se sentarán según el orden de llegada (fair = true)
        */
        Semaphore sentarseEnElPorche = new Semaphore(4, true);

        /*
        Solo puede entrar 1 persona en la casa cada vez. El resto debe esperar
        en el porche.
        La persona que entra es la que haya llegado antes (fair = true)
        */
        Semaphore entrarEnCasa = new Semaphore(1, true);
        
        for(int i = 0; i < nombres.length; i++) {
            new Visitante(sentarseEnElPorche, entrarEnCasa, nombres[i]).start();
        }
    }
}
