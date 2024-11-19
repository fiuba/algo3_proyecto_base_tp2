package edu.fiuba.algo3.entrega_2.parserRondaTienda;

public class Tarot2 {
    private String nombre;
    private String descripcion;
    private String sobre;
    private String ejemplar;
    private int  puntos;
    private int  multiplicador;

    public Tarot2(String nombre, String descripcion, String sobre, String  ejemplar, int puntos, int multiplicador ) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sobre = sobre;
        this.ejemplar = ejemplar;
        this.puntos  = puntos;
        this.multiplicador = multiplicador;
    }

    public String getNombre() {return this.nombre;}

    public boolean esElNombre(String nombre) {return nombre.equals(this.nombre);}
}
