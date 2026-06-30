package ui;
import data.GestorServicios;
import model.Tour;
import service.ServicioBusqueda;
import java.util.ArrayList;
import model.ServicioTuristico;
/**
 * Clase Main
 */
public class Main {
    public static void main(String[] args) {
/**
 * Nuevo gestor de servicios, servicio de busqueda y crear servicios
 */
        GestorServicios gestor = new GestorServicios();
        ServicioBusqueda buscador = new ServicioBusqueda();
        gestor.crearServicios();
/**
 * Cargar los tours
 * y buscar por tipo
 */
        ArrayList<Tour> tours = gestor.cargarTours();

        System.out.println("\nTOURS CULTURALES:");
        buscador.buscarPorTipo(tours, "cultural");
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
            if (t.getTarifa() > 10000) {
                System.out.println(t);
            }
        }
    }
}