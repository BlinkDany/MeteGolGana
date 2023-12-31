/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.ConexionMySql;
import Modelo.Clase_Campeonato;

import Modelo.Modelo_Campeonato;
import Modelo.Clase_Temporada;
import Modelo.Modelo_Temporada;
import Vista.VistaCampeonato;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
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
//--------------------------------------------------Controlador--------------------------------//
public class Controlador_Campeonato {

    Modelo_Campeonato modelo;

    VistaCampeonato vista;

    ConexionMySql conSql = new ConexionMySql();
    
    Validaciones val = new Validaciones();

    public Controlador_Campeonato() {
    }

    public Controlador_Campeonato(Modelo_Campeonato modelo, VistaCampeonato vista) {

        this.modelo = modelo;

        this.vista = vista;

        vista.setVisible(true);

    }

//----------------------------------------------Iniciar Control-------------------------------------------------------------------------//
    public void iniciaControl() {
        // Configuración inicial de la vista
        vista.setTitle("Campeonatos");

        vista.getBtnAgregar().addActionListener(l -> abrirDialogo("Crear"));
        vista.getBtnModificar().addActionListener(l -> abrirEditarDialogo());
        vista.getBtnLimpiarDlg().addActionListener(l -> limpiar());
        vista.getBtnEliminar().addActionListener(l -> EliminarCampeonato());
        vista.getBtnCancelarDlg().addActionListener(l -> cerrarDialogo());
        vista.getBtnRegistrarModificarDlg().addActionListener(l -> crearEditarEliminarCampeonato());
        vista.getBtnBuscar().addActionListener(l -> buscar());
        vista.getBtnLimpiarBuscar().addActionListener(l -> limpiaBusca());
        vista.getBtnReporte().addActionListener(l -> reporteHorario());

        vista.getBtnAgregar().addActionListener(l -> {
            try {
                CargarID();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Partido.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
         vista.getTxtNombre().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char nombre = e.getKeyChar();
                boolean numeros = nombre >= 48 && nombre <= 57;
        boolean backspace = nombre == 8;
        boolean espacio = nombre == 32;
        boolean mayusculas = nombre >= 65 && nombre <= 90;
        boolean minusculas = nombre >= 97 && nombre <= 122;
        boolean punto = nombre == 46;
        boolean guion = nombre == 45;
        boolean tildesMinusculas = nombre >= 160 && nombre <= 163;
        boolean tildeE = nombre == 130;
        boolean ñ = nombre == 164;
        boolean Ñ = nombre == 165;
        boolean ETILDE = nombre == 144;
        boolean ATILDE = nombre == 181;
        boolean ITILDE = nombre == 214;
        boolean OTILDE = nombre == 224;
        boolean UTILDE = nombre == 233;

        if (!(mayusculas || backspace || ETILDE || ATILDE || ITILDE || OTILDE || UTILDE || Ñ || espacio || minusculas || tildeE || tildesMinusculas || numeros)) {
                    e.consume();
                   JOptionPane.showMessageDialog(null, "Dato Incorrecto");
            System.out.println("Dato es:" + nombre);
                }
            }
        });

        mostrarDatosTabla();

    }

//-----------------------------------------------------------Dialogo------------------------------------------------------------------------//
    private void cerrarDialogo() {

        vista.getDlgCampeonatos().dispose();

    }

    private void abrirEditarDialogo() {
        int selectedRow = vista.getTblCampeonato().getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un registro de la tabla",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            abrirDialogo("Editar");
            spn2();
        }
    }

    private void spn2() {
        vista.getSpnMaxEqipo().setValue(2);
    }

    private void abrirDialogo(String ce) {

        
        vista.getDlgCampeonatos().setSize(750, 600);
        vista.getDlgCampeonatos().setLocationRelativeTo(null);
        vista.getDlgCampeonatos().setTitle(ce);

        if (vista.getDlgCampeonatos().getTitle().equals("Crear")) {

            vista.getBtnRegistrarModificarDlg().setText("Registrar");
            vista.getLblReMoJugadores().setText("REGISTRO DE CAMPEONATOS");
            vista.getTxtCod().setEditable(false);

            limpiar();
            spn2();
        } else {

            vista.getBtnRegistrarModificarDlg().setText("Modificar");
            vista.getLblReMoJugadores().setText("MODIFICAR CAMPEONATOS");
            vista.getTxtCod().setEditable(false);

            llenarCamposDeTexto();

        }
        vista.getDlgCampeonatos().setVisible(true);
    }

//-------------------------------------------------------------CREAR MODIFICAR ELIMINAR---------------------------------------------------------------//
    private void crearEditarEliminarCampeonato() {
        String title = vista.getDlgCampeonatos().getTitle();

        if (title.equals("Crear")) {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(null, "Aún existen campos vacíos",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                // Asignar valores al modelo
                modelo.setNombre(vista.getTxtNombre().getText());
                modelo.setTipo_campeonato((String) vista.getCbxTipoCampeonato().getSelectedItem());
                modelo.setMax_equipos((int) vista.getSpnMaxEqipo().getValue());
                modelo.setEstado_elim(false);

                // Transformar de objeto a int
                int maxEqui = ((Number) vista.getSpnMaxEqipo().getValue()).intValue();

                if (modelo.InsertarCampeonato()) {
                    JOptionPane.showMessageDialog(null, "Datos guardados exitosamente",
                            "Advertencia", JOptionPane.INFORMATION_MESSAGE);

                    cerrarDialogo();
                    mostrarDatosTabla();

                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar la información",
                            "Advertencia", JOptionPane.ERROR_MESSAGE);
                }

            }

        } else if (title.equals("Editar")) {
            int selectedRow = vista.getTblCampeonato().getSelectedRow();

            if (selectedRow >= 0) { // Verificar si hay una fila seleccionada
                int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de modificar esta información?",
                        "Advertencia", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    int codigoCampeonato = (int) vista.getTblCampeonato().getValueAt(selectedRow, 0);
                    modelo.setCod_campeonato(codigoCampeonato);
                    modelo.setNombre(vista.getTxtNombre().getText());
                    modelo.setTipo_campeonato((String) vista.getCbxTipoCampeonato().getSelectedItem());
                    modelo.setMax_equipos((int) vista.getSpnMaxEqipo().getValue());

                    if (modelo.ModificarCampeonato()) {
                        JOptionPane.showMessageDialog(vista, "Datos modificados",
                                "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                        mostrarDatosTabla();
                        cerrarDialogo();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un campeonato para editar",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

//------------------------------------------------ Verifica si hay campos vacíos en el formulario----------------------------------------\\
    private boolean camposVacios() {
        return //vista.getTxtCodigo().getText().isEmpty()
                vista.getTxtNombre().getText().isEmpty()
                || vista.getCbxTipoCampeonato().getSelectedItem().equals("Selecciona:")
                || vista.getSpnMaxEqipo().getValue().equals(0);

    }
//---------------------------------LLENAR CAMPOS DE TEXTO DESDE TABLA------------------------------------------------\\

    public void llenarCamposDeTexto() {
        // Obtener la lista de productos
        List<Clase_Campeonato> listCamp = modelo.ListaCampeonato();

        // Recorrer la lista de productos
        listCamp.stream().forEach(p -> {
            // Verificar si el codigo del producto coincide con el codigo seleccionado en la tabla
            if (vista.getTblCampeonato().getValueAt(vista.getTblCampeonato().getSelectedRow(), 0).equals(p.getCod_campeonato())) {

                // Llenar los campos de la vista con los datos de producto seleccionado
                vista.getTxtCod().setText(String.valueOf(p.getCod_campeonato()));
                vista.getTxtNombre().setText(p.getNombre());
                vista.getCbxTipoCampeonato().setSelectedItem(p.getTipo_campeonato());
                vista.getSpnMaxEqipo().setValue(p.getMax_equipos());

            }
        });
    }

    //----------------------------------MOSTRAR DATOS TABLA---------------------------------------------------------\\
    public void mostrarDatosTabla() {

        DefaultTableModel tabla = (DefaultTableModel) vista.getTblCampeonato().getModel();
        tabla.setRowCount(0);

        // Obtener la lista de productos
        List<Clase_Campeonato> listCampeon = modelo.ListaCampeonato();

        // Recorrer la lista de productos
        listCampeon.stream().forEach(p -> {

            if (!p.isEstado_elim()) {

                Object[] datos = {p.getCod_campeonato(), p.getNombre(), p.getTipo_campeonato(), p.getMax_equipos()};

                // Agregar el objeto como una nueva fila a la tabla
                tabla.addRow(datos);

            }

        });

    }

//--------------------------------------------------------BUSCAR---------------------------------------------------\\
    public void buscar() {
        try {
            // Obtener el código ingresado en el campo de búsqueda
            String codigoTexto = vista.getTxtBuscar().getText();

            if (codigoTexto.isEmpty()) {
                // Mostrar mensaje de error si el campo está vacío
                JOptionPane.showMessageDialog(null, "Ingrese el código del campeonato que desea buscar",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int codigo = Integer.parseInt(codigoTexto);

                if (codigo == 0) {
                    // Mostrar mensaje de error si el código es igual a cero
                    JOptionPane.showMessageDialog(null, "El código ingresado no existe, ingrese un código diferente",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Obtener el modelo de la tabla
                    DefaultTableModel tabla = (DefaultTableModel) vista.getTblCampeonato().getModel();
                    // Limpiar el modelo de datos de la tabla
                    tabla.setNumRows(0);

                    // Obtener la lista de campeonatos
                    List<Clase_Campeonato> listaCampeonatos = modelo.ListaCampeonato();

                    // Utilizar un stream para procesar la lista de campeonatos
                    listaCampeonatos.stream()
                            // Filtrar los campeonatos por el código
                            .filter(p -> codigo == p.getCod_campeonato())
                            // Mapear cada campeonato filtrado a un objeto "datos" que contiene los valores deseados
                            .map(p -> {
                                // Crear un objeto "datos"
                                Object[] datos = {p.getCod_campeonato(), p.getNombre(), p.getTipo_campeonato(), p.getMax_equipos()};
                                return datos;
                            })
                            // Agregar cada objeto "datos" como una nueva fila al modelo de la tabla
                            .forEach(tabla::addRow);
                }
            }
        } catch (NumberFormatException e) {
            // Mostrar mensaje de error si el texto ingresado no es un número válido
            JOptionPane.showMessageDialog(null, "Ingrese un código de campeonato válido (número entero)",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//--------------------------------------------------------------LIMPIAR------------------------------------------------------------//
    public void limpiar() {

        vista.getTxtNombre().setText("");
        vista.getTxtBuscar().setText("");
        vista.getCbxTipoCampeonato().setSelectedIndex(0);
        vista.getSpnMaxEqipo().setValue(2);

    }

    private void limpiaBusca() {
        vista.getTxtBuscar().setText("");
        mostrarDatosTabla();
    }
//------------------------------------REPORTE------------------------------------------------------------------------------//

    public void reporteHorario() {

        int rta = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el código del campeonato "));
        //String rta2 = JOptionPane.showInputDialog("Ingrese el título de su reporte");
        try {
            ConexionMySql con = new ConexionMySql();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            String path = "src\\Reportes\\HorariosCamepeonato.jasper";

            Map parametro = new HashMap();
            parametro.put("CodigoCampeonato", rta);
            // parametro.put("titulo", rta2);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);

            JasperViewer vista = new JasperViewer(jprint, false);

            vista.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            vista.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Controlador_temporada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------\\
    public void EliminarCampeonato() {

        if (vista.getTblCampeonato().getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(null, "Seleccione el campeonato que desea eliminar ",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            int x = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar este campeonato?", "Advertecia!", JOptionPane.YES_NO_OPTION);
            if (x == 0) {

                modelo.setCod_campeonato(vista.getTblCampeonato().getValueAt(vista.getTblCampeonato().getSelectedRow(), 0).hashCode());

                if (modelo.OcultarCampeonato()) {

                    JOptionPane.showMessageDialog(null, "Campeonato eliminada exitosamente ",
                            "Eliminado", JOptionPane.INFORMATION_MESSAGE);

                    mostrarDatosTabla();

                } else {

                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar el campeonato ",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void CargarID() throws SQLException {
        vista.getTxtCod().setText(String.valueOf(modelo.CargarCodigoID()));
    }

}
