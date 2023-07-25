package Controlador;

import Modelo.Clase_Equipo;
import Modelo.ModeloEquipos;
import Vista.VistaEquipos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
        vistaequi.getBtnRegistrarModificar().addActionListener(l -> crearEditarPartido());

        //vista.getBtnSalir1().addActionListener(l -> salirdialogo());
        //vista.getBtnImprimir().addActionListener(l -> generarreporte());
        //vista.getBtnSalir().addActionListener(l -> salir());
        //vista.getBtnCrear().addActionListener(l -> {
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
    private void crearEditarPartido() {
        if (vistaequi.getJdlgEquipos().getTitle().contentEquals("Crear")) {

            ModeloEquipos model = new ModeloEquipos();

            if (vistaequi.getTxtcodequipo().equals("") || vistaequi.getTxtNombreequipo().equals("") || vistaequi.getJdcaniofundacion().equals("") || vistaequi.getTxtCiudadequipo().equals("")) {

                JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS DATOS");

            } else {
                int codigopartido = Integer.valueOf(vistaequi.getTxtcodequipo().getText());
                String nombreequi = vistaequi.getTxtNombreequipo().getText();
                String equipo1 = vistaequi.getJdcaniofundacion().getDateFormatString();
                String ciudadequi = vistaequi.getTxtCiudadequipo().getText();
                int estado = 0;

                model.setCod_equipo(codigopartido);
                model.setNombre_equi(nombreequi);
                model.setAnio_fundacion(java.sql.Date.valueOf(equipo1));
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
                String fechaequi = String.valueOf(vistaequi.getJdcaniofundacion().getDateFormatString());
                String ciudadequi = vistaequi.getTxtCiudadequipo().getText();

                model.setCod_equipo(codigoequi);
                model.setNombre_equi(nombreequi);
                model.setAnio_fundacion(java.sql.Date.valueOf(fechaequi));
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
            if (model.EliminarPartido()) {

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
            Optional<Clase_Equipo> matchingPartido = Listequi.stream()
                    .filter(p -> selectedId.equals(p.getCod_equipo()))
                    .findFirst();

            if (matchingPartido.isPresent()) {
                Clase_Equipo p = matchingPartido.get();
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
