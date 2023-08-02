/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.ConexionMySql;
import Modelo.Clase_Campeonato;
import Modelo.Clase_Temporada;
import Modelo.Modelo_Temporada;
import Modelo.Modelo_Campeonato;
import Modelo.Clase_Temporada;
import Vista.VistaTemporada;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author tatip
 */
public class Controlador_temporada {

    // -------------------------------------------------------------------------------------------------------------------\\
    private Modelo_Campeonato modeloCam;

    private Modelo_Temporada modeloTemporada;

    private VistaTemporada vista;

    private ConexionMySql con = new ConexionMySql();

    public Controlador_temporada(Modelo_Temporada modelo, VistaTemporada vista, Modelo_Campeonato modeloCamp) {

        this.modeloTemporada = modelo;

        this.vista = vista;

        this.modeloCam = modeloCamp;

        vista.setVisible(true);

        this.vista = vista;
        vista.setVisible(true);
        vista.getTxtCodigoCampeonatoFK().setEnabled(false);
        vista.getTxtCodigoPk().setEnabled(false);

        cargarTemporadas();
    }

//-------------------------------------------------------CONTROL--------------------------------------------------------------------------------------------
    public void iniciaControl() {
        vista.getBtnAgregar().addActionListener(l -> abrirDialogo("Crear"));
        vista.getBtnModificar().addActionListener(l -> abrirDialogo("Editar"));
        vista.getBtnEliminar().addActionListener(l -> EliminarTemmporada());
        vista.getBtnCancelar().addActionListener(l -> salirdialogo());
        vista.getBtnCancelarDlg2().addActionListener(l -> salirdialogo1());
        vista.getBtnBuscarCampeonatoDlg().addActionListener(l -> buscarCampeonato());
        vista.getBtnRegistrarModificarDlg().addActionListener(l -> crearEditarEliminarTemporada());
        vista.getBtnCampeonato().addActionListener(l -> abrirDialogobusqueda("CAMPEONATOS"));
        vista.getBtnmandardatos().addActionListener(l -> mandardatos());
        vista.getBtnBuscar().addActionListener(l -> buscar());
        vista.getBtnLimpiar().addActionListener(l -> limpiarBuscar());
        vista.getBtnLimpiarDlg().addActionListener(l -> limpiarBuscar());
        vista.getBtnReporte().addActionListener(l -> reporteTemporada());

        vista.getBtnAgregar().addActionListener(l -> {
            try {
                CargarID();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Partido.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
//-------------------------------------------------------DIALOGO--------------------------------------------------------------------------------------------

    private void abrirDialogo(String ce) {

        vista.getDlgaTemporada().setSize(700, 550);
        vista.getDlgCampeonato().setLocationRelativeTo(null);
        vista.getDlgaTemporada().setTitle(ce);
        vista.getDlgaTemporada().setVisible(true);

        if (vista.getDlgaTemporada().getTitle().contentEquals("Crear")) {
            vista.getLblReMoJugadores().setText("REGISTRO TEMPORADAS");
            vista.getBtnRegistrarModificarDlg().setText("Registrar");

        } else if (vista.getDlgaTemporada().getTitle().contentEquals("Editar")) {

            vista.getLblReMoJugadores().setText("MODIFICAR TEMPORADAS");
            vista.getBtnRegistrarModificarDlg().setText("Modificar");

            llenarDatosTemporada();

        }
    }
    //-------------------------------------------------------DIALOGO 2--------------------------------------------------------------------------------------------

    private void abrirDialogobusqueda(String ce) {

        vista.getDlgCampeonato().setSize(780, 600);
        vista.getDlgCampeonato().setTitle(ce);
        vista.getDlgCampeonato().setVisible(true);

        if (vista.getDlgCampeonato().getTitle().contentEquals("CAMPEONATOS")) {
            vista.getLblbusqueda().setText("CAMPEONATOS");
            cargarCampeonato();

        }
    }
    //-------------------------------------------------------CODIGO --------------------------------------------------------------------------------------------

    private void CargarID() throws SQLException {
        vista.getTxtCodigoPk().setText(String.valueOf(modeloTemporada.CargarCodigoID()));
    }
//-------------------------------------------------------SETEAR DATOS--------------------------------------------------------------------------------------------

    private void mandardatos() {

        //String set = vista.getTxtbuscarcod().getText();
        if (vista.getDlgCampeonato().getTitle().contentEquals("CAMPEONATOS")) {
            int selectedRow = vista.getTblCampeonatoFK1().getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
            } else {
                String selectedId = vista.getTblCampeonatoFK1().getValueAt(selectedRow, 0).toString();
                vista.getTxtCodigoCampeonatoFK().setText(selectedId);
                salirdialogo1();
            }
        }

    }
    //--------------------------------------------------------CRUD--------------------------------------------------------------------------------------------
    //-------------------------------------------------------AGREGAR--------------------------------------------------------------------------------------------

    //-------------------------------------------------------------CREAR MODIFICAR ELIMINAR---------------------------------------------------------------//
    private void cerrarDialogo() {

        vista.getDlgaTemporada().dispose();

    }

    private boolean camposVacios() {
        return// vista.getTxtCodigo().getText().isEmpty()
                vista.getTxtFechaFin().getDate() == null
                || vista.getTxtFechaIni().getDate().equals(null)
                || vista.getTxtCodigoCampeonatoFK().getText().equals(null);

    }

    private void crearEditarEliminarTemporada() {
        String title = vista.getDlgaTemporada().getTitle();

        if (title.equals("Crear")) {

            if (camposVacios()) {
                JOptionPane.showMessageDialog(null, "Aún existen campos vacíos",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                // Convert java.util.Date to java.sql.Date
                java.util.Date fechaIni = vista.getTxtFechaIni().getDate();
                java.sql.Date sqlIni = new java.sql.Date(fechaIni.getTime());

                // Convert java.util.Date to java.sql.Date
                java.util.Date fechaFin = vista.getTxtFechaFin().getDate();
                java.sql.Date sqlFin = new java.sql.Date(fechaFin.getTime());

                if (sqlIni.before(sqlFin)) { // Verificar que fechaIni sea menor que fechaFin
                    // Set the java.sql.Date objects in your model
                    modeloTemporada.setFechaIni(sqlIni);
                    modeloTemporada.setFechaFin(sqlFin);

                    modeloTemporada.setCodCampeonatoFk(Integer.valueOf(vista.getTxtCodigoCampeonatoFK().getText()));
                    modeloTemporada.setEstadoEli(false);

                    if (modeloTemporada.InsertarTemporada()) {
                        JOptionPane.showMessageDialog(null, "Datos guardados exitosamente",
                                "Advertencia", JOptionPane.INFORMATION_MESSAGE);

                        vista.getDlgaTemporada().dispose();

                        cargarTemporadas();
                        limpiar();

                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar la información",
                                "Advertencia", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(vista, "La fecha de inicio debe ser anterior a la fecha de fin",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (title.equals("Editar")) {

            int selectedRow = vista.getTblTemporada().getSelectedRow();

            if (selectedRow >= 0) { // Verificar si hay una fila seleccionada
                int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de modificar esta información?",
                        "Advertencia", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    int codigoTemporada = (int) vista.getTblTemporada().getValueAt(selectedRow, 0);
                    modeloTemporada.setCodigoPk(codigoTemporada);

                    // Convert java.util.Date to java.sql.Date
                    java.util.Date fechaIni = vista.getTxtFechaIni().getDate();
                    java.sql.Date nuevoIni = new java.sql.Date(fechaIni.getTime());

                    // Convert java.util.Date to java.sql.Date
                    java.util.Date fechaFin = vista.getTxtFechaFin().getDate();
                    java.sql.Date nuevoFin = new java.sql.Date(fechaFin.getTime());

                    if (nuevoIni.before(nuevoFin)) { // Verificar que fechaIni sea menor que fechaFin
                        modeloTemporada.setFechaIni(nuevoIni);
                        modeloTemporada.setFechaFin(nuevoFin);
                        modeloTemporada.setCodCampeonatoFk(Integer.parseInt(vista.getTxtCodigoCampeonatoFK().getText()));

                        if (modeloTemporada.ModificarTemporada()) {
                            JOptionPane.showMessageDialog(vista, "Datos modificados",
                                    "Advertencia", JOptionPane.INFORMATION_MESSAGE);

                            cerrarDialogo();
                            cargarTemporadas();
                            limpiar();

                        }
                    } else {
                        JOptionPane.showMessageDialog(vista, "La fecha de inicio debe ser anterior a la fecha de fin",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

            } else {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una temporada y un campeonato  para editar",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void EliminarTemmporada() {

        if (vista.getTblTemporada().getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(null, "Seleccione temporada que desea eliminar ",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            int x = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar la temporada?", "Advertecia!", JOptionPane.YES_NO_OPTION);
            if (x == 0) {

                modeloTemporada.setCodigoPk(vista.getTblTemporada().getValueAt(vista.getTblTemporada().getSelectedRow(), 0).hashCode());

                if (modeloTemporada.OcultarTemporada()) {

                    JOptionPane.showMessageDialog(null, "Temporada eliminada con exito ",
                            "Eliminado", JOptionPane.INFORMATION_MESSAGE);

                    cargarTemporadas();

                } else {

                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar la temporada ",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    //-------------------------------------------------------CARGAR PARTIDOS EN LA TABLA--------------------------------------------------------------------------------------------

    
    public void cargarTemporadas() {

        DefaultTableModel tabla = (DefaultTableModel) vista.getTblTemporada().getModel();
        tabla.setNumRows(0);

        List<Clase_Temporada> listTemporada = modeloTemporada.ListaTemporada();
        List<Clase_Campeonato> listCampeonato = modeloCam.ListaCampeonato();
        listTemporada.stream().forEach(p -> {
            listCampeonato.stream().forEach(l -> {

                if (p.getCodCampeonatoFk()== l.getCod_campeonato()) {

                    Object datos[] = {p.getCodigoPk(), p.getFechaIni(), p.getFechaFin(), l.getNombre()};
                    tabla.addRow(datos);
                }
            });
        });
    }

    public void cargarCampeonato() {

        DefaultTableModel tabla = (DefaultTableModel) vista.getTblCampeonatoFK1().getModel();
        tabla.setRowCount(0);

        // Obtener la lista de productos
        List<Clase_Campeonato> listCampeon = modeloCam.ListaCampeonato();

        // Recorrer la lista de productos
        listCampeon.stream().forEach(p -> {

            if (!p.isEstado_elim()) {

                Object[] datos = {p.getCod_campeonato(), p.getNombre(), p.getTipo_campeonato(), p.getMax_equipos()};

                // Agregar el objeto como una nueva fila a la tabla
                tabla.addRow(datos);

            }

        });

    }

//-------------------------------------------------------LLENAR DATOS--------------------------------------------------------------------------------------------
    public void llenarDatosTemporada() {

        List<Clase_Temporada> listTempo = modeloTemporada.ListaTemporada();
        int selectedRow = vista.getTblTemporada().getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");

        } else {

            String selectedId = vista.getTblTemporada().getValueAt(selectedRow, 0).toString();
            Optional<Clase_Temporada> coincidenciaTemporada = listTempo.stream()
                    .filter(p -> selectedId.equals(String.valueOf(p.getCodigoPk())))
                    .findFirst();

            if (coincidenciaTemporada.isPresent()) {
                Clase_Temporada p = coincidenciaTemporada.get();
                vista.getTxtCodigoPk().setText(String.valueOf(p.getCodCampeonatoFk()));
                vista.getTxtFechaFin().setDate(p.getFechaFin());
                vista.getTxtFechaIni().setDate(p.getFechaIni());
                vista.getTxtCodigoCampeonatoFK().setText(String.valueOf(p.getCodCampeonatoFk()));

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento válido de la tabla.");
            }
        }
    }

    //--------------------------------------------------------BUSCAR---------------------------------------------------\\
    public void buscar() {
        try {
            // Obtener el código ingresado en el campo de búsqueda
            String codigoTexto = vista.getTxtBuscar().getText();

            if (codigoTexto.isEmpty()) {
                // Mostrar mensaje de error si no se ingresa el código
                JOptionPane.showMessageDialog(null, "Ingrese el código de la temporada que desea buscar",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int codigo = Integer.parseInt(codigoTexto);
                boolean[] temporadaEncontrada = {false}; // Array de un solo elemento

                if (codigo == 0) {
                    // Mostrar mensaje de error si el código es igual a cero
                    JOptionPane.showMessageDialog(null, "El código ingresado no existe, ingrese un código diferente",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Obtener el modelo de la tabla
                    DefaultTableModel tabla = (DefaultTableModel) vista.getTblTemporada().getModel();
                    // Limpiar el modelo de datos de la tabla
                    tabla.setNumRows(0);

                    // Obtener la lista de temporadas
                    List<Clase_Temporada> listTemp = modeloTemporada.ListaTemporada();

                    // Utilizar un stream para procesar la lista de temporadas
                    listTemp.stream()
                            // Filtrar las temporadas por el código
                            .filter(p -> codigo == p.getCodigoPk())
                            // Mapear cada temporada filtrada a un objeto "datos" que contiene los valores deseados
                            .map(p -> {
                                // Obtener el nombre del campeonato correspondiente al código

                                // Crear un objeto "datos" con el nombre del campeonato en lugar del código
                                Object[] datos = {p.getCodigoPk(), p.getFechaIni(), p.getFechaFin(), p.getCodCampeonatoFk()};
                                temporadaEncontrada[0] = true; // Se encontró la temporada
                                return datos;
                            })
                            // Agregar cada objeto "datos" como una nueva fila al modelo de la tabla
                            .forEach(tabla::addRow);

                    if (!temporadaEncontrada[0]) {
                        // Mostrar mensaje si la temporada no fue encontrada
                        JOptionPane.showMessageDialog(null, "El código ingresado no existe en la tabla de temporadas",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (NumberFormatException e) {
            // Mostrar mensaje de error si el texto ingresado no es un número válido
            JOptionPane.showMessageDialog(null, "Ingrese un código de temporada válido (número entero)",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//-------------------------------------------BUSCA CAMPEONATO-------------------------------------------------------\\

    public void buscarCampeonato() {
        try {
            // Obtener el código ingresado en el campo de búsqueda
            String codigoTexto = vista.getTxtBuscarCampeonato1().getText();

            if (codigoTexto.isEmpty()) {
                // Mostrar mensaje de error si el campo está vacío
                JOptionPane.showMessageDialog(null, "Ingrese el código del campeonato que desea buscar",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int codigo = Integer.parseInt(codigoTexto);
                boolean[] campeonatoEncontrado = {false}; // Array de un solo elemento

                if (codigo == 0) {
                    // Mostrar mensaje de error si el código es igual a cero
                    JOptionPane.showMessageDialog(null, "El código ingresado no existe, ingrese un código diferente",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Obtener el modelo de la tabla
                    DefaultTableModel tabla = (DefaultTableModel) vista.getTblCampeonatoFK1().getModel();
                    // Limpiar el modelo de datos de la tabla
                    tabla.setNumRows(0);

                    // Obtener la lista de campeonatos
                    List<Clase_Campeonato> listaCampeonatos = modeloCam.ListaCampeonato();

                    // Utilizar un stream para procesar la lista de campeonatos
                    listaCampeonatos.stream()
                            // Filtrar los campeonatos por el código
                            .filter(p -> codigo == p.getCod_campeonato())
                            // Mapear cada campeonato filtrado a un objeto "datos" que contiene los valores deseados
                            .map(p -> {
                                // Crear un objeto "datos"
                                Object[] datos = {p.getCod_campeonato(), p.getNombre(), p.getTipo_campeonato(), p.getMax_equipos()};
                                campeonatoEncontrado[0] = true; // Se encontró el campeonato
                                return datos;
                            })
                            // Agregar cada objeto "datos" como una nueva fila al modelo de la tabla
                            .forEach(tabla::addRow);

                    if (!campeonatoEncontrado[0]) {
                        // Mostrar mensaje si el campeonato no fue encontrado
                        JOptionPane.showMessageDialog(null, "El código ingresado no existe en la tabla de campeonatos",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (NumberFormatException e) {
            // Mostrar mensaje de error si el texto ingresado no es un número válido
            JOptionPane.showMessageDialog(null, "Ingrese un código de campeonato válido (número entero)",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ------------------------------------------------------------------------------------------ -----------------------------------\\
//------------------------------------------------------- VALIDAR ENTRADA--------------------------------------------------------------------------------------------
    private void validarEntrada(java.awt.event.KeyEvent evt) {
        char dato = evt.getKeyChar();
        boolean numeros = dato >= 48 && dato <= 57;
        boolean backspace = dato == 8;

        if (!(backspace || numeros)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar NUMEROS");
        }
        if (vista.getTxtBuscar().getText().trim().length() > 3) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (4)");
        }
    }

//------------------------------------------------------- SALIR DEL DIALOGO--------------------------------------------------------------------------------------------
    public void salirdialogo() {

        vista.getDlgaTemporada().setVisible(false);
    }
//------------------------------------------------------- SALIR DEL DIALOGO DE TABLAS--------------------------------------------------------------------------------------------

    public void salirdialogo1() {

        vista.getDlgCampeonato().setVisible(false);
    }

//------------------------------------------------------- LIMPIAR--------------------------------------------------------------------------------------------
    private void limpiar() {

        vista.getTxtCodigoPk().setText("");
        vista.getTxtFechaFin().setDate(null);
        vista.getTxtFechaIni().setDate(null);
        vista.getTxtCodigoCampeonatoFK().setText("");

    }
//------------------------------------------------------- LIMPIAR--------------------------------------------------------------------------------------------

    private void limpiarBuscar() {

        vista.getTxtBuscarCampeonato1().setText("");
        vista.getTxtBuscar().setText("");
        cargarCampeonato();
        cargarTemporadas();

    }

    //--------------------------------------------------REPORTE--------------------------------------------------\\
    private void reporte() {

        try {

            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("src\\Reportes\\CampeonatoTemporada.jasper"));
            Map<String, Object> params = new HashMap<String, Object>();
            JasperPrint jasPrint = JasperFillManager.fillReport(jr, params, con.getCon());
            JasperViewer jasview = new JasperViewer(jasPrint, false);
            jasview.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jasview.setVisible(true);

        } catch (JRException ex) {

            Logger.getLogger(Controlador_temporada.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void reporteTemporada() {

        //int rta =Integer.valueOf(JOptionPane.showInputDialog("Ingrese la cantidad mínima referente para el stock")) ;
        //String rta2 = JOptionPane.showInputDialog("Ingrese el título de su reporte");
        try {
            ConexionMySql con = new ConexionMySql();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            String path = "src\\Reportes\\CampeonatoTemporada.jasper";

            Map parametro = new HashMap();
            //parametro.put("cantidad", rta);
            // parametro.put("titulo", rta2);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);

            JasperViewer vista = new JasperViewer(jprint, false);

            vista.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            vista.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Controlador_temporada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    //---------------------------------------------------------------------------------------------------------------------------\\   
    public void llenafecha() {
        vista.getTxtFechaIni().setDate(new java.sql.Date(System.currentTimeMillis()));
    }

}


