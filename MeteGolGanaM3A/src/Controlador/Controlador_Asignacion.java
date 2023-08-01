package Controlador;

import Conexion.ConexionMySql;
import Modelo.*;
import Vista.Vista_Asignacion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class Controlador_Asignacion {

    private Modelo_Asignacion modeloAsig;
    private Modelo_Arbitro modeloArb;
    private Modelo_Partido modeloPart;
    private ModeloEquipos modeloEquip;

    private Vista_Asignacion vistaAsig;

    public Controlador_Asignacion(Modelo_Asignacion modeloAsig, Modelo_Arbitro modeloArb, Modelo_Partido modeloPart, Vista_Asignacion vistaAsig) {
        this.modeloAsig = modeloAsig;
        this.modeloArb = modeloArb;
        this.modeloPart = modeloPart;
        this.vistaAsig = vistaAsig;

        vistaAsig.setVisible(true);
        cargaAsignacion();
    }

//-------------------------------------------------------CONTROL--------------------------------------------------------------------------------------------
    public void iniciaControl() {
        vistaAsig.getBtnAgregar().addActionListener(l -> abrirDialogo("Crear"));
        vistaAsig.getBtnAgregar().addActionListener(l -> fechaLocal());
        vistaAsig.btnModificar.addActionListener(l -> {
            if (vistaAsig.tblAsignacion.getSelectedRow() == -1) {

                JOptionPane.showMessageDialog(null, "Seleccione una asignacion", "Error", JOptionPane.ERROR_MESSAGE);

            } else {

                abrirDialogo("Editar");

            }
        });
        vistaAsig.getBtnEliminar().addActionListener(l -> abrirDialogo("Eliminar"));
        vistaAsig.getBtnCancelar().addActionListener(l -> salirdialogo());
        vistaAsig.getBtnCancelar1().addActionListener(l -> salirdialogo1());
        vistaAsig.getBtnRegistrarModificar().addActionListener(l -> crearEditarAsignacion());
        vistaAsig.getBtnArbitro().addActionListener(l -> abrirDialogobusqueda("ARBITRO"));
        vistaAsig.getBtnArbitro().addActionListener(l -> {
            vistaAsig.getTblPartido().setEnabled(false);
            vistaAsig.getTblArbitro().setEnabled(true);
            vistaAsig.getPanelPartido().setVisible(false);
            vistaAsig.getTblArbitro().setVisible(true);
        });
        vistaAsig.getBtnPartido().addActionListener(l -> abrirDialogobusqueda("PARTIDO"));
        vistaAsig.getBtnPartido().addActionListener(l -> {
            vistaAsig.getTblPartido().setEnabled(true);
            vistaAsig.getTblArbitro().setEnabled(false);
            vistaAsig.getPanelPartido().setVisible(true);
            vistaAsig.getTblPartido().setVisible(true);
        });

        vistaAsig.getBtnmandardatos().addActionListener(l -> mandardatos());
        vistaAsig.getBtnBuscar().addActionListener(l -> buscarFK());
        vistaAsig.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar();
            }
        });
        vistaAsig.getTxtBuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntrada(evt);
            }
        });
        vistaAsig.getBtnCancelar1().addActionListener(e -> {
            vistaAsig.getTblPartido().clearSelection();
            vistaAsig.getTblArbitro().clearSelection();
        });
        vistaAsig.getBtnCancelar().addActionListener(e -> {
            vistaAsig.getTblAsignacion().clearSelection();
        });
        vistaAsig.getBtnRegistrarModificar().addActionListener(e -> {
            vistaAsig.getTblAsignacion().clearSelection();
        });
        vistaAsig.getBtnAgregar().addActionListener(l -> {
            try {
                CargarID();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Asignacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    //--------------------------------------------------FECHA------------------------------------------------------------------------//
    public void fechaLocal() {
        vistaAsig.dtfecha.setText(LocalDate.now().toString());
    }

    //-------------------------------------------------VALIDACION FECHA---------------------------------------------//
    public boolean validacionFecha() {
        java.util.Date fechaUtil = null;
        java.util.Date fechaUtilP = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String fechaS = vistaAsig.getDtfecha().getText();
            fechaUtil = formato.parse(fechaS);

            String fechaSP = vistaAsig.getFechaPartido().getText();
            fechaUtilP = formato.parse(fechaSP);

        } catch (ParseException ex) {
            Logger.getLogger(Controlador_Asignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaUtil.after(fechaUtilP);
    }

    public boolean validacionFechaModificar() {
        java.util.Date fechaUtil = null;
        java.util.Date fechaUtilP = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String fechaS = vistaAsig.getFechaPartido().getText();
            fechaUtil = formato.parse(fechaS);

            String fechaSP = LocalDate.now().toString();
            fechaUtilP = formato.parse(fechaSP);

        } catch (ParseException ex) {
            Logger.getLogger(Controlador_Asignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaUtil.before(fechaUtilP);
    }
//-------------------------------------------------------DIALOGO--------------------------------------------------------------------------------------------

    private void abrirDialogo(String ce) {

        vistaAsig.getDialogRegistrarModificar().setSize(515, 450);
        vistaAsig.getDialogRegistrarModificar().setTitle(ce);
        vistaAsig.getDialogRegistrarModificar().setVisible(true);

        if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Crear")) {
            vistaAsig.getLblReMoJugadores().setText("REGISTRO DE ASIGNACION");
            vistaAsig.getBtnRegistrarModificar().setText("REGISTRAR");

        } else if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Editar")) {
            vistaAsig.getLblReMoJugadores().setText("MODIFICAR ASIGNACION");
            LlenarDatos();
            vistaAsig.getBtnRegistrarModificar().setText("MODIFICAR");

        } else if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Eliminar")) {
            LlenarDatos();
            vistaAsig.getBtnRegistrarModificar().setText("ELIMINAR ASIGNACION");
            vistaAsig.getLblReMoJugadores().setText("ELIMINAR");
            vistaAsig.getBtnRegistrarModificar().setText("ELIMINAR");
        }
    }
    //-------------------------------------------------------DIALOGO 2--------------------------------------------------------------------------------------------

    private void abrirDialogobusqueda(String ce) {

        vistaAsig.getDialogtablas().setSize(820, 605);
        vistaAsig.getDialogtablas().setTitle(ce);
        vistaAsig.getDialogtablas().setVisible(true);

        if (vistaAsig.getDialogtablas().getTitle().contentEquals("ARBITRO")) {
            vistaAsig.getLblbusqueda().setText("ARBITROS");
            cargarArbitros();
        } else if (vistaAsig.getDialogtablas().getTitle().contentEquals("PARTIDO")) {
            vistaAsig.getLblbusqueda().setText("PARTIDOS");
            cargarpartido();
        }
    }
    //-------------------------------------------------------CODIGO --------------------------------------------------------------------------------------------

    private void CargarID() throws SQLException {
        vistaAsig.getTxtCodAsignacion().setText(String.valueOf(modeloAsig.CargarCodigoID()));
    }

//-------------------------------------------------------SETEAR DATOS--------------------------------------------------------------------------------------------
    private void mandardatos() {

        String set = vistaAsig.getTxtbuscarcod().getText();

        if (vistaAsig.getDialogtablas().getTitle().contentEquals("ARBITRO")) {

            int selectedRow = vistaAsig.getTblArbitro().getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");

            } else {

                String selectedId = vistaAsig.getTblArbitro().getValueAt(selectedRow, 3).toString();
                String nombre = vistaAsig.getTblArbitro().getValueAt(selectedRow, 1).toString();
                String apellido = vistaAsig.getTblArbitro().getValueAt(selectedRow, 2).toString();

                vistaAsig.getTxtcodArbitro().setText(selectedId);
                vistaAsig.getTxt_nombre_arb().setText(nombre);
                vistaAsig.getTxt_apellido_arb().setText(apellido);

                salirdialogo1();

            }

        } else if (vistaAsig.getDialogtablas().getTitle().contentEquals("PARTIDO")) {

            int selectedRow = vistaAsig.getTblPartido().getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistaAsig.getTblPartido().getValueAt(selectedRow, 3).toString();
                vistaAsig.getTxtcodPartido().setText(selectedId);
                String selectedFecha = vistaAsig.getTblPartido().getValueAt(selectedRow, 2).toString();
                vistaAsig.getFechaPartido().setText(selectedFecha);
                String selectNombre1 = vistaAsig.getTblPartido().getValueAt(selectedRow, 0).toString();
                vistaAsig.getTxt_equipo_1().setText(selectNombre1);
                String selectNombre2 = vistaAsig.getTblPartido().getValueAt(selectedRow, 1).toString();
                vistaAsig.getTxt_equipo_2().setText(selectNombre1);
                salirdialogo1();
            }
        }
    }
    //--------------------------------------------------------CRUD--------------------------------------------------------------------------------------------
    //-------------------------------------------------------AGREGAR--------------------------------------------------------------------------------------------

    private void crearEditarAsignacion() {
        if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Crear")) {

            Modelo_Asignacion model = new Modelo_Asignacion();

            if (vistaAsig.getDtfecha() == null || vistaAsig.getTxtcodArbitro().equals("") || vistaAsig.getTxtcodPartido().equals("")) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {

                if (validacionFecha() == true) {
                    JOptionPane.showMessageDialog(null, "EL PARTIDO YA A SIDO JUGADO");
                } else {

                    try {
                        int codigoArbitro = Integer.valueOf(vistaAsig.getTxtcodArbitro().getText());
                        int CodigoPartido = Integer.valueOf(vistaAsig.getTxtcodPartido().getText());
                        String fechaS = vistaAsig.getDtfecha().getText();

                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date fechaUtil = formato.parse(fechaS);
                        java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

                        boolean estado = false;

                        model.setCodigo_arbitro_asignacion(codigoArbitro);
                        model.setCodigo_partido_asignacion(CodigoPartido);
                        model.setFecha_asignacion(fechaSQL);
                        model.setEstado_asignacion(estado);

                        if (model.InsertarAsignacion()) {
                            limpiar();
                            JOptionPane.showMessageDialog(vistaAsig, "DATOS CREADOS");
                            vistaAsig.getDialogRegistrarModificar().setVisible(false);
                            cargaAsignacion();
                        } else {
                            JOptionPane.showMessageDialog(vistaAsig, "ERROR AL GRABAR DATOS");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Controlador_Asignacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
//-------------------------------------------------------MODIFICAR--------------------------------------------------------------------------------------------

        } else if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Editar")) {

            Modelo_Asignacion model = new Modelo_Asignacion();

            if (vistaAsig.getTxtCodAsignacion().equals("") || vistaAsig.getDtfecha() == null || vistaAsig.getTxtcodArbitro().equals("") || vistaAsig.getTxtcodPartido().equals("")) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {

                if (validacionFechaModificar() == true) {
                    JOptionPane.showMessageDialog(null, "EL PARTIDO YA SE LLEVO JUGO");

                } else {
                    try {
                        int codigoAsignacion = Integer.valueOf(vistaAsig.getTxtCodAsignacion().getText());
                        int codigoArbitro = Integer.valueOf(vistaAsig.getTxtcodArbitro().getText());
                        int CodigoPartido = Integer.valueOf(vistaAsig.getTxtcodPartido().getText());
                        String fechaS = vistaAsig.getDtfecha().getText();

                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date fechaUtil = formato.parse(fechaS);
                        java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
                        boolean estado = false;

                        model.setCodigo_asignacion(codigoAsignacion);
                        model.setCodigo_arbitro_asignacion(codigoArbitro);
                        model.setCodigo_partido_asignacion(CodigoPartido);
                        model.setFecha_asignacion(fechaSQL);
                        model.setEstado_asignacion(estado);

                        if (model.ModificarAsignacion()) {
                            limpiar();
                            JOptionPane.showMessageDialog(vistaAsig, "DATOS CREADOS");
                            vistaAsig.getDialogRegistrarModificar().setVisible(false);
                            cargaAsignacion();
                        } else {
                            JOptionPane.showMessageDialog(vistaAsig, "ERROR AL GRABAR DATOS");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Controlador_Asignacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
//-------------------------------------------------------ELIMINAR--------------------------------------------------------------------------------------------

        } else if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Eliminar")) {

            Modelo_Asignacion model = new Modelo_Asignacion();

            model.setCodigo_asignacion(Integer.valueOf(vistaAsig.getTxtCodAsignacion().getText()));
            if (model.EliminarAsignacion()) {

                limpiar();
                JOptionPane.showMessageDialog(vistaAsig, "DATOS ELIMINADOS");

                vistaAsig.getDialogRegistrarModificar().setVisible(false);
                cargaAsignacion();

            } else {
                JOptionPane.showMessageDialog(vistaAsig, "ERROR AL ELIMINAR LOS DATOS");
            }

        }
    }
    //-------------------------------------------------------CARGAR ASIGNACION EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargaAsignacion() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistaAsig.getTblAsignacion().getModel();
        mJtable.setNumRows(0);
        List<Clase_Asignacion> listaP = modeloAsig.listarAsignacion();
        listaP.stream().forEach(p -> {
            Object[] rowData = {p.getCodigo_asignacion(), p.getFecha_asignacion(), p.getCodigo_arbitro_asignacion(), p.getNombre_Arbitro(), p.getApellido_Arbitro(), p.getCodigo_partido_asignacion(), p.getEquipo_1(), p.getEquipo_2()};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------CARGAR ARBITRO EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargarArbitros() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistaAsig.getTblArbitro().getModel();
        mJtable.setNumRows(0);
        List<Clase_Arbitro> listaE = modeloArb.ListaArbitro();
        listaE.stream().forEach(p -> {
            Object[] rowData = {p.getCedula_persona_arbitro(), p.getNombnre1(), p.getApellido1(), p.getCodigo_arbitro()};
            mJtable.addRow(rowData);
        });
    }
//-------------------------------------------------------CARGAR PARTIDO EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargarpartido() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistaAsig.getTblPartido().getModel();
        mJtable.setNumRows(0);
        List<Clase_Partido> listaC = modeloPart.listarPartidos();

        listaC.stream().forEach(p -> {
            Object[] rowData = {p.getNombreequipo1(), p.getNombreequipo2(), p.getFecha(), p.getCod_partido()};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------LLENAR DATOS--------------------------------------------------------------------------------------------

    public void LlenarDatos() {
        List<Clase_Asignacion> Listpar = modeloAsig.listarAsignacion();
        int selectedRow = vistaAsig.getTblAsignacion().getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
        } else {
            String selectedId = vistaAsig.getTblAsignacion().getValueAt(selectedRow, 0).toString();
            Optional<Clase_Asignacion> matchingPartido = Listpar.stream()
                    .filter(p -> selectedId.equals(String.valueOf(p.getCodigo_asignacion())))
                    .findFirst();

            if (matchingPartido.isPresent()) {
                Clase_Asignacion p = matchingPartido.get();
                vistaAsig.getTxtCodAsignacion().setText(String.valueOf(p.getCodigo_asignacion()));
                vistaAsig.getDtfecha().setText(String.valueOf(p.getFecha_asignacion()));
                vistaAsig.getTxtcodArbitro().setText(String.valueOf(p.getCodigo_arbitro_asignacion()));
                vistaAsig.getTxt_nombre_arb().setText(String.valueOf(p.getNombre_Arbitro()));
                vistaAsig.getTxt_apellido_arb().setText(String.valueOf(p.getApellido_Arbitro()));
                vistaAsig.getTxtcodPartido().setText(String.valueOf(p.getCodigo_partido_asignacion()));
                vistaAsig.getTxt_equipo_1().setText(String.valueOf(p.getEquipo_1()));
                vistaAsig.getTxt_equipo_2().setText(String.valueOf(p.getEquipo_2()));

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento válido de la tabla.");
            }
        }
    }
//-------------------------------------------------------BUSCAR EQUIPOS--------------------------------------------------------------------------------------------

    private void buscarFK() {
        if (vistaAsig.getDialogtablas().getTitle().contentEquals("ARBITRO")) {
            List<Clase_Arbitro> listaarbitro = modeloArb.ListaArbitro();
            String idBuscado = vistaAsig.getTxtbuscarcod().getText();

            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Codigo Arbitro");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Apellido");

            for (Clase_Arbitro e : listaarbitro) {

                if (String.valueOf(e.getCodigo_arbitro()).equals(idBuscado)) {

                    Object[] fila = {
                        e.getCodigo_arbitro(),
                        e.getNombnre1(),
                        e.getApellido1()};
                    modeloTabla.addRow(fila);
                }
            }

            vistaAsig.getTblArbitro().setModel(modeloTabla);

        } else if (vistaAsig.getDialogtablas().getTitle().contentEquals("PARTIDO")) {
            List<Clase_Partido> listaequipos = modeloPart.listarPartidos();
            String idBuscado = vistaAsig.getTxtbuscarcod().getText();

            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Codigo");
            modeloTabla.addColumn("Grupo");
            modeloTabla.addColumn("Fecha");

            for (Clase_Partido e : listaequipos) {

                if (String.valueOf(e.getCod_partido()).equals(idBuscado)) {

                    Object[] fila = {
                        e.getCod_partido(),
                        e.getGrupo(),
                        e.getFecha()};
                    modeloTabla.addRow(fila);
                }

            }

            vistaAsig.getTblPartido().setModel(modeloTabla);

        }
    }
    //------------------------------------------------------- BUSCADOR PRINCIPAL--------------------------------------------------------------------------------------------

    public void buscar() {
        if (vistaAsig.getTxtBuscar().getText().equals("")) {
            cargaAsignacion();
        } else {
            DefaultTableModel tabla = (DefaultTableModel) vistaAsig.getTblAsignacion().getModel();
            tabla.setNumRows(0);

            List<Clase_Asignacion> par = modeloAsig.BuscarAsignacion(vistaAsig.txtBuscar.getText());
            par.stream().forEach(p -> {

                Object datos[] = {p.getCodigo_asignacion(), p.getFecha_asignacion(), p.getCodigo_arbitro_asignacion(), p.getCodigo_partido_asignacion()};
                tabla.addRow(datos);
            });
        }
    }
//------------------------------------------------------- VALIDAR ENTRADA--------------------------------------------------------------------------------------------

    private void validarEntrada(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean numeros = dato >= 48 && dato <= 57;
        boolean backspace = dato == 8;

        if (!(backspace || numeros)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar NUMEROS");
        }
        if (vistaAsig.getTxtBuscar().getText().trim().length() > 3) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (4)");
        }
    }

//------------------------------------------------------- SALIR DEL DIALOGO--------------------------------------------------------------------------------------------
    public void salirdialogo() {
        limpiar();
        vistaAsig.getDialogRegistrarModificar().setVisible(false);
    }
//------------------------------------------------------- SALIR DEL DIALOGO DE TABLAS--------------------------------------------------------------------------------------------

    public void salirdialogo1() {
        limpiartablas();
        vistaAsig.getDialogtablas().setVisible(false);
    }

//------------------------------------------------------- LIMPIAR--------------------------------------------------------------------------------------------
    private void limpiar() {

        vistaAsig.getTxtCodAsignacion().setText("");
        vistaAsig.getTxtcodArbitro().setText("");
        vistaAsig.getTxtcodPartido().setText("");
        vistaAsig.getDtfecha().setText("");

    }
//------------------------------------------------------- LIMPIAR--------------------------------------------------------------------------------------------

    private void limpiartablas() {

        vistaAsig.getTxtbuscarcod().setText("");

    }
}
