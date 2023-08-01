/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Clase_Equipo;
import Modelo.Clase_Persona;
import Modelo.ModeloEquipos;
import Modelo.ModeloLoggin;
import Modelo.Modelo_Arbitro;
import Modelo.Modelo_Entrenador;
import Modelo.Modelo_Jugador;
import Modelo.Modelo_Persona;
import Vista.LogIn;
import Vista.MenuPrincipal;
import Vista.VistaEntrenador;
import Vista.VistaJugadores;
import Vista.Vista_Arbitro;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author blink
 */
public class ControladorLoggin {

    private Vista.LogIn visPer;
    private Vista.VistaJugadores visJugador;
    private Vista.Vista_Arbitro visArbitro;
    private Vista.VistaEntrenador visEntrenador;
    private Modelo.Modelo_Persona modPersona;
    private Modelo.Modelo_Jugador modJugador;
    private Modelo.Modelo_Entrenador modEnt;
    private Modelo.Modelo_Arbitro modArb;
    private Modelo.ModeloEquipos modEquipo;
    private Modelo.ModeloLoggin modlog;

    public ControladorLoggin() {
    }

    public ControladorLoggin(LogIn visPer, VistaJugadores visJugador, Vista_Arbitro visArbitro, VistaEntrenador visEntrenador, Modelo_Persona modPersona, Modelo_Jugador modJugador, Modelo_Entrenador modEnt, Modelo_Arbitro modArb, ModeloEquipos modEquipo, ModeloLoggin modlog) {
        this.visPer = visPer;
        this.visJugador = visJugador;
        this.visArbitro = visArbitro;
        this.visEntrenador = visEntrenador;
        this.modPersona = modPersona;
        this.modJugador = modJugador;
        this.modEnt = modEnt;
        this.modArb = modArb;
        this.modEquipo = modEquipo;
        this.modlog = modlog;
        visPer.setVisible(true);
    }

    public void InicarLoggin() {

        MostrarEquipos();
        visJugador.getTxtRuta().setVisible(false);
        visJugador.getTxtCod().setVisible(false);
        visJugador.getTxtCedula().setEditable(false);
        visJugador.getTxtEquipo().setEditable(false);
        visEntrenador.getTxtCedula().setEditable(false);
        visPer.getBtnIngresar().addActionListener(l -> IniciarSesion());
        visPer.getBtnCrearCuenta().addActionListener(l -> EscogerTipoUsuario());
        visPer.getBtnCrearCuenta().addActionListener(l -> LimpiarDatos());
        visPer.getBtnFoto().addActionListener(l -> Foto());
        visPer.getBtnCancelarCombo().addActionListener(l -> visPer.getDlgCombo().dispose());
        visPer.btnRetrocederDlgRegistro.addActionListener(l -> {
            visPer.dlgPersona.dispose();
            LimpiarDatos();
        });
        visJugador.btnCancelar.addActionListener(l -> visJugador.dialogRegistrarModificar.dispose());
        visEntrenador.btnCancelar.addActionListener(l -> visEntrenador.dialogRegistrarModificar.dispose());
        visArbitro.btnCancelar.addActionListener(l -> Vista_Arbitro.dialogRegistrarModificar.dispose());
        visJugador.btnRegistrarModificar.addActionListener(l -> RegistrarPersona());
        visEntrenador.btnRegistrarModificar.addActionListener(l -> RegistrarPersona());
        visArbitro.btnRegistrarModificar.addActionListener(l -> RegistrarPersona());
        visJugador.getTblEquipo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                visJugador.getTxtEquipo().setText(visJugador.getTblEquipo().getValueAt(visJugador.getTblEquipo().getSelectedRow(), 0).toString());
            }
        });
        visEntrenador.getTblEquipo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                visEntrenador.getTxtEquipo().setText(visEntrenador.getTblEquipo().getValueAt(visEntrenador.getTblEquipo().getSelectedRow(), 0).toString());
            }
        });
        try {
            visJugador.getTxtCod().setText(String.valueOf(modJugador.CargarCodigo()));
            visEntrenador.getTxtCodigo().setText(String.valueOf(modEnt.CargarCodigoID()));
            visArbitro.getTxtCodigo().setText(String.valueOf(modArb.CargarCodigoID()));
        } catch (SQLException ex) {
            Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void IniciarDialogPersona(String titulo) {

        visPer.getDlgPersona().setVisible(true);
        visPer.getDlgPersona().setTitle(titulo);
        visPer.getDlgPersona().setSize(1020, 568);
        visPer.getDlgPersona().setLocationRelativeTo(null);
        visPer.getBtnSiguienteDlgUsu().addActionListener(l -> {

            if (visPer.getDlgPersona().getTitle().equals("Jugador")) {

                IniciarDialogJugador("Registrar Jugador");
            } else if (visPer.getDlgPersona().getTitle().equals("Entrenador")) {

                IniciarDialogEntrenador("Registrar Entrenador");
            } else if (visPer.getDlgPersona().getTitle().equals("Arbitro")) {

                IniciarDialogArbitro("Registrar Arbitro");
            }

        });
    }

    public void IniciarSesion() {

        if (visPer.getTxtUsuario().getText().isEmpty() || visPer.getTxtPassword().getText().isEmpty()) {

            MensajeError("Ingrese sus datos por favor");
        } else {

            if (modlog.IniciarSesion(visPer.getTxtUsuario().getText(), visPer.getTxtPassword().getText())) {

                Vista.MenuPrincipal log = new MenuPrincipal();

                Controlador_MP ctr = new Controlador_MP(log);

                ctr.iniciaControl();
            } else {
                
                MensajeError("El usuario no se encuentra registrado");
            }
        }

    }

    public void EscogerTipoUsuario() {

        visPer.getDlgCombo().setVisible(true);
        visPer.getDlgCombo().setTitle("Escoger tipo de usuario");
        visPer.getDlgCombo().setSize(469, 250);
        visPer.getDlgCombo().setLocationRelativeTo(null);
        visPer.getBtnSiguienteCombo().addActionListener(l -> {
            if (visPer.getCbxRegistrarComo().getSelectedIndex() == 0) {

                MensajeError("Seleccione como se quiere registrar");
            } else {

                String x = visPer.getCbxRegistrarComo().getSelectedItem().toString();
                IniciarDialogPersona(x);
                visPer.getLblTitulo().setText("Registrar " + x);
                visPer.getDlgCombo().dispose();
            }
        });

    }

    public void IniciarDialogJugador(String titulo) {

        visPer.dlgPersona.dispose();
        visJugador.dialogRegistrarModificar.setVisible(true);
        visJugador.dialogRegistrarModificar.setTitle(titulo);
        visJugador.dialogRegistrarModificar.setSize(850, 676);
        visJugador.dialogRegistrarModificar.setLocationRelativeTo(null);
        if (visJugador.dialogRegistrarModificar.getTitle().equals("Registrar Jugador")) {
            visJugador.lblReMoJugadores.setText("Registrar Jugador");
            visJugador.txtCedula.setText(visPer.getTxtCedulaDLG().getText());
        }
    }

    public void IniciarDialogEntrenador(String titulo) {

        visPer.dlgPersona.dispose();
        VistaEntrenador.dialogRegistrarModificar.setVisible(true);
        VistaEntrenador.dialogRegistrarModificar.setTitle(titulo);
        VistaEntrenador.dialogRegistrarModificar.setSize(1025, 500);
        visEntrenador.dialogRegistrarModificar.setLocationRelativeTo(null);
        if (VistaEntrenador.dialogRegistrarModificar.getTitle().equals("Registrar Entrenador")) {
            visEntrenador.txtCedula.setText(visPer.getTxtCedulaDLG().getText());
        }
    }

    public void IniciarDialogArbitro(String titulo) {

        visPer.dlgPersona.dispose();
        visArbitro.dialogRegistrarModificar.setVisible(true);
        visArbitro.dialogRegistrarModificar.setTitle(titulo);
        visArbitro.dialogRegistrarModificar.setSize(500, 500);
        visArbitro.dialogRegistrarModificar.setLocationRelativeTo(null);
        if (visArbitro.dialogRegistrarModificar.getTitle().equals("Registrar Arbitro")) {
            visArbitro.txtCedula.setText(visPer.getTxtCedulaDLG().getText());
        }
    }

    public void RegistrarPersona() {

        if (visPer.txtCedulaDLG.getText().isEmpty() || visPer.txt1erApeDLG.getText().isEmpty() || visPer.txt1erNomDlg.getText().isEmpty()
                || visPer.txt2doApeDLG.getText().isEmpty() || visPer.txt2doNomDLG.getText().isEmpty() || visPer.txtCorreoDlg.getText().isEmpty()
                || visPer.txtDirecDLG.getText().isEmpty() || visPer.txtFechaDlg.getDate() == null || visPer.txtTelfDLG.getText().isEmpty()
                || Sexo().equals("") || visPer.lblFoto.getIcon() == null || visPer.getTxtRuta().getText().isEmpty()) {

            MensajeError("Faltan campos por llenar");

        } else {

            try {
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

                if (modPersona.InsertarPersona()) {

                    //RegistrarEditarJugador();
                    if (visPer.getDlgPersona().getTitle().equals("Jugador")) {

                        RegistrarJugador();

                    } else if (visPer.getDlgPersona().getTitle().equals("Entrenador")) {

                        RegistrarEntrenador();

                    } else if (visPer.getDlgPersona().getTitle().equals("Arbitro")) {

                        RegistrarArbitro();
                    }

                } else {

                    MensajeError("Ha ocurrido un error al registrar en la base a la persona");
                }

            } catch (org.postgresql.util.PSQLException e) {

                MensajeError("La cedula ya se encuentra registrada 1");

            } catch (SQLException ex) {

                Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
                MensajeError(ex.getMessage());

            } catch (java.lang.NullPointerException e) {

                MensajeError("Ingrese una fecha correcta");
            }
        }
    }

    public void RegistrarJugador() {

        if (visJugador.txtAñosExperiencia.getText().isEmpty() || visJugador.txtCedula.getText().isEmpty() || visJugador.txtEquipo.getText().isEmpty()
                || VistaJugadores.txtSueldo.getText().isEmpty() || VistaJugadores.dateFechaFin.getDate() == null || visJugador.dateFechaInicio.getDate() == null
                || visJugador.cbxPosicion.getSelectedIndex() == 0) {

            MensajeError("Faltan campos por llenar");
        } else {

            if (VistaJugadores.txtEquipo.getText().isEmpty()) {

                MensajeError("Seleccione un equipo");
            } else {

                try {
                    modJugador.setAnios_exp(Integer.valueOf(visJugador.txtAñosExperiencia.getText()));
                    modJugador.setPosicion(visJugador.cbxPosicion.getSelectedItem().toString());
                    modJugador.setCedula_persona(visJugador.txtCedula.getText());
                    modJugador.setCod_jugador(Integer.valueOf(visJugador.getTxtCod().getText()));
                    modJugador.setCod_equipo(Integer.valueOf(visJugador.txtEquipo.getText()));
                    modJugador.setSueldo(Double.valueOf(visJugador.txtSueldo.getText()));
                    modJugador.setFecha_finContrato(new java.sql.Date(visJugador.dateFechaFin.getDate().getTime()));
                    modJugador.setFecha_inicioContrato(new java.sql.Date(visJugador.dateFechaInicio.getDate().getTime()));

                    if (modJugador.ValidarNumJugadorEquipo() <= 12) {

                        if (modJugador.InsertarJugador()) {

                            MensajeSucces("Se ha registrado con exito ");
                            visJugador.dialogRegistrarModificar.dispose();
                        } else {

                            MensajeError("No se ha podido registrar debido a un error en la base de datos");
                        }

                    } else {

                        MensajeError("El equipo no puede tener mas de 12 jugadores");
                    }

                } catch (java.lang.NullPointerException e) {

                    MensajeError("Ingrese una fecha correcta");
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public void RegistrarEntrenador() {

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
                VistaEntrenador.dialogRegistrarModificar.dispose();

            } else {

                MensajeError("No se ha podido registrar debido a un error en la base de datos");
            }
        }

    }

    public void RegistrarArbitro() {
        if (visArbitro.txtCedula.getText().isEmpty()
                || visArbitro.txtAñosExperiencia.getText().isEmpty() || visArbitro.getTxtSueldo().getText().isEmpty() || visArbitro.cbxPosicion.getSelectedIndex() == 0) {

            MensajeError("Faltan campos por llenar");
        } else {

            modArb.setAnios_esperiencia_arbitro(Integer.valueOf(visArbitro.txtAñosExperiencia.getText()));
            modArb.setPosicion_arbitro(visArbitro.cbxPosicion.getSelectedItem().toString());
            modArb.setCedula_persona_arbitro(visArbitro.txtCedula.getText());
            modArb.setSalario_arbitro(Double.valueOf(visArbitro.txtSueldo.getText()));

            if (modArb.InsertarArbitro()) {

                MensajeSucces("Se ha registrado con exito");
                visArbitro.dialogRegistrarModificar.dispose();
            } else {

                MensajeError("No se ha podido registrar debido a un error en la base de datos");
            }
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
            visJugador.lblFoto.setIcon(new ImageIcon(foto));
            visEntrenador.lblFoto.setIcon(new ImageIcon(foto));
            visArbitro.lblFoto.setIcon(new ImageIcon(foto));
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
        visPer.getCbxRegistrarComo().setSelectedIndex(0);

        visJugador.getTxtAñosExperiencia().setText("");
        //visJugador.getTxtCedula().setText("");
        visJugador.getTxtEquipo().setText("");
        visJugador.getTxtSueldo().setText("");
        visJugador.getDateFechaFin().setDate(null);
        visJugador.getDateFechaInicio().setDate(null);
        visJugador.getCbxPosicion().setSelectedIndex(0);
        visJugador.getLblFoto().setIcon(null);
        visJugador.getTblJugadores().clearSelection();
        visJugador.getTblEquipo().clearSelection();

        try {
            visJugador.getTxtCod().setText(String.valueOf(modJugador.CargarCodigo()));
        } catch (SQLException ex) {
            Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }

        VistaEntrenador.txtAñosExperiencia.setText("");
        VistaEntrenador.txtCedula.setText("");
        VistaEntrenador.txtSueldo.setText("");
        VistaEntrenador.txtEquipo.setText("");
        VistaEntrenador.lblFoto.setIcon(null);
        VistaEntrenador.tblEntrenador.clearSelection();
        VistaEntrenador.tblEquipo.clearSelection();

        Vista_Arbitro.txtAñosExperiencia.setText("");
        Vista_Arbitro.txtCedula.setText("");
        Vista_Arbitro.txtSueldo.setText("");
        Vista_Arbitro.cbxPosicion.setSelectedIndex(0);
        Vista_Arbitro.lblFoto.setIcon(null);
        Vista_Arbitro.tblArbitros.clearSelection();

    }

    ///// Metodos para las tablas con claves foraneas 
    public void MostrarEquipos() {

        DefaultTableModel tabla = (DefaultTableModel) visJugador.getTblEquipo().getModel();
        DefaultTableModel tabla2 = (DefaultTableModel) visEntrenador.getTblEquipo().getModel();
        tabla.setNumRows(0);
        tabla2.setNumRows(0);

        List<Clase_Equipo> jug = modEquipo.listarEquipos();
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCod_equipo(), p.getNombre_equi(), p.getCiudad()};
            tabla.addRow(datos);
            tabla2.addRow(datos);
        });

    }

    public void MensajeSucces(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
    }

    public void MensajeError(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
