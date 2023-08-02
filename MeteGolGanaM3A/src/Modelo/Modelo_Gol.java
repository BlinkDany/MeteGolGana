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
public class Modelo_Gol extends Clase_Gol{
    ConexionMySql CPG = new ConexionMySql();

    public Modelo_Gol() {
        
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
                goles.setCod_jugador(rs.getInt("codigo_jugadorfk"));

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
    public void listarGoles(){
        try {
            ConexionMySql c = new Conexion.ConexionMySql();
            c.getConnection();
            ResultSet rs = c.Consultas("SELECT g.descripcion, g.minuto, g.codigo_partidofk, e.nombre, p.nombre1, g.codigo\n"
                    + "	FROM gol g \n"
                    + "	join equipo e on (g.cod_equipofk = e.codigo) \n"
                    + "	join jugador j on (g.codigo_jugadorfk = j.codigo) \n"
                    + "	join persona p on (j.cedula_personafk = p.cedula);");
            while(rs.next()){
                try {
                    mJtable.addRow(new Object[]{rs.getInt(6),rs.getString(1),rs.getString(2),rs.getString(5),rs.getInt(3),rs.getString(4)});
                } catch (SQLException ex) {
                    Logger.getLogger(Modelo_Gol.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
            VistaGol.tblGoles.setModel(mJtable);
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Gol.class.getName()).log(Level.SEVERE, null, ex);
            
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
