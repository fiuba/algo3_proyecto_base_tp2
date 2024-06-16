package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.VistaInicio;
import edu.fiuba.algo3.vista.VistaPregunta;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoHoot");
        stage.setResizable(false);
        VistaInicio vistaInicio= new VistaInicio(stage,1280,720);
        stage.setScene(vistaInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}