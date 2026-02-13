public class Persona {

    private int id;
    private String nombre;
    private boolean activa;

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.activa = true;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActiva() {
        return activa;
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    // Imprimir los datos de manera ordenada
    @Override
    public String toString() {
        return "ID: " + id + "       Nombre: " + nombre + "       Activa: " + activa;
    }
}
