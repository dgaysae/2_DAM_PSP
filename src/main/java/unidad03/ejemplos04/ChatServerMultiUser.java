package unidad03.ejemplos04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Este chat es aún más completo. Tiene las siguientes características:
 * Salas: en un Map se almacenan las distintas salas y sus respectivos clientes.
 * Nombres de usuario: se pide el nombre de usuario a cada cliente para identificarlo.
 * Mensajes privados: usando el prefijo "@".
 * Comandos: se añaden comandos como /lista para mostrar la lista de usuarios y /salir para
 * desconectarse.
 * Notificaciones: Se envían notificaciones cuando un usuario se une, se desconecta o cuando
 * se envía un mensaje privado.
 */
public class ChatServerMultiUser {
    public static final String COMMAND_CHAT_END = "/fin";
    public static final String COMMAND_CHAT_LIST = "/lista";
    public static final String COMMAND_CHAT_EXIT = "/salir";

    public static final int SERVER_DEFAULT_PORT = 5555;

    private static final Map<String, List<PrintWriter>> salas = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(SERVER_DEFAULT_PORT);
        System.out.printf("Servidor iniciado en el puerto %d%n", SERVER_DEFAULT_PORT);

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Nuevo cliente conectado");

            BufferedReader recibirDeCliente = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter enviarACliente = new PrintWriter(cliente.getOutputStream(), true);

            // Pedir al cliente un nombre de usuario
            System.out.println("Ingrese su nombre de usuario:");
            String nombreUsuario = recibirDeCliente.readLine();

            // Pedir al cliente que seleccione una sala
            System.out.println("Seleccione una sala (o cree una nueva):");
            String sala = recibirDeCliente.readLine();

            // Crear la sala si no existe
            salas.putIfAbsent(sala, new ArrayList<>());
            salas.get(sala).add(enviarACliente);

            // Enviar un mensaje de bienvenida al cliente
            enviarACliente.println("Bienvenido a la sala " + sala + ", " + nombreUsuario);

            // Enviar un mensaje a todos los usuarios de la sala informando de la nueva conexión
            for (PrintWriter clienteEnSala : salas.get(sala)) {
                clienteEnSala.println(nombreUsuario + " se ha unido a la sala");
            }

            new Thread(new HiloGestionarMensajesServidor(salas,
                    sala,
                    nombreUsuario,
                    recibirDeCliente,
                    enviarACliente)
            ).start();
        }
    }
}
