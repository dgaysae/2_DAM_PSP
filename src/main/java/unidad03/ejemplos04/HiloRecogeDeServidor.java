package unidad03.ejemplos04;

import java.io.BufferedReader;
import java.io.IOException;

public class HiloRecogeDeServidor implements Runnable {
    private BufferedReader recibirDeServidor;

    public HiloRecogeDeServidor(BufferedReader datosDeServidor) {
        this.recibirDeServidor = datosDeServidor;
    }

    @Override
    public void run() {
        try {
            String mensaje;
            while ((mensaje = recibirDeServidor.readLine()) != null) {
                System.out.println(mensaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
