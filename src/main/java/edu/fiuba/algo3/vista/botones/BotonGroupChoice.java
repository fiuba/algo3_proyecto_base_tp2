package edu.fiuba.algo3.vista.botones;

import javafx.scene.control.ToggleButton;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.io.File;

public class BotonGroupChoice extends ToggleButton {
        private String estilo;
        private AudioClip sonido;

        public BotonGroupChoice(String text) {
            super(text);
            this.getStyleClass().add("GP-toggle-button");
            this.estilo = this.getStyle();
            File archivoSonidoSeleccionar = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/sonidos/seleccionar.wav");
            Media mediaSeleccionar = new Media(archivoSonidoSeleccionar.toURI().toString());
            this.sonido  = new AudioClip(mediaSeleccionar.getSource());
            this.sonido.setVolume(0.2);
            this.setOnMouseClicked(e -> {
                this.sonido.play();
                actualizarGrafico();
            });


        }

        private void actualizarGrafico() {
            if (this.isSelected()) {
                this.getStyleClass().remove("selected-color1");
                this.getStyleClass().add("selected-color2");
                this.estilo = "selected-color2";
                System.out.println(this.estilo);
            } else {
                this.getStyleClass().remove("selected-color2");
                this.getStyleClass().add("selected-color1");
                this.estilo = "selected-color1";
                System.out.println(this.estilo);
            }
        }

         public String getEstilo() {
            return estilo;
         }
    }

