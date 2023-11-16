package edu.fiuba.algo3.modelo;
import java.util;
public class Jugador {
    private int energia;
    private String seniority;
    private String equipamiento;

    public Jugador() {
        this.energia = 20;
        this.seniority = "Novato";
        this.equipamiento = null;
    }

    public void aumentarEnergia(int energia) {
        this.energia += energia;
    }

    public void disminuirEnergia(int energia) {
        this.energia -= energia;
    }
//uu
    public boolean tieneEnergia(int energia) {
        return (this.energia == energia);
    }
}