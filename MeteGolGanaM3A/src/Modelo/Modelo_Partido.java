/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionMySql;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Modelo_Partido extends Clase_Partido {

    ConexionMySql CPG = new ConexionMySql();

    public Modelo_Partido() {

    }

    public List<Clase_Partido> listarPartidos() {
        List<Clase_Partido> listaPartidos = new ArrayList<Clase_Partido>();

        try {
            String sql = "select * from partido";
            ResultSet rs = CPG.Consultas(sql);
            while (rs.next()) {
                Clase_Partido partido = new Clase_Partido();
                partido.setCod_partido(rs.getInt("codigo"));
                partido.setCod_estadio(rs.getInt("cod_estadiofk"));
                partido.setCod_temporadafk(rs.getInt("cod_temporadafk"));
                partido.setFecha(rs.getDate("fecha"));
                partido.setGrupo(rs.getString("grupo"));
                partido.setEstado(rs.getString("estado"));
                partido.setCod_equipo1(rs.getInt("cod_equipo1fk"));
                partido.setCod_equipo2(rs.getInt("cod_equipo2fk"));

                listaPartidos.add(partido);

            }
            rs.close();//CIERRO CONEXION
            return listaPartidos;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Partido.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Clase_Partido> BuscarPartidos(int aux) {

        try {

            String sql = "SELECT * "
                    + "from partido "
                    + "WHERE codigo = '" + aux + "'";

            ResultSet rs = CPG.Consultas(sql);
            List<Clase_Partido> par = new ArrayList<>();
            byte[] bytea;

            while (rs.next()) {

                Clase_Partido partido = new Clase_Partido();

                partido.setCod_partido(rs.getInt("codigo"));
                partido.setCod_estadio(rs.getInt("cod_estadiofk"));
                partido.setCod_temporadafk(rs.getInt("cod_temporadafk"));
                partido.setFecha(rs.getDate("fecha"));
                partido.setGrupo(rs.getString("grupo"));
                partido.setEstado(rs.getString("estado"));
                partido.setCod_equipo1(rs.getInt("cod_equipo1fk"));
                partido.setCod_equipo2(rs.getInt("cod_equipo2fk"));

                par.add(partido);
            }

            rs.close();
            return par;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public boolean InsertarPartido() {
        String sql;
        sql = "INSERT INTO partido(codigo,cod_estadiofk,cod_temporadafk,fecha,grupo,estado,cod_equipo1fk,cod_equipo2fk,estado_elim)";
        sql += "VALUES('" + getCod_partido() + "','" + getCod_estadio() + "','" + getCod_temporadafk() + "','" + getFecha() + "','" + getGrupo() + "','" + getEstado() + "','" + getCod_equipo1() + "','" + getCod_equipo2() + "','" + false + "')";
        return CPG.CRUD(sql);

    }

    public boolean ModificarPartido() {
        String sql;
        sql = "update partido set codigo='" + getCod_partido() + "' ,cod_estadiofk='" + getCod_estadio() + "' ,cod_temporadafk='" + getCod_temporadafk() + "' ,fecha='" + getFecha() + "' ,grupo='" + getGrupo() + "' ,estado='" + getEstado() + "',cod_equipo1='" + getCod_equipo1() + "',cod_equipo2='" + getCod_equipo2() + "',cod_estadio='" + getCod_estadio() + "'where codigo='" + getCod_partido() + "';";
        return CPG.CRUD(sql);

    }

    public boolean EliminarPartido() {
        String sql;
        sql = "delete from partido where codigo='" + getCod_partido() + "';";
        return CPG.CRUD(sql);

    }

}
