/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.ConexionMySql;
import Modelo.*;
import Vista.Vista_Asignacion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
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
        vistaAsig.getBtnModificar().addActionListener(l -> abrirDialogo("Editar"));
        vistaAsig.getBtnEliminar().addActionListener(l -> abrirDialogo("Eliminar"));
        vistaAsig.getBtnCancelar().addActionListener(l -> salirdialogo());
        vistaAsig.getBtnCancelar1().addActionListener(l -> salirdialogo1());
        vistaAsig.getBtnRegistrarModificar().addActionListener(l -> crearEditarAsignacion());
        vistaAsig.getBtnArbitro().addActionListener(l -> abrirDialogobusqueda("ARBITRO"));
        vistaAsig.getBtnPartido().addActionListener(l -> abrirDialogobusqueda("PARTIDO"));
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
            vistaAsig.getTblbuscar().clearSelection();
        });
        vistaAsig.getBtnCancelar().addActionListener(e -> {
            vistaAsig.getTblPartidos().clearSelection();
        });
        vistaAsig.getBtnRegistrarModificar().addActionListener(e -> {
            vistaAsig.getTblPartidos().clearSelection();
        });
        vistaAsig.getBtnAgregar().addActionListener(l -> {
            try {
                CargarID();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Asignacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
//-------------------------------------------------------DIALOGO--------------------------------------------------------------------------------------------

    private void abrirDialogo(String ce) {

        vistaAsig.getDialogRegistrarModificar().setSize(1047, 700);
        vistaAsig.getDialogRegistrarModificar().setTitle(ce);
        vistaAsig.getDialogRegistrarModificar().setVisible(true);

        if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Crear")) {
            vistaAsig.getLblReMoJugadores().setText("REGISTRO DE PARTIDOS");
            vistaAsig.getBtnRegistrarModificar().setText("REGISTRO DE PARTIDOS");

        } else if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Editar")) {
            vistaAsig.getLblReMoJugadores().setText("MODIFICAR PARTIDOS");
            LlenarDatos();
            vistaAsig.getBtnRegistrarModificar().setText("MODIFICAR PARTIDOS");

        } else if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Eliminar")) {
            LlenarDatos();
            vistaAsig.getBtnRegistrarModificar().setText("ELIMINAR PARTIDOS");
            vistaAsig.getLblReMoJugadores().setText("ELIMINAR PARTIDOS");
            vistaAsig.getBtnRegistrarModificar().setText("ELIMINAR PARTIDOS");
        }
    }
    //-------------------------------------------------------DIALOGO 2--------------------------------------------------------------------------------------------

    private void abrirDialogobusqueda(String ce) {

        vistaAsig.getDialogtablas().setSize(810, 680);
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

            int selectedRow = vistaAsig.getTblbuscar().getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {

                String selectedId = vistaAsig.getTblbuscar().getValueAt(selectedRow, 0).toString();
                vistaAsig.getTxtcodArbitro().setText(selectedId);
                salirdialogo1();

            }

        } else if (vistaAsig.getDialogtablas().getTitle().contentEquals("PARTIDO")) {
            int selectedRow = vistaAsig.getTblbuscar().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistaAsig.getTblbuscar().getValueAt(selectedRow, 0).toString();
                vistaAsig.getTxtcodPartido().setText(selectedId);
                salirdialogo1();
            }
        }
    }
    //--------------------------------------------------------CRUD--------------------------------------------------------------------------------------------
    //-------------------------------------------------------AGREGAR--------------------------------------------------------------------------------------------

    private void crearEditarAsignacion() {
        if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Crear")) {

            Modelo_Asignacion model = new Modelo_Asignacion();

            if (vistaAsig.getTxtCodAsignacion().equals("") || vistaAsig.getDtfecha() == null || vistaAsig.getTxtcodArbitro().equals("") || vistaAsig.getTxtcodPartido().equals("")) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {

                int codigoAsignacion = Integer.valueOf(vistaAsig.getTxtCodAsignacion().getText());
                int codigoArbitro = Integer.valueOf(vistaAsig.getTxtcodArbitro().getText());
                int CodigoPartido = Integer.valueOf(vistaAsig.getTxtcodPartido().getText());

                boolean estado = false;

                model.setCodigo_asignacion(codigoAsignacion);
                model.setCodigo_arbitro_asignacion(codigoArbitro);
                model.setCodigo_partido_asignacion(CodigoPartido);
                model.setFecha_asignacion(new java.sql.Date(vistaAsig.getDtfecha().getDate().getTime()));
                model.setEstado_asignacion(estado);

                if (model.InsertarAsignacion()) {
                    limpiar();
                    JOptionPane.showMessageDialog(vistaAsig, "DATOS CREADOS");
                    vistaAsig.getDialogRegistrarModificar().setVisible(false);
                    cargaAsignacion();
                } else {
                    JOptionPane.showMessageDialog(vistaAsig, "ERROR AL GRABAR DATOS");
                }
            }
//-------------------------------------------------------MODIFICAR--------------------------------------------------------------------------------------------

        } else if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Editar")) {

            Modelo_Asignacion model = new Modelo_Asignacion();

            if (vistaAsig.getTxtCodAsignacion().equals("") || vistaAsig.getDtfecha() == null || vistaAsig.getTxtcodArbitro().equals("") || vistaAsig.getTxtcodPartido().equals("")) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {

                int codigoAsignacion = Integer.valueOf(vistaAsig.getTxtCodAsignacion().getText());
                int codigoArbitro = Integer.valueOf(vistaAsig.getTxtcodArbitro().getText());
                int CodigoPartido = Integer.valueOf(vistaAsig.getTxtcodPartido().getText());

                boolean estado = false;

                model.setCodigo_asignacion(codigoAsignacion);
                model.setCodigo_arbitro_asignacion(codigoArbitro);
                model.setCodigo_partido_asignacion(CodigoPartido);
                model.setFecha_asignacion(new java.sql.Date(vistaAsig.getDtfecha().getDate().getTime()));
                model.setEstado_asignacion(estado);

                if (model.ModificarAsignacion()) {
                    limpiar();
                    JOptionPane.showMessageDialog(vistaAsig, "DATOS CREADOS");
                    vistaAsig.getDialogRegistrarModificar().setVisible(false);
                    cargaAsignacion();
                } else {
                    JOptionPane.showMessageDialog(vistaAsig, "ERROR AL GRABAR DATOS");
                }
            }
//-------------------------------------------------------ELIMINAR--------------------------------------------------------------------------------------------

        } else if (vistaAsig.getDialogRegistrarModificar().getTitle().contentEquals("Eliminar")) {

            Modelo_Partido model = new Modelo_Partido();

            model.setCod_partido(Integer.valueOf(vistaAsig.getTxtCodAsignacion().getText()));
            if (model.EliminarPartido()) {

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
        mJtable = (DefaultTableModel) vistaAsig.getTblPartidos().getModel();
        mJtable.setNumRows(0);
        List<Clase_Asignacion> listaP = modeloAsig.listarAsignacion();
        listaP.stream().forEach(p -> {
            Object[] rowData = {p.getCodigo_asignacion(), p.getFecha_asignacion(), p.getCodigo_arbitro_asignacion(), p.getCodigo_partido_asignacion()};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------CARGAR ARBITRO EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargarArbitros() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistaAsig.getTblbuscar().getModel();
        mJtable.setNumRows(0);
        List<Clase_Arbitro> listaE = modeloArb.ListaArbitro();
        listaE.stream().forEach(p -> {
            Object[] rowData = {p.getCodigo_arbitro(), p.getNombnre1(), p.getApellido1()};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------CARGAR PARTIDO EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargarpartido() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistaAsig.getTblbuscar().getModel();
        mJtable.setNumRows(0);
        List<Clase_Partido> listaC = modeloPart.listarPartidos();
        listaC.stream().forEach(p -> {
            Object[] rowData = {p.getCod_partido(), p.getGrupo(), p.getFecha()};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------LLENAR DATOS--------------------------------------------------------------------------------------------

    public void LlenarDatos() {
        List<Clase_Asignacion> Listpar = modeloAsig.listarAsignacion();
        int selectedRow = vistaAsig.getTblPartidos().getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
        } else {
            String selectedId = vistaAsig.getTblPartidos().getValueAt(selectedRow, 0).toString();
            Optional<Clase_Asignacion> matchingPartido = Listpar.stream()
                    .filter(p -> selectedId.equals(String.valueOf(p.getCodigo_asignacion())))
                    .findFirst();

            if (matchingPartido.isPresent()) {
                Clase_Asignacion p = matchingPartido.get();
                vistaAsig.getTxtCodAsignacion().setText(String.valueOf(p.getCodigo_asignacion()));
                vistaAsig.getDtfecha().setDate((p.getFecha_asignacion()));
                vistaAsig.getTxtcodArbitro().setText(String.valueOf(p.getCodigo_arbitro_asignacion()));
                vistaAsig.getTxtcodPartido().setText(String.valueOf(p.getCodigo_partido_asignacion()));

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

            vistaAsig.getTblbuscar().setModel(modeloTabla);

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

            vistaAsig.getTblbuscar().setModel(modeloTabla);

        }
    }
    //------------------------------------------------------- BUSCADOR PRINCIPAL--------------------------------------------------------------------------------------------

    public void buscar() {
        if (vistaAsig.getTxtBuscar().getText().equals("")) {
            cargaAsignacion();
        } else {
            DefaultTableModel tabla = (DefaultTableModel) vistaAsig.getTblPartidos().getModel();
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
        vistaAsig.getDtfecha().setDate(null);

    }
//------------------------------------------------------- LIMPIAR--------------------------------------------------------------------------------------------

    private void limpiartablas() {

        vistaAsig.getTxtbuscarcod().setText("");

    }
}
