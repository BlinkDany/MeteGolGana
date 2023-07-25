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
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author tatip
 */
public class Controlador_temporada {

    Modelo_Temporada modelo;

    Modelo_Campeonato modeloCamp;

    VistaTemporada vista;

    ConexionMySql conSql = new ConexionMySql();

    public Controlador_temporada() {
    }

    public Controlador_temporada(Modelo_Temporada modelo, VistaTemporada vista, Modelo_Campeonato modeloCamp) {

        this.modelo = modelo;

        this.vista = vista;

        this.modeloCamp = modeloCamp;

        vista.setVisible(true);

    }

//----------------------------------------------Iniciar Control-------------------------------------------------------------------------//
    public void iniciaControl() {
        // Configuración inicial de la vista
        vista.setTitle("Campeonatos");

        vista.getBtnAgregar().addActionListener(l -> abrirDialogo("Crear"));
        vista.getBtnModificar().addActionListener(l -> abrirDialogo("Editar"));
        vista.getBtnModificar().addActionListener(l -> abrirEditarDialogo("Editar"));
        vista.getBtnEliminar().addActionListener(l -> EliminarTemmporada());
        vista.getBtnCancelarDlg().addActionListener(l -> cerrarDialogo());
        vista.getBtnRegistrarModificarDlg().addActionListener(l -> crearEditarEliminarTemporada());
        vista.getBtnBuscar().addActionListener(l -> buscar());
        vista.getBtnBuscarCampeonato().addActionListener(l -> buscarCampeonato() );
        
        
        // TABLA
        
        vista.getTblCampeonatoFK().addMouseListener(new MouseAdapter(){
            
            @Override
            
            public void mouseClicked (MouseEvent e ){
                
                llenarCamposDeTextoCampeonato();
                
            }
            
        });
        
         
         //-------------
         
         mostrarDatosTabla();
        mostrarDatosTablaCampeonato();

    }

//-----------------------------------------------------------Dialogo------------------------------------------------------------------------//
    private void cerrarDialogo() {

        vista.getDlgaTemporada().dispose();

    }

    private void abrirEditarDialogo(String editar) {
        int selectedRow = vista.getTblTemporada().getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un registro de la tabla de temporadas para poder modificarlo",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            abrirDialogo("Editar");
        }
    }

     private void abrirDialogo(String ce) {

        vista.getDlgaTemporada().setLocationRelativeTo(vista);
        vista.getDlgaTemporada().setSize(825,600 );
        vista.getDlgaTemporada().setTitle(ce);

        if (vista.getDlgaTemporada().getTitle().equals("Crear")) {
            
            

            if (vista.getTblCampeonatoFK().getSelectedRow() == -1 ) {

                JOptionPane.showMessageDialog(vista, "Seleccione el campeonato perteneciente a la temporada", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                vista.getBtnRegistrarModificarDlg().setText("Registrar");
                vista.getTxtCodigoCampeonatoFK().setEditable(true);
                llenarCamposDeTextoCampeonato();
                vista.getDlgaTemporada().setVisible(true);
                llenafecha();
                // crearFactura();
                mostrarDatosTabla();
                mostrarDatosTablaCampeonato();
            }
        }
    }

//-------------------------------------------------------------CREAR MODIFICAR ELIMINAR---------------------------------------------------------------//
    private void crearEditarEliminarTemporada() {
        String title = vista.getDlgaTemporada().getTitle();

        if (title.equals("Crear")) {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(null, "Aún existen campos vacíos",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                // Asignar valores al modelo
                modelo.setCodigoPk(Integer.valueOf(vista.getTxtCodigo().getText()));
              //  modelo.setFechaIni((Date) vista.getTxtFechaIni().getDate());
              
              // Convert java.util.Date to java.sql.Date
java.util.Date utilDate = vista.getTxtFechaIni().getDate();
java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

// Set the java.sql.Date object in your model
modelo.setFechaIni(sqlDate);
              
                //modelo.setFechaFin((Date) vista.getTxtFechaFin().getDate());
                
                // Convert java.util.Date to java.sql.Date
java.util.Date utilDateFin = vista.getTxtFechaFin().getDate();
java.sql.Date sqlDateFin = new java.sql.Date(utilDateFin.getTime());

// Set the java.sql.Date object in your model
modelo.setFechaFin(sqlDateFin);
                
                modelo.setCodCampeonatoFk(Integer.valueOf(vista.getTxtCodigoCampeonatoFK().getText()));
                modelo.setEstadoEli(false);

                if (modelo.InsertarTemporada()) {
                    JOptionPane.showMessageDialog(null, "Datos guardados exitosamente",
                            "Advertencia", JOptionPane.INFORMATION_MESSAGE);

                    vista.getDlgaTemporada().dispose();
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

                vista.getTxtCodigo().setEditable(true);

                modelo.setCodigoPk(Integer.valueOf(vista.getTxtCodigo().getText()));
                modelo.setCodCampeonatoFk(Integer.valueOf(vista.getTxtCodigoCampeonatoFK().getText()));
                modelo.setFechaIni((Date) vista.getTxtFechaIni().getDate());
                modelo.setFechaFin((Date) vista.getTxtFechaFin().getDate());

                if (modelo.ModificarTemporada()) {
                    JOptionPane.showMessageDialog(vista, "Datos modificados ",
                            "Advertencia", JOptionPane.INFORMATION_MESSAGE);

                    mostrarDatosTabla();
                }
            }

        }
    }

//------------------------------------------------ Verifica si hay campos vacíos en el formulario----------------------------------------\\
    private boolean camposVacios() {
        return// vista.getTxtCodigo().getText().isEmpty()
                vista.getTxtFechaFin().getDate() == null
                || vista.getTxtFechaIni().getDate().equals(null)
                || vista.getTxtCodigoCampeonatoFK().getText().equals(null);

    }
//---------------------------------LLENAR CAMPOS DE TEXTO DESDE TABLA------------------------------------------------\\

    public void llenarCamposDeTexto() {
        // Obtener la lista de productos
        List<Clase_Temporada> listTempo = modelo.ListaTemporada();

        // Recorrer la lista de productos
        listTempo.stream().forEach(p -> {
            // Verificar si el codigo del producto coincide con el codigo seleccionado en la tabla
            if (vista.getTblTemporada().getValueAt(vista.getTblTemporada().getSelectedRow(), 0).equals(p.getCodigoPk())) {

                // Llenar los campos de la vista con los datos de producto seleccionado
                vista.getTxtCodigo().setText(String.valueOf(p.getCodigoPk()));
                vista.getTxtFechaFin().setDate(p.getFechaFin());
                vista.getTxtFechaIni().setDate(p.getFechaIni());
                vista.getTxtCodigoCampeonatoFK().setText(String.valueOf(p.getCodCampeonatoFk()));

            }
        });
    }

    //----------------------------------MOSTRAR DATOS TABLA---------------------------------------------------------\\
    public void mostrarDatosTabla() {

        DefaultTableModel tabla = (DefaultTableModel) vista.getTblTemporada().getModel();
        tabla.setRowCount(0);

        // Obtener la lista de productos
        List<Clase_Temporada> listCamp = modelo.ListaTemporada();

        // Recorrer la lista de productos
        listCamp.forEach(p -> {

            // Crear un objeto datos con los valores de los campos correspondientes del producto
            Object[] datos = {p.getCodigoPk(), p.getFechaIni(), p.getFechaFin(), p.getCodCampeonatoFk()};

            // Agregar el objeto como una nueva fila a la tabla
            tabla.addRow(datos);
        });

        // Agregar ordenamiento y filtrado a la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabla);
        vista.getTblTemporada().setRowSorter(sorter);
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------\\
//--------------------------------------------------------BUSCAR---------------------------------------------------\\
    public void buscar() {
        // Obtener el código ingresado en el campo de búsqueda
        int codigo = Integer.parseInt(vista.getTxtBuscar().getText());

        if (codigo == 0) {
            // Mostrar mensaje de error si no se ingresa el código
            JOptionPane.showMessageDialog(null, "Ingrese el código de la temporada que desea buscar",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Obtener el modelo de la tabla
            DefaultTableModel tabla = (DefaultTableModel) vista.getTblTemporada().getModel();
            // Limpiar el modelo de datos de la tabla
            tabla.setNumRows(0);

            // Obtener la lista de productos
            List<Clase_Temporada> listTemp = modelo.ListaTemporada();

            // Utilizar un stream para procesar la lista de productos
            listTemp.stream()
                    // Filtrar los productos por el código
                    .filter(p -> codigo == p.getCodigoPk())
                    // Mapear cada producto filtrado a un objeto "datos" que contiene los valores deseados
                    .map(p -> {
                        // Crear un objeto "datos"
                        Object[] datos = {p.getCodigoPk(), p.getFechaIni(), p.getFechaFin(), p.getCodCampeonatoFk()};
                        return datos;
                    })
                    // Agregar cada objeto "datos" como una nueva fila al modelo de la tabla
                    .forEach(tabla::addRow);
        }
    }

    //------------------------------------------------CAMPEONATO-------------------------------------------------------\\
    //---------------------------------------------------MOSTRAR DATOS TABLA CAMPEONATO----------------------------------\\
   
    public void llenarCamposDeTextoCampeonato() {

        List<Clase_Campeonato> listaCampeonato = modeloCamp.ListaCampeonato();

        // Recorrer la lista de productos
        listaCampeonato.stream().forEach(p -> {
            // Verificar si el código del producto coincide con el código seleccionado en la tabla
            try {
                if (vista.getTblCampeonatoFK().getValueAt(vista.getTblCampeonatoFK().getSelectedRow(), 0).equals(p.getCod_campeonato())) {

                    vista.getTxtCodigoCampeonatoFK().setText(String.valueOf(p.getCod_campeonato()));                 
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }

    //----------------------------------MOSTRAR DATOS TABLA---------------------------------------------------------\\
    public void mostrarDatosTablaCampeonato() {

        DefaultTableModel tabla = (DefaultTableModel) vista.getTblCampeonatoFK().getModel();
        tabla.setRowCount(0);

        // Obtener la lista de productos
        List<Clase_Campeonato> listCampeon = modeloCamp.ListaCampeonato();

        // Recorrer la lista de productos
        listCampeon.stream().forEach(p -> {

            if (!p.isEstado_elim()) {

                Object[] datos = {p.getCod_campeonato(), p.getNombre(), p.getTipo_campeonato(), p.getMax_equipos()};

                // Agregar el objeto como una nueva fila a la tabla
                tabla.addRow(datos);

            }

        });

    }

    // ------------------------------------------------------------------------------------------ -----------------------------------\\
    //-------------------------------------------BUSCA CAMPEONATO-------------------------------------------------------\\
    public void buscarCampeonato() {
        try {
            // Obtener el código ingresado en el campo de búsqueda
            String codigoTexto = vista.getTxtBuscarCampeonato().getText();

            if (codigoTexto.isEmpty()) {
                // Mostrar mensaje de error si el campo está vacío
                JOptionPane.showMessageDialog(null, "Ingrese el código del campeonato que desea buscar",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int codigo = Integer.parseInt(codigoTexto);

                if (codigo == 0) {
                    // Mostrar mensaje de error si el código es igual a cero
                    JOptionPane.showMessageDialog(null, "Ingrese otro código diferente",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Obtener el modelo de la tabla
                    DefaultTableModel tabla = (DefaultTableModel) vista.getTblCampeonatoFK().getModel();
                    // Limpiar el modelo de datos de la tabla
                    tabla.setNumRows(0);

                    // Obtener la lista de campeonatos
                    List<Clase_Campeonato> listaCampeonatos = modeloCamp.ListaCampeonato();

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

    // ------------------------------------------------------------------------------------------ -----------------------------------\\
    //------------------------------------------------------FIN CAMPEONATO------------------------------------------------------------------------------\\ 
//--------------------------------------------------------------LIMPIAR------------------------------------------------------------//
    public void limpiar() {

        vista.getTxtCodigo().setText("");
        vista.getTxtFechaIni().setDateFormatString("");
        vista.getTxtFechaFin().setDateFormatString("");
        vista.getTxtCodigoCampeonatoFK().setText("");
        vista.getTxtBuscar().setText("");

    }

    private void limpiaActualizaBusca() {
        vista.getTxtBuscar().setText("");
        vista.getTxtBuscarCampeonato().setText("");
        
        mostrarDatosTabla();
        mostrarDatosTablaCampeonato();
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
    public void EliminarTemmporada() {

        if (vista.getTblTemporada().getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(null, "Seleccione temporada que desea eliminar ",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            int x = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar la factura?", "Advertecia!", JOptionPane.YES_NO_OPTION);
            if (x == 0) {

                modelo.setCodigoPk(vista.getTblTemporada().getValueAt(vista.getTblTemporada().getSelectedRow(), 0).hashCode());

                if (modelo.OcultarTemporada()) {

                    JOptionPane.showMessageDialog(null, "Temporada eliminada con exito ",
                            "Eliminado", JOptionPane.INFORMATION_MESSAGE);

                    mostrarDatosTabla();

                } else {

                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar la temporada ",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
     public void llenafecha() {
        vista.getTxtFechaIni().setDate(new java.sql.Date(System.currentTimeMillis()));
    }

}
