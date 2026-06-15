package model;

/**
 * Atributos y constructor
 */
public class Tour {
    private String nombre;
    private String tipo;
    private int precio;
    public Tour(String nombre, String tipo, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    /**
     * Setters y getters de
     * los atributos
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
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Decorador
     * @return
     */
        @Override
        public String toString() {
            return nombre + " - " + tipo + " - $" + precio;
        }
    }
