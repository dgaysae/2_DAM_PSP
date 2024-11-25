package unidad02.ejemplos01;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 * 
 * @author diego
 */
public class Reloj implements Runnable {
    private LocalTime hora;
    private JLabel etiqueta;
    
    public Reloj(JLabel etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    public void setTime() {
        
        while (true) {
            hora = LocalTime.now();
            etiqueta.setText(hora.getHour() + ":"
                    + hora.getMinute() + ":"
                    + hora.getSecond());
            
            esperarDurante(1);
        }
    }
    
    private void esperarDurante(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {}
    }
    
    public void run() {
        setTime();
    }
}
