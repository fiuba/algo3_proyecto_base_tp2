package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepciones.ArchivoInexistente;
import edu.fiuba.algo3.vista.VistaGroupChoice;
import edu.fiuba.algo3.vista.botones.NumberField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.List;

public class ControladorConfigurarPartida implements EventHandler<ActionEvent>  {
    private Stage stage;
    private List<String> jugadores;
    private NumberField limitePuntaje;
    private NumberField limitePreguntas;

    public ControladorConfigurarPartida(Stage stage, List<String> jugadores, NumberField limitePuntaje, NumberField limitePreguntas) {
        this.stage = stage;
        this.jugadores = jugadores;
        this.limitePuntaje = limitePuntaje;
        this.limitePreguntas = limitePreguntas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            AlgoHoot a = AlgoHoot.getInstancia();
            jugadores.forEach(jugador -> {a.agregarJugador(new Jugador(jugador));});

            stage.setScene(new VistaGroupChoice(1280,720));
        } catch (ArchivoInexistente e) {
            throw new RuntimeException(e);
        }
    }
}
