
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
 * @author Derek
 */
public class ModeloEquipos extends Clase_Equipo{
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

    public boolean EliminarPartido() {
        String sql;
        sql = "update equipo set estado_elim = true where codigo='" + getCod_equipo() + "';";
        return CPG.CRUD(sql);

    }
}
