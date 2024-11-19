package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

public class Trio extends ManoDePoker{
    public Trio(){
        this.nombre = "trio";
        this.puntaje = new Puntaje(30,3);
        this.probabilidad = 2.1128;
    }
}
