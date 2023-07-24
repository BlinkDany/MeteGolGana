package Controlador;

import Modelo.Clase_Equipo;
import Modelo.Clase_Gol;
import Modelo.Clase_Jugador;
import Modelo.Clase_Partido;
import Modelo.ModeloEquipos;
import Modelo.Modelo_Gol;
import Modelo.Modelo_Jugador;
import Modelo.Modelo_Partido;
import Vista.VistaGol;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Optional;
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
    private Modelo_Gol modeloGol;
    private VistaGol vistagol;

    public Controlador_Gol(Modelo_Partido modeloPar, Modelo_Jugador modeloJug, ModeloEquipos modeloEqu, VistaGol vistagol, Modelo_Gol modeloGol) {
        this.modeloPar = modeloPar;
        this.modeloJug = modeloJug;
        this.modeloEqu = modeloEqu;
        this.modeloGol = modeloGol;
        this.vistagol = vistagol;
        vistagol.setVisible(true);
        //cargaGoles();
    }
     public void iniciaControl() {
        vistagol.getBtnAgregar().addActionListener(l -> abrirDialogo("Crear"));
        vistagol.getBtnModificar().addActionListener(l -> abrirDialogo("Editar"));
        vistagol.getBtnEliminar().addActionListener(l -> abrirDialogo("Eliminar"));
        vistagol.getBtnCancelar().addActionListener(l -> salirdialogo());
        vistagol.getBtnRegistrarModificar().addActionListener(l -> crearEditarPartido());
        vistagol.getBtnEquipo().addActionListener(l -> abrirDialogobusqueda("JUGADOR"));
        vistagol.getBtnJugador().addActionListener(l -> abrirDialogobusqueda("PARTIDO"));
        vistagol.getBtnPartido().addActionListener(l -> abrirDialogobusqueda("EQUIPO"));
        vistagol.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
             
            }
        });
        vistagol.getBtnCancelar().addActionListener(e -> {
            //vistagol.getTblbuscar().clearSelection();
        });
        vistagol.getBtnCancelar().addActionListener(e -> {
            vistagol.getTblGoles().clearSelection();
        });
        vistagol.getBtnRegistrarModificar().addActionListener(e -> {
            vistagol.getTblGoles().clearSelection();
        });
        //vistagol.getBtnBuscar().addActionListener(l -> buscarFK());
    }
     private void abrirDialogo(String ce) {

        vistagol.getJdgGoles().setLocationRelativeTo(null);
        vistagol.getJdgGoles().setSize(900, 900);
        vistagol.getJdgGoles().setTitle(ce);
        vistagol.getJdgGoles().setVisible(true);

        if (vistagol.getJdgGoles().getTitle().contentEquals("Crear")) {
            vistagol.getLblReMoGoles().setText("REGISTRO DE PARTIDOS");
            vistagol.getBtnRegistrarModificar().setText("REGISTRO DE PARTIDOS");

        } else if (vistagol.getJdgGoles().getTitle().contentEquals("Editar")) {
            vistagol.getLblReMoGoles().setText("MODIFICAR GOLES");
            LlenarDatos();
            vistagol.getBtnRegistrarModificar().setText("MODIFICAR GOLES");

        } else if (vistagol.getJdgGoles().getTitle().contentEquals("Eliminar")) {
            LlenarDatos();
            vistagol.getBtnRegistrarModificar().setText("ELIMINAR GOLES");

        }
    }
     public void LlenarDatos() {
        List<Clase_Gol> Listgol = modeloGol.listarGoles();
        int selectedRow = vistagol.getTblGoles().getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
        } else {
            String selectedId = vistagol.getTblGoles().getValueAt(selectedRow, 0).toString();
            Optional<Clase_Gol> matchingPartido = Listgol.stream()
                    .filter(p -> selectedId.equals(String.valueOf(p.getCod_partido())))
                    .findFirst();

            if (matchingPartido.isPresent()) {
                Clase_Gol p = matchingPartido.get();
                vistagol.getTxtcodGol().setText(String.valueOf(p.getCod_partido()));
                vistagol.getTxtdescripcion().setText(p.getDescripcion());
                vistagol.getTxtMinuto().setText(p.getMinuto());
                vistagol.getTxtcodGol().setEnabled(false);
                vistagol.getTxtCodJugador().setText(String.valueOf(p.getCod_jugador()));
                vistagol.getTxtCodPartido().setText(String.valueOf(p.getCod_partido()));
                vistagol.getTxtCodEquipo().setText(String.valueOf(p.getCod_equipo()));

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento válido de la tabla.");
            }
        }
    }
     public void buscar() {

        DefaultTableModel tabla = (DefaultTableModel) vistagol.getTblGoles().getModel();
        tabla.setNumRows(0);
        if (vistagol.getTxtBuscar().equals(null)) {
            System.out.println("pene");
        } else {

            List<Clase_Gol> par = modeloGol.BuscarGoles(Integer.parseInt(vistagol.txtBuscar.getText()));
            par.stream().forEach(p -> {

                Object datos[] = {p.getCod_gol(), p.getDescripcion(),p.getMinuto(),p.getCod_jugador(), p.getCod_partido(), p.getCod_equipo()};
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
        limpiartablas();
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

    private void limpiartablas() {

        vistagol.getTxtBuscar().setText("");

    }
     private void mandardatos() {

        String set = vistagol.getTxtbuscarcod().getText();

        if (vistagol.getJdggolestabla().getTitle().contentEquals("JUGADOR")) {
            int selectedRow = vistagol.getTblbuscar().getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistagol.getTblbuscar().getValueAt(selectedRow, 0).toString();
                vistagol.getTxtCodJugador().setText(selectedId);
                salirdialogo1();
            }
        } else if (vistagol.getJdggolestabla().getTitle().contentEquals("PARTIDOS")) {
            int selectedRow = vistagol.getTblbuscar().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistagol.getTblbuscar().getValueAt(selectedRow, 0).toString();
                vistagol.getTxtCodPartido().setText(selectedId);
                salirdialogo1();
            }

        } else if (vistagol.getJdggolestabla().getTitle().contentEquals("EQUIPOS")) {
            int selectedRow = vistagol.getTblbuscar().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vistagol.getTblbuscar().getValueAt(selectedRow, 0).toString();
                vistagol.getTxtCodEquipo().setText(selectedId);
                salirdialogo1();
            }
        } 
    }
    //--------------------------------------------------------CRUD--------------------------------------------------------------------------------------------
    //-------------------------------------------------------AGREGAR--------------------------------------------------------------------------------------------

    private void crearEditarPartido() {
        if (vistagol.getJdgGoles().getTitle().contentEquals("Crear")) {

            Modelo_Gol model = new Modelo_Gol();

            if (vistagol.getTxtCodPartido().equals("") || vistagol.getTxtCampeonato().equals("") || vistapar.getTxtEquipo1().equals("") || vistapar.getTxtEquipo2().equals("") || vistapar.getTxtEstadio().equals("") || vistapar.getTxtgrupo().equals("") || vistapar.getCmestado().getSelectedItem().equals("Ninguno") || vistapar.getDtfecha().getDate() == null) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {
                int codigopartido = Integer.valueOf(vistapar.getTxtCodPartido().getText());
                int codtemporada = Integer.valueOf(vistapar.getTxtCampeonato().getText());
                int equipo1 = Integer.valueOf(vistapar.getTxtEquipo1().getText());
                int equipo2 = Integer.valueOf(vistapar.getTxtEquipo2().getText());
                int estadio = Integer.valueOf(vistapar.getTxtEstadio().getText());
                String grupo = vistapar.getTxtgrupo().getText();
                vistapar.getDtfecha().getDate();
                boolean estado = false;

                model.setCod_partido(codigopartido);
                model.setCod_temporadafk(codtemporada);
                model.setCod_equipo1(equipo1);
                model.setCod_equipo2(equipo2);
                model.setCod_estadio(estadio);
                model.setGrupo(grupo);
                model.setFecha(vistapar.getDtfecha().getDate());

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
//-------------------------------------------------------MODIFICAR--------------------------------------------------------------------------------------------

        } else if (vistapar.getDialogRegistrarModificar().getTitle().contentEquals("Editar")) {

            Modelo_Gol model = new Modelo_Gol();

            if (vistapar.getTxtCodPartido().equals("") || vistapar.getTxtCampeonato().equals("") || vistapar.getTxtEquipo1().equals("") || vistapar.getTxtEquipo2().equals("") || vistapar.getTxtEstadio().equals("") || vistapar.getTxtgrupo().equals("") || vistapar.getCmestado().getSelectedItem().equals("Ninguno") || vistapar.getDtfecha().getDate() == null) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {
                int codigopartido = Integer.valueOf(vistapar.getTxtCodPartido().getText());
                int codtemporada = Integer.valueOf(vistapar.getTxtCampeonato().getText());
                int equipo1 = Integer.valueOf(vistapar.getTxtEquipo1().getText());
                int equipo2 = Integer.valueOf(vistapar.getTxtEquipo2().getText());
                int estadio = Integer.valueOf(vistapar.getTxtEstadio().getText());
                String grupo = vistapar.getTxtgrupo().getText();
                vistapar.getDtfecha().getDate();
                boolean estado = false;

                model.setCod_partido(codigopartido);
                model.setCod_temporadafk(codtemporada);
                model.setCod_equipo1(equipo1);
                model.setCod_equipo2(equipo2);
                model.setCod_estadio(estadio);
                model.setGrupo(grupo);
                model.setFecha(vistapar.getDtfecha().getDate());

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
                if (model.ModificarGol()) {
                    limpiar();
                    JOptionPane.showMessageDialog(vistagol, "DATOS CREADOS");
                    vistagol.getJdgGoles().setVisible(false);
                    cargaPartidos();
                } else {
                    JOptionPane.showMessageDialog(vistagol, "ERROR AL GRABAR DATOS");
                }

            }
//-------------------------------------------------------ELIMINAR--------------------------------------------------------------------------------------------

        } else if (vistagol.getJdgGoles().getTitle().contentEquals("Eliminar")) {
            Modelo_Gol model = new Modelo_Gol();
            model.setCod_partido(Integer.valueOf(vistagol.getTxtCodPartido().getText()));
            if (model.EliminarGol()) {

                limpiar();
                JOptionPane.showMessageDialog(vistagol, "DATOS ELIMINADOS");

                vistagol.getJdgGoles().setVisible(false);
                cargaPartidos();

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
            String[] rowData = {String.valueOf(p.getCod_partido()), String.valueOf(p.getCod_temporadafk()), String.valueOf(p.getCod_equipo1()), String.valueOf(p.getCod_equipo2()), String.valueOf(p.getCod_estadio())};
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
            String[] rowData = {String.valueOf(p.getCod_equipo()), String.valueOf(p.getNombre_equi())};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------CARGAR CAMPEONATOS EN LA TABLA--------------------------------------------------------------------------------------------

    private void cargajugadores() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistagol.getTblbuscar().getModel();
        mJtable.setNumRows(0);
        List<Clase_Jugador> listaC = modeloJug.ListaJugador();
        listaC.stream().forEach(p -> {
            String[] rowData = {String.valueOf(p.getCod_jugador()), String.valueOf(p.getNombnre1())};
            mJtable.addRow(rowData);
        }
        );
    }
}
