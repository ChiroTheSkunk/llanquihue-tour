package data;
import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Gestor de datos
 * Usa split
 */
public class GestorDatos {
    /**
     * Constructor
     * @return
     */
    public ArrayList<Tour> cargarTours() {
        ArrayList<Tour> tours = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("resources/tours.txt")
            );
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0];
                String tipo = datos[1];
                int precio = Integer.parseInt(datos[2]);
                Tour tour = new Tour(nombre, tipo, precio);
                tours.add(tour);
            }
            br.close();
        } catch (Exception e) {
            /**
             * Imprimir error
             */
            System.out.println("Error: " + e.getMessage());
        }
        return tours;
    }
}