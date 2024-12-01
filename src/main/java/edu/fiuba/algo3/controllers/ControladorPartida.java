package main.java.edu.fiuba.algo3.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorPartida implements EventHandler<ActionEvent>  {
    private Stage stage;
    private String jugador;

    public ControladorPartida(Stage stage, String jugador) {
        this.stage = stage;
        this.jugador = jugador;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego j = Juego.getInstancia();
        try {
            j.inicializarBalatro();
        } catch (ArchivoInexistente e) {
            Alert archivoInexistente = new Alert(Alert.AlertType.ERROR);
            archivoInexistente.setTitle("Archivo no encontrado");
            archivoInexistente.setHeaderText("No se encontró el archivo de preguntas.");
            archivoInexistente.show();
        }

        if (jugador.isEmpty()) {
        } else {
                j.agregarJugador(jugador);
                CambiadorDeVistas.cambiarVistaANuevaRonda(stage);
        }
    }

}