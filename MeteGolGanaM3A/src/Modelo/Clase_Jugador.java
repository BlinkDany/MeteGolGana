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
public class Clase_Jugador extends Clase_Persona{
    
    private int cod_jugador;
    private String posicion;
    private int anios_exp;
    private double sueldo;
    private Date fecha_inicioContrato;
    private Date fecha_finContrato;
    private String cedula_persona;
    private int cod_equipo;

    public Clase_Jugador() {
    }

    public Clase_Jugador(int cod_jugador, String posicion, int anios_exp, double sueldo, Date fecha_inicioContrato, Date fecha_finContrato, String cedula_persona, int cod_equipo) {
        this.cod_jugador = cod_jugador;
        this.posicion = posicion;
        this.anios_exp = anios_exp;
        this.sueldo = sueldo;
        this.fecha_inicioContrato = fecha_inicioContrato;
        this.fecha_finContrato = fecha_finContrato;
        this.cedula_persona = cedula_persona;
        this.cod_equipo = cod_equipo;
    }

    public Clase_Jugador(int cod_jugador, String posicion, int anios_exp, double sueldo, Date fecha_inicioContrato, Date fecha_finContrato, String cedula_persona, int cod_equipo, String cedula, String nombnre1, String nombnre2, String apellido1, String apellido2, Date fecha_nac, String telefono, String email, String sexo, String direccion, boolean estado_elim, String foto) {
        super(cedula, nombnre1, nombnre2, apellido1, apellido2, fecha_nac, telefono, email, sexo, direccion, estado_elim, foto);
        this.cod_jugador = cod_jugador;
        this.posicion = posicion;
        this.anios_exp = anios_exp;
        this.sueldo = sueldo;
        this.fecha_inicioContrato = fecha_inicioContrato;
        this.fecha_finContrato = fecha_finContrato;
        this.cedula_persona = cedula_persona;
        this.cod_equipo = cod_equipo;
    }


    public int getCod_jugador() {
        return cod_jugador;
    }

    public void setCod_jugador(int cod_jugador) {
        this.cod_jugador = cod_jugador;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getAnios_exp() {
        return anios_exp;
    }

    public void setAnios_exp(int anios_exp) {
        this.anios_exp = anios_exp;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFecha_inicioContrato() {
        return fecha_inicioContrato;
    }

    public void setFecha_inicioContrato(Date fecha_inicioContrato) {
        this.fecha_inicioContrato = fecha_inicioContrato;
    }

    public Date getFecha_finContrato() {
        return fecha_finContrato;
    }

    public void setFecha_finContrato(Date fecha_finContrato) {
        this.fecha_finContrato = fecha_finContrato;
    }

    public String getCedula_persona() {
        return cedula_persona;
    }

    public void setCedula_persona(String cedula_persona) {
        this.cedula_persona = cedula_persona;
    }

    public int getCod_equipo() {
        return cod_equipo;
    }

    public void setCod_equipo(int cod_equipo) {
        this.cod_equipo = cod_equipo;
    }
}
