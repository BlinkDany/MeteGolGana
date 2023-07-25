package Modelo;

import Conexion.ConexionMySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Derek
 */
public class Modelo_Gol extends Clase_Gol{
    ConexionMySql CPG = new ConexionMySql();

    public Modelo_Gol() {
    }
    public List<Clase_Gol> listarGoles() {
        List<Clase_Gol> listargoles = new ArrayList<Clase_Gol>();

        try {
            String sql = "select * from gol where estado_elim = false";
            ResultSet rs = CPG.Consultas(sql);
            while (rs.next()) {
                Clase_Gol goles = new Clase_Gol();
                goles.setCod_gol(rs.getInt("codigo"));
                goles.setDescripcion(rs.getString("descripcion"));
                goles.setMinuto(rs.getString("minuto"));
                goles.setCod_partido(rs.getInt("codigo_partidofk"));
                goles.setCod_equipo(rs.getInt("cod_equipofk"));
                goles.setCod_jugador(rs.getInt("cod_jugadorfk"));
                listargoles.add(goles);

            }
            rs.close();//CIERRO CONEXION
            return listargoles;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Gol.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public List<Clase_Gol> BuscarGoles(int aux) {

        try {

            String sql = "SELECT * "
                    + "from gol "
                    + "WHERE codigo = '" + aux + "'";

            ResultSet rs = CPG.Consultas(sql);
            List<Clase_Gol> gol = new ArrayList<>();
            byte[] bytea;

            while (rs.next()) {

                Clase_Gol goles = new Clase_Gol();
                goles.setCod_gol(rs.getInt("codigo"));
                goles.setDescripcion(rs.getString("descripcion"));
                goles.setMinuto(rs.getString("minuto"));
                goles.setCod_partido(rs.getInt("codigo_partidofk"));
                goles.setCod_equipo(rs.getInt("cod_equipofk"));
                goles.setCod_jugador(rs.getInt("cod_jugadorfk"));

                gol.add(goles);
            }

            rs.close();
            return gol;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Gol.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public boolean InsertarGol() {
        String sql;
        sql = "INSERT INTO gol(codigo,descripcion,minuto,cod_jugadorfk,cod_partidofk,cod_equipofk,estado_elim)";
        sql += "VALUES('" + getCod_gol() + "','" + getDescripcion() + "','" + getMinuto() + "','" + getCod_jugador() + "','" + getCod_partido() + "','" + getCod_equipo() + "','" + false + "')";
        return CPG.CRUD(sql);

    }

    public boolean ModificarGol() {
        String sql;
        sql = "update gol set codigo='" + getCod_gol() + "' ,cod_estadiofk='" + getDescripcion() + "' ,cod_temporadafk='" + getMinuto() + "' ,fecha='" + getCod_jugador() + "' ,grupo='" + getCod_partido() + "' ,estado='" + getCod_equipo() + "'where codigo='" + getCod_gol() + "';";
        return CPG.CRUD(sql);

    }

    public boolean EliminarGol() {
        String sql;
        sql = "update gol set estado_elim = true where codigo='" + getCod_partido() + "';";
        return CPG.CRUD(sql);

    }
}
