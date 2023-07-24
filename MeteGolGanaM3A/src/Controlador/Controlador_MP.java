/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clase_Arbitro;
import Modelo.Clase_Campeonato;
import Modelo.Clase_Temporada;
import Modelo.ModeloEquipos;
import Modelo.Modelo_Partido;
import Modelo.Modelo_Arbitro;
import Modelo.Modelo_Campeonato;
import Modelo.Modelo_Jugador;
import Modelo.Modelo_Persona;
import Modelo.Modelo_Temporada;
import Vista.LogIn;
import Vista.MenuPrincipal;
import Vista.VistaCampeonato;
import Vista.VistaJugadores;
import Vista.VistaTemporada;
import Vista.VistaEquipos;
import Vista.VistaGol;
import Vista.VistaPartido;
import Vista.Vista_Arbitro;

/**
 *
 * @author tatip
 */
public class Controlador_MP {

    MenuPrincipal vistaPrincipal;

    public Controlador_MP(MenuPrincipal vistaPrincipal) {

        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
    }

    public void iniciaControl() {

        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.getBtnCampeonato().addActionListener(l -> menuCampeonato());
        vistaPrincipal.getBtnTemporada().addActionListener(l -> menuTemporada());
        vistaPrincipal.getBtnJugadores().addActionListener(l -> MenuJugadores());
        vistaPrincipal.getBtnEquipos().addActionListener(l -> MenuEquipos());
        vistaPrincipal.getBtnGoles().addActionListener(l -> MenuJugadores());
        vistaPrincipal.getBtnArbitros().addActionListener(l -> MenuArbitros());
        vistaPrincipal.getBtnPatidos().addActionListener(l -> MenuPartidos());

    }

    private void menuCampeonato() {

        Modelo.Modelo_Campeonato model = new Modelo_Campeonato();
        Vista.VistaCampeonato vista = new VistaCampeonato();
        Clase_Campeonato miCampeon = new Clase_Campeonato();
        vistaPrincipal.getDesctopPrincipal().add(vista);
        Controlador.Controlador_Campeonato controlPer = new Controlador_Campeonato(model, vista);
        controlPer.iniciaControl();

    }

    private void menuTemporada() {

        Modelo.Modelo_Temporada mod = new Modelo_Temporada();
        Modelo.Modelo_Campeonato mc = new Modelo_Campeonato();
        Vista.VistaTemporada vis = new VistaTemporada();
        Clase_Temporada miTempo = new Clase_Temporada();
        vistaPrincipal.getDesctopPrincipal().add(vis);
        Controlador_temporada controlPro = new Controlador_temporada(mod, vis, mc);
        controlPro.iniciaControl();

    }

    private void MenuJugadores() {

        Modelo.Modelo_Jugador moJu = new Modelo_Jugador();
        Vista.VistaJugadores visju = new VistaJugadores();
        Modelo.Modelo_Persona modper = new Modelo_Persona();
        Vista.LogIn vislo = new LogIn();
        vistaPrincipal.getDesctopPrincipal().add(visju);
        Controlador_Jugador controlJuga = new Controlador_Jugador(moJu, visju, modper, vislo);
        controlJuga.InicarControlador();

    }

    private void MenuEquipos() {
        Modelo.ModeloEquipos moEqui = new ModeloEquipos();
        Vista.VistaEquipos visequi = new VistaEquipos();
        vistaPrincipal.getDesctopPrincipal().add(visequi);
        Controlador_Equipo controlEqui = new Controlador_Equipo(moEqui, visequi);
        controlEqui.iniciaControl();
    }

    private void MenuArbitros() {

        Modelo.Modelo_Arbitro moJu = new Modelo_Arbitro();
        Vista.Vista_Arbitro visju = new Vista_Arbitro();
        Modelo.Modelo_Persona modper = new Modelo_Persona();
        Vista.LogIn vislo = new LogIn();
        vistaPrincipal.getDesctopPrincipal().add(visju);
        Controlador_Arbitro controlJuga = new Controlador_Arbitro(moJu, visju, modper, vislo);
        controlJuga.InicarControlador();

    }

    private void MenuPartidos() {
        Modelo_Partido moPar = new Modelo_Partido();
        Vista.VistaPartido visPar = new VistaPartido();
        Modelo.Modelo_Temporada moTem = new Modelo_Temporada();
        Modelo.ModeloEquipos moEq = new ModeloEquipos();
        vistaPrincipal.getDesctopPrincipal().add(visPar);
        Controlador.Controlador_Partido controlPar = new Controlador_Partido(moPar, moTem, moEq, visPar);
        controlPar.iniciaControl();

    }

    /*private void MenuGoles(){     
        Modelo.Modelo moEqui = new ModeloEquipos();
        Vista.VistaEquipos visequi = new VistaEquipos();
        vistaPrincipal.getDesctopPrincipal().add(visequi);
        Controlador_Equipo controlEqui = new Controlador_Equipo(moEqui, visequi);
        controlEqui.iniciaControl(); 
    }*/

 /* private void menuFactura () { 
        
        modelo.ModeloDetalleFactura mod = new ModeloDetalleFactura();
        modelo.ModeloFactura mf = new ModeloFactura();
        modelo.ModeloPersona mp = new ModeloPersona();
        modelo.ModeloProductos mpro = new ModeloProductos();
        
        vista.VistaFactura vis = new VistaFactura();
        

         
        vistaPrincipal.getDesctopPrincipal().add(vis);
        
        controlador.ControladorFactura controlfac = new ControladorFactura(mf, mp, mpro, mod, vis);
        controlfac.iniciaControl();
        

}*/
}
