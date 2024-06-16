package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private int puntosTotales;
    private ModificadorIndividual duplicador;
    private ModificadorIndividual triplicador;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.duplicador = new Duplicador();
        this.triplicador = new Triplicador();
        this.puntosTotales = 0;
    }

    public boolean equals(Jugador j) {
        return this.nombre.equals(j.nombre);
    }

    public void gastar(ModificadorIndividual mod) {
        if (duplicador.equals(mod)) {
            duplicador = new ModificadorBase();
        } else if (triplicador.equals(mod)) {
            triplicador = new ModificadorBase();
        }
    }

    public void sumarPuntos(int i) {
        this.puntosTotales += i;
    }

    public int obtenerPuntaje() {
        return this.puntosTotales;
    }
}
