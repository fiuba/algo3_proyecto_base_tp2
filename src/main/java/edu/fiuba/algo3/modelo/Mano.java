package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class Mano {
    private ArrayList<Carta> cartas;

    public Mano() {
        this.cartas = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            this.cartas.add(new Carta());
        }
    }

    public ArrayList<Carta> obtenerCartas() {
        return cartas;
    }
}
