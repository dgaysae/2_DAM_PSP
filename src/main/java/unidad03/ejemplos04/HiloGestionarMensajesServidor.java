package unidad03.ejemplos04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HiloGestionarMensajesServidor implements Runnable {
    private Map<String, List<PrintWriter>> salas = new HashMap<>();
    private String nombreUsuario;
    private BufferedReader recibirDeCliente;
    private PrintWriter enviarACliente;
    private String sala;

    public HiloGestionarMensajesServidor(
            Map<String, List<PrintWriter>> salas,
            String sala,
            String nombreUsuario,
            BufferedReader recibirDeCliente,
            PrintWriter enviarACliente
    ) {
        this.salas = salas;
        this.nombreUsuario = nombreUsuario;
        this.recibirDeCliente = recibirDeCliente;
        this.enviarACliente = enviarACliente;
        this.sala = sala;
    }

    @Override
    public void run() {
        try {
            String mensaje;
            while ((mensaje = recibirDeCliente.readLine()) != null) {
                if (mensaje.startsWith("@")) {
                    // Mensaje privado
                    String[] partes = mensaje.split(" ", 2);
                    String destinatario = partes[0].substring(1);
                    String mensajePrivado = partes[1];

                    // Buscar al destinatario en todas las salas
                    boolean encontrado = false;
                    for (List<PrintWriter> clientesSala : salas.values()) {
                        for (PrintWriter clienteSala : clientesSala) {
                            if (clienteSala.toString().contains(destinatario)) {
                                clienteSala.println(nombreUsuario + " (privado): " + mensajePrivado);
                                encontrado = true;
                                break;
                            }
                        }
                        if (encontrado) {
                            break;
                        }
                    }
                    if (!encontrado) {
                        enviarACliente.println("Usuario no encontrado");
                    }
                } else if (mensaje.equals(ChatServerMultiUser.COMMAND_CHAT_LIST)) {
                    // Mostrar lista de usuarios en la sala
                    enviarACliente.println("Usuarios en la sala " + sala + ":");
                    for (PrintWriter clienteSala : salas.get(sala)) {
                        enviarACliente.println(clienteSala.toString().split("=")[1]);
                    }
                } else if (mensaje.equals(ChatServerMultiUser.COMMAND_CHAT_EXIT)) {
                    // Desconectar al cliente
                    salas.get(sala).remove(enviarACliente);
                    for (PrintWriter clienteSala : salas.get(sala)) {
                        clienteSala.println(nombreUsuario + " ha abandonado la sala");
                    }
                    break;
                } else {
                    // Mensaje público
                    for (PrintWriter clienteSala : salas.get(sala)) {
                        clienteSala.println(nombreUsuario + ": " + mensaje);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR! " + e.getMessage());
        } finally {
            salas.get(sala).remove(enviarACliente);
            for (PrintWriter clienteSala : salas.get(sala)) {
                clienteSala.println(nombreUsuario + " se ha desconectado");
            }
        }
    }
}
