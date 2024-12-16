package unidad01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta clase muestra el resultado de un listado de ficheros-directorios.
 * Para diferenciar el comando (ls-Linux, dir-Windows) se implementa
 * un método que extraiga el SO donde se ejecuta el programa.
 * 
 * TODO: ejecutar un comando un otro dependiendo del SO
 * @author Diego Gay Sáez
 */
public class PSP_01 {

    public final String SISTEMA_OPERATIVO = getOSName();
    private static final String OS_WINDOWS = "windows";
    private static final String OS_LINUX = "linux";
    private static final String OS_MAC = "mac";

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {

//        PSP_01 psp_01 = new PSP_01();
//        System.out.println(psp_01.SISTEMA_OPERATIVO);
        InputStreamReader isr = null;
        BufferedReader lector = null;
        try {
            Process proceso = Runtime.getRuntime().exec("ls /asdf");
            
            int exitCode = proceso.waitFor();
            
            if (exitCode == 0) {
                isr = new InputStreamReader(proceso.getInputStream());
                lector = new BufferedReader(isr);

                String linea;
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
            }

        } catch (IOException e) {
            System.out.println("ERROR!!");
            System.exit(1);
            
        } catch (InterruptedException e) {
            System.out.println("ERROR!! Ejecución interrumpida inesperadamente");
            System.exit(2);
        }
        finally {
            try {
                if (isr != null) {
                    isr.close();
                }
                if (lector != null) {
                    lector.close();
                }
            } catch (IOException ex) {
                System.out.println("Error al cerrar conexión con proceso");
            }
        }
        
        System.exit(0);

    }

    private String getOSName() {
        String osName = System.getProperty("os.name");
        if (isWindows(osName)) {
            return OS_WINDOWS;
        } else if (isLinux(osName)) {
            return OS_LINUX;
        } else {
            return OS_MAC;
        }
    }

    /**
     * asdfasdf asdf asdf 
     * @param osName Nombre abreviado del so en curso.
     * @return true si el so es Windows. FAlse en caso contrario.
     */
    public boolean isWindows(String osName) {
        return osName.toLowerCase().contains("windows");
    }

    public boolean isLinux(String osName) {
        return osName.toLowerCase().contains("linux");
    }

}
