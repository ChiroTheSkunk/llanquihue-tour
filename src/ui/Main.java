package ui;
import data.GestorDatos;
import model.Tour;
import java.util.ArrayList;

/**
 * Clase Main
 */
public class Main {

    public static void main(String[] args) {
/**
 * Nuevo gestor de datos
 */
        GestorDatos gestor = new GestorDatos();
/**
 * Cargar los tours
 */
        ArrayList<Tour> tours = gestor.cargarTours();
/**
 * Imprimir los tours
 */
        System.out.println("TODOS LOS TOURS:");

        for (Tour t : tours) {
            System.out.println(t);
        }

        System.out.println("\nTOURS SOBRE $10000:");
/**
 * Imprimir los tours con precio mas de 10000
 */
        for (Tour t : tours) {
            if (t.getPrecio() > 10000) {
                System.out.println(t);
            }
        }
    }
}