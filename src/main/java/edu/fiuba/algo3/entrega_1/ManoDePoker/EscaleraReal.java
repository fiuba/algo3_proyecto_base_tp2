package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

import java.util.Objects;

public class EscaleraReal extends ManoDePoker{
    String nombre;
    Puntaje puntaje;

    public EscaleraReal(){
        this.nombre = "escalera real";
        this.puntaje = new Puntaje(100,8);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        EscaleraReal otraEscalera = (EscaleraReal) obj;
        return(Objects.equals(nombre,otraEscalera.nombre));
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }
}
