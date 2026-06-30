package data;
import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import model.ServicioTuristico;
import model.ExcursionCultural;
import model.RutaGastronomica;
import model.PaseoLacustre;
/**
 * Gestor de datos
 * Usa split
 */
public class GestorServicios {
    /**
     * Constructor
     * @return
     */
    public void crearServicios() {
        RutaGastronomica ruta1 = new RutaGastronomica(
                "Ruta del Salmon",
                4,
                5
        );
        RutaGastronomica ruta2 = new RutaGastronomica(
                "Ruta del Queso",
                3,
                4
        );
        PaseoLacustre paseo1 = new PaseoLacustre(
                "Lago Llanquihue",
                2,
                "Catamaran"
        );
        PaseoLacustre paseo2 = new PaseoLacustre(
                "Lago Todos los Santos",
                3,
                "Lancha"
        );
        ExcursionCultural excursion1 = new ExcursionCultural(
                "Museo Colonial",
                5,
                "Fuerte Historico"
        );
        ExcursionCultural excursion2 = new ExcursionCultural(
                "Puerto Varas",
                4,
                "Iglesia del Sagrado Corazon"
        );
        System.out.println(ruta1);
        System.out.println(ruta2);
        System.out.println(paseo1);
        System.out.println(paseo2);
        System.out.println(excursion1);
        System.out.println(excursion2);
    }
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
            System.out.println("Error al gestionar datos: " + e.getMessage());
        }
        return tours;
    }
}