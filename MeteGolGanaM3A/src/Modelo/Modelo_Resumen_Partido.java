/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.ConexionMySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blink
 */
public class Modelo_Resumen_Partido extends Clase_Resumen_Partido {

    Conexion.ConexionMySql con = new ConexionMySql();

    public boolean InsertarResumen() {

        String sql = "INSERT INTO public.resumen_partido(\n"
                + "faltas, tarjetas_amarillas, tarjetas_rojas, tiros_esquina, saques_mano, tiros_libres, penales, codigo_equipofk, codigo_partidofk)\n"
                + "VALUES (" + getFaltas() + ", " + getTarjetas_amarillas() + ", " + getTarjetas_rojas() + ", " + getTiros_esquina()
                + ", " + getSaques_mano() + ", " + getTiros_libres() + ", " + getPenales() + ", " + getCodigo_equipofk() + ", " + getCodigo_partidofk() + ");";

        return con.CRUD(sql);
    }

    public List extarerResumen() {

        try {
            String sql = "select codigo_equipofk from resumen_partido\n"
                    + "where codigo_partidofk = " + getCodigo_partidofk() +"";
            ResultSet res = con.Consultas(sql);
            List<Integer> listaod = new ArrayList<>();

            while (res.next()) {
                int cod;

                cod = res.getInt("codigo_equipofk");
                listaod.add(cod);
            }

            return listaod;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Resumen_Partido.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Clase_Resumen_Partido> Mostrar() {

        try {
            String sql = "select * from resumen_partido where estado_elim = false order by codigo";

            ResultSet res = con.Consultas(sql);
            List<Clase_Resumen_Partido> lisres = new ArrayList<>();

            while (res.next()) {

                Clase_Resumen_Partido resumen = new Clase_Resumen_Partido();
                resumen.setCodigo(res.getInt("codigo"));
                resumen.setCodigo_equipofk(res.getInt("codigo_equipofk"));
                resumen.setCodigo_partidofk(res.getInt("codigo_partidofk"));
                resumen.setEstado_elim(res.getBoolean("estado_elim"));
                resumen.setFaltas(res.getInt("faltas"));
                resumen.setSaques_mano(res.getInt("saques_mano"));
                resumen.setPenales(res.getInt("penales"));
                resumen.setTarjetas_amarillas(res.getInt("tarjetas_amarillas"));
                resumen.setTarjetas_rojas(res.getInt("tarjetas_rojas"));
                resumen.setTiros_esquina(res.getInt("tiros_esquina"));
                resumen.setTiros_libres(res.getInt("tiros_libres"));

                lisres.add(resumen);
            }

            res.close();
            return lisres;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Resumen_Partido.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Clase_Resumen_Partido> ListaResumen() {

        try {
            String sql = "select * from resumen_partido where estado_elim = false and codigo_equipofk = " + getCodigo_equipofk() + " order by codigo";

            ResultSet res = con.Consultas(sql);
            List<Clase_Resumen_Partido> lisres = new ArrayList<>();

            while (res.next()) {

                Clase_Resumen_Partido resumen = new Clase_Resumen_Partido();
                resumen.setCodigo(res.getInt("codigo"));
                resumen.setCodigo_equipofk(res.getInt("codigo_equipofk"));
                resumen.setCodigo_partidofk(res.getInt("codigo_partidofk"));
                resumen.setEstado_elim(res.getBoolean("estado_elim"));
                resumen.setFaltas(res.getInt("faltas"));
                resumen.setSaques_mano(res.getInt("saques_mano"));
                resumen.setPenales(res.getInt("penales"));
                resumen.setTarjetas_amarillas(res.getInt("tarjetas_amarillas"));
                resumen.setTarjetas_rojas(res.getInt("tarjetas_rojas"));
                resumen.setTiros_esquina(res.getInt("tiros_esquina"));
                resumen.setTiros_libres(res.getInt("tiros_libres"));

                lisres.add(resumen);
            }

            res.close();
            return lisres;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Resumen_Partido.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
