package berlanga_diaz.crossvault.util;

import berlanga_diaz.crossvault.model.Alquiler;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Jaime Berlanga Diaz
 */
public class AlquilerTableRenderer extends DefaultTableCellRenderer {

    private final List<Alquiler> alquileresMostrados;
    private static final Color VERDE_DEVUELTO = new Color(198, 239, 206);
    private static final Color ROJO_PENDIENTE_VENCIDO = new Color(255, 199, 206);

    public AlquilerTableRenderer(List<Alquiler> alquileresMostrados) {
        this.alquileresMostrados = alquileresMostrados;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected && row >= 0 && row < alquileresMostrados.size()) {
            Alquiler a = alquileresMostrados.get(row);
            if (a.isDevuelto()) {
                c.setBackground(VERDE_DEVUELTO);
                c.setForeground(Color.BLACK);
            } else if (a.isVencido()) {
                c.setBackground(ROJO_PENDIENTE_VENCIDO);
                c.setForeground(Color.BLACK);
            } else {
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
            }
        }
        return c;
    }
}
