package Modelo;


public class Clase_Gol {
    private int cod_gol;
    private String descripcion;
    private String minuto;
    private int cod_jugador;
    private int cod_equipo;
    private int cod_partido;
    private int estado_elim;

    public Clase_Gol() {
    }

    public Clase_Gol(int cod_gol, String descripcion, String minuto, int cod_jugador, int cod_equipo, int cod_partido, int estado_elim) {
        this.cod_gol = cod_gol;
        this.descripcion = descripcion;
        this.minuto = minuto;
        this.cod_jugador = cod_jugador;
        this.cod_equipo = cod_equipo;
        this.cod_partido = cod_partido;
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

    public int getEstado_elim() {
        return estado_elim;
    }

    public void setEstado_elim(int estado_elim) {
        this.estado_elim = estado_elim;
    }
    
}
