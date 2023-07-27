/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Clase_Equipo;
import Modelo.Clase_Partido;
import Modelo.Clase_Resumen_Partido;
import Modelo.ModeloEquipos;
import Modelo.Modelo_Partido;
import Modelo.Modelo_Resumen_Partido;
import Vista.Resumen_Partido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author blink
 */
public class Controlador_Resumen_Partido {

    private Modelo.Modelo_Resumen_Partido modRes;
    private Vista.Resumen_Partido visRes;
    private Modelo.Modelo_Partido modPar;
    private Modelo.ModeloEquipos modEquipos;

    public Controlador_Resumen_Partido() {
    }

    public Controlador_Resumen_Partido(Modelo_Resumen_Partido modRes, Resumen_Partido visRes, Modelo_Partido modPar, ModeloEquipos modEquipos) {
        this.modRes = modRes;
        this.visRes = visRes;
        this.modPar = modPar;
        this.modEquipos = modEquipos;
        visRes.setVisible(true);
    }

    public void IniciarControlador() {

        MostrarDatos();
        MostrarEquipos();
        MostrarPartidos();
        visRes.getBtnAgregar().addActionListener(l -> IniciarDialogRegisrarVisualizar("Registrar"));
        visRes.getBtnRegistrar().addActionListener(l -> RegistrarEquipo1());
        visRes.getBtnRegistrar().addActionListener(l -> RegistrarEquipo2());
        visRes.getBtnModificar().addActionListener(l -> {

            if (!(visRes.getTblResuemn().getSelectedRow() == -1)) {

                IniciarDialogRegisrarVisualizar("Visualizar");
            } else {
                MensajeError("Seleccione un resumen de partido");
            }
        });

        visRes.getLblEquipo4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InicarDialogEquipo1();
            }
        });
        visRes.getLblEquipo2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InicarDialogEquipo2();
            }
        });
        visRes.getLblPartido().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InicarDialogPartido();
            }
        });
        visRes.getTblEquipos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                visRes.getLblEquipo4().setText(String.valueOf(visRes.getTblEquipos().getValueAt(visRes.getTblEquipos().getSelectedRow(), 1).toString()));
                visRes.getDlgEquipo1().dispose();
            }
        });
        visRes.getTblEquipos2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                visRes.getLblEquipo2().setText(String.valueOf(visRes.getTblEquipos2().getValueAt(visRes.getTblEquipos2().getSelectedRow(), 1).toString()));
                visRes.getDlgEquipo2().dispose();
            }
        });
        visRes.getTblPartido().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int codpar = Integer.valueOf(visRes.getTblPartido().getValueAt(visRes.getTblPartido().getSelectedRow(), 0).toString());
                modRes.setCodigo_partidofk(codpar);

                System.out.println(codpar);
                
                if (!modRes.ValidarNumeroPartido()) {

                    visRes.getLblPartido().setText(String.valueOf(visRes.getTblPartido().getValueAt(visRes.getTblPartido().getSelectedRow(), 0).toString()));
                    visRes.getDlgPartido().dispose();

                } else {

                    MensajeError("El partido ya tiene registrado dos equipos registrados en resumen");
                }
            }
        });

    }

    public void InicarDialogEquipo1() {

        visRes.getDlgEquipo1().setVisible(true);
        visRes.getDlgEquipo1().setTitle("Seleccionar equipo 1");
        visRes.getDlgEquipo1().setSize(852, 478);
        if (visRes.getTblEquipos().getSelectedRow() == -1) {

//            visRes.getLblEquipo4().setText(String.valueOf(visRes.getTblEquipos().getValueAt(visRes.getTblEquipos().getSelectedRow(), 1).toString()));
//            visRes.getDlgEquipo1().dispose();
        }
    }

    public void InicarDialogEquipo2() {

        visRes.getDlgEquipo2().setVisible(true);
        visRes.getDlgEquipo2().setTitle("Seleccionar equipo 2");
        visRes.getDlgEquipo2().setSize(852, 478);
        if (visRes.getTblEquipos2().getSelectedRow() == -1) {

//            visRes.getLblEquipo2().setText(String.valueOf(visRes.getTblEquipos2().getValueAt(visRes.getTblEquipos2().getSelectedRow(), 1).toString()));
//            visRes.getDlgEquipo2().dispose();
        }
    }

    public void InicarDialogPartido() {

        visRes.getDlgPartido().setVisible(true);
        visRes.getDlgPartido().setTitle("Seleccionar Partido");
        visRes.getDlgPartido().setSize(892, 478);
        if (visRes.getTblPartido().getSelectedRow() == -1) {

//            visRes.getLblEquipo2().setText(String.valueOf(visRes.getTblEquipos2().getValueAt(visRes.getTblEquipos2().getSelectedRow(), 1).toString()));
//            visRes.getDlgEquipo2().dispose();
        }
    }

    public void IniciarDialogRegisrarVisualizar(String titulo) {

        visRes.getDlgRegistrarConsultar().setVisible(true);
        visRes.getDlgRegistrarConsultar().setTitle(titulo);
        visRes.getDlgRegistrarConsultar().setSize(1060, 890);

        if (visRes.getDlgRegistrarConsultar().getTitle().equals("Registrar")) {

            Limpiar();
        } else {

            LlenarDatos();
        }

    }

    public void RegistrarEquipo1() {

        if (visRes.getLblEquipo4().getText().equals(visRes.getLblEquipo2().getText())) {

            MensajeError("No puede haber un resumen de partido con el mismo equipo");
        } else {

            if (visRes.getTxtFaltas().getText().isEmpty() || visRes.getTxtPenales().getText().isEmpty() || visRes.getTxtSaquesBanda().getText().isEmpty()
                    || visRes.getTxtTarjetasAmarillas().getText().isEmpty() || visRes.getTxtTarjetasRojas().getText().isEmpty() || visRes.getTxtTirosEsquina().getText().isEmpty()
                    || visRes.getTxtTirosLibres().getText().isEmpty() || visRes.getLblEquipo1().getText().equals("Selecionar equipo")
                    || visRes.getLblEquipo2().getText().equals("Selecionar equipo") || visRes.getLblPartido().getText().equals("Partido")) {

                MensajeError("Faltan campos por llenar");
            } else {

                int ccodEquipo;

                if (visRes.getTblEquipos().getSelectedRow() == -1) {

                    MensajeError("Seleccione un equipo");
                } else {

                    ccodEquipo = visRes.getTblEquipos().getValueAt(visRes.getTblEquipos().getSelectedRow(), 0).hashCode();

                    modRes.setCodigo_equipofk(ccodEquipo);
                    modRes.setCodigo_partidofk(Integer.valueOf(visRes.getLblPartido().getText()));
                    modRes.setFaltas(Integer.valueOf(visRes.getTxtFaltas().getText()));
                    modRes.setGoles(Integer.valueOf(visRes.getLblGoles().getText()));
                    modRes.setPenales(Integer.valueOf(visRes.getTxtPenales().getText()));
                    modRes.setSaques_mano(Integer.valueOf(visRes.getTxtSaquesBanda().getText()));
                    modRes.setTarjetas_amarillas(Integer.valueOf(visRes.getTxtTarjetasAmarillas().getText()));
                    modRes.setTarjetas_rojas(Integer.valueOf(visRes.getTxtTarjetasRojas().getText()));
                    modRes.setTiros_esquina(Integer.valueOf(visRes.getTxtTirosEsquina().getText()));
                    modRes.setTiros_libres(Integer.valueOf(visRes.getTxtTirosLibres().getText()));

                    if (modRes.InsertarResumen()) {

                        MensajeSucces("Se registro el equipo 1");
                        MostrarDatos();
                    } else {

                        MensajeError("No se pudo registar");
                        MostrarDatos();
                    }
                }
            }
        }
    }

    public void RegistrarEquipo2() {

        if (visRes.getLblEquipo4().getText().equals(visRes.getLblEquipo2().getText())) {

            MensajeError("No puede haber un resumen de partido con el mismo equipo");
        } else {
            if (visRes.getTxtFaltas1().getText().isEmpty() || visRes.getTxtPenales1().getText().isEmpty() || visRes.getTxtSaquesBanda1().getText().isEmpty()
                    || visRes.getTxtTarjetasAmarillas1().getText().isEmpty() || visRes.getTxtTarjetasRojas1().getText().isEmpty() || visRes.getTxtTirosEsquina1().getText().isEmpty()
                    || visRes.getTxtTirosLibres1().getText().isEmpty() || visRes.getLblEquipo1().getText().equals("Selecionar equipo")
                    || visRes.getLblEquipo2().getText().equals("Selecionar equipo") || visRes.getLblPartido().getText().equals("Partido")) {

                MensajeError("Faltan campos por llenar");
            } else {

                int ccodEquipo2;

                if (visRes.getTblEquipos2().getSelectedRow() == -1) {

                    MensajeError("Seleccione un equipo");
                } else {

                    ccodEquipo2 = visRes.getTblEquipos2().getValueAt(visRes.getTblEquipos2().getSelectedRow(), 0).hashCode();

                    modRes.setCodigo_equipofk(ccodEquipo2);
                    modRes.setCodigo_partidofk(Integer.valueOf(visRes.getLblPartido().getText()));
                    modRes.setFaltas(Integer.valueOf(visRes.getTxtFaltas1().getText()));
                    modRes.setGoles(Integer.valueOf(visRes.getLblGoles1().getText()));
                    modRes.setPenales(Integer.valueOf(visRes.getTxtPenales1().getText()));
                    modRes.setSaques_mano(Integer.valueOf(visRes.getTxtSaquesBanda1().getText()));
                    modRes.setTarjetas_amarillas(Integer.valueOf(visRes.getTxtTarjetasAmarillas1().getText()));
                    modRes.setTarjetas_rojas(Integer.valueOf(visRes.getTxtTarjetasRojas1().getText()));
                    modRes.setTiros_esquina(Integer.valueOf(visRes.getTxtTirosEsquina1().getText()));
                    modRes.setTiros_libres(Integer.valueOf(visRes.getTxtTirosLibres1().getText()));

                    if (modRes.InsertarResumen()) {

                        MensajeSucces("Se registro el equipo 2");
                        MostrarDatos();
                    } else {

                        MensajeError("No se pudo registar");
                        MostrarDatos();
                    }
                }
            }
        }
    }

    public void MostrarDatos() {

        DefaultTableModel tabla = (DefaultTableModel) visRes.getTblResuemn().getModel();
        tabla.setNumRows(0);

        List<Clase_Resumen_Partido> res = modRes.Mostrar();
        res.stream().forEach(p -> {

            Object datos[] = {p.getCodigo(), p.getCodigo_partidofk(), p.getCodigo_equipofk()};
            tabla.addRow(datos);
        });

    }

    public void MostrarEquipos() {

        DefaultTableModel tabla = (DefaultTableModel) visRes.getTblEquipos().getModel();
        tabla.setNumRows(0);

        DefaultTableModel tabla2 = (DefaultTableModel) visRes.getTblEquipos2().getModel();
        tabla2.setNumRows(0);

        List<Clase_Equipo> res = modEquipos.listarEquipos();
        res.stream().forEach(p -> {

            Object datos[] = {p.getCod_equipo(), p.getNombre_equi(), p.getCiudad()};
            tabla.addRow(datos);
            tabla2.addRow(datos);
        });

    }

    public void MostrarPartidos() {

        DefaultTableModel mJtable;
        mJtable = (DefaultTableModel) visRes.getTblPartido().getModel();
        mJtable.setNumRows(0);
        List<Clase_Partido> listaP = modPar.listarPartidos();
        listaP.stream().forEach(p -> {
            String[] rowData = {String.valueOf(p.getCod_partido()), String.valueOf(p.getFecha()), p.getGrupo(), p.getEstado()};
            mJtable.addRow(rowData);
        }
        );
    }
    
    public void LlenarDatos() {

        int codpar = visRes.getTblResuemn().getValueAt(visRes.getTblResuemn().getSelectedRow(), 1).hashCode();
        modRes.setCodigo_partidofk(codpar);

        List<Clase_Resumen_Partido> res = modRes.Mostrar();
        List<Integer> liscodigo = modRes.extarerResumen();
        List<Clase_Equipo> equipo = modEquipos.listarEquipos();

        res.stream().forEach(p -> {

            equipo.stream().forEach(l -> {

                if (codpar == p.getCodigo_partidofk()) {

                    if (p.getCodigo_equipofk() == l.getCod_equipo()) {

                        if (p.getCodigo_equipofk() == liscodigo.get(0)) {

                            visRes.getTxtFaltas().setText(String.valueOf(p.getFaltas()));
                            visRes.getTxtPenales().setText(String.valueOf(p.getPenales()));
                            visRes.getTxtSaquesBanda().setText(String.valueOf(p.getSaques_mano()));
                            visRes.getTxtTarjetasAmarillas().setText(String.valueOf(p.getTarjetas_amarillas()));
                            visRes.getTxtTarjetasRojas().setText(String.valueOf(p.getTarjetas_rojas()));
                            visRes.getTxtTirosEsquina().setText(String.valueOf(p.getTiros_esquina()));
                            visRes.getTxtTirosLibres().setText(String.valueOf(p.getTiros_libres()));
                            visRes.getLblPartido().setText(String.valueOf(codpar));
                            visRes.getLblEquipo4().setText(l.getNombre_equi());
                            
                            try {
                                modRes.setCodigo_equipofk(liscodigo.get(0));
                                visRes.getLblGoles().setText(String.valueOf(modRes.ConsultarGoles()));
                            } catch (SQLException ex) {
                                Logger.getLogger(Controlador_Resumen_Partido.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else if (p.getCodigo_equipofk() == liscodigo.get(1)) {

                            visRes.getTxtFaltas1().setText(String.valueOf(p.getFaltas()));
                            visRes.getTxtPenales1().setText(String.valueOf(p.getPenales()));
                            visRes.getTxtSaquesBanda1().setText(String.valueOf(p.getSaques_mano()));
                            visRes.getTxtTarjetasAmarillas1().setText(String.valueOf(p.getTarjetas_amarillas()));
                            visRes.getTxtTarjetasRojas1().setText(String.valueOf(p.getTarjetas_rojas()));
                            visRes.getTxtTirosEsquina1().setText(String.valueOf(p.getTiros_esquina()));
                            visRes.getTxtTirosLibres1().setText(String.valueOf(p.getTiros_libres()));
                            visRes.getLblPartido().setText(String.valueOf(codpar));
                            visRes.getLblEquipo2().setText(l.getNombre_equi());
                            
                            try {
                                modRes.setCodigo_equipofk(liscodigo.get(1));
                                visRes.getLblGoles1().setText(String.valueOf(modRes.ConsultarGoles()));
                            } catch (SQLException ex) {
                                Logger.getLogger(Controlador_Resumen_Partido.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                    }
                }
            });

        });

    }

    public void Limpiar() {

        visRes.getTxtFaltas().setText("");
        visRes.getTxtPenales().setText("");
        visRes.getTxtSaquesBanda().setText("");
        visRes.getTxtTarjetasAmarillas().setText("");
        visRes.getTxtTarjetasRojas().setText("");
        visRes.getTxtTirosEsquina().setText("");
        visRes.getTxtTirosLibres().setText("");
        visRes.getLblEquipo4().setText("Seleccionar equipo");
        visRes.getTxtFaltas1().setText("");
        visRes.getTxtPenales1().setText("");
        visRes.getTxtSaquesBanda1().setText("");
        visRes.getTxtTarjetasAmarillas1().setText("");
        visRes.getTxtTarjetasRojas1().setText("");
        visRes.getTxtTirosEsquina1().setText("");
        visRes.getTxtTirosLibres1().setText("");
        visRes.getLblPartido().setText("Partido");
        visRes.getLblEquipo2().setText("Seleccionar equipo");

    }

    public void MensajeSucces(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
    }

    public void MensajeError(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
