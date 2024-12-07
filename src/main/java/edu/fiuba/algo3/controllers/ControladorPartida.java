package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.controllers.Factory.FactoryComodines;
import edu.fiuba.algo3.controllers.Factory.FactoryDeMaso;
import edu.fiuba.algo3.controllers.Factory.FactoryDeTarot;
import edu.fiuba.algo3.controllers.Factory.FactoryRondas;
import edu.fiuba.algo3.modelo.Balatro.Balatro;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import edu.fiuba.algo3.modelo.GeneradorDeCartas.GeneradorDeCartas;

public class ControladorPartida {
    private Stage stage;
    private String jugador;

    public ControladorPartida(Stage stage) {
        this.stage = stage;

    }

    public void handle(String jugador) {
        FactoryComodines factoryComodines = new FactoryComodines("src/main/resources/comodines.json");
        FactoryDeMaso factoryDeMaso = new FactoryDeMaso("src/main/resources/mazo.json");
        FactoryDeTarot factoryDeTarot = new FactoryDeTarot("src/main/resources/tarots.json");
        FactoryRondas factoryRondas = new FactoryRondas("src/main/resources/balatro.json",factoryDeTarot, factoryDeMaso, factoryComodines );
        GeneradorDeCartas generadorDeCartas = new GeneradorDeCartas();
        Mazo mazo = new Mazo(generadorDeCartas);

        List<Ronda> rondasList = new ArrayList<>();
        try {
            rondasList = factoryRondas.generarRondas();
        } catch (IOException e) {
            System.err.println("Error al generar rondas: " + e.getMessage());
        }

        // Verificamos si 'jugador' no está vacío antes de proceder
        if (jugador.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("El nombre del jugador no puede estar vacío.");
            alerta.showAndWait();
        } else {
            if (rondasList.isEmpty()) {
                System.err.println("No se generaron rondas. Iniciando con una lista vacía.");
            }
            ArrayList<Ronda> rondas = new ArrayList<>(rondasList);
            Balatro balatro = Balatro.inicializarBalatro(rondas, mazo, jugador);

            ControladorPrincipal controlador = new ControladorPrincipal(stage);
            controlador.empezarPartida();
        }
    }

}