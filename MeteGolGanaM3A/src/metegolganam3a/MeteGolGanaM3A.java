/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metegolganam3a;

import Conexion.ConexionMySql;
import Controlador.ControladorLoggin;
import Controlador.Controlador_Arbitro;
import Controlador.Controlador_Jugador;
import Controlador.Controlador_MP;
import Modelo.Modelo_Arbitro;
import Modelo.Modelo_Entrenador;
import Modelo.Modelo_Jugador;
import Modelo.Modelo_Persona;
import Vista.LogIn;
import Vista.MenuPrincipal;
import Vista.VistaEntrenador;
import Vista.VistaJugadores;
import Vista.Vista_Arbitro;

/**
 *
 * @author blink
 */
public class MeteGolGanaM3A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Vista.LogIn log = new LogIn();
        Vista.VistaJugadores ju = new VistaJugadores();
        Vista.VistaEntrenador entr = new VistaEntrenador();
        Vista.Vista_Arbitro arb = new Vista_Arbitro();
        Modelo.Modelo_Persona modper = new Modelo_Persona();
        Modelo.Modelo_Jugador modjug = new Modelo_Jugador();
        Modelo.Modelo_Entrenador moden = new Modelo_Entrenador();
        Modelo.Modelo_Arbitro modar = new Modelo_Arbitro();
        
        ControladorLoggin ctr = new ControladorLoggin(log, ju, arb, entr, modper, modjug, moden, modar);
        
        ctr.InicarLoggin();
    
    }

}
