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
public class Modelo_Arbitro extends Clase_Arbitro {

    Conexion.ConexionMySql con = new ConexionMySql();

    public boolean InsertarArbitro() {

        String sql = "INSERT INTO arbitro(posicion, anios_exp, salario, estado_elim, cedula_personafk) "
                + "VALUES ('" + getPosicion_arbitro() + "'," + getAnios_esperiencia_arbitro() + ",'" + getSalario_arbitro()
                + "','" + isEstado_eliminado_arbitro() + "','" + getCedula_persona_arbitro() + "');";

        return con.CRUD(sql);
    }

    public boolean ModificarArbitro() {

        String sql = "UPDATE arbitro SET posicion='" + getPosicion_arbitro() + "',anios_exp=" + getAnios_esperiencia_arbitro() + ",salario=" + getSalario_arbitro() + " "
                + "WHERE codigo=" + getCodigo_arbitro() + ";";

        return con.CRUD(sql);
    }

    public boolean OcultarArbitro() {

        String sql = "UPDATE arbitro SET estado_elim=true "
                + "WHERE `codigo`=" + getCodigo_arbitro() + ";";

        return con.CRUD(sql);
    }

    public List<Clase_Arbitro> ListaArbitro() {

        try {

            String sql = "SELECT * "
                    + "FROM arbitro j, persona p "
                    + "WHERE p.cedula = j.cedula_personafk "
                    + "ORDER BY j.codigo";
            ResultSet res = con.Consultas(sql);
            List<Clase_Arbitro> arb = new ArrayList<>();
            byte[] bytea;

            while (res.next()) {

                Clase_Arbitro miarbitro = new Clase_Arbitro();

                //arbitro
                miarbitro.setCodigo_arbitro(res.getInt("codigo"));
                miarbitro.setPosicion_arbitro(res.getString("posicion"));
                miarbitro.setAnios_esperiencia_arbitro(res.getInt("anios_exp"));
                miarbitro.setSalario_arbitro(res.getDouble("salario"));
                miarbitro.setEstado_elim(res.getBoolean("estado_elim"));
                miarbitro.setCedula_persona_arbitro(res.getString("cedula_personafk"));

                //persona
                miarbitro.setApellido1(res.getString("apellido1"));
                miarbitro.setApellido2(res.getString("apellido2"));
                miarbitro.setCedula(res.getString("cedula"));
                miarbitro.setDireccion(res.getString("direccion"));
                miarbitro.setEmail(res.getString("email"));
                miarbitro.setFecha_nac(res.getDate("fecha_nac"));
                miarbitro.setNombnre1(res.getString("nombre1"));
                miarbitro.setNombnre2(res.getString("nombre2"));
                miarbitro.setSexo(res.getString("sexo"));
                miarbitro.setFoto(res.getString("foto"));
                miarbitro.setTelefono(res.getString("telefono"));
                miarbitro.setEstado_elim(res.getBoolean("estado_elim"));

                arb.add(miarbitro);
            }

            res.close();
            return arb;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public List<Clase_Arbitro> BuscarArbitro(String aux) {

        try {

            String sql = "SELECT * "
                    + "FROM arbitro j, persona p "
                    + "WHERE p.cedula = j.cedula_personafk "
                    + "AND (j.cedula_personafk LIKE '%" + aux + "%' OR CONCAT(p.nombre1, ' ', p.apellido1) LIKE '%" + aux + "%') "
                    + "ORDER BY j.codigo";
            ResultSet res = con.Consultas(sql);
            List<Clase_Arbitro> arb = new ArrayList<>();
            byte[] bytea;

            while (res.next()) {

                Clase_Arbitro miarbitro = new Clase_Arbitro();

                //arbitro
                miarbitro.setCodigo_arbitro(res.getInt("codigo"));
                miarbitro.setPosicion_arbitro(res.getString("posicion"));
                miarbitro.setAnios_esperiencia_arbitro(res.getInt("anios_exp"));
                miarbitro.setSalario_arbitro(res.getDouble("salario"));
                miarbitro.setEstado_elim(res.getBoolean("estado_elim"));
                miarbitro.setCedula_persona_arbitro(res.getString("cedula_personafk"));

                //persona
                miarbitro.setApellido1(res.getString("apellido1"));
                miarbitro.setApellido2(res.getString("apellido2"));
                miarbitro.setCedula(res.getString("cedula"));
                miarbitro.setDireccion(res.getString("direccion"));
                miarbitro.setEmail(res.getString("email"));
                miarbitro.setFecha_nac(res.getDate("fecha_nac"));
                miarbitro.setNombnre1(res.getString("nombre1"));
                miarbitro.setNombnre2(res.getString("nombre2"));
                miarbitro.setSexo(res.getString("sexo"));
                miarbitro.setFoto(res.getString("foto"));
                miarbitro.setTelefono(res.getString("telefono"));
                miarbitro.setEstado_elim(res.getBoolean("estado_elim"));

                arb.add(miarbitro);
            }

            res.close();
            return arb;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
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
