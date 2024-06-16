package edu.fiuba.algo3.vista.botones;

import javafx.scene.control.ToggleButton;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.io.File;

public class BotonVF extends ToggleButton {
    private BotonVF otroBoton;
    private AudioClip sonido;
    public BotonVF(String texto) {
        super(texto);
        File archivoSonido = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/sonidos/select.wav");
        Media media = new Media(archivoSonido.toURI().toString());
        this.sonido = new AudioClip(media.getSource());
        this.sonido.setVolume(0.2);
        this.setOnMouseClicked(e -> {
            actualizarGrafico();
            otroBoton.actualizarGrafico();
        });
    }

    public void setOtroBoton(BotonVF otroBoton) {
        this.otroBoton = otroBoton;
    }

    private void actualizarGrafico() {
        String estilo = this.getStyle();
        this.sonido.play();
        if (this.isSelected()) {
            estilo = estilo.replace("-fx-border-color: black;","-fx-border-color: blue;");
            this.setStyle(estilo);
        } else {
            estilo = estilo.replace("-fx-border-color: blue;","-fx-border-color: black;");
            this.setStyle(estilo);
        }
    }
}
