package unidad03.ejemplos05;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Al arrancar el servidor se debe elegir un directorio para guardar los ficheros
 * que envíen los clientes.
 * Si no, se guardarán en el directorio actual.
 */
public class Servidor {
    public static final int SERVER_DEFAULT_PORT = 12345;
    public static final int SERVER_DEFAULT_BUFFER_SIZE = 1024;
    public static final String SERVER_UPLOAD_DIRECTORY = getDirectorio();

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(SERVER_DEFAULT_PORT);
        System.out.printf("Servidor iniciado en el puerto %d%n", SERVER_DEFAULT_PORT);

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");

            // Recibir el nombre del archivo
            BufferedReader recibirDatos = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String nombreArchivo = recibirDatos.readLine();

            // Crear el archivo en el servidor
            String rutaArchivo = SERVER_UPLOAD_DIRECTORY
                    + File.separator
                    + nombreArchivo;
            System.out.printf("Ruta en servidor: %s%n", rutaArchivo);
            FileOutputStream enviarAArchivo = new FileOutputStream(rutaArchivo);

            // Recibir los datos del archivo
            byte[] buffer = new byte[SERVER_DEFAULT_BUFFER_SIZE];
            int bytesLeidos;
            while ((bytesLeidos = cliente.getInputStream().read(buffer)) != -1) {
                enviarAArchivo.write(buffer, 0, bytesLeidos);
            }

            enviarAArchivo.close();
            cliente.close();
            System.out.printf("Archivo %s recibido correctamente%n", rutaArchivo);
        }
    }

    /**
     * Selecciona visualmente el directorio de destino de los ficheros que enviarán los clientes.
     * Si no se elige ninguno, se tomará por defecto el directorio de trabajo.
     * @return objeto que representa a dicho directorio.
     */
    private static String getDirectorio() {
        JFileChooser elegirDirectorio = new JFileChooser();
        elegirDirectorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int seleccion = elegirDirectorio.showOpenDialog(null);

        String directorioSeleccionado;
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            directorioSeleccionado = elegirDirectorio.getSelectedFile().getAbsolutePath();
            System.out.println("Directorio seleccionado: " + directorioSeleccionado);
        } else {
            // Directorio de trabajo
            directorioSeleccionado = System.getProperty("user.dir");
        }
        return directorioSeleccionado;
    }
}
