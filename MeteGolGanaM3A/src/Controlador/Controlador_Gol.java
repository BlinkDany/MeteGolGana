package Controlador;

import Conexion.ConexionMySql;
import Modelo.Clase_Equipo;
import Modelo.Clase_Estadio;
import Modelo.Clase_Gol;
import Modelo.Clase_Jugador;
import Modelo.Clase_Partido;
import Modelo.ModeloEquipos;
import Modelo.Modelo_Estadio;
import Modelo.Modelo_Gol;
import Modelo.Modelo_Jugador;
import Modelo.Modelo_Partido;
import Vista.VistaGol;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Derek
 */
public class Controlador_Gol {

    private Modelo_Partido modeloPar;
    private Modelo_Jugador modeloJug;
    private ModeloEquipos modeloEqu;
    private Modelo_Estadio modeloEsta;
    private Modelo_Gol modeloGol;
    private VistaGol vistagol;

    public Controlador_Gol(Modelo_Partido modeloPar, Modelo_Jugador modeloJug, ModeloEquipos modeloEqu, VistaGol vistagol, Modelo_Gol modeloGol, Modelo_Estadio modeloEsta) {
        this.modeloPar = modeloPar;
        this.modeloJug = modeloJug;
        this.modeloEqu = modeloEqu;
        this.modeloEsta = modeloEsta;
        this.modeloGol = modeloGol;
        this.vistagol = vistagol;
        vistagol.setVisible(true);
        vistagol.getTxtCodJugador().setEnabled(false);
        vistagol.getTxtCodPartido().setEnabled(false);
        vistagol.getTxtCodEquipo().setEnabled(false);
        vistagol.getTxtcodGol().setVisible(false);

        cargaGoles();
    }

    public void iniciaControl() {
        vistagol.getBtnAgregar().addActionListener(l -> abrirDialogo("Crear"));
        vistagol.getBtnModificar().addActionListener(l -> abrirDialogo("Editar"));
        vistagol.getBtnEliminar().addActionListener(l -> abrirDialogo("Eliminar"));
        vistagol.getBtnCancelar().addActionListener(l -> salirdialogo());
        vistagol.getBtnCancelar1().addActionListener(l -> salirdialogo1());
        vistagol.getBtnRegistrarModificar().addActionListener(l -> crearEditarGoles());
        vistagol.getBtnEquipo().addActionListener(l -> abrirDialogobusqueda("EQUIPO"));
        vistagol.getBtnJugador().addActionListener(l -> abrirDialogobusqueda("JUGADOR"));
        vistagol.getBtnPartido().addActionListener(l -> abrirDialogobusqueda("PARTIDO"));
        vistagol.getBtnmandardatos().addActionListener(l -> mandardatos());
        vistagol.getBtnBuscar().addActionListener(l -> buscarFK());
        vistagol.getBtnBuscar().addActionListener(l -> buscarFK());
        vistagol.getTxtBuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntrada(evt);
            }
        });
        vistagol.getBtnCancelar().addActionListener(e -> {
            vistagol.getTblbuscar().clearSelection();
        });
        vistagol.getBtnCancelar().addActionListener(e -> {
            vistagol.getTblGoles().clearSelection();
        });
        vistagol.getBtnRegistrarModificar().addActionListener(e -> {
            vistagol.getTblGoles().clearSelection();
        });

        vistagol.getTxtBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscargol();
            }
        });

        vistagol.getBtnAgregar().addActionListener(l -> {
            try {
                CargarID();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Equipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void abrirDialogo(String ce) {

        vistagol.getJdgGoles().setLocationRelativeTo(null);
        vistagol.getJdgGoles().setSize(662, 522);
        vistagol.getJdgGoles().setTitle(ce);
        vistagol.getJdgGoles().setVisible(true);
        vistagol.getCodigo().setVisible(false);
        vistagol.getCodigo2().setVisible(false);

        if (vistagol.getJdgGoles().getTitle().contentEquals("Crear")) {
            vistagol.getLblReMoGoles().setText("REGISTRO DE GOLES");

            vistagol.getBtnRegistrarModificar().setText("REGISTRO DE GOLES");

        } else if (vistagol.getJdgGoles().getTitle().contentEquals("Editar")) {

            vistagol.getLblReMoGoles().setText("MODIFICAR GOLES");
            LlenarDatos();
            vistagol.getBtnRegistrarModificar().setText("MODIFICAR GOLES");

        } else if (vistagol.getJdgGoles().getTitle().contentEquals("Eliminar")) {

            LlenarDatos();
            vistagol.getBtnRegistrarModificar().setText("ELIMINAR GOLES");

        }
    }

    private void abrirDialogobusqueda(String ce) {

        vistagol.getJdggolestabla().setSize(810, 680);
        vistagol.getJdggolestabla().setTitle(ce);
        vistagol.getJdggolestabla().setVisible(true);

        if (vistagol.getJdggolestabla().getTitle().contentEquals("JUGADOR")) {
            vistagol.getLblbusqueda().setText("JUGADOR");
            cargajugadores();
        } else if (vistagol.getJdggolestabla().getTitle().contentEquals("PARTIDO")) {
            vistagol.getLblbusqueda().setText("PARTIDO");
            cargaPartidos();
        } else if (vistagol.getJdggolestabla().getTitle().contentEquals("EQUIPO")) {
            vistagol.getLblbusqueda().setText("EQUIPO");
            cargaequipos();
        }
    }

    public void LlenarDatos() {
        List<Clase_Gol> Listgol = modeloGol.listarGoles();
        int selectedRow = vistagol.getTblGoles().getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
        } else {
            String selectedId = vistagol.getTblGoles().getValueAt(selectedRow, 0).toString();
            Optional<Clase_Gol> matchingGoles = Listgol.stream()
                    .filter(p -> selectedId.equals(String.valueOf(p.getCod_gol())))
                    .findFirst();

            if (matchingGoles.isPresent()) {
                Clase_Gol p = matchingGoles.get();
                vistagol.getTxtcodGol().setText(String.valueOf(p.getCod_gol()));
                vistagol.getTxtdescripcion().setText(p.getDescripcion());
                vistagol.getTxtMinuto().setText(p.getMinuto());
                vistagol.getTxtcodGol().setEnabled(false);
                vistagol.getTxtCodJugador().setText(String.valueOf(p.getNombre_jugador()));
                vistagol.getTxtCodPartido().setText(String.valueOf(p.getCod_partido()));
                vistagol.getTxtCodEquipo().setText(String.valueOf(p.getNombre_equipo()));
                vistagol.getCodigo().setText(String.valueOf(p.getCod_jugador()));
                vistagol.getCodigo2().setText(String.valueOf(p.getCod_equipo()));

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento válido de la tabla.");
            }
        }
    }

    //------------------------------------------------------- BUSCADOR PRINCIPAL--------------------------------------------------------------------------------------------
    public void buscargol() {
        if (vistagol.getTxtBuscar().getText().equals("")) {
            cargaGoles();
        } else {

            DefaultTableModel tabla = (DefaultTableModel) vistagol.getTblGoles().getModel();
            tabla.setNumRows(0);

            List<Clase_Gol> par = modeloGol.BuscarGoles(vistagol.getTxtBuscar().getText());
            par.stream().forEach(p -> {

                Object datos[] = {p.getCod_gol(), p.getDescripcion(), p.getMinuto(), p.getCod_jugador(), p.getNombre_equipo(), p.getNombre_jugador()};
                tabla.addRow(datos);
            });
        }
    }

    //------------------------------------------------------- SALIR DEL DIALOGO--------------------------------------------------------------------------------------------
    public void salirdialogo() {
        limpiar();
        vistagol.getJdgGoles().setVisible(false);
    }

    public void salirdialogo1() {
        try {
            limpiarBuscar();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador_Gol.class.getName()).log(Level.SEVERE, null, ex);
        }
        vistagol.getJdggolestabla().setVisible(false);
    }

    private void limpiar() {

        vistagol.getTxtCodPartido().setText("");
        vistagol.getTxtcodGol().setText("");
        vistagol.getTxtMinuto().setText("");
        vistagol.getTxtdescripcion().setText("");
        vistagol.getTxtCodJugador().setText("");
        vistagol.getTxtCodEquipo().setText("");
        vistagol.getTxtcodGol().setEnabled(true);

    }
//------------------------------------------------------- LIMPIAR--------------------------------------------------------------------------------------------

    private void limpiarBuscar() throws SQLException {

        vistagol.getTxtBuscar().setText("");
        cargaGoles();
        CargarID();
    }

    public void limpiara() {
        vistagol.getTxtbuscarcod().setText("");
    }

    private void mandardatos() {

        String set = vistagol.getTxtbuscarcod().getText();

        if (vistagol.getJdggolestabla().getTitle().contentEquals("JUGADOR")) {
            int selectedRow = vistagol.getTblbuscar().getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistagol.getTblbuscar().getValueAt(selectedRow, 0).toString();
                vistagol.getCodigo().setText(selectedId);
                String nombre = vistagol.getTblbuscar().getValueAt(selectedRow, 1).toString();
                vistagol.getTxtCodJugador().setText(nombre);
                salirdialogo1();
                limpiara();
            }
        } else if (vistagol.getJdggolestabla().getTitle().contentEquals("PARTIDO")) {
            int selectedRow = vistagol.getTblbuscar().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistagol.getTblbuscar().getValueAt(selectedRow, 0).toString();
                vistagol.getTxtCodPartido().setText(selectedId);
                salirdialogo1();
                limpiara();
            }

        } else if (vistagol.getJdggolestabla().getTitle().contentEquals("EQUIPO")) {
            int selectedRow = vistagol.getTblbuscar().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistagol.getTblbuscar().getValueAt(selectedRow, 0).toString();
                String nombre = vistagol.getTblbuscar().getValueAt(selectedRow, 1).toString();
                vistagol.getTxtCodEquipo().setText(nombre);
                vistagol.getCodigo2().setText(selectedId);
                salirdialogo1();
                limpiara();
            }
        }
    }
    //--------------------------------------------------------CRUD--------------------------------------------------------------------------------------------
    //-------------------------------------------------------AGREGAR--------------------------------------------------------------------------------------------

    private void crearEditarGoles() {
        if (vistagol.getJdgGoles().getTitle().contentEquals("Crear")) {

            Modelo_Gol model = new Modelo_Gol();

            if (vistagol.getTxtcodGol().equals("") || vistagol.getTxtdescripcion().equals("") || vistagol.getTxtMinuto().equals("") || vistagol.getTxtCodJugador().equals("") || vistagol.getTxtCodPartido().equals("") || vistagol.getTxtCodEquipo().equals("")) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {
                int codigogol = Integer.valueOf(vistagol.getTxtcodGol().getText());
                String descrip = vistagol.getTxtdescripcion().getText();
                String minut = vistagol.getTxtMinuto().getText();
                int codjugador = Integer.valueOf(vistagol.getCodigo().getText());
                int codpartido = Integer.valueOf(vistagol.getTxtCodPartido().getText());
                int codequipo = Integer.valueOf(vistagol.getCodigo2().getText());

                model.setCod_gol(codigogol);
                model.setDescripcion(descrip);
                model.setMinuto(minut);
                model.setCod_partido(codpartido);
                model.setCod_jugador(codjugador);
                model.setCod_equipo(codequipo);
                if (model.InsertarGol()) {
                    limpiar();
                    JOptionPane.showMessageDialog(vistagol, "DATOS CREADOS");
                    vistagol.getJdgGoles().setVisible(false);
                    cargaGoles();
                } else {
                    JOptionPane.showMessageDialog(vistagol, "ERROR AL GRABAR DATOS");
                }
            }
//-------------------------------------------------------MODIFICAR--------------------------------------------------------------------------------------------

        } else if (vistagol.getJdgGoles().getTitle().contentEquals("Editar")) {

            Modelo_Gol model = new Modelo_Gol();

            if (vistagol.getTxtcodGol().equals("") || vistagol.getTxtdescripcion().equals("") || vistagol.getTxtMinuto().equals("") || vistagol.getTxtCodJugador().equals("") || vistagol.getTxtCodPartido().equals("") || vistagol.getTxtCodEquipo().equals("")) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {
                int codigogol = Integer.valueOf(vistagol.getTxtcodGol().getText());
                String descrip = vistagol.getTxtdescripcion().getText();
                String minut = vistagol.getTxtMinuto().getText();
                int codjugador = Integer.valueOf(vistagol.getCodigo().getText());
                int codpartido = Integer.valueOf(vistagol.getTxtCodPartido().getText());
                int codequipo = Integer.valueOf(vistagol.getCodigo2().getText());

                model.setCod_gol(codigogol);
                model.setDescripcion(descrip);
                model.setMinuto(minut);
                model.setCod_partido(codpartido);
                model.setCod_jugador(codjugador);
                model.setCod_equipo(codequipo);
                if (model.ModificarGol()) {
                    limpiar();
                    JOptionPane.showMessageDialog(vistagol, "DATOS CREADOS");
                    vistagol.getJdgGoles().setVisible(false);
                    cargaGoles();
                } else {
                    JOptionPane.showMessageDialog(vistagol, "ERROR AL GRABAR DATOS");
                }

            }
//-------------------------------------------------------ELIMINAR--------------------------------------------------------------------------------------------

        } else if (vistagol.getJdgGoles().getTitle().contentEquals("Eliminar")) {
            Modelo_Gol model = new Modelo_Gol();
            model.setCod_gol(Integer.valueOf(vistagol.getTxtcodGol().getText()));
            if (model.EliminarGol()) {

                limpiar();
                JOptionPane.showMessageDialog(vistagol, "DATOS ELIMINADOS");

                vistagol.getJdgGoles().setVisible(false);
                cargaGoles();

            } else {
                JOptionPane.showMessageDialog(vistagol, "ERROR AL GRABAR DATOS");
            }

        }
    }

//-------------------------------------------------------CARGAR PARTIDOS EN LA TABLA--------------------------------------------------------------------------------------------
    private void cargaPartidos() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistagol.getTblbuscar().getModel();
        mJtable.setNumRows(0);
        List<Clase_Partido> listaP = modeloPar.listarPartidos();
        listaP.stream().forEach(p -> {
            Object[] rowData = {p.getCod_partido(), p.getFecha(), p.getEstado()};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------CARGAR EQUIPOS EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargaequipos() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistagol.getTblbuscar().getModel();
        mJtable.setNumRows(0);
        List<Clase_Equipo> listaE = modeloEqu.listarEquipos();
        listaE.stream().forEach(p -> {
            Object[] rowData = {p.getCod_equipo(), p.getNombre_equi(), p.getCiudad()};
            mJtable.addRow(rowData);
        }
        );
    }

    private void cargajugadores() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistagol.getTblbuscar().getModel();
        mJtable.setNumRows(0);
        List<Clase_Jugador> listaC = modeloJug.ListaJugador();

        listaC.stream().forEach(e -> {
            Object[] rowData = {e.getCod_jugador(), e.getNombnre1(), e.getPosicion()};
            mJtable.addRow(rowData);
        });

    }

    private void cargaGoles() {

        DefaultTableModel tabla = (DefaultTableModel) vistagol.getTblGoles().getModel();
        tabla.setNumRows(0);

        List<Clase_Gol> jug = modeloGol.listarGoles();
        jug.stream().forEach(p -> {

            Object datos[] = {p.getCod_gol(), p.getDescripcion(), p.getMinuto(), p.getCod_partido(), p.getNombre_equipo(), p.getNombre_jugador()};
            tabla.addRow(datos);
        });
    }

    private void CargarID() throws SQLException {
        vistagol.getTxtcodGol().setText(String.valueOf(modeloGol.CargarCodigoID()));
    }

    private void buscarFK() {
        if (vistagol.getJdggolestabla().getTitle().contentEquals("EQUIPO")) {
            List<Clase_Equipo> listaequipos = modeloEqu.listarEquipos();
            String idBuscado = vistagol.getTxtbuscarcod().getText();

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

            vistagol.getTblbuscar().setModel(modeloTabla);

//-------------------------------------------------------BUSCAR ESTADIOS--------------------------------------------------------------------------------------------
        } else if (vistagol.getJdggolestabla().getTitle().contentEquals("JUGADOR")) {
            List<Clase_Jugador> listajugador = modeloJug.ListaJugador();
            String idBuscado = vistagol.getTxtbuscarcod().getText();

            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Codigo Jugador");
            modeloTabla.addColumn("Nombre Jugador");
            modeloTabla.addColumn("Posicion Jugador");

            for (Clase_Jugador e : listajugador) {

                if (String.valueOf(e.getCod_jugador()).equals(idBuscado)) {

                    Object[] fila = {
                        e.getCod_jugador(),
                        e.getNombnre1(),
                        e.getPosicion()};
                    modeloTabla.addRow(fila);
                }

            }

            vistagol.getTblbuscar().setModel(modeloTabla);
//-------------------------------------------------------BUSCAR CAMPEONATOS--------------------------------------------------------------------------------------------      
        } else if (vistagol.getJdggolestabla().getTitle().contentEquals("PARTIDO")) {
            List<Clase_Partido> listapartido = modeloPar.listarPartidos();
            String idBuscado = vistagol.getTxtbuscarcod().getText();

            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Codigo Temporada");
            modeloTabla.addColumn("Fecha Inicio");
            modeloTabla.addColumn("Fecha Fin");

            for (Clase_Partido e : listapartido) {

                if (String.valueOf(e.getCod_partido()).equals(idBuscado)) {

                    Object[] fila = {
                        e.getCod_partido(),
                        e.getNombreequipo1(),
                        e.getNombreequipo2()};
                    modeloTabla.addRow(fila);
                }

            }

            vistagol.getTblbuscar().setModel(modeloTabla);
        }
    }

    private void validarEntrada(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean numeros = dato >= 48 && dato <= 57;
        boolean backspace = dato == 8;

        if (!(backspace || numeros)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar NUMEROS");
        }
        if (vistagol.getTxtBuscar().getText().trim().length() > 3) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (4)");
        }
    }
    //--
}
