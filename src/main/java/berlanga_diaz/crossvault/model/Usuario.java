package berlanga_diaz.crossvault.model;

import java.time.LocalDate;

/**
 *
 * @author Jaime Berlanga Diaz
 */
public class Usuario {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String telefono;
    private LocalDate fechaRegistro;

    public Usuario(String nombre, String apellido1, String apellido2, String dni, String telefono, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido1 + (apellido2 != null && !apellido2.isEmpty() ? " " + apellido2 : " ");
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " (" + dni + ")";
    }

}
