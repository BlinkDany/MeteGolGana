/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author blink
 */
public class Clase_Resumen_Partido {
    
    private int codigo;
    private int faltas;
    private int tarjetas_amarillas;
    private int tarjetas_rojas;
    private int tiros_esquina;
    private int saques_mano;
    private int tiros_libres;
    private int penales;
    private int codigo_equipofk;
    private int codigo_partidofk;
    private boolean estado_elim;
    private int goles;

    public Clase_Resumen_Partido() {
    }

    public Clase_Resumen_Partido(int codigo, int faltas, int tarjetas_amarillas, int tarjetas_rojas, int tiros_esquina, int saques_mano, int tiros_libres, int penales, int codigo_equipofk, int codigo_partidofk, boolean estado_elim) {
        this.codigo = codigo;
        this.faltas = faltas;
        this.tarjetas_amarillas = tarjetas_amarillas;
        this.tarjetas_rojas = tarjetas_rojas;
        this.tiros_esquina = tiros_esquina;
        this.saques_mano = saques_mano;
        this.tiros_libres = tiros_libres;
        this.penales = penales;
        this.codigo_equipofk = codigo_equipofk;
        this.codigo_partidofk = codigo_partidofk;
        this.estado_elim = estado_elim;
    }

    public Clase_Resumen_Partido(int codigo, int faltas, int tarjetas_amarillas, int tarjetas_rojas, int tiros_esquina, int saques_mano, int tiros_libres, int penales, int codigo_equipofk, int codigo_partidofk, boolean estado_elim, int goles) {
        this.codigo = codigo;
        this.faltas = faltas;
        this.tarjetas_amarillas = tarjetas_amarillas;
        this.tarjetas_rojas = tarjetas_rojas;
        this.tiros_esquina = tiros_esquina;
        this.saques_mano = saques_mano;
        this.tiros_libres = tiros_libres;
        this.penales = penales;
        this.codigo_equipofk = codigo_equipofk;
        this.codigo_partidofk = codigo_partidofk;
        this.estado_elim = estado_elim;
        this.goles = goles;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getTarjetas_amarillas() {
        return tarjetas_amarillas;
    }

    public void setTarjetas_amarillas(int tarjetas_amarillas) {
        this.tarjetas_amarillas = tarjetas_amarillas;
    }

    public int getTarjetas_rojas() {
        return tarjetas_rojas;
    }

    public void setTarjetas_rojas(int tarjetas_rojas) {
        this.tarjetas_rojas = tarjetas_rojas;
    }

    public int getTiros_esquina() {
        return tiros_esquina;
    }

    public void setTiros_esquina(int tiros_esquina) {
        this.tiros_esquina = tiros_esquina;
    }

    public int getSaques_mano() {
        return saques_mano;
    }

    public void setSaques_mano(int saques_mano) {
        this.saques_mano = saques_mano;
    }

    public int getTiros_libres() {
        return tiros_libres;
    }

    public void setTiros_libres(int tiros_libres) {
        this.tiros_libres = tiros_libres;
    }

    public int getPenales() {
        return penales;
    }

    public void setPenales(int penales) {
        this.penales = penales;
    }

    public int getCodigo_equipofk() {
        return codigo_equipofk;
    }

    public void setCodigo_equipofk(int codigo_equipofk) {
        this.codigo_equipofk = codigo_equipofk;
    }

    public int getCodigo_partidofk() {
        return codigo_partidofk;
    }

    public void setCodigo_partidofk(int codigo_partidofk) {
        this.codigo_partidofk = codigo_partidofk;
    }

    public boolean isEstado_elim() {
        return estado_elim;
    }

    public void setEstado_elim(boolean estado_elim) {
        this.estado_elim = estado_elim;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
    
}
