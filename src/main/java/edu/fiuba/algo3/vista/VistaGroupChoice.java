package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.botones.BotonPoder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;

public class VistaGroupChoice extends Scene {
    private FlowPane root;
    private VBox opciones;
    public VistaGroupChoice(double width, double height) {
        super(new FlowPane(), width, height);
        double margenAncho = width/32;
        double margenAlto = height/18;
        this.root = (FlowPane) this.getRoot();
        BackgroundImage imagenFondo = new BackgroundImage(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/background.png"),BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(imagenFondo);
        this.root.setBackground(fondo);
        this.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        FlowPane panelTableroJugadores = new FlowPane();
        panelTableroJugadores.setPrefHeight(height - 2*margenAlto);
        panelTableroJugadores.setPrefWidth(floor(width/3 - margenAncho));
        FlowPane.setMargin(panelTableroJugadores,new Insets(margenAlto, 0, margenAlto, margenAncho));
        this.root.getChildren().add(panelTableroJugadores);
        VistaTableroJugadores tablero = new VistaTableroJugadores(panelTableroJugadores.getPrefWidth(), panelTableroJugadores.getPrefHeight());

        panelTableroJugadores.getChildren().add(tablero);
        tablero.agregarJugador("agus",666);
        tablero.agregarJugador("valen",999);
        tablero.agregarJugador("nahu",2);
        tablero.agregarJugador("pat",3);
        tablero.agregarJugador("estebannnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",12);
        tablero.agregarJugador("estebannnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",12);
        tablero.resaltarSiguienteJugador();

        FlowPane panelPregunta = new FlowPane();
        panelPregunta.setPrefHeight(height);
        panelPregunta.setPrefWidth(floor(width * 2/3));
        this.root.getChildren().add(panelPregunta);

        // ESTO NO SE TOCA.
        Label textoPregunta = new Label("¿Cuál fue el aporte más conocido del científico inglés Edgard Codd a la computación?   ");
        textoPregunta.setPrefHeight(height*2/5 - 2*margenAlto);
        textoPregunta.setPrefWidth(width * 2/3 - 2*margenAncho);
        FlowPane.setMargin(textoPregunta,new Insets(margenAlto, margenAncho, margenAlto, margenAncho));
        establecerEstilo(textoPregunta);
        cambiarTamanoFuente(textoPregunta, 32);

        textoPregunta.setWrapText(true);
        panelPregunta.getChildren().add(textoPregunta);


        FlowPane panelBotones = new FlowPane();
        panelBotones.setPrefHeight(height - textoPregunta.getPrefHeight());
        panelBotones.setPrefWidth(textoPregunta.getPrefWidth());
        FlowPane.setMargin(panelBotones,new Insets(0, margenAncho, 0, margenAncho));
        panelPregunta.getChildren().add(panelBotones);

        FlowPane panelOpciones = new FlowPane();
        panelOpciones.setPrefHeight(height/2);
        panelOpciones.setPrefWidth(floor((panelBotones.getPrefWidth())*3/4));
        panelOpciones.setAlignment(Pos.CENTER);
        panelBotones.getChildren().add(panelOpciones);

        FlowPane panelBotonesControl = new FlowPane();
        panelBotonesControl.setPrefHeight(height/2);
        panelBotonesControl.setPrefWidth(floor((panelBotones.getPrefWidth())*1/4));
        panelBotones.getChildren().add(panelBotonesControl);

        FlowPane panelBotonResponder = new FlowPane();
        panelBotonResponder.setPrefHeight(height/8);
        panelBotonResponder.setPrefWidth(panelBotonesControl.getPrefWidth());
        panelBotonResponder.setAlignment(Pos.CENTER);
        panelBotonesControl.getChildren().add(panelBotonResponder);

        ImageView imagenResponder = new ImageView(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/botonResponder.png"));
        Button botonResponder = new Button("", imagenResponder);
        botonResponder.setStyle("-fx-background-color: transparent;");
        panelBotonResponder.getChildren().add(botonResponder);
        File archivoSonidoResponder = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/sonidos/responder.wav");
        Media mediaResponder = new Media(archivoSonidoResponder.toURI().toString());
        AudioClip sonidoResponder = new AudioClip(mediaResponder.getSource());
        sonidoResponder.setVolume(0.1);
        botonResponder.setOnAction(e -> {
            sonidoResponder.play();
            tablero.resaltarSiguienteJugador();
        });

        FlowPane panelBotonesPoderes = new FlowPane();
        panelBotonesPoderes.setPrefHeight(panelBotonesControl.getPrefHeight() - panelBotonResponder.getPrefHeight());
        panelBotonesPoderes.setPrefWidth(panelBotonesControl.getPrefWidth());
        panelBotonesControl.getChildren().add(panelBotonesPoderes);
        VBox poderes = new VBox();
        poderes.setPrefHeight(panelBotonesPoderes.getPrefHeight());
        poderes.setPrefWidth(panelBotonesPoderes.getPrefWidth());
        poderes.setAlignment(Pos.CENTER);
        poderes.setPadding(new Insets(margenAlto,0,0,0));
        poderes.setSpacing(margenAlto/2);
        panelBotonesPoderes.getChildren().add(poderes);


        // ejemplo de ingreso de rtas
        List<String> opcionesLista = new ArrayList<>();

        opcionesLista.add("El disco rígido");
        opcionesLista.add("El sistema operativo Solaris");
        opcionesLista.add("Las bases de datos relacionales");
        opcionesLista.add("El algoritmo quicksort");
        opcionesLista.add("Los lenguajes tipados");

        this.opciones = new VBox();
        opciones.setPrefHeight(panelOpciones.getPrefHeight());
        opciones.setPrefWidth(panelOpciones.getPrefWidth());
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(25);
        panelOpciones.getChildren().add(opciones);

        definirCantidadOpciones(opcionesLista);

        File archivoSonidoSeleccionar = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/sonidos/seleccionar.wav");
        Media mediaSeleccionar = new Media(archivoSonidoSeleccionar.toURI().toString());
        AudioClip sonidoSeleccionar = new AudioClip(mediaSeleccionar.getSource());
        sonidoSeleccionar.setVolume(0.2);

        //aplico sonidos  a opciones
        for (int i = 0; i < opcionesLista.size(); i++) {
            Node opcion =  opciones.getChildren().get(i);
            opcion.setOnMouseClicked(e-> sonidoSeleccionar.play());

        }



        // opcion1.getStyleClass().add("custom-toggle-button");
        // opcion2.getStyleClass().add("custom-toggle-button");
        // opcion1.setPrefWidth(panelOpciones.getPrefWidth()/3);
        // opcion2.setPrefWidth(panelOpciones.getPrefWidth()/3);


        // como es una pregunta VF sin penalidad, se puede usar anulador o exclusividad

        ToggleButton botonAnulador = new BotonPoder("anulador");
        ToggleButton botonExclusividad = new BotonPoder("exclusividad");
        poderes.getChildren().addAll(botonAnulador,botonExclusividad);

    }


    private void establecerEstilo(Node nodo) {
        nodo.setStyle("-fx-background-color: white;" +
                "-fx-border-width: 4px;" +
                "-fx-text-fill: black;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-text-alignment: center;" +
                "-fx-border-color: black;");
    }

    private void cambiarTamanoFuente(Node nodo, int size) {
        String estiloAnterior = nodo.getStyle();
        nodo.setStyle(estiloAnterior + "-fx-font-size: "+size+";");
    }

    private void definirCantidadOpciones(List<String> opcionesLista) {
        for (int i = 0; i < opcionesLista.size(); i++) {
            ToggleButton opcion = new ToggleButton(opcionesLista.get(i));
            opcion.getStyleClass().add("GP-toggle-button");
            opcion.setOnAction(event -> {
                if (opcion.getStyleClass().contains("selected-color1")) {
                        opcion.getStyleClass().remove("selected-color1");
                        opcion.getStyleClass().add("selected-color2");
                } else {
                        opcion.getStyleClass().remove("selected-color2");
                        opcion.getStyleClass().add("selected-color1");
                }
            });

            opciones.getChildren().add(opcion);
            String optionText = opcionesLista.get(i);
        }
    }
}
