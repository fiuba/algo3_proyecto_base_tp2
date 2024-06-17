package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorPrincipal;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoHoot");
        Image icono = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/icono.png");
        stage.getIcons().add(icono);
        stage.setResizable(false);
        ControladorPrincipal cp = new ControladorPrincipal(stage);
        VistaRegistroJugadores vista = new VistaRegistroJugadores(1280,720);
        stage.setScene(vista);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}