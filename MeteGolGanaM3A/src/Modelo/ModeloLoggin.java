/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.ConexionMySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author blink
 */
public class ModeloLoggin {

    Conexion.ConexionMySql con = new ConexionMySql();

    public boolean IniciarSesion(String usu, String pass) {

        try {
            boolean validar = false;
            int count = 0;
            String sql = "select count(*) from persona "
                    + "where email = '" + usu + "' and cedula = '" + pass + "'";
            ResultSet res = con.Consultas(sql);
            
            while (res.next()) {
                
                count = res.getInt("count");
                
            }
            
            if (count == 1) {
                
                validar = true;
            }
            res.close();
            return validar;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLoggin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
}
