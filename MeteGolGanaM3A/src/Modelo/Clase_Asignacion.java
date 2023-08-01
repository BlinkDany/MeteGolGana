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
    private String nombre_Arbitro;
    private String apellido_Arbitro;
    private String equipo_1;
    private String equipo_2;

    public Clase_Asignacion() {
    }

    public Clase_Asignacion(int codigo_asignacion, Date fecha_asignacion, int codigo_arbitro_asignacion, int codigo_partido_asignacion, boolean estado_asignacion, String nombre_Arbitro, String apellido_Arbitro, String equipo_1, String equipo_2) {
        this.codigo_asignacion = codigo_asignacion;
        this.fecha_asignacion = fecha_asignacion;
        this.codigo_arbitro_asignacion = codigo_arbitro_asignacion;
        this.codigo_partido_asignacion = codigo_partido_asignacion;
        this.estado_asignacion = estado_asignacion;
        this.nombre_Arbitro = nombre_Arbitro;
        this.apellido_Arbitro = apellido_Arbitro;
        this.equipo_1 = equipo_1;
        this.equipo_2 = equipo_2;
    }

    public String getNombre_Arbitro() {
        return nombre_Arbitro;
    }

    public void setNombre_Arbitro(String nombre_Arbitro) {
        this.nombre_Arbitro = nombre_Arbitro;
    }

    public String getApellido_Arbitro() {
        return apellido_Arbitro;
    }

    public void setApellido_Arbitro(String apellido_Arbitro) {
        this.apellido_Arbitro = apellido_Arbitro;
    }

    public String getEquipo_1() {
        return equipo_1;
    }

    public void setEquipo_1(String equipo_1) {
        this.equipo_1 = equipo_1;
    }

    public String getEquipo_2() {
        return equipo_2;
    }

    public void setEquipo_2(String equipo_2) {
        this.equipo_2 = equipo_2;
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
