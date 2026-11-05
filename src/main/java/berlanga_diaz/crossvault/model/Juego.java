package berlanga_diaz.crossvault.model;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Jaime Berlanga Diaz
 */
public class Juego {

    private String titulo;
    private String genero;
    private Map<Plataforma, Integer> stockPorPlataforma;

    public Juego(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.stockPorPlataforma = new EnumMap<>(Plataforma.class);
        for (Plataforma p : Plataforma.values()) {
            this.stockPorPlataforma.put(p, 0);
        }
    }

    public String getTitutlo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getStock(Plataforma plataforma) {
        return stockPorPlataforma.getOrDefault(plataforma, 0);
    }

    public void setStock(Plataforma plataforma, int cantidad) {
        stockPorPlataforma.put(plataforma, Math.max(0, cantidad));
    }

    public boolean reducirStock(Plataforma plataforma) {
        int actual = getStock(plataforma);
        if (actual > 0) {
            stockPorPlataforma.put(plataforma, actual - 1);
            return true;
        }
        return false;
    }

    public void incrementarStock(Plataforma plataforma) {
        stockPorPlataforma.put(plataforma, getStock(plataforma) + 1);
    }

    @Override
    public String toString() {
        return titulo;
    }
}
