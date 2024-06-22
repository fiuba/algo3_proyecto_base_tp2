package edu.fiuba.algo3.controladores;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.io.File;

public class ControladorResponderVF implements EventHandler<ActionEvent> {
    private Stage stage;
    private ToggleGroup opciones;
    private ObservableList<Node> poderes;
    private AudioClip sonidoSeleccion;
    private AudioClip sonidoSinSeleccion;

    public ControladorResponderVF(Stage stage, ToggleGroup opciones, ObservableList<Node> poderes) {
        this.stage = stage;
        this.opciones = opciones;
        this.poderes = poderes;
        File archivo = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/sonidos/responder.wav");
        Media media = new Media(archivo.toURI().toString());
        this.sonidoSeleccion = new AudioClip(media.getSource());
        this.sonidoSeleccion.setVolume(0.1);
        File archivo2 = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/sonidos/sinSeleccion.mp3");
        Media media2 = new Media(archivo2.toURI().toString());
        this.sonidoSinSeleccion = new AudioClip(media2.getSource());
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        ToggleButton eleccion = (ToggleButton) opciones.getSelectedToggle();
        if (eleccion == null) {
            if (sonidoSinSeleccion.isPlaying()) {sonidoSinSeleccion.stop();}
            sonidoSinSeleccion.play();
            // no se seleccionó ninguna opción
            System.out.println("no seleccionaste ninguna opcion");

        } else {
            sonidoSeleccion.play();

            System.out.println("seleccionaste: " + eleccion.getText());
        }
    }
}
