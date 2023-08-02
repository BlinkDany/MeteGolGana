/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class Modelo_Estadio extends Clase_Estadio{

    Conexion.ConexionMySql con = new ConexionMySql();

    public boolean InsertarEstadio() {

        String sql = "INSERT INTO estadio(codigo, nombre, aforo, ubicacion, cod_equipofk, estado_elim) "
           + "VALUES (" + getCodigo() + ",'" + getNombre()+ "'," + getAforo()+ ",'" + getUbicacion()
           + "'," + getCod_equipofk()+ "," + isEstado_elim()+ ");";

        return con.CRUD(sql);
    }

    public boolean ModificarEstadio() {

        String sql = "UPDATE estadio SET nombre='" + getNombre()+ "',aforo=" + getAforo()+ ",ubicacion='" + getUbicacion()+ "', cod_equipofk='" + getCod_equipofk()
                + "' WHERE codigo=" + getCodigo()+ ";";

        return con.CRUD(sql);
    }

    public boolean OcultarEstadio() {

        String sql = "UPDATE estadio SET estado_elim=true "
                + "WHERE codigo=" + getCodigo()+ ";";

        return con.CRUD(sql);
    }

    public List<Clase_Estadio> ListaEstadios() {

        try {

            String sql = "SELECT e.codigo,e.nombre,e.aforo,e.ubicacion,e.cod_equipofk,p.nombre "
                    + "FROM estadio e "
                    + "INNER JOIN equipo p ON e.cod_equipofk=p.codigo "
                    + "WHERE NOT e.estado_elim;";
                    
            ResultSet res = con.Consultas(sql);
            List<Clase_Estadio> est = new ArrayList<>();
            byte[] bytea;

            while (res.next()) {

                Clase_Estadio estadio = new Clase_Estadio();

                estadio.setCodigo(res.getInt(1));
                estadio.setNombre(res.getString(2));
                estadio.setAforo(res.getInt(3));
                estadio.setUbicacion(res.getString(4));
                estadio.setCod_equipofk(res.getInt(5));
                estadio.setNombreEquipo(res.getString(6));

                est.add(estadio);
            }

            res.close();
            return est;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Estadio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public List<Clase_Estadio> BuscarEstadio(String aux) {

        try {

            String sql = "SELECT e.codigo,e.nombre,e.aforo,e.ubicacion,e.cod_equipofk,p.nombre "
                    + "FROM estadio e "
                    //+ "AND (j.cedula_personafk LIKE '%" + aux + "%' OR CONCAT(p.nombre1, ' ', p.apellido1) LIKE '%" + aux + "%') "
                    + "INNER JOIN equipo p ON e.cod_equipofk=p.codigo "
                    + "WHERE e.codigo = " + aux + " AND e.estado_elim=false "
                    + "ORDER BY e.codigo;";
            ResultSet res = con.Consultas(sql);
            List<Clase_Estadio> est = new ArrayList<>();
            byte[] bytea;

            while (res.next()) {

                Clase_Estadio estadio = new Clase_Estadio();

                //estadio
                estadio.setCodigo(res.getInt("codigo"));
                estadio.setNombre(res.getString("nombre"));
                estadio.setAforo(res.getInt("aforo"));
                estadio.setUbicacion(res.getString("ubicacion"));
                estadio.setCod_equipofk(res.getInt("cod_equipofk"));
                estadio.setNombreEquipo(res.getString(6));

                est.add(estadio);
            }

            res.close();
            return est;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
    public boolean ValidarEquipoEstadio(String aux) {

        try {

            String sql = "SELECT e.codigo,e.nombre,e.aforo,e.ubicacion,e.cod_equipofk "
                    + "FROM estadio e "
                    + "WHERE e.cod_equipofk = " + aux + " AND e.estado_elim=false; ";
            ResultSet res = con.Consultas(sql);
            boolean validacion = res.next();
            res.close();
            
            return !validacion;
            
        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    
    public int CargarCodigoEstadio() {

        try {
            
            int codigo = 0;
            String sql = "select max(codigo) from estadio;";
            ResultSet res = con.Consultas(sql);
            
            try {
                while (res.next()) {
                    
                    codigo = res.getInt(1) + 1;
                }
            } catch (SQLException ex) {
                
                Logger.getLogger(Clase_Partido.class.getName()).log(Level.SEVERE, null, ex);
            }
            res.close();
            return codigo;
        } catch (SQLException ex) {
            
            Logger.getLogger(Modelo_Estadio.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
            
        }
    }

    private Image getImage(byte[] bytes) throws IOException {

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader imageReader = (ImageReader) it.next();
        Object source = bais;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        imageReader.setInput(iis, true);
        ImageReadParam param = imageReader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);

        return imageReader.read(0, param);
    }
}
