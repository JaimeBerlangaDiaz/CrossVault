package berlanga_diaz.crossvault.controller;

import berlanga_diaz.crossvault.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Jaime Berlanga Diaz
 */
public class GestorAlquileres {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Juego> juegos = new ArrayList<>();
    private final List<Alquiler> alquileres = new ArrayList<>();
    private int contadorRegistros = 1;

    public GestorAlquileres() {
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        // 2 Usuarios distintos
        Usuario u1 = new Usuario("Laura", "García", "López", "12345678A", "600111222", LocalDate.now().minusDays(10));
        Usuario u2 = new Usuario("Anna", "Martinez", "Sanchez", "87654321B", "600333444", LocalDate.now().minusDays(8));
        usuarios.add(u1);
        usuarios.add(u2);

        //Juego1: Disponible para PS5 y Switch2
        Juego j1 = new Juego("The Legend of Zelda", "Aventura");
        j1.setStock(Plataforma.PS5, 2);
        j1.setStock(Plataforma.SWITCH_2, 2);

        //Juego2: Disponible para XBOX y PC
        Juego j2 = new Juego("Cyberpunk 2077", "Acció");
        j2.setStock(Plataforma.XBOX, 2);
        j2.setStock(Plataforma.PC, 2);

        juegos.add(j1);
        juegos.add(j2);

        // 2 alquileres iniciales (uno por usuario, consumiendo stock real
        // Alquiler 1: Hace 10 días (para que se vea en ROJO / fuera de plazo de inmediato
        registrarAlquilerConFechas(u1, j1, Plataforma.SWITCH_2, LocalDate.now().minusDays(10), LocalDate.now().minusDays(3));

        // Alquiler 2: Actual
        registrarAlquiler(u2, j2, Plataforma.PC);
    }

    public Alquiler registrarAlquiler(Usuario usuario, Juego juego, Plataforma plataforma) {
        LocalDate inicio = LocalDate.now();
        LocalDate devolucion = inicio.plusDays(3);
        return registrarAlquilerConFechas(usuario, juego, plataforma, inicio, devolucion);
    }

    private Alquiler registrarAlquilerConFechas(Usuario usuario, Juego juego, Plataforma plataforma, LocalDate inicio, LocalDate fin) {
        if (!juego.reducirStock(plataforma)) {
            throw new IllegalStateException("No hay stock disponible para la plataforma seleccionada");
        }
        Alquiler nuevo = new Alquiler(contadorRegistros++, usuario, juego, plataforma, inicio, fin);
        alquileres.add(nuevo);
        return nuevo;
    }

    public void registrarDevolucion(Alquiler alquiler) {
        if (alquiler != null && !alquiler.isDevuelto()) {
            alquiler.setDevuelto(true);
            alquiler.getJuego().incrementarStock(alquiler.getPlataforma());
        }
    }

    public boolean tieneAlquileresActivos(Usuario usuario) {
        return alquileres.stream().anyMatch(a -> a.getUsuario().equals(usuario) && !a.isDevuelto());
    }

    public boolean tieneAlquileresActivos(Juego juego) {
        return alquileres.stream().anyMatch(a -> a.getJuego().equals(juego) && !a.isDevuelto());
    }

    public boolean eliminarUsuario(Usuario usuario) {
        if (tieneAlquileresActivos(usuario)) {
            return false;
        }
        return usuarios.remove(usuario);
    }

    public boolean eliminarJuego(Juego juego) {
        if (tieneAlquileresActivos(juego)) {
            return false;
        }
        return juegos.remove(juego);
    }

    public void agregarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void agregarJuego(Juego j) {
        juegos.add(j);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    /**
     * Devuelve los alquileres ordenados de forma descendente por número de
     * registro.
     */
    public List<Alquiler> getAlquilersOrdenadosDesc() {
        return alquileres.stream()
                .sorted(Comparator.comparingInt(Alquiler::getNumeroRegistro).reversed())
                .collect(Collectors.toList());
    }

    public List<Alquiler> getAlquileresActivosOrdenadosDesc() {
        return alquileres.stream()
                .filter(a -> !a.isDevuelto())
                .sorted(Comparator.comparingInt(Alquiler::getNumeroRegistro).reversed())
                .collect(Collectors.toList());
    }
}
