/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Clase_Equipo;
import Modelo.Clase_Jugador;
import Modelo.Clase_Persona;
import Modelo.ModeloEquipos;
import Modelo.Modelo_Jugador;
import Modelo.Modelo_Persona;
import Vista.LogIn;
import Vista.VistaJugadores;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
 * @author blink
 */
public class Controlador_Jugador {

    private Modelo.Modelo_Jugador modJugador;
    private Vista.VistaJugadores visJugador;
    private Modelo.Modelo_Persona modPersona;
    private Modelo.ModeloEquipos modequipo;
    private Vista.LogIn visPer;
    private JFileChooser jfc;
    private Validaciones val;

    public Controlador_Jugador() {
    }

    public Controlador_Jugador(Modelo_Jugador modJugador, VistaJugadores visJugador, Modelo_Persona modPersona, ModeloEquipos modequipo, LogIn visPer) {
        this.modJugador = modJugador;
        this.visJugador = visJugador;
        this.modPersona = modPersona;
        this.modequipo = modequipo;
        this.visPer = visPer;
        this.visJugador.setVisible(true);
    }

    public void InicarControlador() {

        MostrarDatos();
        MostrarEquipos();
        visJugador.setTitle("Jugadores");
        visJugador.btnAgregar.addActionListener(l -> IniciarDialogPersona("Registrar"));
        visPer.btnSiguienteDlgUsu.addActionListener(l -> RegistrarEditarPersona());
        visJugador.btnRegistrarModificar.addActionListener(l -> RegistrarEditarJugador());
        visPer.btnFoto.addActionListener(l -> Foto());
        visJugador.btnEliminar.addActionListener(l -> EliminarJugador());
        visJugador.btnCancelar.addActionListener(l -> visJugador.dialogRegistrarModificar.dispose());
        visPer.btnRetrocederDlgRegistro.addActionListener(l -> visPer.dlgPersona.dispose());
        visJugador.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                BuscarJugador();
            }
        });
        visJugador.btnModificar.addActionListener(l -> {
            if (visJugador.tblJugadores.getSelectedRow() == -1) {

                MensajeError("Seleccione al jugador que desea edita");

            } else {

                IniciarDialogPersona("Editar");
            }
        });
        visJugador.tblEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                visJugador.txtEquipo.setText(visJugador.tblEquipo.getValueAt(visJugador.tblEquipo.getSelectedRow(), 0).toString());
            }
        });
        visPer.txtCedulaDLG.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                int codigo1 = e.getKeyChar();
                boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
                boolean retroceso = codigo1 == 8;

                if (!(numeros1 || retroceso)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Sólo se permiten números para la cedula");
                }

                if (visPer.txtCedulaDLG.getText().length() == 10) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "La cedula no debe exceder de los 10 caracteres");
                }

            }
        });

        visPer.txt1erNomDlg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                char nombre = e.getKeyChar();
                boolean mayusculas = nombre >= 65 && nombre <= 90;
                boolean minusculas = nombre >= 97 && nombre <= 122;
                boolean espacio = nombre == 32;
                boolean reto = nombre == 8;
                boolean especial = nombre == 164;
                boolean especial1 = nombre == 165;

                if (!(mayusculas || minusculas || espacio || reto || especial || especial1)) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "Sólo se permiten letras para este campo");
                }

            }
        });
    }

    public void IniciarDialogPersona(String titulo) {

        visPer.dlgPersona.setVisible(true);
        visPer.dlgPersona.setTitle(titulo);
        visPer.dlgPersona.setSize(1020, 568);
        if (visPer.dlgPersona.getTitle().equals("Registrar")) {

            visJugador.btnRegistrarModificar.setText("Registrar");
            LimpiarDatos();
        } else {

            LlenarDatosPersona();
            visJugador.btnRegistrarModificar.setText("Aceptar");
        }

    }

    public void IniciarDialogJugador(String titulo) {

        visPer.dlgPersona.dispose();
        visJugador.dialogRegistrarModificar.setVisible(true);
        visJugador.dialogRegistrarModificar.setTitle(titulo);
        visJugador.dialogRegistrarModificar.setSize(850, 676);
        if (visJugador.dialogRegistrarModificar.getTitle().equals("Registrar Jugador")) {

            visJugador.txtCedula.setText(visPer.txtCedulaDLG.getText());
            List<Clase_Persona> jug = modPersona.ListaPersona();
            jug.stream().forEach(p -> {

                if (p.getCedula().equals(visJugador.txtCedula.getText())) {

                    Image foto = p.getFoto();
                    if (foto != null) {
                        foto = foto.getScaledInstance(VistaJugadores.lblFoto.getWidth(), VistaJugadores.lblFoto.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        VistaJugadores.lblFoto.setIcon(icono);
                    }
                }
            });
        } else {

            LlenarDatosJugador();
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
                Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    if (modPersona.InsertarPersona()) {

                        IniciarDialogJugador("Registrar Jugador");
                    } else {

                        MensajeError("Ha ocurrido un error al registrar en la base");
                    }

                } catch (org.postgresql.util.PSQLException e) {

                    MensajeError("La cedula ya se encuentra registrada");

                } catch (SQLException ex) {

                    Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
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

                    IniciarDialogJugador("Editar");
                    MostrarDatos();
                } else {

                    MensajeError("Ha ocurrido un error al actualizar en la base");
                    MostrarDatos();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void RegistrarEditarJugador() {

        if (visJugador.dialogRegistrarModificar.getTitle().equals("Registrar Jugador")) {

            if (visJugador.txtAñosExperiencia.getText().isEmpty() || visJugador.txtCedula.getText().isEmpty() || visJugador.txtEquipo.getText().isEmpty()
                    || VistaJugadores.txtSueldo.getText().isEmpty() || VistaJugadores.dateFechaFin.getDate() == null || visJugador.dateFechaInicio.getDate() == null
                    || visJugador.cbxPosicion.getSelectedIndex() == 0) {

                MensajeError("Faltan campos por llenar");
            } else {

                modJugador.setAnios_exp(Integer.valueOf(visJugador.txtAñosExperiencia.getText()));
                modJugador.setPosicion(visJugador.cbxPosicion.getSelectedItem().toString());
                modJugador.setCedula_persona(visJugador.txtCedula.getText());
                modJugador.setCod_equipo(Integer.valueOf(visJugador.txtEquipo.getText()));
                modJugador.setSueldo(Double.valueOf(visJugador.txtSueldo.getText()));
                modJugador.setFecha_finContrato(new java.sql.Date(visJugador.dateFechaFin.getDate().getTime()));
                modJugador.setFecha_inicioContrato(new java.sql.Date(visJugador.dateFechaInicio.getDate().getTime()));

                if (modJugador.InsertarJugador()) {

                    MensajeSucces("Se ha registrado con exito ");
                    MostrarDatos();
                    visJugador.dialogRegistrarModificar.dispose();
                } else {

                    MensajeError("No se ha podido registrar debido a un error en la base de datos");
                    MostrarDatos();
                }
            }
        } else if (visJugador.dialogRegistrarModificar.getTitle().equals("Modificar Jugador")) {

            if (VistaJugadores.tblJugadores.getSelectedRow() == -1) {

                MensajeError("Seleccione al jugador que desea modificar");
            } else {

                modJugador.setAnios_exp(Integer.valueOf(visJugador.txtAñosExperiencia.getText()));
                modJugador.setPosicion(visJugador.cbxPosicion.getSelectedItem().toString());
                modJugador.setCod_equipo(visJugador.tblEquipo.getValueAt(VistaJugadores.tblEquipo.getSelectedRow(), 0).hashCode());
                modJugador.setSueldo(Double.valueOf(visJugador.txtSueldo.getText()));
                modJugador.setFecha_finContrato(new java.sql.Date(visJugador.dateFechaFin.getDate().getTime()));
                modJugador.setFecha_inicioContrato(new java.sql.Date(visJugador.dateFechaInicio.getDate().getTime()));
                modJugador.setCod_jugador(VistaJugadores.tblJugadores.getValueAt(VistaJugadores.tblJugadores.getSelectedRow(), 0).hashCode());

                if (modJugador.ModificarJugador()) {

                    MensajeSucces("Se ha modifcado con exito ");
                    MostrarDatos();
                } else {

                    MensajeError("No se ha podido modificar debido a un error en la base de datos");
                    MostrarDatos();
                }
            }
        }

    }

    public void EliminarJugador() {

        if (VistaJugadores.tblJugadores.getSelectedRow() == -1) {

            MensajeError("Seleccione al jugador que desea eliminar");
        } else {

            int x = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta informacion?", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (x == 0) {

                modJugador.setCod_jugador(VistaJugadores.tblJugadores.getValueAt(VistaJugadores.tblJugadores.getSelectedRow(), 0).hashCode());

                if (modJugador.OcultarJugador()) {

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

        String ced = visJugador.tblJugadores.getValueAt(visJugador.tblJugadores.getSelectedRow(), 1).toString();

        List<Clase_Jugador> per = modJugador.ListaJugador();
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

    public void LlenarDatosJugador() {

        try {
            String ced = visJugador.tblJugadores.getValueAt(visJugador.tblJugadores.getSelectedRow(), 1).toString();

            List<Clase_Jugador> jug = modJugador.ListaJugador();
            jug.stream().forEach(p -> {

                if (p.getCedula_persona().equals(ced)) {

                    //Jugador
                    visJugador.txtAñosExperiencia.setText(String.valueOf(p.getAnios_exp()));
                    visJugador.txtCedula.setText(String.valueOf(p.getCedula()));
                    visJugador.cbxPosicion.setSelectedItem(p.getPosicion());
                    visJugador.txtSueldo.setText(String.valueOf(p.getSueldo()));
                    visJugador.txtEquipo.setText(String.valueOf(p.getCod_equipo()));
                    visJugador.dateFechaFin.setDate(p.getFecha_finContrato());
                    visJugador.dateFechaInicio.setDate(p.getFecha_inicioContrato());

                    Image foto = p.getFoto();
                    if (foto != null) {
                        foto = foto.getScaledInstance(VistaJugadores.lblFoto.getWidth(), VistaJugadores.lblFoto.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        VistaJugadores.lblFoto.setIcon(icono);
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

        visJugador.txtAñosExperiencia.setText("");
        visJugador.txtCedula.setText("");
        visJugador.txtEquipo.setText("");
        visJugador.txtSueldo.setText("");
        visJugador.dateFechaFin.setDate(null);
        visJugador.dateFechaInicio.setDate(null);
        visJugador.cbxPosicion.setSelectedIndex(0);
        visJugador.lblFoto.setIcon(null);

    }

    public void MostrarDatos() {

        DefaultTableModel tabla = (DefaultTableModel) VistaJugadores.tblJugadores.getModel();
        tabla.setNumRows(0);

        List<Clase_Jugador> jug = modJugador.ListaJugador();
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCod_jugador(), p.getCedula_persona(), p.getNombnre1(), p.getApellido1(), p.getCod_equipo(), p.getPosicion(), p.getSueldo()};
            tabla.addRow(datos);
        });
    }

    public void MostrarEquipos() {

        DefaultTableModel tabla = (DefaultTableModel) VistaJugadores.tblEquipo.getModel();
        tabla.setNumRows(0);

        List<Clase_Equipo> jug = modequipo.listarEquipos();
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCod_equipo(), p.getNombre_equi(), p.getCiudad()};
            tabla.addRow(datos);
        });

    }

    public void BuscarJugador() {

        DefaultTableModel tabla = (DefaultTableModel) VistaJugadores.tblJugadores.getModel();
        tabla.setNumRows(0);

        List<Clase_Jugador> jug = modJugador.BuscarJugador(visJugador.txtBuscar.getText());
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCod_jugador(), p.getCedula_persona(), p.getNombnre1(), p.getCod_equipo(), p.getPosicion(), p.getSueldo()};
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
