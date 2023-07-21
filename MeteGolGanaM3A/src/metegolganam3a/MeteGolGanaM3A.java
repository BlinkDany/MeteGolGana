/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metegolganam3a;

import Conexion.ConexionMySql;
import Controlador.Controlador_Jugador;
import Controlador.Controlador_MP;
import Modelo.Modelo_Jugador;
import Modelo.Modelo_Persona;
import Vista.LogIn;
import Vista.MenuPrincipal;
import Vista.VistaJugadores;

/**
 *
 * @author blink
 */
public class MeteGolGanaM3A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MenuPrincipal mp = new MenuPrincipal();
        
        Controlador_MP  cmp = new Controlador_MP(mp);
        
        cmp.iniciaControl();
        
        Modelo_Jugador modju = new Modelo_Jugador();
        Modelo.Modelo_Persona modper = new Modelo_Persona();
        Vista.VistaJugadores visju = new VistaJugadores();
        Vista.LogIn lo = new LogIn();
        
        Controlador.Controlador_Jugador con = new Controlador_Jugador(modju, visju, modper, lo);
        con.InicarControlador();
        
        
        
    }
    
}
