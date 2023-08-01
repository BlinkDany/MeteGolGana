/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;



/**
 *
 * @author Usuario
 */
public class Clase_Partido {

    private int cod_partido;
    private int cod_estadio;
    private int cod_temporadafk;
    private Date fecha;
    private Date fechaantes;
    private Date fechadespues;
    private String grupo;
    private String estado;
    private int cod_equipo1;
    private int cod_equipo2;
    private String nombre_estadio;
    private String nombreequipo1;
    private String nombreequipo2;
    
    private boolean estado_elim;

    public Clase_Partido() {
    }

    public Clase_Partido(int cod_partido, int cod_estadio, int cod_temporadafk, Date fecha, Date fechaantes, Date fechadespues, String grupo, String estado, int cod_equipo1, int cod_equipo2, String nombre_estadio, String nombreequipo1, String nombreequipo2, boolean estado_elim) {
        this.cod_partido = cod_partido;
        this.cod_estadio = cod_estadio;
        this.cod_temporadafk = cod_temporadafk;
        this.fecha = fecha;
        this.fechaantes = fechaantes;
        this.fechadespues = fechadespues;
        this.grupo = grupo;
        this.estado = estado;
        this.cod_equipo1 = cod_equipo1;
        this.cod_equipo2 = cod_equipo2;
        this.nombre_estadio = nombre_estadio;
        this.nombreequipo1 = nombreequipo1;
        this.nombreequipo2 = nombreequipo2;
        this.estado_elim = estado_elim;
    }

    public Date getFechaantes() {
        return fechaantes;
    }

    public void setFechaantes(Date fechaantes) {
        this.fechaantes = fechaantes;
    }

    public Date getFechadespues() {
        return fechadespues;
    }

    public void setFechadespues(Date fechadespues) {
        this.fechadespues = fechadespues;
    }

    

    public String getNombre_estadio() {
        return nombre_estadio;
    }

    public void setNombre_estadio(String nombre_estadio) {
        this.nombre_estadio = nombre_estadio;
    }

    public String getNombreequipo1() {
        return nombreequipo1;
    }

    public void setNombreequipo1(String nombreequipo1) {
        this.nombreequipo1 = nombreequipo1;
    }

    public String getNombreequipo2() {
        return nombreequipo2;
    }

    public void setNombreequipo2(String nombreequipo2) {
        this.nombreequipo2 = nombreequipo2;
    }


    public int getCod_partido() {
        return cod_partido;
    }

    public void setCod_partido(int cod_partido) {
        this.cod_partido = cod_partido;
    }

    public int getCod_estadio() {
        return cod_estadio;
    }

    public void setCod_estadio(int cod_estadio) {
        this.cod_estadio = cod_estadio;
    }

    public int getCod_temporadafk() {
        return cod_temporadafk;
    }

    public void setCod_temporadafk(int cod_temporadafk) {
        this.cod_temporadafk = cod_temporadafk;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCod_equipo1() {
        return cod_equipo1;
    }

    public void setCod_equipo1(int cod_equipo1) {
        this.cod_equipo1 = cod_equipo1;
    }

    public int getCod_equipo2() {
        return cod_equipo2;
    }

    public void setCod_equipo2(int cod_equipo2) {
        this.cod_equipo2 = cod_equipo2;
    }

    public boolean isEstado_elim() {
        return estado_elim;
    }

    public void setEstado_elim(boolean estado_elim) {
        this.estado_elim = estado_elim;
    }

}
