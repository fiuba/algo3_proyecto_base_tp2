package edu.fiuba.algo3.entrega_2.comodin;

import edu.fiuba.algo3.entrega_2.comodin.efecto.Efecto;

public class Comodin {
    private String nombre;
    private String descripcion;
    private String activacion;
    private Efecto efecto;

    public Comodin(String nombre, String descripcion, String activacion, Efecto efecto, int puntos, int multiplicador){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activacion = activacion;
        this.efecto = new Efecto(puntos, multiplicador);
    }
}
