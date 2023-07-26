/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Clase_Entrenador;
import Modelo.Clase_Equipo;
import Modelo.Clase_Persona;
import Modelo.ModeloEquipos;
import Modelo.Modelo_Entrenador;
import Modelo.Modelo_Persona;
import Vista.LogIn;
import Vista.VistaEntrenador;
import Vista.VistaJugadores;
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
 * @author Usuario
 */
public class Controlador_Entrenador {

    private Modelo.Modelo_Entrenador modEnt;
    private Vista.VistaEntrenador visEnt;
    private Modelo.Modelo_Persona modPersona;
    private Modelo.ModeloEquipos modequipo;
    private Vista.LogIn visPer;
    private JFileChooser jfc;

    public Controlador_Entrenador() {
    }

    public Controlador_Entrenador(Modelo_Entrenador modEnt, VistaEntrenador visEnt, Modelo_Persona modPersona, ModeloEquipos modequipo, LogIn visPer) {
        this.modEnt = modEnt;
        this.visEnt = visEnt;
        this.modPersona = modPersona;
        this.modequipo = modequipo;
        this.visPer = visPer;
        this.visEnt.setVisible(true);
    }

    public void InicarControlador() {

        MostrarDatos();
        MostrarEquipos();
        VistaEntrenador.btnAgregar.addActionListener(l -> IniciarDialogPersona("Registrar"));
        VistaEntrenador.btnModificar.addActionListener(l -> {
            if (visEnt.tblArbitros.getSelectedRow() == -1) {

                MensajeError("Seleccione al Entrenador que desea editar");

            } else {

                IniciarDialogPersona("Editar");

            }
        });
        visPer.btnSiguienteDlgUsu.addActionListener(l -> RegistrarEditarPersona());
        VistaEntrenador.btnRegistrarModificar.addActionListener(l -> RegistrarEditarEntrenador());
        visPer.btnFoto.addActionListener(l -> Foto());
        VistaEntrenador.btnEliminar.addActionListener(l -> EliminarArbitro());
        VistaEntrenador.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                BuscarEntrenador();
            }
        });
        VistaEntrenador.tblEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                VistaEntrenador.txtEquipo.setText(VistaEntrenador.tblEquipo.getValueAt(VistaEntrenador.tblEquipo.getSelectedRow(), 0).toString());
            }
        });
    }

    public void IniciarDialogPersona(String titulo) {

        visPer.dlgPersona.setVisible(true);
        visPer.dlgPersona.setTitle(titulo);
        visPer.dlgPersona.setSize(1020, 568);

        if (visPer.dlgPersona.getTitle().equals("Registrar")) {

            VistaEntrenador.btnRegistrarModificar.setText("Registrar");
            LimpiarDatos();
        } else {

            LlenarDatosPersona();
            VistaEntrenador.btnRegistrarModificar.setText("Aceptar");
        }

    }

    public void IniciarDialogEntrenador(String titulo) {

        visPer.dlgPersona.dispose();
        VistaEntrenador.dialogRegistrarModificar.setVisible(true);
        VistaEntrenador.dialogRegistrarModificar.setTitle(titulo);
        VistaEntrenador.dialogRegistrarModificar.setSize(500, 500);

        if (VistaEntrenador.dialogRegistrarModificar.getTitle().equals("Registrar Entrenador")) {

            VistaEntrenador.txtCedula.setText(visPer.txtCedulaDLG.getText());
            List<Clase_Persona> jug = modPersona.ListaPersona();
            jug.stream().forEach(p -> {

                if (p.getCedula().equals(VistaEntrenador.txtCedula.getText())) {

                    Image foto = p.getFoto();
                    if (foto != null) {
                        foto = foto.getScaledInstance(VistaEntrenador.lblFoto.getWidth(), VistaEntrenador.lblFoto.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        VistaEntrenador.lblFoto.setIcon(icono);
                    }
                }
            });
        } else {
            LlenarDatosEntrenador();
        }
    }

    public String Sexo() {

        String x = "";

        if (visPer.rdbFemeninoDlg.isSelected()) {

            x = "Femenino";
        }
        if (visPer.rdbMasculinoDlg.isSelected()) {

            x = "Masculino";
        }
        if (visPer.rdbOtroDlg.isSelected()) {

            x = "Otro";
        }

        return x;
    }

    public void Foto() {

        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(visPer);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        visPer.lblFoto.getWidth(),
                        visPer.lblFoto.getHeight(),
                        Image.SCALE_DEFAULT);

                Icon icono = new ImageIcon(imagen);
                visPer.lblFoto.setIcon(icono);
                visPer.lblFoto.updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Controlador_Entrenador.class.getName()).log(Level.SEVERE, null, ex);
                MensajeError(ex.getMessage());
            }
        }
    }

    public void RegistrarEditarPersona() {

        if (visPer.dlgPersona.getTitle().equals("Registrar")) {

            if (visPer.txtCedulaDLG.getText().isEmpty() || visPer.txt1erApeDLG.getText().isEmpty() || visPer.txt1erNomDlg.getText().isEmpty()
                    || visPer.txt2doApeDLG.getText().isEmpty() || visPer.txt2doNomDLG.getText().isEmpty() || visPer.txtCorreoDlg.getText().isEmpty()
                    || visPer.txtDirecDLG.getText().isEmpty() || visPer.txtFechaDlg.getDate() == null || visPer.txtTelfDLG.getText().isEmpty()
                    || Sexo().equals("") || visPer.lblFoto.getIcon() == null) {

                MensajeError("Faltan campos por llenar");

            } else {

                modPersona.setApellido1(visPer.txt1erApeDLG.getText());
                modPersona.setApellido2(visPer.txt2doApeDLG.getText());
                modPersona.setCedula(visPer.txtCedulaDLG.getText());
                modPersona.setDireccion(visPer.txtDirecDLG.getText());
                modPersona.setTelefono(visPer.txtTelfDLG.getText());
                modPersona.setEmail(visPer.txtCorreoDlg.getText());
                modPersona.setFecha_nac(new java.sql.Date(visPer.txtFechaDlg.getDate().getTime()));
                modPersona.setNombnre1(visPer.txt1erNomDlg.getText());
                modPersona.setNombnre2(visPer.txt2doNomDLG.getText());
                modPersona.setSexo(Sexo());

                try {

                    FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                    int largo = (int) jfc.getSelectedFile().length();
                    modPersona.setImageFile(img);
                    modPersona.setLength(largo);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Controlador_Entrenador.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    if (modPersona.InsertarPersona()) {

                        IniciarDialogEntrenador("Registrar Entrenador");
                    } else {

                        MensajeError("Ha ocurrido un error al registrar en la base");
                    }

                } catch (org.postgresql.util.PSQLException e) {

                    MensajeError("La cedula ya se encuentra registrada");

                } catch (SQLException ex) {

                    Logger.getLogger(Controlador_Entrenador.class.getName()).log(Level.SEVERE, null, ex);
                    MensajeError(ex.getMessage());
                }
            }
        } else if (visPer.dlgPersona.getTitle().equals("Editar")) {

            modPersona.setApellido1(visPer.txt1erApeDLG.getText());
            modPersona.setApellido2(visPer.txt2doApeDLG.getText());
            modPersona.setCedula(visPer.txtCedulaDLG.getText());
            modPersona.setDireccion(visPer.txtDirecDLG.getText());
            modPersona.setTelefono(visPer.txtTelfDLG.getText());
            modPersona.setEmail(visPer.txtCorreoDlg.getText());
            modPersona.setFecha_nac(new java.sql.Date(visPer.txtFechaDlg.getDate().getTime()));
            modPersona.setNombnre1(visPer.txt1erNomDlg.getText());
            modPersona.setNombnre2(visPer.txt2doNomDLG.getText());
            modPersona.setSexo(Sexo());

            try {

                if (modPersona.ActualizarPersona()) {

                    IniciarDialogEntrenador("Editar");
                    MostrarDatos();
                } else {

                    MensajeError("Ha ocurrido un error al actualizar en la base");
                    MostrarDatos();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Entrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ModificarFoto() {

        if (visPer.dlgPersona.getTitle().equals("Editar")) {

            try {

                FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                int largo = (int) jfc.getSelectedFile().length();
                modPersona.setImageFile(img);
                modPersona.setLength(largo);

                if (modPersona.ActualizarPersona()) {

                    MensajeSucces("Se modifico con exito la foto de la persona");
                    MostrarDatos();
                } else {

                    MensajeError("Ha ocurrido un error al actualizar en la base");
                    MostrarDatos();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Entrenador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador_Entrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void RegistrarEditarEntrenador() {

        if (visEnt.dialogRegistrarModificar.getTitle().equals("Registrar Entrenador")) {

            if (VistaEntrenador.txtCodigo.getText().isEmpty() || VistaEntrenador.txtCedula.getText().isEmpty()
                    || VistaEntrenador.txtAñosExperiencia.getText().isEmpty() || VistaEntrenador.getTxtSueldo().getText().isEmpty() || VistaEntrenador.txtEquipo.getText().isEmpty()) {

                MensajeError("Faltan campos por llenar");
            } else {

                modEnt.setAniosexp(Integer.valueOf(VistaEntrenador.txtAñosExperiencia.getText()));
                modEnt.setCodigo_equipofk(VistaEntrenador.txtEquipo.getText());
                modEnt.setCedula(VistaEntrenador.txtCedula.getText());
                modEnt.setCodigo(Integer.valueOf(VistaEntrenador.txtCodigo.getText()));
                modEnt.setSueldo(Double.valueOf(VistaEntrenador.txtSueldo.getText()));

                if (modEnt.InsertarEntrenador()) {

                    MensajeSucces("Se ha registrado con exito ");
                    MostrarDatos();
                    VistaEntrenador.dialogRegistrarModificar.dispose();
                } else {

                    MensajeError("No se ha podido registrar debido a un error en la base de datos");
                    MostrarDatos();
                }
            }
        } else if (VistaEntrenador.dialogRegistrarModificar.getTitle().equals("Editar")) {

            if (VistaEntrenador.tblArbitros.getSelectedRow() == -1) {

                MensajeError("Seleccione al Arbitro que desea modificar");
            } else {

                modEnt.setAniosexp(Integer.valueOf(VistaEntrenador.txtAñosExperiencia.getText()));
                modEnt.setCodigo_equipofk(VistaEntrenador.txtEquipo.getText());
                modEnt.setCodigo(Integer.valueOf(VistaEntrenador.txtCodigo.getText()));
                modEnt.setSueldo(Double.valueOf(VistaEntrenador.txtSueldo.getText()));
                modEnt.setCodigo(VistaEntrenador.tblArbitros.getValueAt(VistaEntrenador.tblArbitros.getSelectedRow(), 0).hashCode());

                if (modEnt.ModificarEntrenador()) {

                    MensajeSucces("Se ha modifcado con exito ");
                    MostrarDatos();
                } else {

                    MensajeError("No se ha podido modificar debido a un error en la base de datos");
                    MostrarDatos();
                }
            }
        }

    }

    public void EliminarArbitro() {

        if (VistaEntrenador.tblArbitros.getSelectedRow() == -1) {

            MensajeError("Seleccione al Arbitro que desea eliminar");
        } else {

            int x = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta informacion?", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (x == 0) {

                modEnt.setCodigo(VistaEntrenador.tblArbitros.getValueAt(VistaEntrenador.tblArbitros.getSelectedRow(), 0).hashCode());

                if (modEnt.EliminarEntrenador()) {

                    MensajeSucces("Se ha eliminado con exito");
                    MostrarDatos();
                } else {

                    MensajeError("No se ha podido eliminar debido a un error en la base de datos");
                    MostrarDatos();
                }
            }
        }
    }

    public void LlenarDatosPersona() {

        String ced = VistaEntrenador.tblArbitros.getValueAt(VistaEntrenador.tblArbitros.getSelectedRow(), 1).toString();

        List<Clase_Entrenador> per = modEnt.ListaEntrenador();
        per.stream().forEach(p -> {

            if (p.getCedula().equals(ced) && p.getCedula().equals(ced)) {

                //Persona
                visPer.txt1erApeDLG.setText(p.getApellido1());
                visPer.txt1erNomDlg.setText(p.getNombnre1());
                visPer.txt2doApeDLG.setText(p.getApellido2());
                visPer.txtCedulaDLG.setText(p.getCedula());
                visPer.txtDirecDLG.setText(p.getDireccion());
                visPer.txtCorreoDlg.setText(p.getEmail());
                visPer.txt2doNomDLG.setText(p.getNombnre2());
                visPer.txtTelfDLG.setText(p.getTelefono());
                visPer.txtFechaDlg.setDate(p.getFecha_nac());
                if (p.getSexo().equals("Femenino")) {

                    visPer.rdbFemeninoDlg.setSelected(true);
                }
                if (p.getSexo().equals("Masculino")) {

                    visPer.rdbMasculinoDlg.setSelected(true);
                }
                if (p.getSexo().equals("Otro")) {

                    visPer.rdbOtroDlg.setSelected(true);
                }

                Image foto = p.getFoto();
                if (foto != null) {
                    foto = foto.getScaledInstance(visPer.lblFoto.getWidth(), visPer.lblFoto.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icono = new ImageIcon(foto);
                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                    visPer.lblFoto.setIcon(icono);
                }
            }
        });

    }

    public void LlenarDatosEntrenador() {

        try {
            String ced = VistaEntrenador.tblArbitros.getValueAt(VistaEntrenador.tblArbitros.getSelectedRow(), 1).toString();

            List<Clase_Entrenador> jug = modEnt.ListaEntrenador();
            jug.stream().forEach(p -> {

                if (p.getCedula_personafk().equals(ced)) {

                    //Arbitro
                    VistaEntrenador.txtAñosExperiencia.setText(String.valueOf(p.getAniosexp()));
                    VistaEntrenador.txtCedula.setText(String.valueOf(p.getCedula()));
                    VistaEntrenador.txtEquipo.setText(p.getCodigo_equipofk());
                    VistaEntrenador.txtSueldo.setText(String.valueOf(p.getSueldo()));

                    Image foto = p.getFoto();
                    if (foto != null) {
                        foto = foto.getScaledInstance(VistaEntrenador.lblFoto.getWidth(), VistaEntrenador.lblFoto.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        VistaEntrenador.lblFoto.setIcon(icono);
                    }
                }
            });
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }

    public void LimpiarDatos() {

        visPer.txt1erApeDLG.setText("");
        visPer.txt1erNomDlg.setText("");
        visPer.txt2doApeDLG.setText("");
        visPer.txt2doNomDLG.setText("");
        visPer.txtCedulaDLG.setText("");
        visPer.txtCorreoDlg.setText("");
        visPer.txtDirecDLG.setText("");
        visPer.txtFechaDlg.setDate(null);
        visPer.txtTelfDLG.setText("");
        visPer.btnGrupo1.clearSelection();
        visPer.lblFoto.setIcon(null);

        VistaEntrenador.txtAñosExperiencia.setText("");
        VistaEntrenador.txtCedula.setText("");
        VistaEntrenador.txtSueldo.setText("");
        VistaEntrenador.txtEquipo.setText("");
        VistaEntrenador.lblFoto.setIcon(null);

    }

    public void MostrarDatos() {

        DefaultTableModel tabla = (DefaultTableModel) VistaEntrenador.tblArbitros.getModel();
        tabla.setNumRows(0);

        List<Clase_Entrenador> jug = modEnt.ListaEntrenador();
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCodigo(), p.getCedula_personafk(), p.getNombnre1(), p.getApellido1(), p.getCodigo_equipofk(), p.getSueldo()};
            tabla.addRow(datos);
        });
    }

    public void MostrarEquipos() {

        DefaultTableModel tabla = (DefaultTableModel) VistaEntrenador.tblEquipo.getModel();
        tabla.setNumRows(0);

        List<Clase_Equipo> jug = modequipo.listarEquipos();
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCod_equipo(), p.getNombre_equi(), p.getCiudad()};
            tabla.addRow(datos);
        });

    }

    public void BuscarEntrenador() {

        DefaultTableModel tabla = (DefaultTableModel) VistaEntrenador.tblArbitros.getModel();
        tabla.setNumRows(0);

        List<Clase_Entrenador> jug = modEnt.BuscarEntrenador(VistaEntrenador.txtBuscar.getText());
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCodigo(), p.getCedula_personafk(), p.getNombnre1(), p.getApellido1(), p.getCodigo_equipofk(), p.getSueldo()};
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
