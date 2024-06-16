package edu.fiuba.algo3.vista;

import javafx.scene.layout.FlowPane;

public class JugadorVista extends FlowPane {

    private String nombre;
    private int puntaje;

    public JugadorVista(String nombre, int puntaje, double ancho, double alto) {
        super();
        this.setPrefSize(ancho, alto);
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
}
