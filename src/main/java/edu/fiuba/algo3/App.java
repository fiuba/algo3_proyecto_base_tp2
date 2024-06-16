package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorPrincipal;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.vista.VistaMenuPrincipal;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoHoot");
        stage.setResizable(false);
        ControladorPrincipal cp = new ControladorPrincipal(stage);
        VistaMenuPrincipal vista = new VistaMenuPrincipal(cp,1280,720);
        stage.setScene(vista);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}