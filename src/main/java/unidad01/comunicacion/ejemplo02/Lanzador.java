package unidad01.comunicacion.ejemplo02;

import java.io.File;

public class Lanzador {
    public void lanzarSumador(Integer n1, Integer n2, String ficheroResultado){
        String clase = "Sumador";
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(
                    "java",
                    clase,
                    n1.toString(),
                    n2.toString());
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(ficheroResultado));
            pb.start();
        } catch (Exception e) {
            System.out.printf("ERROR! %s %n", e.getMessage());
        }
    }
    public static void main(String[] args){
        Lanzador l=new Lanzador();
        l.lanzarSumador(1, 5, "resultado1.txt");
        l.lanzarSumador(6, 10, "resultado2.txt");
        System.out.println("Ok");
    }
}
