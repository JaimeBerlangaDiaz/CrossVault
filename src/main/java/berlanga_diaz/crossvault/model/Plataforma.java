package berlanga_diaz.crossvault.model;

/**
 *
 * @author Jaime Berlanga Diaz
 */
public enum Plataforma {
    PS5("PS5"),
    SWITCH_2("Switch 2"),
    XBOX("Xbox"),
    PC("PC");

    private final String nombreMostrar;

    Plataforma(String nombreMostrar) {
        this.nombreMostrar = nombreMostrar;
    }

    public String getNombreMostrar() {
        return nombreMostrar;
    }

    @Override
    public String toString() {
        return nombreMostrar;
    }
}
