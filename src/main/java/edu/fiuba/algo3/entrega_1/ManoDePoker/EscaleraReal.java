package edu.fiuba.algo3.entrega_1.ManoDePoker;

import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

public class EscaleraReal extends ManoDePoker{
    public EscaleraReal(){
        this.nombre = "escalera real";
        this.puntaje = new Puntaje(100,8);
    }
}

