package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

public class DoblePar extends ManoDePoker{
    public DoblePar(){
        this.nombre = "doble par";
        this.puntaje = new Puntaje(20,2);
    }
}
