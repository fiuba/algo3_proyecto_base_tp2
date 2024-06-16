package edu.fiuba.algo3.vista.botones;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.io.File;

public class CustomToggleButton extends ToggleButton {
    private ImageView graficoON;
    private ImageView graficoOFF;
    private AudioClip sonidoON;
    private AudioClip sonidoOFF;

    public CustomToggleButton(String tipo) {
        super();
        this.graficoON = new ImageView(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/vista/recursos/imagenes/"+tipo+"On.png"));
        this.graficoOFF = new ImageView(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/vista/recursos/imagenes/"+tipo+"Off.png"));

        File archivoSonidoON = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/vista/recursos/sonidos/poderOn.wav");
        Media mediaON = new Media(archivoSonidoON.toURI().toString());
        sonidoON = new AudioClip(mediaON.getSource());
        File archivoSonidoOFF = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/vista/recursos/sonidos/poderOff.wav");
        Media mediaOFF = new Media(archivoSonidoOFF.toURI().toString());
        sonidoOFF = new AudioClip(mediaOFF.getSource());
        this.setGraphic(graficoOFF);
        this.setStyle("-fx-background-color: transparent;");
        this.setOnMouseClicked(e -> this.pulsar());
    }

    private void pulsar() {
        if (this.isSelected()) {
            this.setGraphic(graficoON);
            sonidoON.play();
        } else {
            this.setGraphic(graficoOFF);
            sonidoOFF.play();
        }
    }
}