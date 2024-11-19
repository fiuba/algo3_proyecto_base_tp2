package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;
import edu.fiuba.algo3.entrega_1.carta.Carta;

import java.util.ArrayList;
import java.util.Objects;


public abstract class ManoDePoker {
    protected String nombre;
    protected Puntaje puntaje;

    public int jugar(ArrayList<Carta> cartas){
        Puntaje sumaDePuntajes = this.puntaje;
        for (Carta carta : cartas){
            Puntaje puntajeDeCarta = carta.calcularPuntaje();
            sumaDePuntajes.sumarConPuntaje(puntajeDeCarta);
        }
        return this.puntaje.calcularPuntaje();
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        ManoDePoker otraManoDePoker = (ManoDePoker) obj;
        return(Objects.equals(nombre,otraManoDePoker.nombre));
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }


}

