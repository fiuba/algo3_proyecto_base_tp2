package edu.fiuba.algo3.controllers;
import java.io.File;
import edu.fiuba.algo3.modelo.ronda.Tienda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.fiuba.algo3.vistas.escenas.VistaTienda;


public abstract class ControladorJugar implements EventHandler<ActionEvent> {
    protected Stage stage;


    public ControladorJugar(Stage stage) {
        this.stage = stage;
    }

    private void cambiarAVistaRonda(Stage stage){
        /* Juego j = Juego.getInstancia();
        Ronda ronda = j.obtenerRondaActual();
        VistaBalatro nuevaVista = new VistaBalatro(stage, stage.getScene().getWidth(), stage.getScene().getHeight(), ronda);
        stage.setScene(nuevaVista); */
    }


}
