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
import Vista.Vista_Arbitro;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        VistaEntrenador.txtCedula.setEnabled(false);
        VistaEntrenador.txtCodigo.setEnabled(false);
    }

    public void InicarControlador() {

        MostrarDatos();
        MostrarEquipos();
        visEnt.getTxt_Ruta_Foto().setVisible(false);
        visEnt.btnCancelar.addActionListener(l -> visEnt.dialogRegistrarModificar.dispose());
        visPer.btnRetrocederDlgRegistro.addActionListener(l -> visPer.dlgPersona.dispose());
        VistaEntrenador.btnAgregar.addActionListener(l -> {
            try {
                IniciarDialogPersona("Registrar");
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Entrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        VistaEntrenador.btnModificar.addActionListener(l -> {
            if (visEnt.tblEntrenador.getSelectedRow() == -1) {

                MensajeError("Seleccione al Entrenador que desea editar");

            } else {

                try {
                    IniciarDialogPersona("Editar");
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador_Entrenador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        visPer.btnSiguienteDlgUsu.addActionListener(l -> RegistrarEditarPersona());
        VistaEntrenador.btnRegistrarModificar.addActionListener(l -> RegistrarEditarEntrenador());
        visPer.btnFoto.addActionListener(l -> Foto());
        VistaEntrenador.btnEliminar.addActionListener(l -> EliminarEntrenador());
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
        VistaEntrenador.getTxtAñosExperiencia().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntradaAnios(evt);
            }
        });
        VistaEntrenador.getTxtSueldo().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarSueldo(evt);
            }
        });
        visPer.getTxtCedulaDLG().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntradaCedula(evt);
            }
        });
        visPer.getTxt1erNomDlg().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntradaNombreApellido(evt);
            }
        });
        visPer.getTxt2doNomDLG().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntradaNombreApellido(evt);
            }
        });
        visPer.getTxt1erApeDLG().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntradaNombreApellido(evt);
            }
        });
        visPer.getTxt2doApeDLG().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntradaNombreApellido(evt);
            }
        });
        visPer.getTxtDirecDLG().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntradaDireccion(evt);
            }
        });
        visPer.getTxtTelfDLG().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntradaTelefono(evt);
            }
        });
    }

    public void IniciarDialogPersona(String titulo) throws SQLException {

        visPer.dlgPersona.setVisible(true);
        visPer.dlgPersona.setTitle(titulo);
        visPer.dlgPersona.setSize(1020, 568);

        if (visPer.dlgPersona.getTitle().equals("Registrar")) {
            CargarID();
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
        VistaEntrenador.dialogRegistrarModificar.setSize(1025, 500);

        if (VistaEntrenador.dialogRegistrarModificar.getTitle().equals("Registrar Entrenador")) {

            VistaEntrenador.txtCedula.setText(visPer.txtCedulaDLG.getText());
            List<Clase_Persona> jug = modPersona.ListaPersona();
            jug.stream().forEach(p -> {

                if (p.getCedula().equals(VistaEntrenador.txtCedula.getText())) {

                    ImageIcon miImagen = new ImageIcon(visPer.getTxtRuta().getText());
                    Image foto = miImagen.getImage();
                    foto = foto.getScaledInstance(145, 145, Image.SCALE_SMOOTH);
                    visEnt.lblFoto.setIcon(new ImageIcon(foto));
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

        JFileChooser file = new JFileChooser();
        file.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG, & GIF", "jpg", "png", "gif");
        file.setFileFilter(filtrado);
        file.setDialogTitle("Abrir Archivo");

        File Ruta = new File("C:\\Users\\blink\\Pictures");
        file.setCurrentDirectory(Ruta);

        int res = file.showOpenDialog(visPer);
        if (res == JFileChooser.APPROVE_OPTION) {

            File archivo = file.getSelectedFile();
            visPer.getTxtRuta().setText(String.valueOf(archivo));
            ImageIcon miImagen = new ImageIcon(visPer.getTxtRuta().getText());
            Image foto = miImagen.getImage();
            foto = foto.getScaledInstance(visPer.getLblFoto().getWidth(), visPer.getLblFoto().getHeight(), Image.SCALE_SMOOTH);
            visPer.getLblFoto().setIcon(new ImageIcon(foto));
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

                if (validarCedula() == false) {

                    MensajeError("CEDULA INCORRECTA");

                } else {

                    if (validacionCorreo() == false) {

                        MensajeError("FORMATO DE CORREO ELECTRONICO INCORRECTO");

                    } else {

                        if (edad() == false) {

                            MensajeError("LA PERSONA DEBE TENER 18 AÑOS O MAS");

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
                            modPersona.setFoto(visPer.getTxtRuta().getText());

                            try {

                                if (modPersona.InsertarPersona()) {

                                    IniciarDialogEntrenador("Registrar Entrenador");
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
                    }
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
            modPersona.setFoto(visPer.getTxtRuta().getText());

            try {

                if (modPersona.ActualizarPersona()) {

                    IniciarDialogEntrenador("Editar");
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

    private void CargarID() throws SQLException {
        VistaEntrenador.txtCodigo.setText(String.valueOf(modEnt.CargarCodigoID()));
    }

    public void RegistrarEditarEntrenador() {

        if (visEnt.dialogRegistrarModificar.getTitle().equals("Registrar Entrenador")) {

            if (VistaEntrenador.txtCodigo.getText().isEmpty() || VistaEntrenador.txtCedula.getText().isEmpty()
                    || VistaEntrenador.txtAñosExperiencia.getText().isEmpty() || VistaEntrenador.getTxtSueldo().getText().isEmpty() || VistaEntrenador.txtEquipo.getText().isEmpty()) {

                MensajeError("Faltan campos por llenar");
            } else {

                modEnt.setAniosexp(Integer.valueOf(VistaEntrenador.txtAñosExperiencia.getText()));
                modEnt.setCodigo_equipofk(VistaEntrenador.txtEquipo.getText());
                modEnt.setCedula_personafk(VistaEntrenador.txtCedula.getText());
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

            if (VistaEntrenador.tblEntrenador.getSelectedRow() == -1) {

                MensajeError("Seleccione al entrenador que desea modificar");
            } else {

                modEnt.setAniosexp(Integer.valueOf(VistaEntrenador.txtAñosExperiencia.getText()));
                modEnt.setCodigo_equipofk(VistaEntrenador.txtEquipo.getText());
                modEnt.setCodigo(Integer.valueOf(VistaEntrenador.txtCodigo.getText()));
                modEnt.setSueldo(Double.valueOf(VistaEntrenador.txtSueldo.getText()));
                modEnt.setCodigo(VistaEntrenador.tblEntrenador.getValueAt(VistaEntrenador.tblEntrenador.getSelectedRow(), 0).hashCode());

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

    public void EliminarEntrenador() {

        if (VistaEntrenador.tblEntrenador.getSelectedRow() == -1) {

            MensajeError("Seleccione al entrenador que desea eliminar");
        } else {

            int x = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta informacion?", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (x == 0) {

                modEnt.setCodigo(VistaEntrenador.tblEntrenador.getValueAt(VistaEntrenador.tblEntrenador.getSelectedRow(), 0).hashCode());

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

        String ced = VistaEntrenador.tblEntrenador.getValueAt(VistaEntrenador.tblEntrenador.getSelectedRow(), 1).toString();

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
            }
        });
    }

    public void LlenarDatosEntrenador() {

        try {
            String ced = VistaEntrenador.tblEntrenador.getValueAt(VistaEntrenador.tblEntrenador.getSelectedRow(), 1).toString();

            List<Clase_Entrenador> jug = modEnt.ListaEntrenador();
            jug.stream().forEach(p -> {

                if (p.getCedula_personafk().equals(ced)) {

                    VistaEntrenador.txtAñosExperiencia.setText(String.valueOf(p.getAniosexp()));
                    VistaEntrenador.txtCedula.setText(String.valueOf(p.getCedula()));
                    VistaEntrenador.txtEquipo.setText(p.getCodigo_equipofk());
                    VistaEntrenador.txtCodigo.setText(String.valueOf(p.getCodigo()));
                    VistaEntrenador.txtSueldo.setText(String.valueOf(p.getSueldo()));

                    ImageIcon miImagen = new ImageIcon(visEnt.getTxt_Ruta_Foto().getText());
                    Image foto = miImagen.getImage();
                    foto = foto.getScaledInstance(145, 145, Image.SCALE_SMOOTH);
                    visEnt.lblFoto.setIcon(new ImageIcon(foto));

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

        DefaultTableModel tabla = (DefaultTableModel) VistaEntrenador.tblEntrenador.getModel();
        tabla.setNumRows(0);

        List<Clase_Entrenador> jug = modEnt.ListaEntrenador();
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCodigo(), p.getCedula_personafk(), p.getNombnre1(), p.getApellido1(), p.getNombreEquipo(), p.getSueldo()};
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
        if (VistaEntrenador.getTxtBuscar().getText().equals("")) {
            MostrarDatos();
        } else {

            DefaultTableModel tabla = (DefaultTableModel) VistaEntrenador.tblEntrenador.getModel();
            tabla.setNumRows(0);

            List<Clase_Entrenador> jug = modEnt.BuscarEntrenador(VistaEntrenador.getTxtBuscar().getText());
            jug.stream().forEach(p -> {

                Object datos[] = {p.getCodigo(), p.getCedula_personafk(), p.getNombnre1(), p.getApellido1(), p.getNombreEquipo(), p.getSueldo()};
                tabla.addRow(datos);
            });
        }
    }

    public void MensajeSucces(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
    }

    public void MensajeError(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public boolean validacionCorreo() {
        boolean x = false;

        if (visPer.txtCorreoDlg.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") && visPer.txtCorreoDlg.getText().trim().length() < 100) {

            x = true;

        } else {
            JOptionPane.showMessageDialog(null, "Correo Electronico Incorrecto");
        }
        return x;
    }

    public boolean validarCedula() {
        String cedula = visPer.txtCedulaDLG.getText();
        if (cedula.length() != 10) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(cedula.charAt(i));
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }

        int lastDigit = Character.getNumericValue(cedula.charAt(9));
        int calculatedDigit = (10 - (sum % 10)) % 10;

        return lastDigit == calculatedDigit;
    }

    private void validarEntradaCedula(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean numeros = dato >= 48 && dato <= 57;
        boolean backspace = dato == 8;

        if (!(backspace || numeros)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar NUMEROS");
        }
        if (visPer.getTxtCedulaDLG().getText().trim().length() > 9) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (10) digitos");
        }
    }

    private void validarEntradaTelefono(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean numeros = dato >= 48 && dato <= 57;
        boolean backspace = dato == 8;

        if (!(backspace || numeros)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar NUMEROS");
        }
        if (visPer.getTxtTelfDLG().getText().trim().length() > 14) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (10) digitos");
        }
    }

    private void validarEntradaNombreApellido(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean mayusculas = dato >= 65 && dato <= 90;
        boolean minusculas = dato >= 97 && dato <= 122;
        boolean tildesMinusculas = dato >= 160 && dato <= 163;
        boolean tildeE = dato == 130;
        boolean ñ = dato == 164;
        boolean Ñ = dato == 165;
        boolean ETILDE = dato == 144;
        boolean ATILDE = dato == 181;
        boolean ITILDE = dato == 214;
        boolean OTILDE = dato == 224;
        boolean UTILDE = dato == 233;

        boolean backspace = dato == 8;

        if (!(mayusculas || backspace || ETILDE || ATILDE || ITILDE || OTILDE || UTILDE || Ñ || minusculas || ñ || Ñ)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar LETRAS");
        }
        if (visPer.getTxt1erNomDlg().getText().trim().length() > 49) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (50) digitos");
        }
        if (visPer.getTxt2doNomDLG().getText().trim().length() > 49) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (50) digitos");
        }
        if (visPer.getTxt1erApeDLG().getText().trim().length() > 49) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (50) digitos");
        }
        if (visPer.getTxt2doApeDLG().getText().trim().length() > 49) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (50) digitos");
        }
    }

    private void validarEntradaDireccion(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean mayusculas = dato >= 65 && dato <= 90;
        boolean minusculas = dato >= 97 && dato <= 122;
        boolean tildesMinusculas = dato >= 160 && dato <= 163;
        boolean tildeE = dato == 130;
        boolean ñ = dato == 164;
        boolean Ñ = dato == 165;
        boolean ETILDE = dato == 144;
        boolean ATILDE = dato == 181;
        boolean ITILDE = dato == 214;
        boolean OTILDE = dato == 224;
        boolean UTILDE = dato == 233;
        boolean punto = dato == 46;
        boolean guion = dato == 45;
        boolean backspace = dato == 8;

        if (!(mayusculas || backspace || ETILDE || ATILDE || ITILDE || OTILDE || UTILDE || Ñ || minusculas || ñ || Ñ || punto || guion)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Digito INCORRECTO");
        }
        if (visPer.getTxtDirecDLG().getText().trim().length() > 149) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (50) digitos");
        }
    }
/////////////////////////////ARBITRO/////////////////////////////////////////////////

    private void validarEntradaAnios(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean numeros = dato >= 48 && dato <= 57;
        boolean backspace = dato == 8;

        if (!(backspace || numeros)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar NUMEROS");
        }
        if (visEnt.getTxtAñosExperiencia().getText().trim().length() > 1) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (2) digitos");
        }
    }

    private void validarSueldo(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean numeros = dato >= 48 && dato <= 57;
        boolean coma = dato == 44;
        boolean backspace = dato == 8;

        if (!(backspace || numeros || coma)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "FPRMATO INCORRECTO");
        }
    }
//////////////////////////////////////////////////VALIDAR EDAD//////////////////////////////////////

    public boolean edad() {

        Calendar fechaseleccionada = visPer.txtFechaDlg.getCalendar();
        int dia = fechaseleccionada.get(Calendar.DAY_OF_WEEK);
        int mes = fechaseleccionada.get(Calendar.MONTH);
        int año = fechaseleccionada.get(Calendar.YEAR);

        LocalDate fechaDeNacimiento = LocalDate.of(año, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period edad = Period.between(fechaDeNacimiento, fechaActual);

        int edadstr = edad.getYears();

        return edadstr >= 18;

    }

}
