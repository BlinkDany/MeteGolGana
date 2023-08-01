/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.ConexionMySql;
import Modelo.*;
import Vista.VistaPartido;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Controlador_Partido {

    private Modelo_Partido modeloPar;
    private Modelo_Temporada modeloTem;
    private ModeloEquipos modeloEqu;
    private Modelo_Estadio modeloEst;
    private VistaPartido vistapar;

    public Controlador_Partido(Modelo_Partido modeloPar, Modelo_Temporada modeloTem, ModeloEquipos modeloEqu, Modelo_Estadio modeloEst, VistaPartido vistapar) {
        this.modeloPar = modeloPar;
        this.modeloTem = modeloTem;
        this.modeloEqu = modeloEqu;
        this.modeloEst = modeloEst;
        this.vistapar = vistapar;
        vistapar.setVisible(true);
        vistapar.getTxtCodPartido().setEnabled(false);
        vistapar.getTxtCodPartido().setVisible(false);
        vistapar.getTxtEquipo1().setEnabled(false);
        vistapar.getTxtEquipo2().setEnabled(false);
        vistapar.getTxtCampeonato().setEnabled(false);
        vistapar.getTxtEstadio().setEnabled(false);
        vistapar.getEquocu().setVisible(false);
        vistapar.getEquocu2().setVisible(false);
        vistapar.getEstocu().setVisible(false);
        vistapar.getFechaantes().setVisible(false);
        vistapar.getFechadespues().setVisible(false);

        cargaPartidos();
    }

//-------------------------------------------------------CONTROL--------------------------------------------------------------------------------------------
    public void iniciaControl() {
        vistapar.getBtnAgregar().addActionListener(l -> abrirDialogo("Crear"));
        vistapar.getBtnModificar().addActionListener(l -> {
            if (vistapar.getTblPartidos().getSelectedRow() == -1) {

                JOptionPane.showMessageDialog(null, "Seleccione el partido que desea editar");

            } else {

                abrirDialogo("Editar");

            }
        });
        vistapar.getBtnEliminar().addActionListener(l -> {
            if (vistapar.getTblPartidos().getSelectedRow() == -1) {

                JOptionPane.showMessageDialog(null, "Seleccione el partido que desea eliminar");

            } else {

                abrirDialogo("Eliminar");

            }
        });

        vistapar.getBtnCancelar().addActionListener(l -> salirdialogo());
        vistapar.getBtnCancelar1().addActionListener(l -> salirdialogo1());
        vistapar.getBtnRegistrarModificar().addActionListener(l -> crearEditarPartido());
        vistapar.getBtnEquipo1().addActionListener(l -> abrirDialogobusqueda("EQUIPOS 1"));
        vistapar.getBtnEquipo2().addActionListener(l -> abrirDialogobusqueda("EQUIPOS 2"));
        vistapar.getBtnEstadio().addActionListener(l -> abrirDialogobusqueda("ESTADIO"));
        vistapar.getBtnTemporada().addActionListener(l -> abrirDialogobusqueda("TEMPORADA"));
        vistapar.getBtnmandardatos().addActionListener(l -> mandardatos());
        vistapar.getBtnBuscar().addActionListener(l -> buscarFK());
        vistapar.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar();
            }
        });
        vistapar.getTxtBuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntrada(evt);
            }
        });
        vistapar.getTxtgrupo().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarGrupo(evt);
            }
        });
        vistapar.getBtnCancelar1().addActionListener(e -> {
            vistapar.getTblbuscar().clearSelection();
        });
        vistapar.getBtnCancelar().addActionListener(e -> {
            vistapar.getTblPartidos().clearSelection();
        });
        vistapar.getBtnRegistrarModificar().addActionListener(e -> {
            vistapar.getTblPartidos().clearSelection();
        });
        vistapar.getBtnAgregar().addActionListener(l -> {
            try {
                CargarID();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Partido.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
//-------------------------------------------------------DIALOGO--------------------------------------------------------------------------------------------

    private void abrirDialogo(String ce) {

        vistapar.getDialogRegistrarModificar().setSize(1047, 700);
        vistapar.getDialogRegistrarModificar().setTitle(ce);
        vistapar.getDialogRegistrarModificar().setVisible(true);

        if (vistapar.getDialogRegistrarModificar().getTitle().contentEquals("Crear")) {
            vistapar.getLblReMoJugadores().setText("REGISTRO DE PARTIDOS");
            vistapar.getBtnRegistrarModificar().setText("REGISTRO DE PARTIDOS");

        } else if (vistapar.getDialogRegistrarModificar().getTitle().contentEquals("Editar")) {
            vistapar.getLblReMoJugadores().setText("MODIFICAR PARTIDOS");
            LlenarDatos();
            vistapar.getBtnRegistrarModificar().setText("MODIFICAR PARTIDOS");

        } else if (vistapar.getDialogRegistrarModificar().getTitle().contentEquals("Eliminar")) {
            LlenarDatos();
            vistapar.getBtnRegistrarModificar().setText("ELIMINAR PARTIDOS");
            vistapar.getLblReMoJugadores().setText("ELIMINAR PARTIDOS");
            vistapar.getBtnRegistrarModificar().setText("ELIMINAR PARTIDOS");
        }
    }

    //-------------------------------------------------------DIALOGO 2--------------------------------------------------------------------------------------------
    public boolean validacionFechaantes() {
        java.util.Date fechaUtil = null;
        java.util.Date fechaUtilP = null;

        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String fechaS = formato.format(vistapar.getDtfecha().getDate());
            fechaUtil = formato.parse(fechaS);

            String fechaSP = vistapar.getFechaantes().getText();
            fechaUtilP = formato.parse(fechaSP);

        } catch (ParseException ex) {
            Logger.getLogger(Controlador_Asignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaUtil.before(fechaUtilP);
    }

    public boolean validacionFechadespues() {
        java.util.Date fechaUtil = null;
        java.util.Date fechaUtilP = null;

        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String fechaS = formato.format(vistapar.getDtfecha().getDate());
            fechaUtil = formato.parse(fechaS);

            String fechaSP = vistapar.getFechadespues().getText();
            fechaUtilP = formato.parse(fechaSP);

        } catch (ParseException ex) {
            Logger.getLogger(Controlador_Asignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaUtil.after(fechaUtilP);
    }

    private void abrirDialogobusqueda(String ce) {

        vistapar.getDialogtablas().setSize(810, 680);
        vistapar.getDialogtablas().setTitle(ce);
        vistapar.getDialogtablas().setVisible(true);

        if (vistapar.getDialogtablas().getTitle().contentEquals("EQUIPOS 1")) {
            vistapar.getLblbusqueda().setText("EQUIPOS");
            cargaequipos();
        } else if (vistapar.getDialogtablas().getTitle().contentEquals("EQUIPOS 2")) {
            vistapar.getLblbusqueda().setText("EQUIPOS");
            cargaequipos();
        } else if (vistapar.getDialogtablas().getTitle().contentEquals("ESTADIO")) {
            vistapar.getLblbusqueda().setText("ESTADIOS");
            cargaestadios();

        } else if (vistapar.getDialogtablas().getTitle().contentEquals("TEMPORADA")) {
            vistapar.getLblbusqueda().setText("TEMPORADA");
            cargacampeonatos();
        }

    }
    //-------------------------------------------------------CODIGO --------------------------------------------------------------------------------------------

    private void CargarID() throws SQLException {
        vistapar.getTxtCodPartido().setText(String.valueOf(modeloPar.CargarCodigoID()));
    }

//-------------------------------------------------------SETEAR DATOS--------------------------------------------------------------------------------------------
    private void mandardatos() {

        String set = vistapar.getTxtbuscarcod().getText();

        if (vistapar.getDialogtablas().getTitle().contentEquals("EQUIPOS 1")) {
            int selectedRow = vistapar.getTblbuscar().getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistapar.getTblbuscar().getValueAt(selectedRow, 0).toString();
                String nombre = vistapar.getTblbuscar().getValueAt(selectedRow, 1).toString();
                vistapar.getEquocu().setText(selectedId);
                vistapar.getTxtEquipo1().setText(nombre);
                salirdialogo1();
            }
        } else if (vistapar.getDialogtablas().getTitle().contentEquals("EQUIPOS 2")) {
            int selectedRow = vistapar.getTblbuscar().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistapar.getTblbuscar().getValueAt(selectedRow, 0).toString();
                String nombre = vistapar.getTblbuscar().getValueAt(selectedRow, 1).toString();
                vistapar.getEquocu2().setText(selectedId);
                vistapar.getTxtEquipo2().setText(nombre);
                salirdialogo1();
            }

        } else if (vistapar.getDialogtablas().getTitle().contentEquals("ESTADIO")) {
            int selectedRow = vistapar.getTblbuscar().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistapar.getTblbuscar().getValueAt(selectedRow, 0).toString();
                String nombre = vistapar.getTblbuscar().getValueAt(selectedRow, 1).toString();
                vistapar.getTxtEstadio().setText(nombre);
                vistapar.getEstocu().setText(selectedId);
                salirdialogo1();
            }
        } else if (vistapar.getDialogtablas().getTitle().contentEquals("TEMPORADA")) {
            int selectedRow = vistapar.getTblbuscar().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistapar.getTblbuscar().getValueAt(selectedRow, 0).toString();
                vistapar.getTxtCampeonato().setText(selectedId);
                String selectedFecha = vistapar.getTblbuscar().getValueAt(selectedRow, 1).toString();
                String selectedFecha1 = vistapar.getTblbuscar().getValueAt(selectedRow, 2).toString();
                vistapar.getFechaantes().setText(selectedFecha);
                vistapar.getFechadespues().setText(selectedFecha1);
                salirdialogo1();
            }

        }

    }
    //--------------------------------------------------------CRUD--------------------------------------------------------------------------------------------
    //-------------------------------------------------------AGREGAR--------------------------------------------------------------------------------------------

    private void crearEditarPartido() {
        if (vistapar.getDialogRegistrarModificar().getTitle().contentEquals("Crear")) {

            Modelo_Partido model = new Modelo_Partido();

            if (vistapar.getTxtCodPartido().getText().equals("") || vistapar.getTxtgrupo().getText().equals("") || vistapar.getTxtCampeonato().getText().equals("") || vistapar.getTxtEquipo1().getText().equals("") || vistapar.getTxtEquipo2().getText().equals("") || vistapar.getTxtEstadio().getText().equals("") || vistapar.getCmestado().getSelectedItem().equals("Ninguno") || vistapar.getDtfecha().getDate() == null) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {
                if (vistapar.getTxtEquipo1().getText().equals(vistapar.getTxtEquipo2().getText())) {
                    JOptionPane.showMessageDialog(null, "NO PUEDEN SER LOS MISMOS EQUIPOS");
                } else {
                    if (validacionFechaantes() == true) {
                        JOptionPane.showMessageDialog(null, "EL PARTIDO NO PUEDE SER UNA FECHA ANTES DE LA TEMPORADA");
                    } else {
                        if (validacionFechadespues() == true) {
                            JOptionPane.showMessageDialog(null, "EL PARTIDO NO PUEDE SER UNA FECHA DESPUES DE LA TEMPORADA");
                        } else {

                            int codigopartido = Integer.valueOf(vistapar.getTxtCodPartido().getText());
                            int codtemporada = Integer.valueOf(vistapar.getTxtCampeonato().getText());
                            int equipo1 = Integer.valueOf(vistapar.getEquocu().getText());
                            int equipo2 = Integer.valueOf(vistapar.getEquocu2().getText());
                            int estadio = Integer.valueOf(vistapar.getEstocu().getText());
                            String grupo = vistapar.getTxtgrupo().getText();

                            boolean estado = false;

                            model.setCod_partido(codigopartido);
                            model.setCod_temporadafk(codtemporada);
                            model.setCod_equipo1(equipo1);
                            model.setCod_equipo2(equipo2);
                            model.setCod_estadio(estadio);
                            model.setGrupo(grupo);
                            model.setFecha(new java.sql.Date(vistapar.getDtfecha().getDate().getTime()));

                            if (vistapar.getCmestado().getSelectedItem().equals("Finalizado")) {
                                model.setEstado("Finalizado");
                            } else if (vistapar.getCmestado().getSelectedItem().equals("Activo")) {
                                model.setEstado("Activo");
                            } else if (vistapar.getCmestado().getSelectedItem().equals("Suspendido")) {
                                model.setEstado("Suspendido");
                            } else if (vistapar.getCmestado().getSelectedItem().equals("En Espera")) {
                                model.setEstado("En Espera");
                            }
                            model.setEstado_elim(estado);
                            if (model.InsertarPartido()) {
                                limpiar();
                                JOptionPane.showMessageDialog(vistapar, "DATOS CREADOS");
                                vistapar.getDialogRegistrarModificar().setVisible(false);
                                cargaPartidos();
                            } else {
                                JOptionPane.showMessageDialog(vistapar, "ERROR AL GRABAR DATOS");
                            }
                        }
                    }
                }
            }
//-------------------------------------------------------MODIFICAR--------------------------------------------------------------------------------------------

        } else if (vistapar.getDialogRegistrarModificar().getTitle().contentEquals("Editar")) {

            Modelo_Partido model = new Modelo_Partido();

            if (vistapar.getTxtCodPartido().getText().equals("") || vistapar.getTxtgrupo().getText().equals("") || vistapar.getTxtCampeonato().getText().equals("") || vistapar.getTxtEquipo1().getText().equals("") || vistapar.getTxtEquipo2().getText().equals("") || vistapar.getTxtEstadio().getText().equals("") || vistapar.getCmestado().getSelectedItem().equals("Ninguno") || vistapar.getDtfecha().getDate() == null) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {
                if (vistapar.getTxtEquipo1().getText().equals(vistapar.getTxtEquipo2().getText())) {
                    JOptionPane.showMessageDialog(null, "NO PUEDEN SER LOS MISMOS EQUIPOS");
                } else {
                    if (validacionFechaantes() == true) {
                        JOptionPane.showMessageDialog(null, "EL PARTIDO NO PUEDE SER UNA FECHA ANTES DE LA TEMPORADA");
                    } else {
                        if (validacionFechadespues() == true) {
                            JOptionPane.showMessageDialog(null, "EL PARTIDO NO PUEDE SER UNA FECHA DESPUES DE LA TEMPORADA");
                        } else {
                            int codigopartido = Integer.valueOf(vistapar.getTxtCodPartido().getText());
                            int codtemporada = Integer.valueOf(vistapar.getTxtCampeonato().getText());
                            int equipo1 = Integer.valueOf(vistapar.getEquocu().getText());
                            int equipo2 = Integer.valueOf(vistapar.getEquocu2().getText());
                            int estadio = Integer.valueOf(vistapar.getEstocu().getText());
                            String grupo = vistapar.getTxtgrupo().getText();
                            vistapar.getDtfecha().getDate();
                            boolean estado = false;

                            model.setCod_partido(codigopartido);
                            model.setCod_temporadafk(codtemporada);
                            model.setCod_equipo1(equipo1);
                            model.setCod_equipo2(equipo2);
                            model.setCod_estadio(estadio);
                            model.setGrupo(grupo);
                            model.setFecha(new java.sql.Date(vistapar.getDtfecha().getDate().getTime()));

                            if (vistapar.getCmestado().getSelectedItem().equals("Finalizado")) {
                                model.setEstado("Finalizado");
                            } else if (vistapar.getCmestado().getSelectedItem().equals("Activo")) {
                                model.setEstado("Activo");
                            } else if (vistapar.getCmestado().getSelectedItem().equals("Suspendido")) {
                                model.setEstado("Suspendido");
                            } else if (vistapar.getCmestado().getSelectedItem().equals("En Espera")) {
                                model.setEstado("En Espera");
                            }
                            model.setEstado_elim(estado);
                            if (model.ModificarPartido()) {
                                limpiar();
                                JOptionPane.showMessageDialog(vistapar, "DATOS CREADOS");
                                vistapar.getDialogRegistrarModificar().setVisible(false);
                                cargaPartidos();
                            } else {
                                JOptionPane.showMessageDialog(vistapar, "ERROR AL GRABAR DATOS");
                            }

                        }
                    }
                }
            }
//-------------------------------------------------------ELIMINAR--------------------------------------------------------------------------------------------

        } else if (vistapar.getDialogRegistrarModificar().getTitle().contentEquals("Eliminar")) {

            Modelo_Partido model = new Modelo_Partido();

            model.setCod_partido(Integer.valueOf(vistapar.getTxtCodPartido().getText()));
            if (model.EliminarPartido()) {

                limpiar();
                JOptionPane.showMessageDialog(vistapar, "DATOS ELIMINADOS");

                vistapar.getDialogRegistrarModificar().setVisible(false);
                cargaPartidos();

            } else {
                JOptionPane.showMessageDialog(vistapar, "ERROR AL GRABAR DATOS");
            }

        }
    }
    //-------------------------------------------------------CARGAR PARTIDOS EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargaPartidos() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistapar.getTblPartidos().getModel();
        mJtable.setNumRows(0);
        List<Clase_Partido> listaP = modeloPar.listarPartidos();
        listaP.stream().forEach(p -> {
            Object[] rowData = {p.getCod_partido(), p.getNombre_estadio(), p.getCod_temporadafk(), p.getFecha(), p.getGrupo(), p.getEstado(), p.getNombreequipo1(), p.getNombreequipo2()};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------CARGAR EQUIPOS EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargaequipos() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistapar.getTblbuscar().getModel();
        mJtable.setNumRows(0);
        List<Clase_Equipo> listaE = modeloEqu.listarEquipos();
        listaE.stream().forEach(p -> {
            Object[] rowData = {p.getCod_equipo(), p.getNombre_equi(), p.getCiudad()};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------CARGAR CAMPEONATOS EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargacampeonatos() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistapar.getTblbuscar().getModel();
        mJtable.setNumRows(0);
        List<Clase_Temporada> listaC = modeloTem.ListaTemporada();
        listaC.stream().forEach(p -> {
            Object[] rowData = {p.getCodigoPk(), p.getFechaIni(), p.getFechaFin()};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------CARGAR ESTADIOS EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargaestadios() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistapar.getTblbuscar().getModel();
        mJtable.setNumRows(0);
        List<Clase_Estadio> listaE = modeloEst.ListaEstadios();
        listaE.stream().forEach(p -> {
            Object[] rowData = {p.getCodigo(), p.getNombre(), p.getUbicacion()};
            mJtable.addRow(rowData);
        }
        );
    }

//-------------------------------------------------------LLENAR DATOS--------------------------------------------------------------------------------------------
    public void LlenarDatos() {
        List<Clase_Partido> Listpar = modeloPar.listarPartidos();
        int selectedRow = vistapar.getTblPartidos().getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
        } else {
            String selectedId = vistapar.getTblPartidos().getValueAt(selectedRow, 0).toString();
            Optional<Clase_Partido> matchingPartido = Listpar.stream()
                    .filter(p -> selectedId.equals(String.valueOf(p.getCod_partido())))
                    .findFirst();

            if (matchingPartido.isPresent()) {
                Clase_Partido p = matchingPartido.get();
                vistapar.getTxtCodPartido().setText(String.valueOf(p.getCod_partido()));
                vistapar.getTxtCampeonato().setText(String.valueOf(p.getCod_temporadafk()));
                vistapar.getTxtgrupo().setText(String.valueOf(p.getGrupo()));
                vistapar.getCmestado().setSelectedItem(String.valueOf(p.getEstado()));
                vistapar.getDtfecha().setDate((p.getFecha()));
                vistapar.getTxtEquipo1().setText(String.valueOf(p.getNombreequipo1()));
                vistapar.getTxtEquipo2().setText(String.valueOf(p.getNombreequipo2()));
                vistapar.getTxtEstadio().setText(String.valueOf(p.getNombre_estadio()));
                vistapar.getEstocu().setText(String.valueOf(p.getCod_estadio()));
                vistapar.getEquocu().setText(String.valueOf(p.getCod_equipo1()));
                vistapar.getEquocu2().setText(String.valueOf(p.getCod_equipo2()));
                vistapar.getFechaantes().setText(String.valueOf(p.getFechaantes()));
                vistapar.getFechadespues().setText(String.valueOf(p.getFechadespues()));

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento válido de la tabla.");
            }
        }
    }
//-------------------------------------------------------BUSCAR EQUIPOS--------------------------------------------------------------------------------------------

    private void buscarFK() {
        if (vistapar.getDialogtablas().getTitle().contentEquals("EQUIPOS 1")) {
            List<Clase_Equipo> listaequipos = modeloEqu.listarEquipos();
            String idBuscado = vistapar.getTxtbuscarcod().getText();

            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Codigo Equipo");
            modeloTabla.addColumn("Nombre Equipo");
            modeloTabla.addColumn("Ciudad Equipo");

            for (Clase_Equipo e : listaequipos) {

                if (String.valueOf(e.getCod_equipo()).equals(idBuscado)) {

                    Object[] fila = {
                        e.getCod_equipo(),
                        e.getNombre_equi(),
                        e.getCiudad()};
                    modeloTabla.addRow(fila);
                }

            }

            vistapar.getTblbuscar().setModel(modeloTabla);
        } else if (vistapar.getDialogtablas().getTitle().contentEquals("EQUIPOS 2")) {
            List<Clase_Equipo> listaequipos = modeloEqu.listarEquipos();
            String idBuscado = vistapar.getTxtbuscarcod().getText();

            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Codigo Equipo");
            modeloTabla.addColumn("Nombre Equipo");
            modeloTabla.addColumn("Ciudad Equipo");

            for (Clase_Equipo e : listaequipos) {

                if (String.valueOf(e.getCod_equipo()).equals(idBuscado)) {

                    Object[] fila = {
                        e.getCod_equipo(),
                        e.getNombre_equi(),
                        e.getCiudad()};
                    modeloTabla.addRow(fila);
                }

            }

            vistapar.getTblbuscar().setModel(modeloTabla);
//-------------------------------------------------------BUSCAR ESTADIOS--------------------------------------------------------------------------------------------
        } else if (vistapar.getDialogtablas().getTitle().contentEquals("ESTADIO")) {
            List<Clase_Estadio> listaestadios = modeloEst.ListaEstadios();
            String idBuscado = vistapar.getTxtbuscarcod().getText();

            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Codigo Estadio");
            modeloTabla.addColumn("Nombre Estadio");
            modeloTabla.addColumn("Ubicacion Estadio");

            for (Clase_Estadio e : listaestadios) {

                if (String.valueOf(e.getCodigo()).equals(idBuscado)) {

                    Object[] fila = {
                        e.getCodigo(),
                        e.getNombre(),
                        e.getUbicacion()};
                    modeloTabla.addRow(fila);
                }

            }

            vistapar.getTblbuscar().setModel(modeloTabla);
//-------------------------------------------------------BUSCAR CAMPEONATOS--------------------------------------------------------------------------------------------      
        } else if (vistapar.getDialogtablas().getTitle().contentEquals("TEMPORADA")) {
            List<Clase_Temporada> listaTemporada = modeloTem.ListaTemporada();
            String idBuscado = vistapar.getTxtbuscarcod().getText();

            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Codigo Temporada");
            modeloTabla.addColumn("Fecha Inicio");
            modeloTabla.addColumn("Fecha Fin");

            for (Clase_Temporada e : listaTemporada) {

                if (String.valueOf(e.getCodigoPk()).equals(idBuscado)) {

                    Object[] fila = {
                        e.getCodigoPk(),
                        e.getFechaIni(),
                        e.getFechaFin()};
                    modeloTabla.addRow(fila);
                }

            }

            vistapar.getTblbuscar().setModel(modeloTabla);
        }
    }
    //------------------------------------------------------- BUSCADOR PRINCIPAL--------------------------------------------------------------------------------------------

    public void buscar() {
        if (vistapar.getTxtBuscar().getText().equals("")) {
            cargaPartidos();
        } else {
            DefaultTableModel tabla = (DefaultTableModel) vistapar.getTblPartidos().getModel();
            tabla.setNumRows(0);

            List<Clase_Partido> par = modeloPar.BuscarPartidos(vistapar.txtBuscar.getText());
            par.stream().forEach(p -> {

                Object datos[] = {p.getCod_partido(), p.getCod_estadio(), p.getCod_temporadafk(), p.getFecha(), p.getGrupo(), p.getEstado(), p.getCod_equipo1(), p.getCod_equipo2()};
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
        if (vistapar.getTxtBuscar().getText().trim().length() > 3) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (4)");
        }
    }

    private void validarGrupo(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean numeros = dato >= 48 && dato <= 57;
        boolean backspace = dato == 8;
        boolean mayusculas = dato >= 65 && dato <= 90;

        if (!(mayusculas || backspace)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar letras en MAYUSCULA");
        }
        if (vistapar.getTxtgrupo().getText().trim().length() > 0) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (1)");
        }
    }

//------------------------------------------------------- SALIR DEL DIALOGO--------------------------------------------------------------------------------------------
    public void salirdialogo() {
        limpiar();
        vistapar.getDialogRegistrarModificar().setVisible(false);
    }
//------------------------------------------------------- SALIR DEL DIALOGO DE TABLAS--------------------------------------------------------------------------------------------

    public void salirdialogo1() {
        limpiartablas();
        vistapar.getDialogtablas().setVisible(false);
    }

//------------------------------------------------------- LIMPIAR--------------------------------------------------------------------------------------------
    private void limpiar() {

        vistapar.getTxtCodPartido().setText("");
        vistapar.getTxtCampeonato().setText("");
        vistapar.getTxtEquipo1().setText("");
        vistapar.getTxtEquipo2().setText("");
        vistapar.getTxtEstadio().setText("");
        vistapar.getTxtgrupo().setText("");
        vistapar.getCmestado().setSelectedItem("Ninguno");
        vistapar.getDtfecha().setDate(null);

    }
//------------------------------------------------------- LIMPIAR--------------------------------------------------------------------------------------------

    private void limpiartablas() {

        vistapar.getTxtbuscarcod().setText("");

    }
}
