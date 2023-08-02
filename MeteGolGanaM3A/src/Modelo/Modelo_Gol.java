package Modelo;

import Conexion.ConexionMySql;
import Vista.VistaGol;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Derek
 */
public class Modelo_Gol extends Clase_Gol {

    ConexionMySql CPG = new ConexionMySql();

    public Modelo_Gol() {

    }

    public List<Clase_Gol> BuscarGoles(int aux) {

        try {
            String sql = "SELECT g.codigo, g.descripcion, g.minuto, g.codigo_partidofk, g.cod_equipofk, g.codigo_jugadorfk, e.nombre, p.nombre1, g.estado_elim "
                    + "FROM gol g "
                    + "JOIN equipo e ON (g.cod_equipofk = e.codigo) "
                    + "JOIN jugador j ON (g.codigo_jugadorfk = j.codigo) "
                    + "JOIN persona p ON (j.cedula_personafk = p.cedula) "
                    + "WHERE g.estado_elim = false and g.codigo = '" + aux + "'"
                    + " ORDER BY g.codigo ";

            ResultSet rs = CPG.Consultas(sql);
            List<Clase_Gol> listita = new ArrayList<>();

            while (rs.next()) {
                Clase_Gol gol = new Clase_Gol();
                gol.setCod_gol(rs.getInt(1));
                gol.setDescripcion(rs.getString(2));
                gol.setMinuto(rs.getString(3));
                gol.setCod_partido(rs.getInt(4));
                gol.setCod_equipo(rs.getInt(5));
                gol.setCod_jugador(rs.getInt(6));
                gol.setNombre_equipo(rs.getString(7));
                gol.setNombre_jugador(rs.getString(8));
                gol.setEstado_elim(rs.getBoolean(9));
                listita.add(gol);

            }

            rs.close();
            return listita;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Gol.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public boolean InsertarGol() {
        String sql;
        sql = "INSERT INTO gol(descripcion,minuto,codigo_jugadorfk,codigo_partidofk,cod_equipofk,estado_elim)";
        sql += "VALUES('" + getDescripcion() + "','" + getMinuto() + "','" + getCod_jugador() + "','" + getCod_partido() + "','" + getCod_equipo() + "','" + false + "')";
        return CPG.CRUD(sql);

    }

    public boolean ModificarGol() {
        String sql;
        sql = "update gol set codigo='" + getCod_gol() + "' ,descripcion='" + getDescripcion() + "' ,minuto='" + getMinuto() + "' ,codigo_jugadorfk='" + getCod_jugador() + "' ,codigo_partidofk='" + getCod_partido() + "' ,cod_equipofk='" + getCod_equipo() + "'where codigo='" + getCod_gol() + "';";
        return CPG.CRUD(sql);

    }

    public boolean EliminarGol() {
        String sql;
        sql = "update gol set estado_elim = true where codigo='" + getCod_gol() + "';";
        return CPG.CRUD(sql);

    }

    public List<Clase_Gol> listarGoles() {
        List<Clase_Gol> listagoles = new ArrayList<Clase_Gol>();

        try {
            String sql = "SELECT g.codigo, g.descripcion, g.minuto, g.codigo_partidofk, g.cod_equipofk, g.codigo_jugadorfk, e.nombre, p.nombre1, g.estado_elim "
                    + "FROM gol g "
                    + "JOIN equipo e ON (g.cod_equipofk = e.codigo) "
                    + "JOIN jugador j ON (g.codigo_jugadorfk = j.codigo) "
                    + "JOIN persona p ON (j.cedula_personafk = p.cedula) "
                    + "WHERE g.estado_elim = false "
                    + "ORDER BY g.codigo";
            ResultSet rs = CPG.Consultas(sql);
            while (rs.next()) {
                Clase_Gol gol = new Clase_Gol();
                gol.setCod_gol(rs.getInt(1));
                gol.setDescripcion(rs.getString(2));
                gol.setMinuto(rs.getString(3));
                gol.setCod_partido(rs.getInt(4));
                gol.setCod_equipo(rs.getInt(5));
                gol.setCod_jugador(rs.getInt(6));
                gol.setNombre_equipo(rs.getString(7));
                gol.setNombre_jugador(rs.getString(8));
                gol.setEstado_elim(rs.getBoolean(9));
                listagoles.add(gol);

            }
            rs.close();//CIERRO CONEXION
            return listagoles;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Partido.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public int CargarCodigoID() throws SQLException {

        int codigo = 0;
        String sql = "select max(codigo) from gol;";
        ResultSet res = CPG.Consultas(sql);

        try {
            while (res.next()) {

                codigo = res.getInt("max") + 1;
            }
        } catch (SQLException ex) {

            Logger.getLogger(Clase_Gol.class.getName()).log(Level.SEVERE, null, ex);
        }
        res.close();
        return codigo;
    }
}
