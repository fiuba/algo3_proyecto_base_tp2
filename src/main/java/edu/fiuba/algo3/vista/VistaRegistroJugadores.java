package edu.fiuba.algo3.vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.io.File;
import java.util.concurrent.Flow;

import static java.lang.Math.floor;


public class VistaRegistroJugadores extends Scene {
    private FlowPane root;
    private VBox boxjugadores;
    private TextField fieldNombreJugador;
    private ObservableList<String> jugadores;
    private int maximoJugadores;
    private AudioClip sonidoError;

    public VistaRegistroJugadores(double width, double height) {
        super(new FlowPane(), width, height);
        double margenAncho = width/32;
        double margenAlto = height/18;
        this.root = (FlowPane) this.getRoot();
        BackgroundImage imagenFondo = new BackgroundImage(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/background.png"),BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(imagenFondo);
        this.root.setBackground(fondo);
        this.getStylesheets().add("styles.css");
        this.jugadores = FXCollections.observableArrayList();
        this.maximoJugadores = 6;
        File archivoSonido = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/sonidos/error.wav");
        Media media = new Media(archivoSonido.toURI().toString());
        sonidoError = new AudioClip(media.getSource());


        FlowPane primerColumna = new FlowPane();
        FlowPane segundaColumna = new FlowPane();
        primerColumna.setPrefWidth(floor(width/3));
        primerColumna.setMaxWidth(floor(width/3));
        primerColumna.setPrefHeight(height);
        segundaColumna.setPrefWidth(floor(width*2/3));
        segundaColumna.setPrefHeight(height);


        FlowPane panelAgregarJugador = new FlowPane();
        panelAgregarJugador.setPrefWidth(segundaColumna.getPrefWidth());
        panelAgregarJugador.setPrefHeight(floor(segundaColumna.getPrefHeight()/3));
        FlowPane restoSegundaColumna = new FlowPane();
        restoSegundaColumna.setPrefWidth(segundaColumna.getPrefWidth());
        restoSegundaColumna.setPrefHeight(floor(segundaColumna.getPrefHeight()*2/3));
        restoSegundaColumna.setAlignment(Pos.CENTER);


        FlowPane panelIngresoNombre = new FlowPane();
        panelIngresoNombre.setPrefWidth(floor(panelAgregarJugador.getPrefWidth()*2/3));
        panelIngresoNombre.setPrefHeight(panelAgregarJugador.getPrefHeight());
        VBox boxIngresoNombre = new VBox();
        boxIngresoNombre.setAlignment(Pos.CENTER);
        panelIngresoNombre.getChildren().add(boxIngresoNombre);

        FlowPane panelBotonesIngreso = new FlowPane();
        panelBotonesIngreso.setPrefWidth(floor(panelAgregarJugador.getPrefWidth()*1/4));
        panelBotonesIngreso.setPrefHeight(panelAgregarJugador.getPrefHeight());
        panelBotonesIngreso.setPadding(new Insets(margenAlto,margenAncho,margenAlto,margenAncho));

        HBox boxBotonesIngreso = new HBox();
        boxBotonesIngreso.setSpacing(panelBotonesIngreso.getPrefWidth()/8);
        boxBotonesIngreso.setAlignment(Pos.CENTER);
        panelBotonesIngreso.getChildren().add(boxBotonesIngreso);

        panelAgregarJugador.getChildren().addAll(panelIngresoNombre, panelBotonesIngreso);
        segundaColumna.getChildren().add(panelAgregarJugador);

        Label textoAgregarJugador = new Label("agregar jugador:");
        textoAgregarJugador.setStyle("-fx-text-fill: black;" +
                        "-fx-font-family: 'Comic Sans MS';" +
                        "-fx-text-alignment: center;" +
                        "-fx-font-size: 32;");
        fieldNombreJugador = new TextField();
        fieldNombreJugador.setPrefWidth(width / 2 - margenAncho);
        fieldNombreJugador.setStyle("-fx-text-fill: black;" +
                        "-fx-font-family: 'Comic Sans MS';" +
                        "-fx-text-alignment: center;" +
                        "-fx-font-size: 32;" +
                        "-fx-background-color: white;" +
                        "-fx-border-width: 4px;" +
                        "-fx-border-color: black;");
        fieldNombreJugador.setOnAction(event -> agregarJugador());

        boxIngresoNombre.getChildren().addAll(textoAgregarJugador,fieldNombreJugador);

        Button botonAgregar = new Button("+");
        botonAgregar.getStyleClass().add("custom-button");
        botonAgregar.setOnAction(event -> agregarJugador());

        Button botonQuitar = new Button("-");
        botonQuitar.getStyleClass().add("custom-button");
        botonQuitar.setOnAction(event -> quitarJugador());

        boxBotonesIngreso.getChildren().addAll(botonAgregar,botonQuitar);


        FlowPane panelListaJugadores = new FlowPane();
        panelListaJugadores.setPrefWidth(primerColumna.getPrefWidth() - 2*margenAncho);
        panelListaJugadores.setPrefHeight(primerColumna.getPrefHeight() - 2*margenAlto);
        FlowPane.setMargin(panelListaJugadores, new Insets(margenAlto,margenAncho,margenAlto,margenAncho));
        this.boxjugadores = new VBox();
        boxjugadores.setPrefWidth(panelListaJugadores.getPrefWidth());
        boxjugadores.setSpacing(margenAlto/2);
        boxjugadores.setAlignment(Pos.CENTER_LEFT);
        boxjugadores.setPadding(new Insets(0,margenAncho/2,0,margenAncho/2));
        panelListaJugadores.getChildren().add(boxjugadores);
        primerColumna.getChildren().add(panelListaJugadores);

        this.root.getChildren().addAll(primerColumna,segundaColumna);


        ImageView imagenJugar = new ImageView(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/botonJugar.png"));
        Button botonjugar = new Button("", imagenJugar);
        botonjugar.setStyle("-fx-background-color: transparent;");
        segundaColumna.getChildren().add(restoSegundaColumna);
        restoSegundaColumna.getChildren().add(botonjugar);

    }

    private void agregarJugador() {
        String nombre = fieldNombreJugador.getText().trim();
        if (!nombre.isEmpty()) {
            if (jugadores.size() >= maximoJugadores) {
                sonidoError.play();
            } else {
                jugadores.add(nombre);
                fieldNombreJugador.clear();

                Label jugadorLabel = new Label(nombre);
                jugadorLabel.setMaxWidth(boxjugadores.getPrefWidth());
                jugadorLabel.setMaxHeight(boxjugadores.getPrefHeight()/12);
                jugadorLabel.setStyle("-fx-text-fill: black;" +
                        "-fx-font-family: 'Comic Sans MS';" +
                        "-fx-text-alignment: center;" +
                        "-fx-font-size: 32;" +
                        "-fx-padding: "+ boxjugadores.getPrefWidth()*1/16+"px");

                this.boxjugadores.getChildren().add(jugadorLabel);
            }
        }
    }

    private void quitarJugador() {
        if (!boxjugadores.getChildren().isEmpty()) {
            jugadores.remove(jugadores.size()-1);
            boxjugadores.getChildren().remove(boxjugadores.getChildren().size() - 1);
        } else {
            sonidoError.play();
        }
    }
}
