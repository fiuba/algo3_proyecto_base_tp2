package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

public class FullHouse extends ManoDePoker {
    public FullHouse(){
        this.nombre = "full";
        this.puntaje = new Puntaje(40,4);
    }
}
