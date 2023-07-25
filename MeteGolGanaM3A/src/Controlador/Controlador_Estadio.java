/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Clase_Arbitro;
import Modelo.Clase_Estadio;
import Modelo.Clase_Partido;
import Modelo.Clase_Persona;
import Modelo.Modelo_Arbitro;
import Modelo.Modelo_Estadio;
import Modelo.Modelo_Persona;
import Vista.LogIn;
import Vista.VistaEquipos;
import Vista.VistaEstadios;
import Vista.Vista_Arbitro;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class Controlador_Estadio {

    private Modelo.Modelo_Estadio modEstadio;
    private Vista.VistaEstadios visEstadio;
    private JFileChooser jfc;

    public Controlador_Estadio(Modelo_Estadio modEstadio, VistaEstadios visEstadio) {
        this.modEstadio = modEstadio;
        this.visEstadio = visEstadio;
        visEstadio.setVisible(true);
    }

    public void InicarControlador() {

        visEstadio.setTitle("Estadios");
        MostrarDatos();
        visEstadio.btnAgregar.addActionListener(l -> abrirDialogo("Crear"));
        visEstadio.btnModificar.addActionListener(l -> abrirDialogo("Editar"));
        visEstadio.btnModificar.addActionListener(l -> {
            if (visEstadio.tblEstadios.getSelectedRow() == -1) {

                MensajeError("Seleccione el Estadio que desea editar");

            } else {

//                IniciarDialogPersona("Editar");

            }
        });
//        visPer.btnSiguienteDlgUsu.addActionListener(l -> RegistrarEditarPersona());
//        Vista_Arbitro.btnRegistrarModificar.addActionListener(l -> RegistrarEditarArbitro());
//        visPer.btnFoto.addActionListener(l -> Foto());
//        Vista_Arbitro.btnEliminar.addActionListener(l -> EliminarArbitro());
        visEstadio.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //char tecla = e.getKeyChar();
                if(!Character.isDigit( e.getKeyChar())){
                    e.consume();
                    
                 }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //char tecla = e.getKeyChar();
                BuscarEstadios();
            }
        });
    }

    public void MostrarDatos() {

        DefaultTableModel tabla = (DefaultTableModel) VistaEstadios.tblEstadios.getModel();
        tabla.setNumRows(0);
        List<Clase_Estadio> est = modEstadio.ListaEstadios();
        est.stream().forEach(p -> {

            Object datos[] = {p.getCodigo(), p.getNombre(), p.getAforo(), p.getUbicacion(), p.getNombreEquipo()};
            tabla.addRow(datos);
        });
    }

    public void BuscarEstadios() {
        
        if(visEstadio.txtBuscar.getText().isEmpty()){
            MostrarDatos();
            return;
        }

        DefaultTableModel tabla = (DefaultTableModel) visEstadio.tblEstadios.getModel();
        tabla.setNumRows(0);

        List<Clase_Estadio> est = modEstadio.BuscarEstadio(visEstadio.txtBuscar.getText());
         est.stream().forEach(p -> {

            Object datos[] = {p.getCodigo(), p.getNombre(), p.getAforo(), p.getUbicacion(), p.getNombreEquipo()};
            tabla.addRow(datos);
        });
    }
    
    private void abrirDialogo(String ce) {

        visEstadio.getDialogRegistrarModificar().setLocationRelativeTo(null);
        visEstadio.getDialogRegistrarModificar().setSize(900, 900);
        visEstadio.getDialogRegistrarModificar().setTitle(ce);
        visEstadio.getDialogRegistrarModificar().setVisible(true);

        if (visEstadio.getDialogRegistrarModificar().getTitle().contentEquals("Crear")) {
            visEstadio.getLblReMoJugadores().setText("REGISTRO DE ESTADIOS");
            visEstadio.getBtnRegistrarModificar().setText("REGISTRO DE ESTADIOS");

        } else if (visEstadio.getDialogRegistrarModificar().getTitle().contentEquals("Editar")) {
            visEstadio.getLblReMoJugadores().setText("MODIFICAR ESTADIOS");
            LlenarDatos();
            visEstadio.getBtnRegistrarModificar().setText("MODIFICAR ESTADIOS");

        } else if (visEstadio.getDialogRegistrarModificar().getTitle().contentEquals("Eliminar")) {
            LlenarDatos();
            visEstadio.getBtnRegistrarModificar().setText("ELIMINAR ESTADIOS");

        }
    }
    
    public void LlenarDatos() {
        List<Clase_Estadio> Listpar = modEstadio.ListaEstadios();
        int selectedRow = visEstadio.getTblEstadios().getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
        } else {
            String selectedId = visEstadio.getTblEstadios().getValueAt(selectedRow, 0).toString();
            Optional<Clase_Estadio> matchingPartido = Listpar.stream()
                    .filter(p -> selectedId.equals(String.valueOf(p.getCodigo())))
                    .findFirst();

            if (matchingPartido.isPresent()) {
                Clase_Estadio p = matchingPartido.get();
                visEstadio.getTxtCodigoEst().setText(String.valueOf(p.getCodigo()));
                visEstadio.getTxtCodigoEst().setEnabled(false);
                visEstadio.getTxtNombreEst().setText(String.valueOf(p.getNombre()));
                visEstadio.getTxtAforoEst().setText(String.valueOf(p.getAforo()));
                visEstadio.getTxtUbicacionEst().setText(String.valueOf(p.getUbicacion()));

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento válido de la tabla.");
            }
        }
    }

    public void MensajeSucces(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
    }

    public void MensajeError(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
