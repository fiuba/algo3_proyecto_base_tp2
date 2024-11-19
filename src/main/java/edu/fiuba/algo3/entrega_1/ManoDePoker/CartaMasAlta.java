package edu.fiuba.algo3.entrega_1.ManoDePoker;


import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

public class CartaMasAlta extends ManoDePoker{

    public CartaMasAlta(){
        this.nombre = "carta mas alta";
        this.puntaje = new Puntaje(5,1);
    }

}
