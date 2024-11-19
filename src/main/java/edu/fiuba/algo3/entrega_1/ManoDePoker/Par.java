package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

public class Par extends ManoDePoker{
    public Par(){
        this.nombre = "par ";
        this.puntaje = new Puntaje(10,2);
    }
}
