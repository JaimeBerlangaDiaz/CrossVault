package berlanga_diaz.crossvault;

import berlanga_diaz.crossvault.view.MainFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CrossVault {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
            frame.setVisible(true);            // Fuerza que se muestre visible
        });
    }
}