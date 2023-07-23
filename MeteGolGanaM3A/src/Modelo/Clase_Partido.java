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
    private String grupo;
    private String estado;
    private int cod_equipo1;
    private int cod_equipo2;
    private boolean estado_elim;

    public Clase_Partido() {
    }

    public Clase_Partido(int cod_partido, int cod_estadio, int cod_temporadafk, Date fecha, String grupo, String estado, int cod_equipo1, int cod_equipo2, boolean estado_elim) {
        this.cod_partido = cod_partido;
        this.cod_estadio = cod_estadio;
        this.cod_temporadafk = cod_temporadafk;
        this.fecha = fecha;
        this.grupo = grupo;
        this.estado = estado;
        this.cod_equipo1 = cod_equipo1;
        this.cod_equipo2 = cod_equipo2;
        this.estado_elim = estado_elim;
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
