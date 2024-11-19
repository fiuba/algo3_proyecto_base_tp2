package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

public class EscaleraSimple extends ManoDePoker{
    public EscaleraSimple(){
        this.nombre = "escalera simple";
        this.puntaje = new Puntaje(30,4);
        this.probabilidad = 0.3924;
    }
}
