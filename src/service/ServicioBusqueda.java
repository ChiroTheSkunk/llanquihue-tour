package service;
import model.Tour;
import java.util.ArrayList;
public class ServicioBusqueda {
    public void buscarPorTipo(ArrayList<Tour> tours, String tipo) {
        try {
            for (Tour t : tours) {
                if (t.getTipo().equalsIgnoreCase(tipo)) {
                    System.out.println(t);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar por tipo: " + e.getMessage());
        }
    }
}