package unidad04.ejemplos.ejemplo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EjemploHttpUrlConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.github.com/users/google");
            HttpURLConnection conexion = null;
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            BufferedReader leerWeb = null;
            leerWeb = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = leerWeb.readLine()) != null) {
                System.out.println(linea);
            }
            leerWeb.close();
        } catch (IOException e) {
            System.out.println("ERROR! " + e.getMessage());
        }
    }
}
