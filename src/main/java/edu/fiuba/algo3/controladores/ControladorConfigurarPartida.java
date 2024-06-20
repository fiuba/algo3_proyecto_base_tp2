package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.ArchivoInexistente;
import edu.fiuba.algo3.vista.VistaGroupChoice;
import edu.fiuba.algo3.vista.botones.NumberField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class ControladorConfigurarPartida implements EventHandler<ActionEvent>  {
    private Stage stage;
    private List<String> jugadores;
    private NumberField limitePuntaje;
    private NumberField limitePreguntas;
    private AudioClip sonidoError;

    public ControladorConfigurarPartida(Stage stage, List<String> jugadores, NumberField limitePuntaje, NumberField limitePreguntas) {
        this.stage = stage;
        this.jugadores = jugadores;
        this.limitePuntaje = limitePuntaje;
        this.limitePreguntas = limitePreguntas;
        File archivoSonido = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/sonidos/error.wav");
        Media media = new Media(archivoSonido.toURI().toString());
        sonidoError = new AudioClip(media.getSource());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        AlgoHoot a = AlgoHoot.getInstancia();
    }
}
