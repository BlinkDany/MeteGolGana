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
        visArbi.getBtnAgregar().addActionListener(l -> IniciarDialogPersona("Registrar"));
        visArbi.getBtnCancelar().addActionListener(l -> {
            visArbi.dialogRegistrarModificar.dispose();
            visArbi.getTblArbitros().setEnabled(true);
            visPer.txtCedulaDLG.setEnabled(true);

        });
        visPer.btnRetrocederDlgRegistro.addActionListener(l -> {
            visPer.dlgPersona.dispose();
            visArbi.getTblArbitros().setEnabled(true);
            visPer.txtCedulaDLG.setEnabled(true);
        });
        visArbi.getBtnModificar().addActionListener(l -> {
            if (visArbi.getTblArbitros().getSelectedRow() == -1) {

                MensajeError("Seleccione al Arbitro que desea editar");

            } else {

                IniciarDialogPersona("Editar");
                visPer.txtCedulaDLG.setEnabled(false);
                visArbi.getTblArbitros().setEnabled(false);

            }
        });
        visPer.btnSiguienteDlgUsu.addActionListener(l -> RegistrarEditarPersona());
        visArbi.getBtnRegistrarModificar().addActionListener(l -> RegistrarEditarArbitro());
        visPer.btnFoto.addActionListener(l -> Foto());
        visArbi.getBtnEliminar().addActionListener(l -> EliminarArbitro());
        visArbi.getTxtBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                buscarArbitros();

            }
        });
        //////////////////////////////////////////VALIDACIONES////////////////////////////////////////////////
        visArbi.getTxtAñosExperiencia().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntradaAnios(evt);
            }
        });
        visArbi.getTxtSueldo().addKeyListener(new java.awt.event.KeyAdapter() {
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
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void IniciarDialogPersona(String titulo) {

        visPer.dlgPersona.setVisible(true);
        visPer.dlgPersona.setTitle(titulo);
        visPer.dlgPersona.setSize(1020, 568);

        if (visPer.dlgPersona.getTitle().equals("Registrar")) {

            visArbi.getBtnRegistrarModificar().setText("Registrar");
            LimpiarDatos();
        } else {

            LlenarDatosPersona();
            visArbi.getBtnRegistrarModificar().setText("Aceptar");

        }

    }

    public void IniciarDialogArbitro(String titulo) {

        visPer.dlgPersona.dispose();
        Vista_Arbitro.dialogRegistrarModificar.setVisible(true);
        Vista_Arbitro.dialogRegistrarModificar.setTitle(titulo);
        Vista_Arbitro.dialogRegistrarModificar.setSize(500, 500);

        if (Vista_Arbitro.dialogRegistrarModificar.getTitle().equals("Registrar Arbitro")) {

            visArbi.getTxtCedula().setText(visPer.txtCedulaDLG.getText());
            List<Clase_Persona> jug = modPersona.ListaPersona();
            jug.stream().forEach(p -> {

                if (p.getCedula().equals(visArbi.getTxtCedula().getText())) {

                    ImageIcon miImagen = new ImageIcon(visPer.getTxtRuta().getText());
                    Image foto = miImagen.getImage();
                    foto = foto.getScaledInstance(145, 145, Image.SCALE_SMOOTH);
                    visArbi.getLblFoto().setIcon(new ImageIcon(foto));
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

    public void RegistrarEditarArbitro() {

        if (visArbi.dialogRegistrarModificar.getTitle().equals("Registrar Arbitro")) {

            if (visArbi.getTxtCedula().getText().isEmpty()
                    || visArbi.getTxtAñosExperiencia().getText().isEmpty() || visArbi.getTxtSueldo().getText().isEmpty() || visArbi.getCbxPosicion().getSelectedIndex() == 0) {

                MensajeError("Faltan campos por llenar");
            } else {

                modArbi.setAnios_esperiencia_arbitro(Integer.valueOf(visArbi.getTxtAñosExperiencia().getText()));
                modArbi.setPosicion_arbitro(visArbi.getCbxPosicion().getSelectedItem().toString());
                modArbi.setCedula_persona_arbitro(visArbi.getTxtCedula().getText());
                modArbi.setSalario_arbitro(Double.valueOf(visArbi.getTxtSueldo().getText()));

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

            modArbi.setAnios_esperiencia_arbitro(Integer.valueOf(visArbi.getTxtAñosExperiencia().getText()));
            modArbi.setPosicion_arbitro(visArbi.getCbxPosicion().getSelectedItem().toString());
            modArbi.setSalario_arbitro(Double.valueOf(visArbi.getTxtSueldo().getText()));
            modArbi.setCodigo_arbitro(Integer.valueOf(visArbi.txtCodigo.getText()));

            if (modArbi.ModificarArbitro()) {

                MensajeSucces("Se ha modifcado con exito ");
                MostrarDatos();
                visArbi.dialogRegistrarModificar.dispose();
                visPer.txtCedulaDLG.setEnabled(true);
                visArbi.getTblArbitros().setEnabled(true);

            } else {

                MensajeError("No se ha podido modificar debido a un error en la base de datos");
                MostrarDatos();
            }
        }
    }

    public void EliminarArbitro() {

        if (visArbi.getTblArbitros().getSelectedRow() == -1) {

            MensajeError("Seleccione al Arbitro que desea eliminar");
        } else {

            int x = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta informacion?", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (x == 0) {

                modArbi.setCodigo_arbitro(visArbi.getTblArbitros().getValueAt(visArbi.getTblArbitros().getSelectedRow(), 0).hashCode());

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

        String ced = visArbi.getTblArbitros().getValueAt(visArbi.getTblArbitros().getSelectedRow(), 1).toString();

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

                ImageIcon miImagen = new ImageIcon(visPer.getTxtRuta().getText());
                Image foto = miImagen.getImage();
                foto = foto.getScaledInstance(145, 145, Image.SCALE_SMOOTH);
                visPer.getLblFoto().setIcon(new ImageIcon(foto));

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

    public void LlenarDatosArbitro() {

        try {
            String ced = visArbi.getTblArbitros().getValueAt(visArbi.getTblArbitros().getSelectedRow(), 1).toString();

            List<Clase_Arbitro> jug = modArbi.ListaArbitro();
            jug.stream().forEach(p -> {

                if (p.getCedula_persona_arbitro().equals(ced)) {

                    //Arbitro
                    visArbi.getTxtAñosExperiencia().setText(String.valueOf(p.getAnios_esperiencia_arbitro()));
                    visArbi.getTxtCedula().setText(String.valueOf(p.getCedula_persona_arbitro()));
                    visArbi.getCbxPosicion().setSelectedItem(p.getPosicion_arbitro());
                    visArbi.getTxtSueldo().setText(String.valueOf(p.getSalario_arbitro()));
                    visArbi.txtCodigo.setText(String.valueOf(p.getCodigo_arbitro()));
                    ImageIcon miImagen = new ImageIcon(visArbi.getTxt_Ruta_Foto().getText());
                    Image foto = miImagen.getImage();
                    foto = foto.getScaledInstance(145, 145, Image.SCALE_SMOOTH);
                    visArbi.getLblFoto().setIcon(new ImageIcon(foto));
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

        visArbi.getTxtAñosExperiencia().setText("");
        visArbi.getTxtCedula().setText("");
        visArbi.getTxtSueldo().setText("");
        visArbi.getCbxPosicion().setSelectedIndex(0);
        visArbi.getLblFoto().setIcon(null);

    }

    public void MostrarDatos() {

        DefaultTableModel tabla = (DefaultTableModel) visArbi.getTblArbitros().getModel();
        tabla.setNumRows(0);

        List<Clase_Arbitro> jug = modArbi.ListaArbitro();
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCodigo_arbitro(), p.getCedula_persona_arbitro(), p.getNombnre1(), p.getApellido1(), p.getPosicion_arbitro(), p.getSalario_arbitro()};
            tabla.addRow(datos);
        });
    }

    //------------------------------------------------------- BUSCADOR PRINCIPAL--------------------------------------------------------------------------------------------
    public void buscarArbitros() {
        if (visArbi.getTxtBuscar().getText().equals("")) {
            MostrarDatos();
        } else {
            DefaultTableModel tabla = (DefaultTableModel) visArbi.getTblArbitros().getModel();
            tabla.setNumRows(0);

            List<Clase_Arbitro> par = modArbi.BuscarArbitro(visArbi.getTxtBuscar().getText());
            par.stream().forEach(p -> {

                Object datos[] = {p.getCodigo_arbitro(), p.getCedula_persona_arbitro(), p.getNombnre1(), p.getApellido1(), p.getPosicion_arbitro(), p.getSalario_arbitro()};
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

    //------------------------------------------------------- VALIDAR ENTRADA--------------------------------------------------------------------------------------------
    ///////////////////////////////////////PERSONA////////////////////////////////
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
        if (visArbi.getTxtAñosExperiencia().getText().trim().length() > 1) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (2) digitos");
        }
    }

    private void validarSueldo(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean numeros = dato >= 48 && dato <= 57;
        boolean punto = dato == 46;
        boolean backspace = dato == 8;

        if (!(backspace || numeros || punto)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "FORMATO INCORRECTO");
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

    //-------------------------------------------------------CODIGO --------------------------------------------------------------------------------------------
    private void CargarID() throws SQLException {
        visArbi.getTxtCodigo().setText(String.valueOf(modArbi.CargarCodigoID()));
    }
}
