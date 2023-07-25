/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Clase_Equipo;
import Modelo.Clase_Resumen_Partido;
import Modelo.ModeloEquipos;
import Modelo.Modelo_Partido;
import Modelo.Modelo_Resumen_Partido;
import Vista.Resumen_Partido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
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
        visRes.getLblEquipo1().addMouseListener(new MouseAdapter() {
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
        visRes.getBtnAgregar().addActionListener(l -> IniciarDialogRegisrarVisualizar("Registrar"));

    }

    public void InicarDialogEquipo1() {

        visRes.getDlgEquipo1().setVisible(true);
        visRes.getDlgEquipo1().setTitle("Seleccionar equipo 1");
        if (!(visRes.getTblEquipos().getSelectedRow() == -1)) {
            
            visRes.getLblEquipo1().setText(String.valueOf(visRes.getTblEquipos().getValueAt(visRes.getTblEquipos().getSelectedRow(), 1).toString()));
            visRes.getDlgEquipo1().dispose();
        }
    }

    public void InicarDialogEquipo2() {

        visRes.getDlgEquipo2().setVisible(true);
        visRes.getDlgEquipo2().setTitle("Seleccionar equipo 2");
        if (!(visRes.getTblEquipos2().getSelectedRow() == -1)) {
            
            visRes.getLblEquipo2().setText(String.valueOf(visRes.getTblEquipos2().getValueAt(visRes.getTblEquipos2().getSelectedRow(), 1).toString()));
            visRes.getDlgEquipo2().dispose();
        }
    }
    
    public void IniciarDialogRegisrarVisualizar(String titulo){
        
        visRes.getDlgRegistrarConsultar().setVisible(true);
        visRes.getDlgRegistrarConsultar().setTitle(titulo);
        
        if (visRes.getDlgRegistrarConsultar().getTitle().equals("Registrar")) {
            
            RegistrarEquipo1();
            RegistrarEquipo2();
        } else {
            
            LlenarDatos();
        }
        
    }

    public void RegistrarEquipo1() {

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

    public void RegistrarEquipo2() {

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

                ccodEquipo2 = visRes.getTblEquipos2().getValueAt(visRes.getTblEquipos().getSelectedRow(), 0).hashCode();

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

    public void MostrarDatos() {

        DefaultTableModel tabla = (DefaultTableModel) visRes.getTblResuemn().getModel();
        tabla.setNumRows(0);

        List<Clase_Resumen_Partido> res = modRes.ListaResumen();
        res.stream().forEach(p -> {

            Object datos[] = {p.getCodigo(), p.getCodigo_partidofk(), p.getCodigo_equipofk()};
            tabla.addRow(datos);
        });

    }
    
    public void MostrarEquipos(){
        
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

    public void LlenarDatos() {

        if (!(visRes.getTblResuemn().getSelectedRow() == -1)) {

            int codpar = visRes.getTblResuemn().getValueAt(visRes.getTblResuemn().getSelectedRow(), 1).hashCode();

            List<Clase_Resumen_Partido> res = modRes.ListaResumen();
            List<Integer> liscodigo = modRes.extarerResumen();
            res.stream().forEach(p -> {
                for (int i = 0; i < liscodigo.size(); i++) {

                    if (p.getCodigo_partidofk() == codpar) {

                        if (p.getCodigo_equipofk() == liscodigo.get(i)) {

                            visRes.getLblPartido().setText(String.valueOf(p.getCodigo_partidofk()));
                            visRes.getTxtFaltas().setText(String.valueOf(p.getFaltas()));
                            visRes.getTxtPenales().setText(String.valueOf(p.getPenales()));
                            visRes.getTxtSaquesBanda().setText(String.valueOf(p.getSaques_mano()));
                            visRes.getTxtTarjetasAmarillas().setText(String.valueOf(p.getTarjetas_amarillas()));
                            visRes.getTxtTarjetasRojas().setText(String.valueOf(p.getTarjetas_rojas()));
                            visRes.getTxtTirosEsquina().setText(String.valueOf(p.getTiros_esquina()));
                            visRes.getTxtTirosLibres().setText(String.valueOf(p.getTiros_libres()));
                            visRes.getLblEquipo1().setText(String.valueOf(p.getCodigo_equipofk()));
                            visRes.getLblGoles().setText(String.valueOf(p.getGoles()));

                        } else {

                            visRes.getLblPartido().setText(String.valueOf(p.getCodigo_partidofk()));
                            visRes.getTxtFaltas1().setText(String.valueOf(p.getFaltas()));
                            visRes.getTxtPenales1().setText(String.valueOf(p.getPenales()));
                            visRes.getTxtSaquesBanda1().setText(String.valueOf(p.getSaques_mano()));
                            visRes.getTxtTarjetasAmarillas1().setText(String.valueOf(p.getTarjetas_amarillas()));
                            visRes.getTxtTarjetasRojas1().setText(String.valueOf(p.getTarjetas_rojas()));
                            visRes.getTxtTirosEsquina1().setText(String.valueOf(p.getTiros_esquina()));
                            visRes.getTxtTirosLibres1().setText(String.valueOf(p.getTiros_libres()));
                            visRes.getLblEquipo2().setText(String.valueOf(p.getCodigo_equipofk()));
                            visRes.getLblGoles1().setText(String.valueOf(p.getGoles()));
                        }
                    }
                }
            });
            
        } else {
            
            MensajeError("Seleccione un resumen de partido");
        }
    }

    public void MensajeSucces(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
    }

    public void MensajeError(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

}