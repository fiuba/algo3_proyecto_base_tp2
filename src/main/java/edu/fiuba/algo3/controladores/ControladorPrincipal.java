package edu.fiuba.algo3.controladores;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorPrincipal {
    private Stage stage;

    public ControladorPrincipal(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage(){
        return stage;
    }
}
