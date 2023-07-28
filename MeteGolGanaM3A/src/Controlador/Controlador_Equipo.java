package Controlador;

import Modelo.Clase_Equipo;
import Modelo.ModeloEquipos;
import Vista.VistaEquipos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
public class Controlador_Equipo {

    private ModeloEquipos modeloEqui;
    private VistaEquipos vistaequi;

    public Controlador_Equipo(ModeloEquipos modeloEqui, VistaEquipos vistaequi) {
        this.modeloEqui = modeloEqui;
        this.vistaequi = vistaequi;
        vistaequi.setVisible(true);
        cargarEquipos();
    }

    public void iniciaControl() {
        vistaequi.getBtnAgregar().addActionListener(l -> abrirDialogo("Crear"));
        vistaequi.getBtnModificar().addActionListener(l -> abrirDialogo("Editar"));
        vistaequi.getBtnEliminar().addActionListener(l -> abrirDialogo("Eliminar"));
        vistaequi.getBtnCancelar().addActionListener(l -> salirdialogo());
        vistaequi.getBtnRegistrarModificar().addActionListener(l -> crearEditarEquipo());
        vistaequi.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscar();
            }
        });
        vistaequi.getTxtBuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarEntrada(evt);
            }
        });
        vistaequi.getBtnCancelar().addActionListener(e -> {
            vistaequi.getTblEquipos().clearSelection();
        });
        vistaequi.getBtnCancelar().addActionListener(e -> {
            vistaequi.getTblEquipos().clearSelection();
        });
        vistaequi.getBtnRegistrarModificar().addActionListener(e -> {
            vistaequi.getTblEquipos().clearSelection();
        });
        vistaequi.getBtnAgregar().addActionListener(l -> {
            try {
                CargarID();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Equipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    /*public void buscar() {
        if (vistaequi.getTxtBuscar().getText().equals("")) {
            cargarEquipos();
        } else {
            DefaultTableModel tabla = (DefaultTableModel) vistaequi.getTblEquipos().getModel();
            tabla.setNumRows(0);

            List<Clase_Equipo> par = modeloEqui.BuscarEquipo(vistaequi.txtBuscar.getText());
            par.stream().forEach(p -> {

                Object datos[] = {p.getCod_equipo(), p.getNombre_equi(), p.getAnio_fundacion(), p.getCiudad()};
                tabla.addRow(datos);
            });
        }
    }*/
    
    public void buscar() {
        // Obtener el código ingresado en el campo de búsqueda
        int codigo = Integer.parseInt(vistaequi.getTxtBuscar().getText());

        if (codigo == 0) {
            // Mostrar mensaje de error si no se ingresa el código
            JOptionPane.showMessageDialog(null, "Ingrese el código de la temporada que desea buscar",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Obtener el modelo de la tabla
            DefaultTableModel tabla = (DefaultTableModel) vistaequi.getTblEquipos().getModel();
            // Limpiar el modelo de datos de la tabla
            tabla.setNumRows(0);

            // Obtener la lista de productos
            List<Clase_Equipo> listTemp = modeloEqui.listarEquipos();

            // Utilizar un stream para procesar la lista de productos
            listTemp.stream()
                    // Filtrar los productos por el código
                    .filter(p -> codigo == p.getCod_equipo())
                    // Mapear cada producto filtrado a un objeto "datos" que contiene los valores deseados
                    .map(p -> {
                        // Crear un objeto "datos"
                        Object[] datos = {p.getCod_equipo(), p.getNombre_equi(), p.getAnio_fundacion(), p.getCiudad()};
                        return datos;
                    })
                    // Agregar cada objeto "datos" como una nueva fila al modelo de la tabla
                    .forEach(tabla::addRow);
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
        if (vistaequi.getTxtBuscar().getText().trim().length() > 3) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Superior al limite (4)");
        }
    }

    private void CargarID() throws SQLException {
        vistaequi.getTxtcodequipo().setText(String.valueOf(modeloEqui.CargarCodigoID()));
    }

    private void abrirDialogo(String ce) {

        vistaequi.getJdlgEquipos().setLocationRelativeTo(null);
        vistaequi.getJdlgEquipos().setSize(900, 500);
        vistaequi.getJdlgEquipos().setTitle(ce);
        vistaequi.getJdlgEquipos().setVisible(true);

        if (vistaequi.getJdlgEquipos().getTitle().contentEquals("Crear")) {
            vistaequi.getLblReMoEquipos().setText("REGISTRO DE EQUIPOS");

        } else if (vistaequi.getJdlgEquipos().getTitle().contentEquals("Editar")) {
            vistaequi.getLblReMoEquipos().setText("MODIFICAR EQUIPOS");
            LlenarDatos();

        } else if (vistaequi.getJdlgEquipos().getTitle().contentEquals("Eliminar")) {
            LlenarDatos();
        }
    }

    private void crearEditarEquipo() {
        if (vistaequi.getJdlgEquipos().getTitle().contentEquals("Crear")) {

            ModeloEquipos model = new ModeloEquipos();

            if (vistaequi.getTxtcodequipo().equals("") || vistaequi.getTxtNombreequipo().equals("") || vistaequi.getJdcaniofundacion().equals("") || vistaequi.getTxtCiudadequipo().equals("")) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {
                int codigoequipo = Integer.valueOf(vistaequi.getTxtcodequipo().getText());
                String nombreequi = vistaequi.getTxtNombreequipo().getText();
                String ciudadequi = vistaequi.getTxtCiudadequipo().getText();
                int estado = 0;

                model.setCod_equipo(codigoequipo);
                model.setNombre_equi(nombreequi);
                model.setAnio_fundacion(new java.sql.Date(vistaequi.getJdcaniofundacion().getDate().getTime()));
                model.setCiudad(ciudadequi);
                model.setEstado_elim(estado);
                if (model.InsertarEquipo()) {
                    limpiar();
                    JOptionPane.showMessageDialog(vistaequi, "DATOS CREADOS");
                    vistaequi.getJdlgEquipos().setVisible(false);
                    cargarEquipos();
                } else {
                    JOptionPane.showMessageDialog(vistaequi, "ERROR AL GRABAR DATOS");
                }
            }
//-------------------------------------------------------MODIFICAR--------------------------------------------------------------------------------------------

        } else if (vistaequi.getJdlgEquipos().getTitle().contentEquals("Editar")) {

            ModeloEquipos model = new ModeloEquipos();

            if (vistaequi.getTxtcodequipo().equals("") || vistaequi.getTxtNombreequipo().equals("") || vistaequi.getJdcaniofundacion().equals("") || vistaequi.getTxtCiudadequipo().equals("")) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {
                int codigoequi = Integer.valueOf(vistaequi.getTxtcodequipo().getText());
                String nombreequi = vistaequi.getTxtNombreequipo().getText();
                String ciudadequi = vistaequi.getTxtCiudadequipo().getText();

                model.setCod_equipo(codigoequi);
                model.setNombre_equi(nombreequi);
                model.setAnio_fundacion(new java.sql.Date(vistaequi.getJdcaniofundacion().getDate().getTime()));
                model.setCiudad(ciudadequi);
                if (model.ModificarEquipo()) {
                    limpiar();
                    JOptionPane.showMessageDialog(vistaequi, "DATOS CREADOS");
                    vistaequi.getJdlgEquipos().setVisible(false);
                    cargarEquipos();
                } else {
                    JOptionPane.showMessageDialog(vistaequi, "ERROR AL GRABAR DATOS");
                }

            }
//-------------------------------------------------------ELIMINAR--------------------------------------------------------------------------------------------

        } else if (vistaequi.getJdlgEquipos().getTitle().contentEquals("Eliminar")) {
            ModeloEquipos model = new ModeloEquipos();
            model.setCod_equipo(Integer.valueOf(vistaequi.getTxtcodequipo().getText()));
            if (model.EliminarEquipo()) {

                limpiar();
                JOptionPane.showMessageDialog(vistaequi, "DATOS ELIMINADOS");

                vistaequi.getJdlgEquipos().setVisible(false);
                cargarEquipos();

            } else {
                JOptionPane.showMessageDialog(vistaequi, "ERROR AL GRABAR DATOS");
            }

        }
    }

//-------------------------------------------------------CARGAR PARTIDOS EN LA TABLA--------------------------------------------------------------------------------------------
    private void cargarEquipos() {
        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) vistaequi.getTblEquipos().getModel();
        mJtable.setNumRows(0);
        List<Clase_Equipo> listaE = modeloEqui.listarEquipos();
        listaE.stream().forEach(p -> {
            String[] rowData = {String.valueOf(p.getCod_equipo()), String.valueOf(p.getNombre_equi()), String.valueOf(p.getAnio_fundacion()), String.valueOf(p.getCiudad())};
            mJtable.addRow(rowData);
        }
        );
    }
//-------------------------------------------------------LLENAR DATOS--------------------------------------------------------------------------------------------

    public void LlenarDatos() {

        List<Clase_Equipo> Listequi = modeloEqui.listarEquipos();
        int selectedRow = vistaequi.getTblEquipos().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Para que los datos se llenen, debe seleccionar un elemento de la tabla");
        } else {
            String selectedId = vistaequi.getTblEquipos().getValueAt(selectedRow, 0).toString();
            Optional<Clase_Equipo> matchingEquipo = Listequi.stream()
                    .filter(p -> selectedId.equals(p.getCod_equipo()))
                    .findFirst();

            if (matchingEquipo.isPresent()) {
                Clase_Equipo p = matchingEquipo.get();
                vistaequi.getTxtcodequipo().setText(String.valueOf(p.getCod_equipo()));
                vistaequi.getTxtcodequipo().setEnabled(false);
                vistaequi.getTxtNombreequipo().setText(String.valueOf(p.getNombre_equi()));
                vistaequi.getJdcaniofundacion().setDate(p.getAnio_fundacion());
                vistaequi.getTxtCiudadequipo().setText(String.valueOf(p.getCiudad()));

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento válido de la tabla.");
            }
        }
    }
//------------------------------------------------------- SALIR DEL DIALOGO--------------------------------------------------------------------------------------------

    public void salirdialogo() {
        limpiar();
        vistaequi.getJdlgEquipos().setVisible(false);
    }

//------------------------------------------------------- LIMPIAR--------------------------------------------------------------------------------------------
    private void limpiar() {

        vistaequi.getTxtcodequipo().setText("");
        vistaequi.getTxtNombreequipo().setText("");
        vistaequi.getJdcaniofundacion().setDate(null);
        vistaequi.getTxtCiudadequipo().setText("");
        vistaequi.getTxtcodequipo().setEnabled(true);

    }
}
