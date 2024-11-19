package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

public class EscaleraColor extends ManoDePoker{
    public EscaleraColor(){
        this.nombre = "escalera color";
        this.puntaje = new Puntaje(100,8);
        this.probabilidad = 0.0013;
    }
}
