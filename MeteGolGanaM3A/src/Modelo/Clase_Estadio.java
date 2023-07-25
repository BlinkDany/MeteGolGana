/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author ROG STRIX
 */
public class Clase_Estadio {
    
  private int codigo;  
  private String nombre;  
  private int aforo;  
  private String ubicacion;  
  private int cod_equipofk; 
  private boolean estado_elim;
  private String nombreEquipo;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCod_equipofk() {
        return cod_equipofk;
    }

    public void setCod_equipofk(int cod_equipofk) {
        this.cod_equipofk = cod_equipofk;
    }

    public boolean isEstado_elim() {
        return estado_elim;
    }

    public void setEstado_elim(boolean estado_elim) {
        this.estado_elim = estado_elim;
    }
  
}
