package Controlador;

import Modelo.Clase_Gol;
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
        vistagol.getBtnCancelar().addActionListener(l -> salirdialogo1());
        vistagol.getBtnRegistrarModificar().addActionListener(l -> crearEditarPartido());
        vistagol.getBtnEquipo().addActionListener(l -> abrirDialogobusqueda("EQUIPOS 1"));
        vistagol.getBtnJugador().addActionListener(l -> abrirDialogobusqueda("EQUIPOS 2"));
        vistagol.getBtnPartido().addActionListener(l -> abrirDialogobusqueda("ESTADIO"));
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
}
