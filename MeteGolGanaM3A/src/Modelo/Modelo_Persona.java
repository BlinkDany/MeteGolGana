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
import java.sql.SQLIntegrityConstraintViolationException;
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
 * @author blink
 */
public class Modelo_Persona extends Clase_Persona {

    Conexion.ConexionMySql con = new ConexionMySql();

    public boolean InsertarPersona() throws SQLException {

        String sql = "INSERT INTO public.persona( "
                + "cedula, nombre1, nombre2, apellido1, apellido2, fecha_nac, telefono, email, sexo, direccion, foto) "
                + "VALUES (?, INITCAP(?), INITCAP(?), INITCAP(?), INITCAP(?), ?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = con.getCon().prepareStatement(sql);
        ps.setString(1, getCedula());
        ps.setString(2, getNombnre1());
        ps.setString(3, getNombnre2());
        ps.setString(4, getApellido1());
        ps.setString(5, getApellido2());
        ps.setDate(6, getFecha_nac());
        ps.setString(7, getTelefono());
        ps.setString(8, getEmail());
        ps.setString(9, getSexo());
        ps.setString(10, getDireccion());
        ps.setBinaryStream(11, getImageFile(), getLength());
        ps.executeUpdate();
        return true;

    }

    public boolean ActualizarPersona() throws SQLException {

        String sql = "UPDATE public.persona "
                + "SET nombre1=INITCAP(?), nombre2=INITCAP(?), apellido1=INITCAP(?), apellido2=INITCAP(?), fecha_nac=?, telefono=?, email=?, sexo=?, direccion=? "
                + "WHERE cedula='" + getCedula() + "';";

        PreparedStatement ps = con.getCon().prepareStatement(sql);
        ps.setString(1, getNombnre1());
        ps.setString(2, getNombnre2());
        ps.setString(3, getApellido1());
        ps.setString(4, getApellido2());
        ps.setDate(5, getFecha_nac());
        ps.setString(6, getTelefono());
        ps.setString(7, getEmail());
        ps.setString(8, getSexo());
        ps.setString(9, getDireccion());
        ps.executeUpdate();
        return true;
    }
    
    public void ModificarImagen() throws SQLException{
        
        String sql = "UPDATE public.persona "
                + "SET foto=? "
                + "WHERE cedula='" + getCedula() + "';";
        
        PreparedStatement ps = con.getCon().prepareStatement(sql);
        ps.setBinaryStream(1, getImageFile(), getLength());
        ps.executeUpdate();
    }

    public boolean OcultarPersona() {

        String sql = "UPDATE `persona` SET `estado_elim`='" + isEstado_elim() + "' WHERE `cedula`='" + getCedula() + "';";

        return con.CRUD(sql);
    }

    public List<Clase_Persona> ListaPersona() {

        try {

            String sql = "SELECT * FROM persona ORDER BY cedula";
            ResultSet res = con.Consultas(sql);
            List<Clase_Persona> per = new ArrayList<>();
            byte[] bytea;

            while (res.next()) {
                Clase_Persona mipersona = new Clase_Jugador();
                mipersona.setApellido1(res.getString("apellido1"));
                mipersona.setApellido2(res.getString("apellido2"));
                mipersona.setCedula(res.getString("cedula"));
                mipersona.setDireccion(res.getString("direccion"));
                mipersona.setEmail(res.getString("email"));
                mipersona.setFecha_nac(res.getDate("fecha_nac"));
                mipersona.setNombnre1(res.getString("nombre1"));
                mipersona.setNombnre2(res.getString("nombre2"));
                mipersona.setSexo(res.getString("sexo"));
                mipersona.setTelefono(res.getString("telefono"));
                mipersona.setEstado_elim(res.getBoolean("estado_elim"));

                bytea = res.getBytes("foto");

                if (bytea != null) try {
                    mipersona.setFoto(getImage(bytea));
                } catch (IOException ex) {
                    Logger.getLogger(Modelo_Persona.class.getName()).log(Level.SEVERE, null, ex);
                }

                per.add(mipersona);
            }
            res.close();
            return per;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Persona.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
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
