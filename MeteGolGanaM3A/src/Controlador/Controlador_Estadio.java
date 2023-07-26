/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import LIB.FSTexFieldMD;
import Modelo.Clase_Arbitro;
import Modelo.Clase_Equipo;
import Modelo.Clase_Estadio;
import Modelo.Clase_Partido;
import Modelo.Clase_Persona;
import Modelo.ModeloEquipos;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        visEstadio.getBtnCancelar().addActionListener(l -> cerrarDialogo());
        visEstadio.btnModificar.addActionListener(l -> {
            if (visEstadio.tblEstadios.getSelectedRow() == -1) {

                MensajeError("Seleccione el Estadio que desea editar");

            } else {

                abrirDialogo("Editar");

            }
        });
        
        
        visEstadio.tblEquipos.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                int cod = (int) visEstadio.tblEquipos.getValueAt(visEstadio.tblEquipos.getSelectedRow(), 0);
                visEstadio.txtCodigoEquipo.setText(String.valueOf(cod));
            }

        });
        visEstadio.btnRegistrarModificar.addActionListener(l -> RegistrarEditarEstadio());
        visEstadio.btnEliminar.addActionListener(l -> EliminarEstadio());
        visEstadio.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //char tecla = e.getKeyChar();
                if (!Character.isDigit(e.getKeyChar())) {
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

      private void cerrarDialogo() {

        visEstadio.getDialogRegistrarModificar().dispose();

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

        if (visEstadio.txtBuscar.getText().isEmpty()) {
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
        
        limpiarDatos();

        visEstadio.getDialogRegistrarModificar().setLocationRelativeTo(null);
        visEstadio.getDialogRegistrarModificar().setSize(900, 900);
        visEstadio.getDialogRegistrarModificar().setTitle(ce);
        visEstadio.getDialogRegistrarModificar().setVisible(true);

        if (visEstadio.getDialogRegistrarModificar().getTitle().contentEquals("Crear")) {
            visEstadio.getLblReMoJugadores().setText("REGISTRO DE ESTADIOS");
            visEstadio.getBtnRegistrarModificar().setText("REGISTRO DE ESTADIOS");
            LlenarTablaEquipos();

        } else if (visEstadio.getDialogRegistrarModificar().getTitle().contentEquals("Editar")) {
            visEstadio.getLblReMoJugadores().setText("MODIFICAR ESTADIOS");
            LlenarDatos();
            visEstadio.getBtnRegistrarModificar().setText("MODIFICAR ESTADIOS");
            LlenarTablaEquipos();

        } else if (visEstadio.getDialogRegistrarModificar().getTitle().contentEquals("Eliminar")) {
            LlenarDatos();
            visEstadio.getBtnRegistrarModificar().setText("ELIMINAR ESTADIOS");

        }
    }
    
    public void limpiarDatos(){
        visEstadio.txtAforoEst.setText("");
        visEstadio.txtCodigoEquipo.setText("");
        visEstadio.txtCodigoEst.setText("");
        visEstadio.txtNombreEst.setText("");
        visEstadio.txtUbicacionEst.setText("");
        visEstadio.txtCodigoEst.setEnabled(true);
    }
    
    public void EliminarEstadio() {

        if (visEstadio.tblEstadios.getSelectedRow() == -1) {

            MensajeError("Seleccione el Estadio que desea eliminar");
        } else {

            int x = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta informacion?", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (x == 0) {

                modEstadio.setCodigo((int) visEstadio.tblEstadios.getValueAt(visEstadio.tblEstadios.getSelectedRow(), 0));

                if (modEstadio.OcultarEstadio()) {

                    MensajeSucces("Se ha eliminado con exito");
                    MostrarDatos();
                } else {

                    MensajeError("No se ha podido eliminar debido a un error en la base de datos");
                    MostrarDatos();
                }
            }
        }
    }

    public boolean validarNumeros(String txt, String nombreComponente){
        try {
            Integer.parseInt(txt);
            return true;
        } catch (Exception e) {
            MensajeError("Debe Ingresar solo Numeros en "+nombreComponente);
            return false;
        }
    }
    
    public void RegistrarEditarEstadio() {
        
        if(!validarNumeros(visEstadio.txtAforoEst.getText(),"aforo")||!validarNumeros(visEstadio.txtCodigoEquipo.getText(),"codigo de equipo")){
            return;
        }

        if (visEstadio.getDialogRegistrarModificar().getTitle().equals("Crear")) {
            if (visEstadio.txtAforoEst.getText().isEmpty() || visEstadio.txtCodigoEquipo.getText().isEmpty() || visEstadio.txtCodigoEst.getText().isEmpty()
                    || visEstadio.txtNombreEst.getText().isEmpty() || visEstadio.txtUbicacionEst.getText().isEmpty()) {

                MensajeError("Faltan campos por llenar");

            } else {

                modEstadio.setAforo(Integer.parseInt(visEstadio.txtAforoEst.getText()));
                modEstadio.setCod_equipofk(Integer.parseInt(visEstadio.txtCodigoEquipo.getText()));
                modEstadio.setCodigo(Integer.parseInt(visEstadio.txtCodigoEst.getText()));
                modEstadio.setNombre(visEstadio.txtNombreEst.getText());
                modEstadio.setUbicacion(visEstadio.txtUbicacionEst.getText());
                modEstadio.setEstado_elim(false);

                if (modEstadio.InsertarEstadio()) {

                    MensajeSucces("Se ha Registrado Correctamente");
                    visEstadio.getDialogRegistrarModificar().dispose();
                    MostrarDatos();
                } else {

                    MensajeError("Ha ocurrido un error al registrar en la base");
                }
            }
        } else if (visEstadio.getDialogRegistrarModificar().getTitle().equals("Editar")) {

            modEstadio.setAforo(Integer.parseInt(visEstadio.txtAforoEst.getText()));
            modEstadio.setCod_equipofk(Integer.parseInt(visEstadio.txtCodigoEquipo.getText()));
            modEstadio.setCodigo(Integer.parseInt(visEstadio.txtCodigoEst.getText()));
            modEstadio.setNombre(visEstadio.txtNombreEst.getText());
            modEstadio.setUbicacion(visEstadio.txtUbicacionEst.getText());
            modEstadio.setEstado_elim(false);

            if (modEstadio.ModificarEstadio()) {

                MensajeSucces("Se ha Registrado Correctamente");
                visEstadio.getDialogRegistrarModificar().dispose();
                MostrarDatos();
            } else {

                MensajeError("Ha ocurrido un error al actualizar en la base");
                MostrarDatos();
            }
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
                visEstadio.getTxtCodigoEquipo().setText(String.valueOf(p.getCod_equipofk()));
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento válido de la tabla.");
            }
        }
    }

    public void LlenarTablaEquipos() {
        ModeloEquipos meq = new ModeloEquipos();

        List<Clase_Equipo> equi = meq.listarEquipos();
        DefaultTableModel tabla = (DefaultTableModel) VistaEstadios.tblEquipos.getModel();
        tabla.setNumRows(0);

        equi.stream().forEach(p -> {

            Object datos[] = {p.getCod_equipo(), p.getNombre_equi()};
            tabla.addRow(datos);
        });
    }

    public void MensajeSucces(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
    }

    public void MensajeError(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
