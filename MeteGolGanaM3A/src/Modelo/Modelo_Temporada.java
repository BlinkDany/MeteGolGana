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
//construir consulta para insertar el producto 
        String sql = "INSERT INTO public.temporada(\n"
                + "fecha_inicio, fecha_fin, codigo_campeonato, estado_elim)\n"
                + "	VALUES ('" + getFechaIni()+ "','" + getFechaFin()+ "', '" + getCodCampeonatoFk()+ "', '" + isEstadoEli()+ "');";

        return con.CRUD(sql);

    }

    
        public boolean ModificarTemporada() {

        // Construir la consulta SQL para actualizar los datos del producto
        String sql = "UPDATE public.temporada SET fecha_inicio = '" + getFechaIni()+ "', fecha_fin = '" + getFechaFin()+ "', codigo_campeonato = '"
                + getCodCampeonatoFk()+ "' "
                + "WHERE codigo ='" + getCodigoPk()+ "';";

        return con.CRUD(sql);
    }


 
    
      public boolean OcultarTemporada () {
        
        String sql = "UPDATE public.temporada\n" +
"	SET  estado_elim= true\n" +
"	WHERE codigo = "+getCodigoPk()+" ;";
        
        return con.CRUD(sql);
        
    }

    public List<Clase_Temporada> ListaTemporada() {

        try {

            String sql = "SELECT * "
                    + "FROM temporada where estado_elim = false "                    
                    + "ORDER BY codigo";
            ResultSet res = con.Consultas(sql);
            List<Clase_Temporada> listTempo = new ArrayList<>();
            

            while (res.next()) {

                Clase_Temporada mitempo = new Clase_Temporada();

                //campeonato
                mitempo.setCodigoPk(res.getInt("codigo"));
                mitempo.setFechaIni(res.getDate("fecha_inicio"));
                mitempo.setFechaFin(res.getDate("fecha_fin"));
                mitempo.setCodCampeonatoFk(res.getInt("codigo_campeonato"));
                mitempo.setEstadoEli(res.getBoolean("estado_elim"));
                
                listTempo.add(mitempo);
            }

            res.close();
            return listTempo;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Temporada.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
    
    public int CargarCodigoID() throws SQLException {

        int codigo = 0;
        String sql = "select max(codigo) from temporada;";
        ResultSet res = con.Consultas(sql);

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
    
    public List<Clase_Temporada> buscarTemporadasPorCodigo(String aux) {
    try {
        String sql = "SELECT codigo, fecha_inicio, fecha_fin, codigo_campeonato FROM temporada WHERE codigo = '" + aux + "' AND estado_elim = false";
        ResultSet rs = con.Consultas(sql);
        List<Clase_Temporada> temporadasEncontradas = new ArrayList<>();

        while (rs.next()) {
            Clase_Temporada temporada = new Clase_Temporada();

            temporada.setCodigoPk(rs.getInt(1));
            temporada.setFechaIni(rs.getDate(2));
            temporada.setFechaFin(rs.getDate(3));
            temporada.setCodCampeonatoFk(rs.getInt(4));
           

            temporadasEncontradas.add(temporada);
        }

        rs.close();
        return temporadasEncontradas;

    } catch (SQLException ex) {
        Logger.getLogger(Modelo_Temporada.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, ex.getMessage());
        return null;
    }
}
    
}
