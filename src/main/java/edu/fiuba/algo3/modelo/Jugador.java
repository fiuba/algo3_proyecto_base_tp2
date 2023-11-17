package edu.fiuba.algo3.modelo;


//Decorator pattern para equipamiento ?¿
public class Jugador{
    private Gladiador gladiador;

    //private Casilla casilla;

    public Jugador(Gladiador gladiador) {
        this.gladiador = gladiador;
    }

    public boolean energiaIgualA(int energia){
        return this.gladiador.energiaIgualA(energia);
    }


}