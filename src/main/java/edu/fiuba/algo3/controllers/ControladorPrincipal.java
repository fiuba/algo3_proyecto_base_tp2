package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Balatro.Balatro;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ControladorPrincipal {
    private Stage stage;
    private Ronda ronda;

    public ControladorPrincipal(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage(){
        return stage;
    }

    public void empezarPartida(){
        Balatro balatro = Balatro.getInstancia();
        this.ronda = balatro.jugar();
        CambiadorDeVistas.cambiarVistaANuevaRonda(stage, this.ronda);
    }

    public void cambiarVistaARonda(List<Object> elementos, Ronda ronda){
        ControladorJugar controladorJugar = new ControladorJugar(stage);
        controladorJugar.cambiarAVistaRonda(elementos, ronda); // Asigna el controlador al evento.
    }


}