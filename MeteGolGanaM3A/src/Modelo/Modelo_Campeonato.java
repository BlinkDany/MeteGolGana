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
import java.sql.PreparedStatement;
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
public class Modelo_Campeonato extends Clase_Campeonato {
    
       Conexion.ConexionMySql con = new ConexionMySql();

    
    
     public boolean InsertarCampeonato() {
//construir consulta para insertar el producto 
        String sql = "INSERT INTO public.campeonato(\n"
                + "	nombre, tipo_campeonato, max_equipos, estado_elim)\n"
                + "	VALUES ('" +getNombre()+ "','" + getTipo_campeonato()+ "', '" + getMax_equipos()+ "', '" + isEstado_elim() + "');";

        return con.CRUD(sql);

    }

    
    public boolean ModificarCampeonato() {

        // Construir la consulta SQL para actualizar los datos del producto
        String sql = "UPDATE public.campeonato SET nombre = '" + getNombre()+ "', tipo_campeonato = '" + getTipo_campeonato()+ "', max_equipos = '"
                + getMax_equipos() + "' "
                + "WHERE codigo ='" + getCod_campeonato()+ "';";

        return con.CRUD(sql);
    }

 
    
      public boolean OcultarCampeonato () {
        
        String sql = "UPDATE public.campeonato\n" +
"	SET  estado_elim= true\n" +
"	WHERE codigo = "+getCod_campeonato()+" ;";
        
        return con.CRUD(sql);
        
    }

    public List<Clase_Campeonato> ListaCampeonato() {

        try {

            String sql = "SELECT * "
                    + "FROM campeonato "                    
                    + "ORDER BY codigo";
            ResultSet res = con.Consultas(sql);
            List<Clase_Campeonato> camp = new ArrayList<>();
            

            while (res.next()) {

                Clase_Campeonato micampeon = new Clase_Campeonato();

                //campeonato
                micampeon.setCod_campeonato(res.getInt("codigo"));
                micampeon.setNombre(res.getString("nombre"));
                micampeon.setTipo_campeonato(res.getString("tipo_campeonato"));
                micampeon.setMax_equipos(res.getInt("max_equipos"));
                micampeon.setEstado_elim(res.getBoolean("estado_elim"));
                
                camp.add(micampeon);
            }

            res.close();
            return camp;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Campeonato.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
    
     public int CargarCodigoID() throws SQLException {

        int codigo = 0;
        String sql = "select max(codigo) from campeonato;";
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
     
     public List<Clase_Campeonato> buscarCampeonatosPorCodigo(String aux) {
    try {
        String sql = "SELECT codigo, nombre, tipo_campeonato, max_equipos FROM campeonato WHERE codigo = '" + aux + "'";
        ResultSet rs = con.Consultas(sql);
        List<Clase_Campeonato> campeonatosEncontrados = new ArrayList<>();

        while (rs.next()) {
            Clase_Campeonato campeonato = new Clase_Campeonato();

            campeonato.setCod_campeonato(rs.getInt(1));
            campeonato.setNombre(rs.getString(2));
            campeonato.setTipo_campeonato(rs.getString(3));
            campeonato.setMax_equipos(rs.getInt(4));

            campeonatosEncontrados.add(campeonato);
        }

        rs.close();
        return campeonatosEncontrados;

    } catch (SQLException ex) {
        Logger.getLogger(Modelo_Campeonato.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, ex.getMessage());
        return null;
    }
}


   
}
