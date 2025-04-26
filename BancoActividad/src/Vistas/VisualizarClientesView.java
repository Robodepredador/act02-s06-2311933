package Vistas;

import javax.swing.*;
import java.awt.*;

public class VisualizarClientesView extends JPanel {
    private JTextArea cuentasArea;
    private JButton cargarCuentasBtn;
    private JButton limpiarBtn;

    public VisualizarClientesView() {
        setLayout(new BorderLayout());

        cuentasArea = new JTextArea(20, 60);
        cuentasArea.setEditable(false);

        JPanel buttonPanel = new JPanel();
        cargarCuentasBtn = new JButton("Cargar Cuentas");
        limpiarBtn = new JButton("Limpiar");

        buttonPanel.add(cargarCuentasBtn);
        buttonPanel.add(limpiarBtn);

        add(new JScrollPane(cuentasArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JTextArea getCuentasArea() { return cuentasArea; }
    public JButton getCargarCuentasBtn() { return cargarCuentasBtn; }
    public JButton getLimpiarBtn() { return limpiarBtn; }
}
