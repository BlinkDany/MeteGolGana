package Modelo;


public class Clase_Gol {
    private int cod_gol;
    private String descripcion;
    private String minuto;
    private int cod_jugador;
    private int cod_equipo;
    private int cod_partido;
    private String nombre_jugador;
    private String nombre_equipo;
    private boolean estado_elim;

    public Clase_Gol() {
    }

    public Clase_Gol(int cod_gol, String descripcion, String minuto, int cod_jugador, int cod_equipo, int cod_partido, String nombre_jugador, String nombre_equipo, boolean estado_elim) {
        this.cod_gol = cod_gol;
        this.descripcion = descripcion;
        this.minuto = minuto;
        this.cod_jugador = cod_jugador;
        this.cod_equipo = cod_equipo;
        this.cod_partido = cod_partido;
        this.nombre_jugador = nombre_jugador;
        this.nombre_equipo = nombre_equipo;
        this.estado_elim = estado_elim;
    }

    public String getNombre_jugador() {
        return nombre_jugador;
    }

    public void setNombre_jugador(String nombre_jugador) {
        this.nombre_jugador = nombre_jugador;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public boolean isEstado_elim() {
        return estado_elim;
    }

    public void setEstado_elim(boolean estado_elim) {
        this.estado_elim = estado_elim;
    }

    public int getCod_gol() {
        return cod_gol;
    }

    public void setCod_gol(int cod_gol) {
        this.cod_gol = cod_gol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public int getCod_jugador() {
        return cod_jugador;
    }

    public void setCod_jugador(int cod_jugador) {
        this.cod_jugador = cod_jugador;
    }

    public int getCod_equipo() {
        return cod_equipo;
    }

    public void setCod_equipo(int cod_equipo) {
        this.cod_equipo = cod_equipo;
    }

    public int getCod_partido() {
        return cod_partido;
    }

    public void setCod_partido(int cod_partido) {
        this.cod_partido = cod_partido;
    }

    
}
