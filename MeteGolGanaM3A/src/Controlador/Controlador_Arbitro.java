/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Clase_Arbitro;
import Modelo.Clase_Persona;
import Modelo.Modelo_Arbitro;
import Modelo.Modelo_Persona;
import Vista.LogIn;
import Vista.VistaGol;
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
public class Controlador_Arbitro {

    private Modelo.Modelo_Arbitro modArbi;
    private Vista.Vista_Arbitro visArbi;
    private Modelo.Modelo_Persona modPersona;
    private Vista.LogIn visPer;
    private JFileChooser jfc;

    public Controlador_Arbitro() {
    }

    public Controlador_Arbitro(Modelo_Arbitro modArbitro, Vista_Arbitro visArbitro, Modelo_Persona modPersona, LogIn visPer) {
        this.modArbi = modArbitro;
        this.visArbi = visArbitro;
        this.modPersona = modPersona;
        this.visPer = visPer;
        visArbitro.setVisible(true);
        visArbi.txtCodigo.setVisible(false);
    }

    public void InicarControlador() {

        visArbi.setTitle("Arbitros");
        MostrarDatos();
        Vista_Arbitro.btnAgregar.addActionListener(l -> IniciarDialogPersona("Registrar"));
        Vista_Arbitro.btnCancelar.addActionListener(l -> {
            Vista_Arbitro.dialogRegistrarModificar.dispose();
            visArbi.tblArbitros.setEnabled(true);
            visPer.txtCedulaDLG.setEnabled(true);

        });
        visPer.btnRetrocederDlgRegistro.addActionListener(l -> {
            visPer.dlgPersona.dispose();
            visArbi.tblArbitros.setEnabled(true);
            visPer.txtCedulaDLG.setEnabled(true);
        });
        Vista_Arbitro.btnModificar.addActionListener(l -> {
            if (visArbi.tblArbitros.getSelectedRow() == -1) {

                MensajeError("Seleccione al Arbitro que desea editar");

            } else {

                IniciarDialogPersona("Editar");
                visPer.txtCedulaDLG.setEnabled(false);
                visArbi.tblArbitros.setEnabled(false);

            }
        });
        visPer.btnSiguienteDlgUsu.addActionListener(l -> RegistrarEditarPersona());
        Vista_Arbitro.btnRegistrarModificar.addActionListener(l -> RegistrarEditarArbitro());
        visPer.btnFoto.addActionListener(l -> Foto());
        Vista_Arbitro.btnEliminar.addActionListener(l -> EliminarArbitro());
        Vista_Arbitro.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                BuscarArbitros();

            }
        });
    }

    public void IniciarDialogPersona(String titulo) {

        visPer.dlgPersona.setVisible(true);
        visPer.dlgPersona.setTitle(titulo);
        visPer.dlgPersona.setSize(1020, 568);

        if (visPer.dlgPersona.getTitle().equals("Registrar")) {

            Vista_Arbitro.btnRegistrarModificar.setText("Registrar");
            LimpiarDatos();
        } else {

            LlenarDatosPersona();
            Vista_Arbitro.btnRegistrarModificar.setText("Aceptar");
        }

    }

    public void IniciarDialogArbitro(String titulo) {

        visPer.dlgPersona.dispose();
        Vista_Arbitro.dialogRegistrarModificar.setVisible(true);
        Vista_Arbitro.dialogRegistrarModificar.setTitle(titulo);
        Vista_Arbitro.dialogRegistrarModificar.setSize(500, 500);

        if (Vista_Arbitro.dialogRegistrarModificar.getTitle().equals("Registrar Arbitro")) {

            Vista_Arbitro.txtCedula.setText(visPer.txtCedulaDLG.getText());
            List<Clase_Persona> jug = modPersona.ListaPersona();
            jug.stream().forEach(p -> {

                if (p.getCedula().equals(Vista_Arbitro.txtCedula.getText())) {

                    Image foto = p.getFoto();
                    if (foto != null) {
                        foto = foto.getScaledInstance(Vista_Arbitro.lblFoto.getWidth(), Vista_Arbitro.lblFoto.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        Vista_Arbitro.lblFoto.setIcon(icono);
                    }
                }
            });
        } else {
            LlenarDatosArbitro();
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
                Logger.getLogger(Controlador_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(Controlador_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    if (modPersona.InsertarPersona()) {

                        IniciarDialogArbitro("Registrar Arbitro");
                    } else {

                        MensajeError("Ha ocurrido un error al registrar en la base");
                    }

                } catch (org.postgresql.util.PSQLException e) {

                    MensajeError("La cedula ya se encuentra registrada");

                } catch (SQLException ex) {

                    Logger.getLogger(Controlador_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
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

                    IniciarDialogArbitro("Editar");
                    MostrarDatos();
                } else {

                    MensajeError("Ha ocurrido un error al actualizar en la base");
                    MostrarDatos();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Controlador_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void RegistrarEditarArbitro() {

        if (visArbi.dialogRegistrarModificar.getTitle().equals("Registrar Arbitro")) {

            if (Vista_Arbitro.txtCedula.getText().isEmpty()
                    || Vista_Arbitro.txtAñosExperiencia.getText().isEmpty() || Vista_Arbitro.getTxtSueldo().getText().isEmpty() || Vista_Arbitro.cbxPosicion.getSelectedIndex() == 0) {

                MensajeError("Faltan campos por llenar");
            } else {

                modArbi.setAnios_esperiencia_arbitro(Integer.valueOf(Vista_Arbitro.txtAñosExperiencia.getText()));
                modArbi.setPosicion_arbitro(Vista_Arbitro.cbxPosicion.getSelectedItem().toString());
                modArbi.setCedula_persona_arbitro(Vista_Arbitro.txtCedula.getText());
                modArbi.setSalario_arbitro(Double.valueOf(Vista_Arbitro.txtSueldo.getText()));

                if (modArbi.InsertarArbitro()) {

                    MensajeSucces("Se ha registrado con exito ");
                    MostrarDatos();
                    Vista_Arbitro.dialogRegistrarModificar.dispose();
                } else {

                    MensajeError("No se ha podido registrar debido a un error en la base de datos");
                    MostrarDatos();
                }
            }
        } else if (Vista_Arbitro.dialogRegistrarModificar.getTitle().equals("Editar")) {

            modArbi.setAnios_esperiencia_arbitro(Integer.valueOf(Vista_Arbitro.txtAñosExperiencia.getText()));
            modArbi.setPosicion_arbitro(Vista_Arbitro.cbxPosicion.getSelectedItem().toString());
            modArbi.setSalario_arbitro(Double.valueOf(Vista_Arbitro.txtSueldo.getText()));
            modArbi.setCodigo_arbitro(Integer.valueOf(Vista_Arbitro.txtCodigo.getText()));

            if (modArbi.ModificarArbitro()) {

                MensajeSucces("Se ha modifcado con exito ");
                MostrarDatos();
                visArbi.dialogRegistrarModificar.dispose();
                visPer.txtCedulaDLG.setEnabled(true);
            } else {

                MensajeError("No se ha podido modificar debido a un error en la base de datos");
                MostrarDatos();
            }
        }
    }

    public void EliminarArbitro() {

        if (Vista_Arbitro.tblArbitros.getSelectedRow() == -1) {

            MensajeError("Seleccione al Arbitro que desea eliminar");
        } else {

            int x = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta informacion?", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (x == 0) {

                modArbi.setCodigo_arbitro(Vista_Arbitro.tblArbitros.getValueAt(Vista_Arbitro.tblArbitros.getSelectedRow(), 0).hashCode());

                if (modArbi.OcultarArbitro()) {

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

        String ced = Vista_Arbitro.tblArbitros.getValueAt(Vista_Arbitro.tblArbitros.getSelectedRow(), 1).toString();

        List<Clase_Arbitro> per = modArbi.ListaArbitro();
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

    public void LlenarDatosArbitro() {

        try {
            String ced = Vista_Arbitro.tblArbitros.getValueAt(Vista_Arbitro.tblArbitros.getSelectedRow(), 1).toString();

            List<Clase_Arbitro> jug = modArbi.ListaArbitro();
            jug.stream().forEach(p -> {

                if (p.getCedula_persona_arbitro().equals(ced)) {

                    //Arbitro
                    Vista_Arbitro.txtAñosExperiencia.setText(String.valueOf(p.getAnios_esperiencia_arbitro()));
                    Vista_Arbitro.txtCedula.setText(String.valueOf(p.getCedula_persona_arbitro()));
                    Vista_Arbitro.cbxPosicion.setSelectedItem(p.getPosicion_arbitro());
                    Vista_Arbitro.txtSueldo.setText(String.valueOf(p.getSalario_arbitro()));
                    Vista_Arbitro.txtCodigo.setText(String.valueOf(p.getCodigo_arbitro()));
                    Image foto = p.getFoto();
                    if (foto != null) {
                        foto = foto.getScaledInstance(Vista_Arbitro.lblFoto.getWidth(), Vista_Arbitro.lblFoto.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        Vista_Arbitro.lblFoto.setIcon(icono);
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

        Vista_Arbitro.txtAñosExperiencia.setText("");
        Vista_Arbitro.txtCedula.setText("");
        Vista_Arbitro.txtSueldo.setText("");
        Vista_Arbitro.cbxPosicion.setSelectedIndex(0);
        Vista_Arbitro.lblFoto.setIcon(null);

    }

    public void MostrarDatos() {

        DefaultTableModel tabla = (DefaultTableModel) Vista_Arbitro.tblArbitros.getModel();
        tabla.setNumRows(0);

        List<Clase_Arbitro> jug = modArbi.ListaArbitro();
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCodigo_arbitro(), p.getCedula_persona_arbitro(), p.getNombnre1(), p.getApellido1(), p.getPosicion_arbitro(), p.getSalario_arbitro()};
            tabla.addRow(datos);
        });
    }

    public void BuscarArbitros() {

        DefaultTableModel tabla = (DefaultTableModel) Vista_Arbitro.tblArbitros.getModel();
        tabla.setNumRows(0);

        List<Clase_Arbitro> jug = modArbi.BuscarArbitro(Vista_Arbitro.txtBuscar.getText());
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCodigo_arbitro(), p.getCedula_persona_arbitro(), p.getNombnre1(), p.getApellido1(), p.getPosicion_arbitro(), p.getSalario_arbitro()};
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
