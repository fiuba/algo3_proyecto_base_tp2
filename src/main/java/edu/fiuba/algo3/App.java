package edu.fiuba.algo3;

import edu.fiuba.algo3.Utilidades.InicializadorJuego;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        InicializadorJuego inicializadorJuego = new InicializadorJuego();
        inicializadorJuego.iniciar();
    }

    public static void main(String[] args) {
        launch();
    }

}