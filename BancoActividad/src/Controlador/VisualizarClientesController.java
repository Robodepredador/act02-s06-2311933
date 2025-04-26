package Controlador;

import Vistas.VisualizarClientesView;
import Utilidades.Archivo;

import javax.swing.*;
import java.util.List;

public class VisualizarClientesController {
    private VisualizarClientesView vista;
    private Archivo archivo;

    public VisualizarClientesController(VisualizarClientesView vista) {
        this.vista = vista;
        this.archivo = new Archivo("cuentas.txt");

        configurarListeners();
    }

    private void configurarListeners() {
        vista.getCargarCuentasBtn().addActionListener(e -> cargarCuentas());
        vista.getLimpiarBtn().addActionListener(e -> vista.getCuentasArea().setText(""));
    }

    private void cargarCuentas() {
        try {
            List<String> lineas = archivo.leerCuentas();
            if (lineas.isEmpty()) {
                vista.getCuentasArea().setText("No hay cuentas registradas.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (String linea : lineas) {
                sb.append(linea).append("\n");
            }
            vista.getCuentasArea().setText(sb.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al cargar cuentas: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
