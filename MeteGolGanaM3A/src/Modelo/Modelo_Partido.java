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
            String sql = "SELECT e.codigo, e.cod_estadiofk, e.cod_temporadafk, e.fecha, e.grupo, e.estado, e.cod_equipo1fk, e.cod_equipo2fk, e.estado_elim, p.codigo, p.nombre, e1.codigo, e1.nombre, e2.codigo, e2.nombre, t.fecha_inicio, t.fecha_fin "
                    + "FROM partido e "
                    + "INNER JOIN estadio p ON e.cod_estadiofk = p.codigo AND e.estado_elim = false "
                    + "INNER JOIN equipo e1 ON e.cod_equipo1fk = e1.codigo "
                    + "INNER JOIN equipo e2 ON e.cod_equipo2fk = e2.codigo "
                    + "INNER JOIN temporada t ON e.cod_temporadafk = t.codigo "
                    + "ORDER BY e.codigo ";
            ResultSet rs = CPG.Consultas(sql);
            while (rs.next()) {
                Clase_Partido partido = new Clase_Partido();
                partido.setCod_partido(rs.getInt(1));
                partido.setCod_estadio(rs.getInt(2));
                partido.setCod_temporadafk(rs.getInt(3));
                partido.setFecha(rs.getDate(4));
                partido.setGrupo(rs.getString(5));
                partido.setEstado(rs.getString(6));
                partido.setCod_equipo1(rs.getInt(7));
                partido.setCod_equipo2(rs.getInt(8));
                partido.setEstado_elim(rs.getBoolean(9));
                partido.setNombre_estadio(rs.getString(11));
                partido.setNombreequipo1(rs.getString(13));
                partido.setNombreequipo2(rs.getString(15));
                partido.setFechaantes(rs.getDate(16));
                partido.setFechadespues(rs.getDate(17));

                listaPartidos.add(partido);

            }
            rs.close();//CIERRO CONEXION
            return listaPartidos;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Partido.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int CargarCodigoID() throws SQLException {

        int codigo = 0;
        String sql = "select max(codigo) from partido;";
        ResultSet res = CPG.Consultas(sql);

        try {
            while (res.next()) {

                codigo = res.getInt("max") + 1;
            }
        } catch (SQLException ex) {

            Logger.getLogger(Clase_Partido.class.getName()).log(Level.SEVERE, null, ex);
        }
        res.close();
        return codigo;
    }

    public List<Clase_Partido> BuscarPartidos(String aux) {

        try {

            String sql = "SELECT e.codigo, e.cod_estadiofk, e.cod_temporadafk, e.fecha, e.grupo, e.estado, e.cod_equipo1fk, e.cod_equipo2fk, e.estado_elim, p.codigo, p.nombre, e1.codigo, e1.nombre, e2.codigo, e2.nombre, t.fecha_inicio, t.fecha_fin "
                    + "from partido e "
                    + "INNER JOIN estadio p ON e.cod_estadiofk = p.codigo "
                    + "INNER JOIN equipo e1 ON e.cod_equipo1fk = e1.codigo "
                    + "INNER JOIN equipo e2 ON e.cod_equipo2fk = e2.codigo "
                    + "INNER JOIN temporada t ON e.cod_temporadafk = t.codigo "
                    + "WHERE e.codigo = '" + aux + "'and e.estado_elim = false";

            ResultSet rs = CPG.Consultas(sql);
            List<Clase_Partido> par = new ArrayList<>();

            while (rs.next()) {

                Clase_Partido partido = new Clase_Partido();

                partido.setCod_partido(rs.getInt(1));
                partido.setCod_estadio(rs.getInt(2));
                partido.setCod_temporadafk(rs.getInt(3));
                partido.setFecha(rs.getDate(4));
                partido.setGrupo(rs.getString(5));
                partido.setEstado(rs.getString(6));
                partido.setCod_equipo1(rs.getInt(7));
                partido.setCod_equipo2(rs.getInt(8));
                partido.setEstado_elim(rs.getBoolean(9));
                partido.setNombre_estadio(rs.getString(11));
                partido.setNombreequipo1(rs.getString(13));
                partido.setNombreequipo2(rs.getString(15));
                partido.setFechaantes(rs.getDate(16));
                partido.setFechadespues(rs.getDate(17));

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
        sql = "update partido set codigo='" + getCod_partido() + "' ,cod_estadiofk='" + getCod_estadio() + "' ,cod_temporadafk='" + getCod_temporadafk() + "' ,fecha='" + getFecha() + "' ,grupo='" + getGrupo() + "' ,estado='" + getEstado() + "',cod_equipo1fk='" + getCod_equipo1() + "',cod_equipo2fk='" + getCod_equipo2() + "'where codigo='" + getCod_partido() + "';";
        return CPG.CRUD(sql);

    }

    public boolean EliminarPartido() {

        String sql = "UPDATE partido SET estado_elim=true "
                + "WHERE codigo=" + getCod_partido() + ";";

        return CPG.CRUD(sql);
    }

}
