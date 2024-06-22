package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
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

        VistaPreguntaOC vistaOrdered = new VistaPreguntaOC(stage, 1280, 720,
                new PreguntaOC("ordenar segun tengas ganas total no se verifica nada :p", "mesi", "hola", new Opcion("esta va primero"), new Opcion("esta va segundo"), new Opcion("tercera"), new Opcion("esta tambien va primera"), new Opcion("catorce")),
                tablero);
        stage.setScene(vistaOrdered);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}