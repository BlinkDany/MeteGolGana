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
 * @author Usuario
 */
public class Modelo_Entrenador extends Clase_Entrenador {

    Conexion.ConexionMySql con = new ConexionMySql();

    public boolean InsertarEntrenador() {

        String sql = "INSERT INTO entrenador(codigo, anios_exp, sueldo,cedula_personafk, codigo_equipofk,estado_elim) "
                + "VALUES ('" + getCodigo() + "','" + getAniosexp() + "'," + getSueldo() + ",'" + getCedula_personafk()
                + "','" + getCodigo_equipofk() + "','" + false + "');";

        return con.CRUD(sql);
    }

    public boolean ModificarEntrenador() {

        String sql = "UPDATE entrenador SET anios_exp='" + getAniosexp() + "',sueldo=" + getSueldo() + ",codigo_equipofk=" + getCodigo_equipofk() + " "
                + "WHERE codigo=" + getCodigo() + ";";

        return con.CRUD(sql);
    }

    public boolean EliminarEntrenador() {

        String sql = "UPDATE entrenador SET estado_elim=true "
                + "WHERE codigo =" + getCodigo() + ";";

        return con.CRUD(sql);
    }

    public List<Clase_Entrenador> BuscarEntrenador(String aux) {

        try {

            String sql = "SELECT * "
                    + "FROM entrenador j, persona p, equipo f "
                    + "WHERE p.cedula = j.cedula_personafk and p.estado_elim = false and j.codigo_equipofk=f.codigo "
                    + "AND (j.cedula_personafk LIKE '%" + aux + "%' OR CONCAT(p.nombre1, ' ', p.apellido1) LIKE '%" + aux + "%') "
                    + "ORDER BY j.codigo ";
            ResultSet res = con.Consultas(sql);
            List<Clase_Entrenador> ent = new ArrayList<>();
            byte[] bytea;

            while (res.next()) {
                Clase_Entrenador mientrenador = new Clase_Entrenador();

                //entrenador
                mientrenador.setCodigo(res.getInt("codigo"));
                mientrenador.setCodigo_equipofk(res.getString("codigo_equipofk"));
                mientrenador.setAniosexp(res.getInt("anios_exp"));
                mientrenador.setNombreEquipo(res.getString("nombre"));
                mientrenador.setSueldo(res.getDouble("sueldo"));
                mientrenador.setEstado_elim(res.getBoolean("estado_elim"));
                mientrenador.setCedula_personafk(res.getString("cedula_personafk"));

                //persona
                mientrenador.setApellido1(res.getString("apellido1"));
                mientrenador.setApellido2(res.getString("apellido2"));
                mientrenador.setCedula(res.getString("cedula"));
                mientrenador.setDireccion(res.getString("direccion"));
                mientrenador.setEmail(res.getString("email"));
                mientrenador.setFecha_nac(res.getDate("fecha_nac"));
                mientrenador.setNombnre1(res.getString("nombre1"));
                mientrenador.setNombnre2(res.getString("nombre2"));
                mientrenador.setSexo(res.getString("sexo"));
                mientrenador.setTelefono(res.getString("telefono"));
                mientrenador.setEstado_elim(res.getBoolean("estado_elim"));

                bytea = res.getBytes("foto");

                if (bytea != null) try {

                    mientrenador.setFoto(getImage(bytea));

                } catch (IOException ex) {
                    Logger.getLogger(Modelo_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
                }

                ent.add(mientrenador);
            }

            res.close();
            return ent;

        } catch (SQLException ex) {

            Logger.getLogger(Modelo_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public int CargarCodigoID() throws SQLException {

        int codigo = 0;
        String sql = "select max(codigo) from entrenador;";
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

    public List<Clase_Entrenador> ListaEntrenador() {

        try {

            String sql = "SELECT *, f.nombre "
                    + "FROM entrenador j "
                    + "INNER JOIN persona P ON p.cedula = j.cedula_personafk AND j.estado_elim = false "
                    + "INNER JOIN equipo f ON j.codigo_equipofk=f.codigo "
                    + "ORDER BY j.codigo ";
            ResultSet res = con.Consultas(sql);
            List<Clase_Entrenador> ent = new ArrayList<>();
            byte[] bytea;

            while (res.next()) {

                Clase_Entrenador mientrenador = new Clase_Entrenador();

                //entrenador
                mientrenador.setCodigo(res.getInt("codigo"));
                mientrenador.setCodigo_equipofk(res.getString("codigo_equipofk"));
                mientrenador.setNombreEquipo(res.getString("nombre"));
                mientrenador.setAniosexp(res.getInt("anios_exp"));
                mientrenador.setSueldo(res.getDouble("sueldo"));
                mientrenador.setEstado_elim(res.getBoolean("estado_elim"));
                mientrenador.setCedula_personafk(res.getString("cedula_personafk"));

                //persona
                mientrenador.setApellido1(res.getString("apellido1"));
                mientrenador.setApellido2(res.getString("apellido2"));
                mientrenador.setCedula(res.getString("cedula"));
                mientrenador.setDireccion(res.getString("direccion"));
                mientrenador.setEmail(res.getString("email"));
                mientrenador.setFecha_nac(res.getDate("fecha_nac"));
                mientrenador.setNombnre1(res.getString("nombre1"));
                mientrenador.setNombnre2(res.getString("nombre2"));
                mientrenador.setSexo(res.getString("sexo"));
                mientrenador.setTelefono(res.getString("telefono"));
                mientrenador.setEstado_elim(res.getBoolean("estado_elim"));

                bytea = res.getBytes("foto");

                if (bytea != null) try {

                    mientrenador.setFoto(getImage(bytea));

                } catch (IOException ex) {
                    Logger.getLogger(Modelo_Arbitro.class.getName()).log(Level.SEVERE, null, ex);
                }

                ent.add(mientrenador);
            }

            res.close();
            return ent;

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
