package unidad03.ejemplos05;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Al arrancar, el cliente elige el fichero que quiere enviar al servidor.
 */
public class ClienteArchivos {
    private static Socket cliente;

    public static void main(String[] args) throws IOException {
        cliente = new Socket(
                "localhost",
                Servidor.SERVER_DEFAULT_PORT
        );

        File fichero = getFichero();
        if (fichero == null) {
            System.exit(0);
        }

        // Enviar el nombre del archivo
        PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
        out.println(fichero.getName());

        // Leer el archivo y enviarlo al servidor
        FileInputStream leerDeFichero = new FileInputStream(fichero.getAbsoluteFile());
        byte[] buffer = new byte[Servidor.SERVER_DEFAULT_BUFFER_SIZE];
        int bytesLeidos;
        while ((bytesLeidos = leerDeFichero.read(buffer)) != -1) {
            cliente.getOutputStream().write(buffer, 0, bytesLeidos);
        }

        leerDeFichero.close();
        cliente.close();
        System.out.println("Archivo enviado correctamente");
    }

    /**
     * Selecciona visualmente un fichero.
     * @return objeto que representa a dicho fichero o null si no se ha elegido nada.
     */
    private static File getFichero() {
        System.out.println("Seleccione el fichero que desea enviar:");
        JOptionPane.showMessageDialog(
                null,
                "En la siguiente ventana debe seleccionar un fichero para enviarlo al servidor.",
                "Seleccione el fichero que desea enviar",
                JOptionPane.INFORMATION_MESSAGE
        );
        JFileChooser elegirFichero = new JFileChooser();
        int ficheroSeleccionado = elegirFichero.showOpenDialog(null);
        if (ficheroSeleccionado == JFileChooser.CANCEL_OPTION) {
            System.out.println("No se ha seleccionado fichero para subir al servidor");
            return null;
        }
        return elegirFichero.getSelectedFile();
    }


}
