package unidad04.ejemplos.ejemplo03;

class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    // Gson necesita los getters y setters
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
