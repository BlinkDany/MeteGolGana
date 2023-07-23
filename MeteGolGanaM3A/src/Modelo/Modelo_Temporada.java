/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionMySql;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tatip
 */
public class Modelo_Temporada extends Clase_Temporada {
    
      Conexion.ConexionMySql con = new ConexionMySql();
    
     public boolean InsertarTemporada() {

        String sql = "INSERT INTO temporada(fecha_inicio, fecha_fin, codigo_campeonato) "
                + "VALUES ('" + getFechaIni()+ "','" + getFechaFin()+ "'," + getCodCampeonatoFk() + ");";

        return con.CRUD(sql);
    }

    public boolean ModificarTemporada() {

        String sql = "UPDATE temporada SET fecha_inicio='" + getFechaIni()+ "',fecha_fin=" + getFechaFin()+ ",codigo_campeonato=" + getCodCampeonatoFk() + " "
                + "WHERE codigo=" + getCodigoPk()+ ";";

        return con.CRUD(sql);
    }

    public boolean OcultarTemporada() {

        String sql = "UPDATE temporada SET estado_elim = true "
                + "WHERE `codigo`=" + getCodigoPk()+ ";";

        return con.CRUD(sql);
    }

    public List<Clase_Temporada> ListaTemporada() {

        try {

            String sql = "SELECT * "
                    + "FROM temporada "
                    
                    + "ORDER BY codigo";
            ResultSet res = con.Consultas(sql);
            List<Clase_Temporada> listTemporada = new ArrayList<>();
            byte[] bytea;

            while (res.next()) {

                Clase_Temporada mitemp = new Clase_Temporada();

                //temporada
                mitemp.setCodigoPk(res.getInt("codigo"));
                mitemp.setFechaIni(res.getDate("fecha_inicio"));
                mitemp.setFechaFin(res.getDate("fecha_fin"));
                mitemp.setCodCampeonatoFk(res.getInt("codigo_campeonato"));
               

                listTemporada.add(mitemp);
            }

            res.close();
            return listTemporada;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Temporada.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public List<Clase_Temporada> buscarTemporada(String aux) {
    try {
        String sql = "SELECT * FROM temporada "
                + "WHERE codigo LIKE '%" + aux + "%' "
                + "OR fecha_inicio LIKE '%" + aux + "%' "
                + "OR fecha_fin LIKE '%" + aux + "%' "
                + "OR codigo_campeonato LIKE '%" + aux + "%' "
                + "ORDER BY codigo";

        ResultSet res = con.Consultas(sql);
        List<Clase_Temporada> temporadas = new ArrayList<>();

        while (res.next()) {
            Clase_Temporada temporada = new Clase_Temporada();
            temporada.setCodigoPk(res.getInt("codigo"));
            temporada.setFechaIni(res.getDate("fecha_inicio"));
            temporada.setFechaFin(res.getDate("fecha_fin"));
            temporada.setCodCampeonatoFk(res.getInt("codigo_campeonato"));
            temporada.setEstadoEli(res.getInt("estado_elim"));

            temporadas.add(temporada);
        }

        res.close();
        return temporadas;

    } catch (SQLException ex) {
        Logger.getLogger(Modelo_Temporada.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, ex.getMessage());
        return null;
    }
}
    
}
