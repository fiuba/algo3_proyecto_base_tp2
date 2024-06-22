package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorPrincipal;
import edu.fiuba.algo3.modelo.OpcionCorrecta;
import edu.fiuba.algo3.modelo.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.PreguntaVF;
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
        VistaTableroJugadores tablero = new VistaTableroJugadores();
        tablero.agregarJugador("test",0);
        VistaPreguntaVF vista = new VistaPreguntaVF(stage, 1280, 720,
                new PreguntaVF("los patos saben volar??????", "peces", "sos crak respondiste", new OpcionCorrecta("mas vale"), new OpcionIncorrecta("q van a volar los pajaros esos")),
                tablero);

        VistaPreguntaOrdered vistaOrdered = new VistaPreguntaOrdered(stage, 1280, 720);
        stage.setScene(vista);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}