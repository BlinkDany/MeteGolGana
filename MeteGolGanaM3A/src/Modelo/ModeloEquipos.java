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
public class ModeloEquipos extends Clase_Equipo {

    ConexionMySql CPG = new ConexionMySql();

    public ModeloEquipos() {

    }

    public List<Clase_Equipo> listarEquipos() {
        List<Clase_Equipo> listaEquipos = new ArrayList<Clase_Equipo>();

        try {
            String sql = "select * from equipo where estado_elim = false";
            ResultSet rs = CPG.Consultas(sql);
            while (rs.next()) {
                Clase_Equipo equipo = new Clase_Equipo();
                equipo.setCod_equipo(rs.getInt("codigo"));
                equipo.setNombre_equi(rs.getString("nombre"));
                equipo.setAnio_fundacion(rs.getDate("anio_fundacion"));
                equipo.setCiudad(rs.getString("ciudad"));

                listaEquipos.add(equipo);

            }
            rs.close();//CIERRO CONEXION
            return listaEquipos;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Partido.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Clase_Equipo> BuscarEquipo(String aux) {

        try {

            String sql = "SELECT * "
                    + "from equipo "
                    + "WHERE codigo = '" + aux + "'and estado_elim = false";

            ResultSet rs = CPG.Consultas(sql);
            List<Clase_Equipo> par = new ArrayList<>();

            while (rs.next()) {

                Clase_Equipo equipo = new Clase_Equipo();
                equipo.setCod_equipo(rs.getInt("codigo"));
                equipo.setNombre_equi(rs.getString("nombre"));
                equipo.setAnio_fundacion(rs.getDate("anio_fundacion"));
                equipo.setCiudad(rs.getString("ciudad"));
                equipo.setEstado_elim(rs.getInt("estado_elim"));

                par.add(equipo);
            }

            rs.close();
            return par;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public boolean InsertarEquipo() {
        String sql;
        sql = "INSERT INTO equipo(codigo,nombre,anio_fundacion,ciudad,estado_elim)";
        sql += "VALUES('" + getCod_equipo() + "','" + getNombre_equi() + "','" + getAnio_fundacion() + "','" + getCiudad() + "','" + false + "')";
        return CPG.CRUD(sql);

    }

    public boolean ModificarEquipo() {
        String sql;
        sql = "update equipo set codigo='" + getCod_equipo() + "' ,nombre='" + getNombre_equi() + "',anio_fundacion='" + getAnio_fundacion() + "',ciudad='" + getCiudad() + "',estado_elim='" + getEstado_elim() + "'where codigo='" + getCod_equipo() + "';";
        return CPG.CRUD(sql);

    }

    public boolean EliminarEquipo() {
        String sql;
        sql = "update equipo set estado_elim = true where codigo='" + getCod_equipo() + "';";
        return CPG.CRUD(sql);

    }

    public int CargarCodigoID() throws SQLException {

        int codigo = 0;
        String sql = "select max(codigo) from equipo;";
        ResultSet res = CPG.Consultas(sql);

        try {
            while (res.next()) {

                codigo = res.getInt("max") + 1;
            }
        } catch (SQLException ex) {

            Logger.getLogger(Clase_Equipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        res.close();
        return codigo;
    }
}
