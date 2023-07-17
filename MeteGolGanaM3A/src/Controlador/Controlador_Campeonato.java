/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.ConexionMySql;
import Modelo.Clase_Campeonato;
import Modelo.Modelo_Campeonato;
import Vista.VistaCampeonato;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
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

/**
 *
 * @author tatip
 */
//--------------------------------------------------Controlador--------------------------------//
public class Controlador_Campeonato {

    Modelo_Campeonato modelo;

    VistaCampeonato vista;

    ConexionMySql conSql = new ConexionMySql();

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
        vista.getBtnModificar().addActionListener(l -> abrirDialogo("Editar"));
        vista.getBtnEliminar().addActionListener(l -> abrirDialogo("Eliminar"));
        vista.getBtnCancelarDlg().addActionListener(l -> cerrarDialogo());
        vista.getBtnRegistrarModificarDlg().addActionListener(l -> crearEditarEliminarCampeonato());
        
        mostrarDatosTabla();
        
        //vista.getLblBuscar().addAncestorListener(listener);
        
        /*
        // Asociación de acciones a los botones
        //vista.getBtnImprimir().addActionListener(l -> reporteProducto());
        vista.getBtnEliminar().addActionListener(l -> Eliminar());
        vista.getBtnLimpiarDlg().addActionListener(l -> limpiar());
        vista.getBtnConsultar().addActionListener(l -> buscar());
        vista.getBtnExaminar().addActionListener(l -> Foto());
        vista.getBtnSalir().addActionListener(l -> vista.dispose());
        vista.getBtnCrear().addActionListener(l -> abrirDialogo("Crear"));
        vista.getBtnEditar().addActionListener(l -> abrirEditarDialogo());
        vista.getBtnCerrarDlg().addActionListener(l -> cerrarDialogo());
        vista.getBtnLimpiaBusca().addActionListener(l -> limpiaBusca());

        // Validaciones de entrada para los campos de texto
        vista.getTxtCodigoDlg().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                Validaciones.Enteros(evt, vista.getTxtCodigoDlg().getText());
            }
        });

        vista.getTxtNombreDlg().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                Validaciones.validaNomNum(evt, vista.getTxtNombreDlg().getText());
            }
        });

        vista.getTxtPrecioDlg().addKeyListener(new KeyAdapter() {
            @Override

            public void keyTyped(KeyEvent evt) {
                Validaciones.Decimales(evt, vista.getTxtPrecioDlg().getText());
            }
        });

        // Asociación de acción al botón de edición en el diálogo
        vista.getBtnEditarDLG().addActionListener(l -> crearEditarProductos());

        // Mostrar los datos iniciales en la tabla
        mostrarDatosTabla();
   */ }

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
        }
    }

        private void abrirDialogo(String ce) {

        vista.getDlgCampeonatos().setLocationRelativeTo(vista);
        vista.getDlgCampeonatos().setSize(500, 500);
        vista.getDlgCampeonatos().setTitle(ce);

        if (vista.getDlgCampeonatos().getTitle().equals("Crear")) {

            vista.getBtnRegistrarModificarDlg().setText("Registrar");
            limpiar();
            vista.getTxtCodigo().setEnabled(false);
        } else {

            vista.getBtnRegistrarModificarDlg().setText("Modificar");
            llenarCamposDeTexto();
            vista.getTxtCodigo().setEnabled(false);

        }
        vista.getDlgCampeonatos().setVisible(true);
    }
    
   /* private void abrirDialogo(String ce) {

        vista.getDialogRegistrarModificar().setLocationRelativeTo(null);
        vista.getDialogRegistrarModificar().setSize(900, 900);
        vista.getDialogRegistrarModificar().setTitle(ce);
        
        
        if (vista.getDialogRegistrarModificar().getTitle().contentEquals("Crear")) {
            vista.getLblReMoJugadores().setText("REGISTRO DE PARTIDOS");
        } else if (vista.getDialogRegistrarModificar().getTitle().contentEquals("Editar")) {
            
            vista.getLblReMoJugadores().setText("MODIFICAR PARTIDOS");
            llenarCamposDeTexto();

        } else if (vista.getDialogRegistrarModificar().getTitle().contentEquals("Eliminar")) {
            
            llenarCamposDeTexto();
            
        }
        
        vista.getDialogRegistrarModificar().setVisible(true);
        
    }*/

//-------------------------------------------------------------CREAR MODIFICAR ELIMINAR---------------------------------------------------------------//
    private void crearEditarEliminarCampeonato() {
        String title = vista.getDlgCampeonatos().getTitle();

        if (title.equals("Crear")) {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(null, "Aún existen campos vacíos",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                // Asignar valores al modelo
                modelo.setCod_campeonato(Integer.valueOf(vista.getTxtCodigo().getText()));
                modelo.setNombre(vista.getTxtNombre().getText());
                modelo.setTipo_campeonato((String) vista.getCbxTipoCampeonato().getSelectedItem());
                modelo.setEstado_elim(1);

//transformar de objeto a int
                int stock = ((Number) vista.getSpnMaxEqipo().getValue()).intValue();

                if (modelo.InsertarCampeonato()) {
                    JOptionPane.showMessageDialog(null, "Datos guardados exitosamente",
                            "Advertencia", JOptionPane.INFORMATION_MESSAGE);

                    vista.getDlgCampeonatos().dispose();
                    mostrarDatosTabla();

                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar la información",
                            "Advertencia", JOptionPane.ERROR_MESSAGE);
                }

            }

        } else if (title.equals("Editar")) {
            int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de modificar esta información?",
                    "Advertencia", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {

                vista.getTxtCodigo().setEditable(false);

                modelo.setCod_campeonato(Integer.valueOf(vista.getTxtCodigo().getText()));
                modelo.setNombre(vista.getTxtNombre().getText());
                modelo.setTipo_campeonato((String) vista.getCbxTipoCampeonato().getSelectedItem());

                int stock = ((Number) vista.getSpnMaxEqipo().getValue()).intValue();

                if (modelo.ActualizarCampeonato()) {
                    JOptionPane.showMessageDialog(vista, "Datos modificados ",
                            "Advertencia", JOptionPane.INFORMATION_MESSAGE);

                    mostrarDatosTabla();
                }
            }

        } else if (vista.getDlgCampeonatos().getTitle().contentEquals("Eliminar")) {

            Modelo_Campeonato model = new Modelo_Campeonato();
            model.setCod_campeonato(Integer.valueOf(vista.getTxtCodigo().getText()));

            if (model.EliminarCampeonato()) {

                limpiar();
                JOptionPane.showMessageDialog(vista, "Datos eliminados");

                vista.getDlgCampeonatos().setVisible(false);
                mostrarDatosTabla();

            } else {
                JOptionPane.showMessageDialog(vista, "Error al eliminar los datos");
            }
        }
    }

    
//------------------------------------------------ Verifica si hay campos vacíos en el formulario----------------------------------------\\
    private boolean camposVacios() {
        return vista.getTxtCodigo().getText().isEmpty()
                || vista.getTxtNombre().getText().isEmpty()
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
                vista.getTxtCodigo().setText(String.valueOf(p.getCod_campeonato()));
                vista.getTxtCodigo().setText(p.getNombre());
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
        List<Clase_Campeonato> listCamp = modelo.ListaCampeonato();

        // Recorrer la lista de productos
        listCamp.forEach(p -> {

            // Crear un objeto datos con los valores de los campos correspondientes del producto
            Object[] datos = {p.getCod_campeonato(), p.getNombre(), p.getTipo_campeonato(), p.getMax_equipos()};

            // Agregar el objeto como una nueva fila a la tabla
            tabla.addRow(datos);
        });

        // Agregar ordenamiento y filtrado a la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        vista.getTblCampeonato().setRowSorter(sorter);
    }

//--------------------------------------------------------BUSCAR---------------------------------------------------\\
    public void buscar() {
        // Obtener el código ingresado en el campo de búsqueda
        int codigo = Integer.parseInt(vista.getTxtBuscar().getText());

        if (codigo == 0) {
            // Mostrar mensaje de error si no se ingresa el código
            JOptionPane.showMessageDialog(null, "Ingrese el código del campeonato que desea buscar",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Obtener el modelo de la tabla
            DefaultTableModel tabla = (DefaultTableModel) vista.getTblCampeonato().getModel();
            // Limpiar el modelo de datos de la tabla
            tabla.setNumRows(0);

            // Obtener la lista de productos
            List<Clase_Campeonato> listaProductos = modelo.ListaCampeonato();

            // Utilizar un stream para procesar la lista de productos
            listaProductos.stream()
                    // Filtrar los productos por el código
                    .filter(p -> codigo == p.getCod_campeonato())
                    // Mapear cada producto filtrado a un objeto "datos" que contiene los valores deseados
                    .map(p -> {
                        // Crear un objeto "datos"
                        Object[] datos = {p.getCod_campeonato(), p.getNombre(), p.getTipo_campeonato(), p.getMax_equipos()};
                        return datos;
                    })
                    // Agregar cada objeto "datos" como una nueva fila al modelo de la tabla
                    .forEach(tabla::addRow);
        }
    }

//--------------------------------------------------------------LIMPIAR------------------------------------------------------------//
    public void limpiar() {

        vista.getTxtNombre().setText("");
        vista.getTxtCodigo().setText("");
        vista.getTxtBuscar().setText("");
        vista.getCbxTipoCampeonato().setSelectedIndex(0);
        vista.getSpnMaxEqipo().setValue(2);

    }

    private void limpiaBusca() {
        vista.getTxtBuscar().setText("");
        mostrarDatosTabla();
    }

    /* private void reporte(){
    try{
        
        JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/reporteProductos.jasper"));
        Map<String,Object> params = new HashMap<String, Object>();
        JasperPrint jasPrint =JasperFillManager.fillReport(jr, params, conSql.getCon());
        JasperViewer jasview = new JasperViewer(jasPrint,false);
        jasview.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jasview.setVisible(true);
    }catch(JRException ex){
        Logger.getLogger(ControladorFactura.class.getName()).log(Level.SEVERE, null, ex);

}
}
     
      public void reporteProducto() {

       
          int rta =Integer.valueOf(JOptionPane.showInputDialog("Ingrese la cantidad mínima referente para el stock")) ;
          
         String rta2 = JOptionPane.showInputDialog("Ingrese el título de su reporte");
          
        try {
                        ConeccionPG con = new ConeccionPG();
                        Connection conn = con.getConnection();

                        JasperReport reporte = null;
                        String path = "src\\reportes\\reporteProductos.jasper";

                        Map parametro = new HashMap();
                        parametro.put("cantidad", rta);
                        parametro.put("titulo", rta2);

                        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

                        JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);

                        JasperViewer vista = new JasperViewer(jprint, false);

                        vista.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                        vista.setVisible(true);
                    } catch (JRException ex) {
                        Logger.getLogger(ControladorPersonas.class.getName()).log(Level.SEVERE, null, ex);
 }
    }*/
}
