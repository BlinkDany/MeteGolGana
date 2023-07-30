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
 * @author Carlos
 */
public class Modelo_Asignacion extends Clase_Asignacion {

    ConexionMySql CPG = new ConexionMySql();

    public Modelo_Asignacion() {

    }

    public List<Clase_Asignacion> listarAsignacion() {
        List<Clase_Asignacion> listaAsignacion = new ArrayList<Clase_Asignacion>();

        try {
            String sql = "select * from asignacion where estado_elim = false";
            ResultSet rs = CPG.Consultas(sql);
            while (rs.next()) {
                Clase_Asignacion asignacion = new Clase_Asignacion();
                asignacion.setCodigo_asignacion(rs.getInt("codigo"));
                asignacion.setFecha_asignacion(rs.getDate("fecha"));
                asignacion.setCodigo_arbitro_asignacion(rs.getInt("codigo_arbitrofk"));
                asignacion.setCodigo_partido_asignacion(rs.getInt("codigo_partidofk"));
                asignacion.setEstado_asignacion(rs.getBoolean("estado_elim"));

                listaAsignacion.add(asignacion);

            }
            rs.close();//CIERRO CONEXION
            return listaAsignacion;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Asignacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int CargarCodigoID() throws SQLException {

        int codigo = 0;
        String sql = "select max(codigo) from asignacion;";
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

    public List<Clase_Asignacion> BuscarAsignacion(String aux) {

        try {

            String sql = "SELECT * "
                    + "from asignacion "
                    + "WHERE codigo = '" + aux + "'and estado_elim = false";

            ResultSet rs = CPG.Consultas(sql);
            List<Clase_Asignacion> par = new ArrayList<>();

            while (rs.next()) {

                Clase_Asignacion asignacion = new Clase_Asignacion();

                asignacion.setCodigo_asignacion(rs.getInt("codigo"));
                asignacion.setFecha_asignacion(rs.getDate("fecha"));
                asignacion.setCodigo_arbitro_asignacion(rs.getInt("codigo_arbitrofk"));
                asignacion.setCodigo_partido_asignacion(rs.getInt("codigo_partidofk"));
                asignacion.setEstado_asignacion(rs.getBoolean("estado_elim"));

                par.add(asignacion);
            }

            rs.close();
            return par;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public boolean InsertarAsignacion() {
        String sql;
        sql = "INSERT INTO asignacion(fecha,codigo_arbitrofk,codigo_partidofk,estado_elim)";
        sql += "VALUES('" + getFecha_asignacion() + "','" + getCodigo_arbitro_asignacion() + "','" + getCodigo_partido_asignacion() + "','" + false + "')";
        return CPG.CRUD(sql);

    }

    public boolean ModificarAsignacion() {
        String sql;
        sql = "update asignacion set fecha='" + getFecha_asignacion()+ "' ,codigo_arbitrofk='" + getCodigo_arbitro_asignacion()+ "' ,codigo_partidofk='" + getCodigo_partido_asignacion() + "'where codigo='" + getCodigo_asignacion()+ "';";
        return CPG.CRUD(sql);

    }

    public boolean EliminarAsignacion() {

        String sql = "UPDATE asignacion SET estado_elim=true "
                + "WHERE codigo=" + getCodigo_asignacion()+ ";";

        return CPG.CRUD(sql);
    }

}
