/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Date;

/**
 *
 * @author blink
 */
public class Clase_Persona {
    
    private String cedula;
    private String nombnre1;
    private String nombnre2;
    private String apellido1;
    private String apellido2;
    private Date fecha_nac;
    private String telefono;
    private String email;
    private String sexo;
    private String direccion;
    private boolean estado_elim;
    private String foto;

    public Clase_Persona() {
    }

    public Clase_Persona(String cedula, String nombnre1, String nombnre2, String apellido1, String apellido2, Date fecha_nac, String telefono, String email, String sexo, String direccion, boolean estado_elim, String foto) {
        this.cedula = cedula;
        this.nombnre1 = nombnre1;
        this.nombnre2 = nombnre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nac = fecha_nac;
        this.telefono = telefono;
        this.email = email;
        this.sexo = sexo;
        this.direccion = direccion;
        this.estado_elim = estado_elim;
        this.foto = foto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombnre1() {
        return nombnre1;
    }

    public void setNombnre1(String nombnre1) {
        this.nombnre1 = nombnre1;
    }

    public String getNombnre2() {
        return nombnre2;
    }

    public void setNombnre2(String nombnre2) {
        this.nombnre2 = nombnre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado_elim() {
        return estado_elim;
    }

    public void setEstado_elim(boolean estado_elim) {
        this.estado_elim = estado_elim;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
}
