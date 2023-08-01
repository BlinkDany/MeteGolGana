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
import java.io.File;
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
import javax.swing.filechooser.FileNameExtensionFilter;
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
        visPer.getTxtRuta().setVisible(false);
        //visJugador.getTxtCod().setVisible(false);
        try {
            visJugador.getTxtCod().setText(String.valueOf(modJugador.CargarCodigo()));
        } catch (SQLException ex) {
            Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        visJugador.getTxtRuta().setVisible(false);
        visJugador.setTitle("Jugadores");
        visJugador.txtEquipo.setEditable(false);
        visJugador.txtCedula.setEnabled(false);
        visJugador.getBtnRegresar().addActionListener(l -> {
            visPer.dlgPersona.setVisible(true);
            visJugador.dialogRegistrarModificar.setVisible(false);
        });
        visJugador.btnAgregar.addActionListener(l -> IniciarDialogPersona("Registrar"));
        visJugador.btnAgregar.addActionListener(l -> LimpiarDatos());
        visJugador.btnRegistrarModificar.addActionListener(l -> RegistrarEditarPersona());
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
                    //JOptionPane.showMessageDialog(null, "La cedula no debe exceder de los 10 caracteres");
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

        visPer.txt2doNomDLG.addKeyListener(new KeyAdapter() {
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

        visPer.txt1erApeDLG.addKeyListener(new KeyAdapter() {
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

        visPer.txt2doApeDLG.addKeyListener(new KeyAdapter() {
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

        visPer.txtDirecDLG.addKeyListener(new KeyAdapter() {
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

        visPer.txtTelfDLG.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int codigo1 = e.getKeyChar();
                boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
                boolean retroceso = codigo1 == 8;
                if (!(numeros1 || retroceso)) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "Sólo se permiten números");
                }
                if (visPer.txtTelfDLG.getText().trim().length() == 15) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "El numero de telefono no debe exceder de los 15 caracteres");
                }
            }
        });

        visJugador.txtAñosExperiencia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int codigo1 = e.getKeyChar();
                boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
                boolean retroceso = codigo1 == 8;
                if (!(numeros1 || retroceso)) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "Sólo se permiten números");
                }
                if (visJugador.txtAñosExperiencia.getText().trim().length() == 2) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "El numero de telefono no debe exceder de los 15 caracteres");
                }
            }
        });

        visJugador.txtSueldo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int codigo1 = e.getKeyChar();
                boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
                boolean punto = codigo1 == 46;
                boolean coma = codigo1 == 44;
                boolean retroceso = codigo1 == 8;
                if (!(numeros1 || retroceso || punto || coma)) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "Sólo se permiten números o numeros con decimales");
                }

                /*if (visJugador.txtSueldo.getText().trim().length() == 6) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "El codigo numerico no debe exceder de los 7 caracteres");
                }*/
            }
        });
    }

    public void IniciarDialogPersona(String titulo) {

        visPer.dlgPersona.setVisible(true);
        visPer.dlgPersona.setTitle(titulo);
        visPer.dlgPersona.setSize(1020, 568);
        visPer.dlgPersona.setLocationRelativeTo(null);
        if (visPer.dlgPersona.getTitle().equals("Registrar")) {

            visJugador.btnRegistrarModificar.setText("Registrar");
            visPer.lblTitulo.setText("Registrar Persona");
            visPer.btnSiguienteDlgUsu.addActionListener(l -> IniciarDialogJugador("Registrar Jugador"));
        } else {

            LlenarDatosPersona();
            visPer.btnSiguienteDlgUsu.addActionListener(l -> IniciarDialogJugador("Modificar Jugador"));
            visJugador.btnRegistrarModificar.setText("Aceptar");
            visPer.lblTitulo.setText("Modficar Persona");
        }

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
            
        } else {
            visJugador.getLblReMoJugadores().setText("Modificar Jugador");
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
        }

    }

    public void RegistrarEditarPersona() {

        if (visPer.dlgPersona.getTitle().equals("Registrar")) {

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

                        RegistrarEditarJugador();

                    } else {

                        MensajeError("Ha ocurrido un error al registrar en la base a la persona");
                    }

                } catch (org.postgresql.util.PSQLException e) {

                    MensajeError("La cedula ya se encuentra registrada");

                } catch (SQLException ex) {

                    Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
                    MensajeError(ex.getMessage());

                } catch (java.lang.NullPointerException e) {

                    MensajeError("Ingrese una fecha correcta");
                }
            }
        } else if (visPer.dlgPersona.getTitle().equals("Editar")) {

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

                if (modPersona.ActualizarPersona()) {

                    RegistrarEditarJugador();
                } else {

                    MensajeError("Ha ocurrido un error al actualizar en la base");
                }

            } catch (SQLException ex) {

                Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
                MensajeError(ex.getMessage());

            } catch (java.lang.NullPointerException e) {

                MensajeError("Ingrese una fecha correcta");
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
                                MostrarDatos();
                                visJugador.dialogRegistrarModificar.dispose();
                                LimpiarDatos();
                            } else {

                                MensajeError("No se ha podido registrar debido a un error en la base de datos");
                                MostrarDatos();
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
        } else if (visJugador.dialogRegistrarModificar.getTitle().equals("Modificar Jugador")) {

            if (VistaJugadores.txtEquipo.getText().isEmpty()) {

                MensajeError("Seleccione un equipo");
            } else {

                try {
                    modJugador.setAnios_exp(Integer.valueOf(visJugador.txtAñosExperiencia.getText()));
                    modJugador.setPosicion(visJugador.cbxPosicion.getSelectedItem().toString());
                    modJugador.setCod_equipo(Integer.valueOf(visJugador.txtEquipo.getText()));
                    modJugador.setSueldo(Double.valueOf(visJugador.txtSueldo.getText()));
                    modJugador.setFecha_finContrato(new java.sql.Date(visJugador.dateFechaFin.getDate().getTime()));
                    modJugador.setFecha_inicioContrato(new java.sql.Date(visJugador.dateFechaInicio.getDate().getTime()));
                    modJugador.setCod_jugador(VistaJugadores.tblJugadores.getValueAt(VistaJugadores.tblJugadores.getSelectedRow(), 0).hashCode());

                    if (modJugador.ModificarJugador()) {

                        MensajeSucces("Se ha modifcado con exito ");
                        MostrarDatos();
                        visJugador.dialogRegistrarModificar.dispose();
                    } else {

                        MensajeError("No se ha podido modificar debido a un error en la base de datos");
                        MostrarDatos();
                    }

                } catch (java.lang.NullPointerException e) {

                    MensajeError("Ingrese una fecha correcta");
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
                visPer.getTxtRuta().setText(p.getFoto());
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

    public void LlenarDatosJugador() {

        try {
            String ced = visJugador.tblJugadores.getValueAt(visJugador.tblJugadores.getSelectedRow(), 1).toString();

            List<Clase_Jugador> jug = modJugador.ListaJugador();
            jug.stream().forEach(p -> {

                if (p.getCedula_persona().equals(ced)) {

                    //Jugador
                    visJugador.txtAñosExperiencia.setText(String.valueOf(p.getAnios_exp()));
                    visJugador.getTxtCod().setText(String.valueOf(p.getCod_jugador()));
                    visJugador.txtCedula.setText(String.valueOf(p.getCedula()));
                    visJugador.cbxPosicion.setSelectedItem(p.getPosicion());
                    visJugador.txtSueldo.setText(String.valueOf(p.getSueldo()));
                    visJugador.txtEquipo.setText(String.valueOf(p.getCod_equipo()));
                    visJugador.getTxtRuta().setText(p.getFoto());
                    visJugador.dateFechaFin.setDate(p.getFecha_finContrato());
                    visJugador.dateFechaInicio.setDate(p.getFecha_inicioContrato());

                    ImageIcon miImagen = new ImageIcon(visJugador.getTxtRuta().getText());
                    Image foto = miImagen.getImage();
                    foto = foto.getScaledInstance(145, 145, Image.SCALE_SMOOTH);
                    visJugador.lblFoto.setIcon(new ImageIcon(foto));

                }
            });
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }

    public void LimpiarDatos() {

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

        try {
            visJugador.getTxtCod().setText(String.valueOf(modJugador.CargarCodigo()));
        } catch (SQLException ex) {
            Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void MostrarDatos() {

        DefaultTableModel tabla = (DefaultTableModel) VistaJugadores.tblJugadores.getModel();
        tabla.setNumRows(0);

        List<Clase_Jugador> jug = modJugador.ListaJugador();
        List<Clase_Equipo> equipo = modequipo.listarEquipos();
        jug.stream().forEach(p -> {
            equipo.stream().forEach(l -> {

                if (p.getCod_equipo() == l.getCod_equipo()) {

                    Object datos[] = {p.getCod_jugador(), p.getCedula_persona(), p.getNombnre1(), p.getApellido1(), l.getNombre_equi(), p.getPosicion(), p.getSueldo()};
                    tabla.addRow(datos);
                }
            });
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
        List<Clase_Equipo> equipo = modequipo.listarEquipos();
        jug.stream().forEach(p -> {
            equipo.stream().forEach(l -> {

                if (p.getCod_equipo() == l.getCod_equipo()) {

                    Object datos[] = {p.getCod_jugador(), p.getCedula_persona(), p.getNombnre1(), p.getApellido1(), l.getNombre_equi(), p.getPosicion(), p.getSueldo()};
                    tabla.addRow(datos);
                }
            });
        });
    }

    public void MensajeSucces(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
    }

    public void MensajeError(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
