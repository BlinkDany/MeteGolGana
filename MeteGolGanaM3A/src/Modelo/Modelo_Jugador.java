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
 * @author blink
 */
public class Modelo_Jugador extends Clase_Jugador {

    Conexion.ConexionMySql con = new ConexionMySql();

    public boolean InsertarJugador() {

        String sql = "INSERT INTO jugador(posicion, anios_exp, sueldo, fecha_inicio_contrato, fecha_fin_contrato, cedula_personafk, cod_equipofk) "
                + "VALUES ('" + getPosicion() + "','" + getAnios_exp() + "'," + getSueldo() + ",'" + getFecha_inicioContrato()
                + "','" + getFecha_finContrato() + "','" + getCedula_persona() + "'," + getCod_equipo() + ");";

        return con.CRUD(sql);
    }

    public boolean ModificarJugador() {

        String sql = "UPDATE jugador SET posicion='" + getPosicion() + "',anios_exp=" + getAnios_exp() + ",sueldo=" + getSueldo() + ""
                + ",fecha_inicio_contrato='" + getFecha_inicioContrato() + "',fecha_fin_contrato='" + getFecha_finContrato() + "',"
                + "cod_equipofk=" + getCod_equipo() + " "
                + "WHERE codigo=" + getCod_jugador() + ";";

        return con.CRUD(sql);
    }

    public boolean OcultarJugador() {

        String sql = "UPDATE jugador SET estado_elim=true "
                + "WHERE codigo=" + getCod_jugador() + ";";

        return con.CRUD(sql);
    }

    public int ValidarNumJugadorEquipo() {

        int count = 0;
        try {

            String sql = "select count(cod_equipofk) from jugador\n"
                    + "where cod_equipofk = " + getCod_equipo() + ";";

            ResultSet res = con.Consultas(sql);

            while (res.next()) {

                count = res.getInt("count");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return count;
    }

    public List<Clase_Jugador> ListaJugador() {

        try {

            String sql = "SELECT * FROM jugador j, persona p "
                    + "WHERE p.cedula = j.cedula_personafk and j.estado_elim = false "
                    + "ORDER BY j.codigo";
            ResultSet res = con.Consultas(sql);
            List<Clase_Jugador> jug = new ArrayList<>();
            byte[] bytea;

            while (res.next()) {

                Clase_Jugador mijugador = new Clase_Jugador();

                //jugador
                mijugador.setCod_equipo(res.getInt("cod_equipofk"));
                mijugador.setCod_jugador(res.getInt("codigo"));
                mijugador.setCedula_persona(res.getString("cedula_personafk"));
                mijugador.setSueldo(res.getDouble("sueldo"));
                mijugador.setPosicion(res.getString("posicion"));
                mijugador.setFecha_finContrato(res.getDate("fecha_fin_contrato"));
                mijugador.setFecha_inicioContrato(res.getDate("fecha_inicio_contrato"));
                mijugador.setAnios_exp(res.getInt("anios_exp"));

                //persona
                mijugador.setApellido1(res.getString("apellido1"));
                mijugador.setApellido2(res.getString("apellido2"));
                mijugador.setCedula(res.getString("cedula"));
                mijugador.setDireccion(res.getString("direccion"));
                mijugador.setEmail(res.getString("email"));
                mijugador.setFecha_nac(res.getDate("fecha_nac"));
                mijugador.setNombnre1(res.getString("nombre1"));
                mijugador.setNombnre2(res.getString("nombre2"));
                mijugador.setSexo(res.getString("sexo"));
                mijugador.setTelefono(res.getString("telefono"));
                mijugador.setEstado_elim(res.getBoolean("estado_elim"));

                bytea = res.getBytes("foto");

                if (bytea != null) try {

                    mijugador.setFoto(getImage(bytea));

                } catch (IOException ex) {
                    Logger.getLogger(Modelo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }

                jug.add(mijugador);
            }

            res.close();
            return jug;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public List<Clase_Jugador> BuscarJugador(String aux) {

        try {

            String sql = "SELECT * "
                    + "FROM jugador j, persona p "
                    + "WHERE p.cedula = j.cedula_personafk "
                    + "AND (j.cedula_personafk LIKE '%" + aux + "%' OR CONCAT(p.nombre1, ' ', p.apellido1) LIKE '%" + aux + "%') "
                    + "ORDER BY j.codigo";
            ResultSet res = con.Consultas(sql);
            List<Clase_Jugador> jug = new ArrayList<>();
            byte[] bytea;

            while (res.next()) {

                Clase_Jugador mijugador = new Clase_Jugador();

                //jugador
                mijugador.setCod_equipo(res.getInt("cod_equipofk"));
                mijugador.setCod_jugador(res.getInt("codigo"));
                mijugador.setCedula_persona(res.getString("cedula_personafk"));
                mijugador.setSueldo(res.getDouble("sueldo"));
                mijugador.setPosicion(res.getString("posicion"));

                //persona
                mijugador.setApellido1(res.getString("apellido1"));
                mijugador.setApellido2(res.getString("apellido2"));
                mijugador.setCedula(res.getString("cedula"));
                mijugador.setDireccion(res.getString("direccion"));
                mijugador.setEmail(res.getString("email"));
                mijugador.setFecha_nac(res.getDate("fecha_nac"));
                mijugador.setNombnre1(res.getString("nombre1"));
                mijugador.setNombnre2(res.getString("nombre2"));
                mijugador.setSexo(res.getString("sexo"));
                mijugador.setTelefono(res.getString("telefono"));
                mijugador.setEstado_elim(res.getBoolean("estado_elim"));

                bytea = res.getBytes("foto");

                if (bytea != null) try {

                    mijugador.setFoto(getImage(bytea));

                } catch (IOException ex) {
                    Logger.getLogger(Modelo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
                }

                jug.add(mijugador);
            }

            res.close();
            return jug;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
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
