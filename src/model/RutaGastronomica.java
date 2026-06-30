package model;

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;
    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre,duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }
    @Override
    public String toString() {
        return super.toString() + ", Numero de paradas: " + numeroDeParadas;
    }
}
