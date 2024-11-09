package edu.fiuba.algo3.entrega_1.Jugador;

public class Jugador {
    private String nombre;
    private Mano mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }


    public void asignarMano(Mano mano) {
        this.mano = mano;
    }

    public boolean puedeJugar() {
        return this.mano.esManoCompleta();
    }
}
