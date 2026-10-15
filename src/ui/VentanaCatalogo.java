package ui;

import dominio.Catalogo;
import dominio.DatoInvalidoException;
import dominio.Libro;
import dominio.LibroDigital;
import dominio.LibroFisico;

import javax.swing.*;
import java.awt.*;

/** Solo arma la interfaz y traduce texto a objetos. Las reglas viven en el dominio. */
public class VentanaCatalogo extends JFrame {
    private final Catalogo catalogo = new Catalogo();

    private final JTextField txtTitulo = new JTextField(20);
    private final JTextField txtAutor = new JTextField(20);
    private final JTextField txtAnio = new JTextField(20);
    private final JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Físico", "Digital"});
    private final JLabel lblExtra = new JLabel("Páginas:");
    private final JTextField txtExtra = new JTextField(20);
    private final JTextArea areaLista = new JTextArea(10, 40);

    public VentanaCatalogo() {
        super("Catálogo de libros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 6, 6));
        formulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        formulario.add(new JLabel("Título:"));  formulario.add(txtTitulo);
        formulario.add(new JLabel("Autor:"));   formulario.add(txtAutor);
        formulario.add(new JLabel("Año:"));     formulario.add(txtAnio);
        formulario.add(new JLabel("Tipo:"));    formulario.add(cmbTipo);
        formulario.add(lblExtra);               formulario.add(txtExtra);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> agregarLibro());
        cmbTipo.addActionListener(e ->
                lblExtra.setText(cmbTipo.getSelectedIndex() == 0 ? "Páginas:" : "Tamaño (MB):"));

        areaLista.setEditable(false);

        JPanel norte = new JPanel(new BorderLayout());
        norte.add(formulario, BorderLayout.CENTER);
        norte.add(btnAgregar, BorderLayout.SOUTH);

        add(norte, BorderLayout.NORTH);
        add(new JScrollPane(areaLista), BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void agregarLibro() {
        try {
            int anio = Integer.parseInt(txtAnio.getText().trim());
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            Libro libro;
            if (cmbTipo.getSelectedIndex() == 0) {
                libro = new LibroFisico(titulo, autor, anio, Integer.parseInt(txtExtra.getText().trim()));
            } else {
                libro = new LibroDigital(titulo, autor, anio,
                        Double.parseDouble(txtExtra.getText().trim().replace(',', '.')));
            }
            catalogo.agregar(libro);
            refrescarLista();
            limpiarCampos();
        } catch (NumberFormatException ex) {
            mostrarError("El año y " + (cmbTipo.getSelectedIndex() == 0 ? "las páginas" : "el tamaño")
                    + " deben ser números válidos.");
        } catch (DatoInvalidoException ex) {
            mostrarError(ex.getMessage());
        }
    }

    private void refrescarLista() {
        StringBuilder sb = new StringBuilder();
        for (Libro l : catalogo.listar()) {
            sb.append(l.descripcion()).append('\n');
        }
        areaLista.setText(sb.toString());
    }

    private void limpiarCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtAnio.setText("");
        txtExtra.setText("");
        txtTitulo.requestFocus();
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Datos incorrectos", JOptionPane.WARNING_MESSAGE);
    }
}
