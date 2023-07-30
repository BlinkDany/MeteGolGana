/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.sql.Date;

/**
 *
 * @author Carlos
 */
public class Clase_Arbitro extends Clase_Persona {

    private int codigo_arbitro;
    private String posicion_arbitro;
    private int anios_esperiencia_arbitro;
    private double salario_arbitro;
    private boolean estado_eliminado_arbitro;
    private String cedula_persona_arbitro;

    public Clase_Arbitro() {
    }

    public Clase_Arbitro(int codigo_arbitro, String posicion_arbitro, int anios_esperiencia_arbitro, double salario_arbitro, boolean estado_eliminado_arbitro, String cedula_persona_arbitro) {
        this.codigo_arbitro = codigo_arbitro;
        this.posicion_arbitro = posicion_arbitro;
        this.anios_esperiencia_arbitro = anios_esperiencia_arbitro;
        this.salario_arbitro = salario_arbitro;
        this.estado_eliminado_arbitro = estado_eliminado_arbitro;
        this.cedula_persona_arbitro = cedula_persona_arbitro;
    }

    public Clase_Arbitro(int codigo_arbitro, String posicion_arbitro, int anios_esperiencia_arbitro, double salario_arbitro, boolean estado_eliminado_arbitro, String cedula_persona_arbitro, String cedula, String nombnre1, String nombnre2, String apellido1, String apellido2, Date fecha_nac, String telefono, String email, String sexo, String direccion, boolean estado_elim, String foto) {
        super(cedula, nombnre1, nombnre2, apellido1, apellido2, fecha_nac, telefono, email, sexo, direccion, estado_elim, foto);
        this.codigo_arbitro = codigo_arbitro;
        this.posicion_arbitro = posicion_arbitro;
        this.anios_esperiencia_arbitro = anios_esperiencia_arbitro;
        this.salario_arbitro = salario_arbitro;
        this.estado_eliminado_arbitro = estado_eliminado_arbitro;
        this.cedula_persona_arbitro = cedula_persona_arbitro;
    }

    public int getCodigo_arbitro() {
        return codigo_arbitro;
    }

    public void setCodigo_arbitro(int codigo_arbitro) {
        this.codigo_arbitro = codigo_arbitro;
    }

    public String getPosicion_arbitro() {
        return posicion_arbitro;
    }

    public void setPosicion_arbitro(String posicion_arbitro) {
        this.posicion_arbitro = posicion_arbitro;
    }

    public int getAnios_esperiencia_arbitro() {
        return anios_esperiencia_arbitro;
    }

    public void setAnios_esperiencia_arbitro(int anios_esperiencia_arbitro) {
        this.anios_esperiencia_arbitro = anios_esperiencia_arbitro;
    }

    public double getSalario_arbitro() {
        return salario_arbitro;
    }

    public void setSalario_arbitro(double salario_arbitro) {
        this.salario_arbitro = salario_arbitro;
    }

    public boolean isEstado_eliminado_arbitro() {
        return estado_eliminado_arbitro;
    }

    public void setEstado_eliminado_arbitro(boolean estado_eliminado_arbitro) {
        this.estado_eliminado_arbitro = estado_eliminado_arbitro;
    }

    public String getCedula_persona_arbitro() {
        return cedula_persona_arbitro;
    }

    public void setCedula_persona_arbitro(String cedula_persona_arbitro) {
        this.cedula_persona_arbitro = cedula_persona_arbitro;
    }    

}
