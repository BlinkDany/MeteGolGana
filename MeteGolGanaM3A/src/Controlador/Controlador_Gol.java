package Controlador;

import Modelo.ModeloEquipos;
import Modelo.Modelo_Jugador;
import Modelo.Modelo_Partido;
import Vista.VistaGol;

/**
 *
 * @author Derek
 */
public class Controlador_Gol {
    private Modelo_Partido modeloPar;
    private Modelo_Jugador modeloJug;
    private ModeloEquipos modeloEqu;
    private VistaGol vistagol;

    public Controlador_Gol(Modelo_Partido modeloPar, Modelo_Jugador modeloJug, ModeloEquipos modeloEqu, VistaGol vistagol) {
        this.modeloPar = modeloPar;
        this.modeloJug = modeloJug;
        this.modeloEqu = modeloEqu;
        this.vistagol = vistagol;
        vistagol.setVisible(true);
        //cargaGoles();
    }
    
}
