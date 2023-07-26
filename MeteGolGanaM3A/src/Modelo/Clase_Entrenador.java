/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Clase_Entrenador extends Clase_Persona {

    private int codigo;
    private int aniosexp;
    private double sueldo;
    private String cedula_personafk;
    private String codigo_equipofk;
    private String nombreEquipo;

    public Clase_Entrenador() {
    }

    public Clase_Entrenador(int codigo, int aniosexp, double sueldo, String cedula_personafk, String codigo_equipofk, String nombreEquipo) {
        this.codigo = codigo;
        this.aniosexp = aniosexp;
        this.sueldo = sueldo;
        this.cedula_personafk = cedula_personafk;
        this.codigo_equipofk = codigo_equipofk;
        this.nombreEquipo = nombreEquipo;
    }

    public Clase_Entrenador(int codigo, int aniosexp, double sueldo, String cedula_personafk, String codigo_equipofk, String nombreEquipo, String cedula, String nombnre1, String nombnre2, String apellido1, String apellido2, Date fecha_nac, String telefono, String email, String sexo, String direccion, boolean estado_elim, Image foto, FileInputStream imageFile, int length) {
        super(cedula, nombnre1, nombnre2, apellido1, apellido2, fecha_nac, telefono, email, sexo, direccion, estado_elim, foto, imageFile, length);
        this.codigo = codigo;
        this.aniosexp = aniosexp;
        this.sueldo = sueldo;
        this.cedula_personafk = cedula_personafk;
        this.codigo_equipofk = codigo_equipofk;
        this.nombreEquipo = nombreEquipo;
    }

    public String getCodigo_equipofk() {
        return codigo_equipofk;
    }

    public void setCodigo_equipofk(String codigo_equipofk) {
        this.codigo_equipofk = codigo_equipofk;
    }

 
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAniosexp() {
        return aniosexp;
    }

    public void setAniosexp(int aniosexp) {
        this.aniosexp = aniosexp;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCedula_personafk() {
        return cedula_personafk;
    }

    public void setCedula_personafk(String cedula_personafk) {
        this.cedula_personafk = cedula_personafk;
    }

}
