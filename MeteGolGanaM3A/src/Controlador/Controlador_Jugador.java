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
        visJugador.getTxtEquipo().setEditable(false);
        visJugador.getTxtCedula().setEnabled(false);
        visJugador.getBtnRegresar().addActionListener(l -> {
            visPer.dlgPersona.setVisible(true);
            visJugador.getDialogRegistrarModificar().setVisible(false);
        });
        visJugador.btnAgregar.addActionListener(l -> IniciarDialogPersona("Registrar"));
        visJugador.btnAgregar.addActionListener(l -> LimpiarDatos());
        visJugador.btnRegistrarModificar.addActionListener(l -> RegistrarEditarPersona());
        visPer.btnFoto.addActionListener(l -> Foto());
        visJugador.btnEliminar.addActionListener(l -> EliminarJugador());
        visJugador.btnCancelar.addActionListener(l -> visJugador.getDialogRegistrarModificar().dispose());
        visPer.btnRetrocederDlgRegistro.addActionListener(l -> visPer.dlgPersona.dispose());
        visJugador.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                BuscarJugador();
            }
        });
        visJugador.btnModificar.addActionListener(l -> {
            if (visJugador.getTblJugadores().getSelectedRow() == -1) {
                MensajeError("Seleccione al jugador que desea edita");
            } else {
                IniciarDialogPersona("Editar");
            }
        });
        visJugador.tblEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                visJugador.getTxtEquipo().setText(visJugador.tblEquipo.getValueAt(visJugador.tblEquipo.getSelectedRow(), 0).toString());
            }
        });
        visPer.getTxtCedulaDLG().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int codigo1 = e.getKeyChar();
                boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
                boolean retroceso = codigo1 == 8;
                if (!(numeros1 || retroceso)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Sólo se permiten números para la cedula");
                }
                if (visPer.getTxtCedulaDLG().getText().length() == 10) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "La cedula no debe exceder de los 10 caracteres");
                }
            }
        });

        visPer.getTxt1erNomDlg().addKeyListener(new KeyAdapter() {
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

        visPer.getTxt2doNomDLG().addKeyListener(new KeyAdapter() {
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

        visPer.getTxt1erApeDLG().addKeyListener(new KeyAdapter() {
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

        visPer.getTxt2doApeDLG().addKeyListener(new KeyAdapter() {
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

        visPer.getTxtDirecDLG().addKeyListener(new KeyAdapter() {
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

        visPer.getTxtTelfDLG().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int codigo1 = e.getKeyChar();
                boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
                boolean retroceso = codigo1 == 8;
                if (!(numeros1 || retroceso)) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "Sólo se permiten números");
                }
                if (visPer.getTxtTelfDLG().getText().trim().length() == 15) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "El numero de telefono no debe exceder de los 15 caracteres");
                }
            }
        });

        visJugador.getTxtAñosExperiencia().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int codigo1 = e.getKeyChar();
                boolean numeros1 = codigo1 >= 48 && codigo1 <= 57;
                boolean retroceso = codigo1 == 8;
                if (!(numeros1 || retroceso)) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "Sólo se permiten números");
                }
                if (visJugador.getTxtAñosExperiencia().getText().trim().length() == 2) {
                    e.consume();
                    //JOptionPane.showMessageDialog(null, "El numero de telefono no debe exceder de los 15 caracteres");
                }
            }
        });

        visJugador.getTxtSueldo().addKeyListener(new KeyAdapter() {
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

                /*if (visJugador.getTxtSueldo().getText().trim().length() == 6) {
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
        visJugador.getDialogRegistrarModificar().setVisible(true);
        visJugador.getDialogRegistrarModificar().setTitle(titulo);
        visJugador.getDialogRegistrarModificar().setSize(850, 676);
        visJugador.getDialogRegistrarModificar().setLocationRelativeTo(null);
        if (visJugador.getDialogRegistrarModificar().getTitle().equals("Registrar Jugador")) {
            visJugador.lblReMoJugadores.setText("Registrar Jugador");
            visJugador.getTxtCedula().setText(visPer.getTxtCedulaDLG().getText());
            
        } else {
            visJugador.getLblReMoJugadores().setText("Modificar Jugador");
            LlenarDatosJugador();
        }
    }

    public String Sexo() {

        String x = "";

        if (visPer.getRdbFemeninoDlg().isSelected()) {

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

            if (visPer.getTxtCedulaDLG().getText().isEmpty() || visPer.getTxt1erApeDLG().getText().isEmpty() || visPer.getTxt1erNomDlg().getText().isEmpty()
                    || visPer.getTxt2doApeDLG().getText().isEmpty() || visPer.getTxt2doNomDLG().getText().isEmpty() || visPer.getTxtCorreoDlg().getText().isEmpty()
                    || visPer.getTxtDirecDLG().getText().isEmpty() || visPer.getTxtFechaDlg().getDate() == null || visPer.getTxtTelfDLG().getText().isEmpty()
                    || Sexo().equals("") || visPer.getLblFoto().getIcon() == null || visPer.getTxtRuta().getText().isEmpty()) {

                MensajeError("Faltan campos por llenar");

            } else {

                try {
                    modPersona.setApellido1(visPer.getTxt1erApeDLG().getText());
                    modPersona.setApellido2(visPer.getTxt2doApeDLG().getText());
                    modPersona.setCedula(visPer.getTxtCedulaDLG().getText());
                    modPersona.setDireccion(visPer.getTxtDirecDLG().getText());
                    modPersona.setTelefono(visPer.getTxtTelfDLG().getText());
                    modPersona.setEmail(visPer.getTxtCorreoDlg().getText());
                    modPersona.setFecha_nac(new java.sql.Date(visPer.getTxtFechaDlg().getDate().getTime()));
                    modPersona.setNombnre1(visPer.getTxt1erNomDlg().getText());
                    modPersona.setNombnre2(visPer.getTxt2doNomDLG().getText());
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
                modPersona.setApellido1(visPer.getTxt1erApeDLG().getText());
                modPersona.setApellido2(visPer.getTxt2doApeDLG().getText());
                modPersona.setCedula(visPer.getTxtCedulaDLG().getText());
                modPersona.setDireccion(visPer.getTxtDirecDLG().getText());
                modPersona.setTelefono(visPer.getTxtTelfDLG().getText());
                modPersona.setEmail(visPer.getTxtCorreoDlg().getText());
                modPersona.setFecha_nac(new java.sql.Date(visPer.getTxtFechaDlg().getDate().getTime()));
                modPersona.setNombnre1(visPer.getTxt1erNomDlg().getText());
                modPersona.setNombnre2(visPer.getTxt2doNomDLG().getText());
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

        if (visJugador.getDialogRegistrarModificar().getTitle().equals("Registrar Jugador")) {

            if (visJugador.getTxtAñosExperiencia().getText().isEmpty() || visJugador.getTxtCedula().getText().isEmpty() || visJugador.getTxtEquipo().getText().isEmpty()
                    || VistaJugadores.txtSueldo.getText().isEmpty() || VistaJugadores.dateFechaFin.getDate() == null || visJugador.getDateFechaInicio().getDate() == null
                    || visJugador.getCbxPosicion().getSelectedIndex() == 0) {

                MensajeError("Faltan campos por llenar");
            } else {

                if (VistaJugadores.getTxtEquipo().getText().isEmpty()) {

                    MensajeError("Seleccione un equipo");
                } else {

                    try {
                        modJugador.setAnios_exp(Integer.valueOf(visJugador.getTxtAñosExperiencia().getText()));
                        modJugador.setPosicion(visJugador.getCbxPosicion().getSelectedItem().toString());
                        modJugador.setCedula_persona(visJugador.getTxtCedula().getText());
                        modJugador.setCod_jugador(Integer.valueOf(visJugador.getTxtCod().getText()));
                        modJugador.setCod_equipo(Integer.valueOf(visJugador.getTxtEquipo().getText()));
                        modJugador.setSueldo(Double.valueOf(visJugador.getTxtSueldo().getText()));
                        modJugador.setFecha_finContrato(new java.sql.Date(visJugador.getDateFechaFin().getDate().getTime()));
                        modJugador.setFecha_inicioContrato(new java.sql.Date(visJugador.getDateFechaInicio().getDate().getTime()));

                        if (modJugador.ValidarNumJugadorEquipo() <= 12) {

                            if (modJugador.InsertarJugador()) {

                                MensajeSucces("Se ha registrado con exito ");
                                MostrarDatos();
                                visJugador.getDialogRegistrarModificar().dispose();
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
        } else if (visJugador.getDialogRegistrarModificar().getTitle().equals("Modificar Jugador")) {

            if (VistaJugadores.getTxtEquipo().getText().isEmpty()) {

                MensajeError("Seleccione un equipo");
            } else {

                try {
                    modJugador.setAnios_exp(Integer.valueOf(visJugador.getTxtAñosExperiencia().getText()));
                    modJugador.setPosicion(visJugador.getCbxPosicion().getSelectedItem().toString());
                    modJugador.setCod_equipo(Integer.valueOf(visJugador.getTxtEquipo().getText()));
                    modJugador.setSueldo(Double.valueOf(visJugador.getTxtSueldo().getText()));
                    modJugador.setFecha_finContrato(new java.sql.Date(visJugador.getDateFechaFin().getDate().getTime()));
                    modJugador.setFecha_inicioContrato(new java.sql.Date(visJugador.getDateFechaInicio().getDate().getTime()));
                    modJugador.setCod_jugador(visJugador.getTblJugadores().getValueAt(visJugador.getTblJugadores().getSelectedRow(), 0).hashCode());

                    if (modJugador.ModificarJugador()) {

                        MensajeSucces("Se ha modifcado con exito ");
                        MostrarDatos();
                        visJugador.getDialogRegistrarModificar().dispose();
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

        if (visJugador.getTblJugadores().getSelectedRow() == -1) {

            MensajeError("Seleccione al jugador que desea eliminar");
        } else {

            int x = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta informacion?", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (x == 0) {

                modJugador.setCod_jugador(visJugador.getTblJugadores().getValueAt(visJugador.getTblJugadores().getSelectedRow(), 0).hashCode());

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

        String ced = visJugador.getTblJugadores().getValueAt(visJugador.getTblJugadores().getSelectedRow(), 1).toString();

        List<Clase_Jugador> per = modJugador.ListaJugador();
        per.stream().forEach(p -> {

            if (p.getCedula().equals(ced) && p.getCedula().equals(ced)) {

                //Persona
                visPer.getTxt1erApeDLG().setText(p.getApellido1());
                visPer.getTxt1erNomDlg().setText(p.getNombnre1());
                visPer.getTxt2doApeDLG().setText(p.getApellido2());
                visPer.getTxtCedulaDLG().setText(p.getCedula());
                visPer.getTxtDirecDLG().setText(p.getDireccion());
                visPer.getTxtCorreoDlg().setText(p.getEmail());
                visPer.getTxt2doNomDLG().setText(p.getNombnre2());
                visPer.getTxtTelfDLG().setText(p.getTelefono());
                visPer.getTxtRuta().setText(p.getFoto());
                visPer.getTxtFechaDlg().setDate(p.getFecha_nac());

                ImageIcon miImagen = new ImageIcon(visPer.getTxtRuta().getText());
                Image foto = miImagen.getImage();
                foto = foto.getScaledInstance(145, 145, Image.SCALE_SMOOTH);
                visPer.getLblFoto().setIcon(new ImageIcon(foto));

                if (p.getSexo().equals("Femenino")) {

                    visPer.getRdbFemeninoDlg().setSelected(true);
                }
                if (p.getSexo().equals("Masculino")) {

                    visPer.getRdbMasculinoDlg().setSelected(true);
                }
                if (p.getSexo().equals("Otro")) {

                    visPer.getRdbOtroDlg().setSelected(true);
                }
            }
        });

    }

    public void LlenarDatosJugador() {

        try {
            String ced = visJugador.getTblJugadores().getValueAt(visJugador.getTblJugadores().getSelectedRow(), 1).toString();

            List<Clase_Jugador> jug = modJugador.ListaJugador();
            jug.stream().forEach(p -> {

                if (p.getCedula_persona().equals(ced)) {

                    //Jugador
                    visJugador.getTxtAñosExperiencia().setText(String.valueOf(p.getAnios_exp()));
                    visJugador.getTxtCod().setText(String.valueOf(p.getCod_jugador()));
                    visJugador.getTxtCedula().setText(String.valueOf(p.getCedula()));
                    visJugador.getCbxPosicion().setSelectedItem(p.getPosicion());
                    visJugador.getTxtSueldo().setText(String.valueOf(p.getSueldo()));
                    visJugador.getTxtEquipo().setText(String.valueOf(p.getCod_equipo()));
                    visJugador.getTxtRuta().setText(p.getFoto());
                    visJugador.getDateFechaFin().setDate(p.getFecha_finContrato());
                    visJugador.getDateFechaInicio().setDate(p.getFecha_inicioContrato());

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
        
        visPer.getTxt1erApeDLG().setText("");
        visPer.getTxt1erNomDlg().setText("");
        visPer.getTxt2doApeDLG().setText("");
        visPer.getTxt2doNomDLG().setText("");
        visPer.getTxtCedulaDLG().setText("");
        visPer.getTxtCorreoDlg().setText("");
        visPer.getTxtDirecDLG().setText("");
        visPer.getTxtFechaDlg().setDate(null);
        visPer.getTxtTelfDLG().setText("");
        visPer.getBtnGrupo1().clearSelection();
        visPer.getLblFoto().setIcon(null);

        try {
            visJugador.getTxtCod().setText(String.valueOf(modJugador.CargarCodigo()));
        } catch (SQLException ex) {
            Logger.getLogger(Controlador_Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void MostrarDatos() {

        DefaultTableModel tabla = (DefaultTableModel) visJugador.getTblJugadores().getModel();
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

        DefaultTableModel tabla = (DefaultTableModel) visJugador.getTblJugadores().getModel();
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
