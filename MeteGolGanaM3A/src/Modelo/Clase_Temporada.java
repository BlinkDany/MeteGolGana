/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author tatip
 */
public class Clase_Temporada {
     private int codigoPk;
    private Date fechaIni;
    private Date fechaFin;
    private int codCampeonatoFk;
    private boolean estadoEli;

    public Clase_Temporada() {
    }

    

    public Clase_Temporada(int codigoPk, Date fechaIni, Date fechaFin, int codCampeonatoFk) {
        this.codigoPk = codigoPk;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.codCampeonatoFk = codCampeonatoFk;
    }

    public Clase_Temporada(int codigoPk, Date fechaIni, Date fechaFin, int codCampeonatoFk, boolean estadoEli) {
        this.codigoPk = codigoPk;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.codCampeonatoFk = codCampeonatoFk;
        this.estadoEli = estadoEli;
    }

    public int getCodigoPk() {
        return codigoPk;
    }

    public void setCodigoPk(int codigoPk) {
        this.codigoPk = codigoPk;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCodCampeonatoFk() {
        return codCampeonatoFk;
    }

    public void setCodCampeonatoFk(int codCampeonatoFk) {
        this.codCampeonatoFk = codCampeonatoFk;
    }

    public boolean isEstadoEli() {
        return estadoEli;
    }

    public void setEstadoEli(boolean estadoEli) {
        this.estadoEli = estadoEli;
    }
    
}
