package model;

/**
 * Atributos y constructor
 */
public class Tour {
    private String nombre;
    private String tipo;
    private int tarifa;

    public Tour(String nombre, String tipo, int tarifa) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.tarifa = tarifa;
    }

    /**
     * Setters y getters de
     * los atributos
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int precio) {
        this.tarifa = precio;
    }

    /**
     * Decorador
     *
     * @return
     */
    @Override
    public String toString() {
        return nombre + " | " + tipo + " | $" + tarifa;
    }
}
