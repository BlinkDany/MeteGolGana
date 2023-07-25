/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Carlos
 */
public class Clase_Asignacion {
    private int codigo_asignacion;
    private Date fecha_asignacion;
    private int codigo_arbitro_asignacion;
    private int codigo_partido_asignacion;
    private boolean estado_asignacion;

    public Clase_Asignacion() {
    }

    public Clase_Asignacion(int codigo_asignacion, Date fecha_asignacion, int codigo_arbitro_asignacion, int codigo_partido_asignacion, boolean estado_asignacion) {
        this.codigo_asignacion = codigo_asignacion;
        this.fecha_asignacion = fecha_asignacion;
        this.codigo_arbitro_asignacion = codigo_arbitro_asignacion;
        this.codigo_partido_asignacion = codigo_partido_asignacion;
        this.estado_asignacion = estado_asignacion;
    }

    public int getCodigo_asignacion() {
        return codigo_asignacion;
    }

    public void setCodigo_asignacion(int codigo_asignacion) {
        this.codigo_asignacion = codigo_asignacion;
    }

    public Date getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public int getCodigo_arbitro_asignacion() {
        return codigo_arbitro_asignacion;
    }

    public void setCodigo_arbitro_asignacion(int codigo_arbitro_asignacion) {
        this.codigo_arbitro_asignacion = codigo_arbitro_asignacion;
    }

    public int getCodigo_partido_asignacion() {
        return codigo_partido_asignacion;
    }

    public void setCodigo_partido_asignacion(int codigo_partido_asignacion) {
        this.codigo_partido_asignacion = codigo_partido_asignacion;
    }

    public boolean isEstado_asignacion() {
        return estado_asignacion;
    }

    public void setEstado_asignacion(boolean estado_asignacion) {
        this.estado_asignacion = estado_asignacion;
    }
    
    
    
}
