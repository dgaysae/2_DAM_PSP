package unidad04.ejemplos.ejemplo02;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class EjemploHttpUrlConnection2 {
    public static void main(String[] args) {
        URL url;
        String params;
        try {
            url = new URL("https://api.github.com/users/google");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            params = URLEncoder.encode("param1=value1&param2=value2",
                    StandardCharsets.UTF_8.name());
            dos.writeChars(params);

            dos.flush();
            dos.close();
        } catch (MalformedURLException ex) {
            System.out.println("URL incorrecta");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error al codificar los parámetros de la URL. No se pueden condificar en UTF8");
        } catch (IOException ex) {
            System.out.println("Se ha producido un error en la conexión");
        }
    }
}
