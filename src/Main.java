import ui.VentanaCatalogo;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaCatalogo().setVisible(true));
    }
}
