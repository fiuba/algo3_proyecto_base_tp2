package edu.fiuba.algo3.vista;

import javafx.scene.layout.VBox;

import java.util.List;

public class TableroJugadores extends VBox {
    private List<JugadorVista> jugadores;

    public TableroJugadores(double ancho, double alto) {
        super();
        this.setPrefSize(ancho, alto);
    }
}
