package edu.fiuba.algo3.vista;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static java.lang.Math.floor;

public class TableroJugadores extends FlowPane {
    private double ancho;
    private double alto;
    private List<JugadorVista> jugadores;
    private ListIterator<JugadorVista> cursor;
    private JugadorVista jugadorActual;

    public TableroJugadores(double ancho, double alto) {
        super();
        this.setPrefSize(ancho, alto);
        this.ancho = ancho;
        this.alto = alto;
        this.jugadores = new ArrayList<>();
        this.cursor = null;
        this.jugadorActual = null;
        this.setStyle("-fx-background-color: white;" +
                "-fx-border-width: 4px;" +
                "-fx-border-color: black;");
    }

    public void agregarJugador(String nombre, int puntaje) {
        JugadorVista nuevoJugador = new JugadorVista(nombre,puntaje,ancho,floor(alto/8));
        jugadores.add(nuevoJugador);
        this.getChildren().add(nuevoJugador);
    }

    public void resaltarSiguienteJugador() {
        if (cursor == null || !cursor.hasNext()) {
            cursor = jugadores.listIterator();
        }
        if (jugadorActual != null) {
            jugadorActual.desResaltar();
        }
        jugadorActual = cursor.next();
        jugadorActual.resaltar();
    }
}
