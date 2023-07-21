/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author tatip
 */
public class Clase_Campeonato {
    
    private int cod_campeonato;
    private String nombre;
    private String tipo_campeonato;
    private int max_equipos;
    private boolean estado_elim;

    public Clase_Campeonato() {
    }

    public Clase_Campeonato(int cod_campeonato, String nombre, String tipo_campeonato, int max_equipos, boolean estado_elim) {
        this.cod_campeonato = cod_campeonato;
        this.nombre = nombre;
        this.tipo_campeonato = tipo_campeonato;
        this.max_equipos = max_equipos;
        this.estado_elim = estado_elim;
    }

    public Clase_Campeonato(int cod_campeonato, String nombre, String tipo_campeonato, int max_equipos) {
        this.cod_campeonato = cod_campeonato;
        this.nombre = nombre;
        this.tipo_campeonato = tipo_campeonato;
        this.max_equipos = max_equipos;
    }

    public int getCod_campeonato() {
        return cod_campeonato;
    }

    public void setCod_campeonato(int cod_campeonato) {
        this.cod_campeonato = cod_campeonato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_campeonato() {
        return tipo_campeonato;
    }

    public void setTipo_campeonato(String tipo_campeonato) {
        this.tipo_campeonato = tipo_campeonato;
    }

    public int getMax_equipos() {
        return max_equipos;
    }

    public void setMax_equipos(int max_equipos) {
        this.max_equipos = max_equipos;
    }

    public boolean isEstado_elim() {
        return estado_elim;
    }

    public void setEstado_elim(boolean estado_elim) {
        this.estado_elim = estado_elim;
    }
    
    
    
}
