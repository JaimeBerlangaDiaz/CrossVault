package berlanga_diaz.crossvault.model;

import java.time.LocalDate;

/**
 *
 * @author Jaime Berlanga Diaz
 */
public class Alquiler {

    private int numeroRegistro;
    private Usuario usuario;
    private Juego juego;
    private Plataforma plataforma;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucionPrevista;
    private boolean devuelto;

    public Alquiler(int numeroRegistro, Usuario usuario, Juego juego, Plataforma plataforma, LocalDate fechaInicio, LocalDate fechaDevolucionPrevista) {
        this.numeroRegistro = numeroRegistro;
        this.usuario = usuario;
        this.juego = juego;
        this.plataforma = plataforma;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        this.devuelto = false;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Juego getJuego() {
        return juego;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    /**
     * Determina si el alquiler está expirado( no devuelto y fecha actual
     * posterior a la prevista)
     */
    public boolean isVencido() {
        return !devuelto && LocalDate.now().isAfter(fechaDevolucionPrevista);
    }

}
