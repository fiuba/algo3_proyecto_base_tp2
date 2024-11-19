package edu.fiuba.algo3.entrega_2.ParserComodin;

public class ComodinParseado {
    private String nombre;
    private String descripcion;
    private String puntos;
    private String multiplicador;
    private Object activacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Object getActivacion() {
        return activacion;
    }

    public void setActivacion(String activacion) {
        this.activacion = activacion;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(String multiplicador) {
        this.multiplicador = multiplicador;
    }
}

