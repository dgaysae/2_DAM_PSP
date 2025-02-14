package unidad04.ejemplos.ejemplo03;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Vamos a ver un ejemplo de cómo consumir información de una API Rest.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // Crear un cliente HttpClient
        HttpClient cliente = HttpClient.newHttpClient();

        // Crear una solicitud GET
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/18"))
                .GET()
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> respuesta = cliente.send(
                solicitud,
                HttpResponse.BodyHandlers.ofString()
        );

        // Imprimir el código de estado de la respuesta
        System.out.println("Código de estado: " + respuesta.statusCode());

        // Imprimir el cuerpo de la respuesta (JSON)
        String json = respuesta.body();
        System.out.println("Respuesta JSON: " + json);

        // Parsear el JSON a un objeto Java (usando Gson)
        Gson gson = new Gson();
        Post post = gson.fromJson(json, Post.class);

        // Imprimir los datos del objeto Post
        System.out.println("- ID de usuario: " + post.getUserId());
        System.out.println("- ID del post: " + post.getId());
        System.out.println("- Título del post: " + post.getTitle());
        System.out.println("- Cuerpo del post: " + post.getBody());
    }
}
