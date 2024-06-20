package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.botones.BotonPoder;
import edu.fiuba.algo3.vista.botones.BotonGroupChoice;
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

import javax.swing.*;
import java.awt.*;
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
        tablero.agregarJugador("estebannnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",12);
        tablero.agregarJugador("estebannnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",12);
        tablero.agregarJugador("estebannnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",12);
        tablero.agregarJugador("estebannnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",12);
        tablero.agregarJugador("estebannnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",12);
        tablero.agregarJugador("estebannnnnnnnnnnnnnnnnnnnnnnnnnnnnnn",12);
        tablero.resaltarSiguienteJugador();

        FlowPane panelPregunta = new FlowPane();
        panelPregunta.setPrefHeight(height);
        panelPregunta.setPrefWidth(floor(width * 2/3));
        this.root.getChildren().add(panelPregunta);

        // ESTO NO SE TOCA.
        Label textoPregunta = new Label("Asigne las siguientes leyendas del deporte nacional a disciplina grupales (Fútbol, Básquet, Voley, Rugby,) o individuales (atletismo, tenis, artes marciales, ajedrez, etc):");
        textoPregunta.setPrefHeight(height*2/5 - 2*margenAlto);
        textoPregunta.setPrefWidth(width * 2/3 - 2*margenAncho);
        establecerEstilo(textoPregunta);
        cambiarTamanoFuente(textoPregunta, 30);

        //NO TOCAR, sufriran consecuencias

        StackPane contenidoPreguntaGrupos = new StackPane();
        contenidoPreguntaGrupos.setPrefWidth(floor(width * 2/3));
        contenidoPreguntaGrupos.setPrefHeight(height/3);
        StackPane.setMargin(textoPregunta,new Insets(margenAlto, margenAncho, margenAlto, margenAncho));

        HBox contenedorTema = new HBox();
        contenedorTema.setPrefWidth(floor(width * 2/3));
        Label tema = new Label("tematica");
        contenedorTema.setPrefHeight(tema.getPrefHeight());

        establecerEstilo(tema);
        cambiarTamanoFuente(tema, 25);
        contenedorTema.getChildren().add(tema);
        contenedorTema.setAlignment(Pos.TOP_RIGHT);


        HBox grupos = new HBox();
        grupos.setPrefWidth(floor(width * 2/3));
        Label grupo1 = new Label("grupo 1");
        Label grupo2 = new Label("grupo 2");
        grupos.setAlignment(Pos.BOTTOM_CENTER);
        grupos.setSpacing(20);
        cambiarTamanoFuente(grupo1, 20);
        cambiarTamanoFuente(grupo2, 20);
        grupo1.getStyleClass().add("GP-toggle-button");
        grupo1.getStyleClass().add("selected-color1");
        grupo2.getStyleClass().add("GP-toggle-button");
        grupo2.getStyleClass().add("selected-color2");
        grupos.getChildren().addAll(grupo1, grupo2);

        StackPane.setMargin(contenedorTema,new Insets(margenAlto/3, margenAncho/2, 0, 0));
        StackPane.setMargin(grupos,new Insets( textoPregunta.getPrefHeight(), margenAncho, margenAlto/2, margenAncho));

        textoPregunta.setWrapText(true);
        contenidoPreguntaGrupos.getChildren().addAll(textoPregunta,contenedorTema,grupos);
        panelPregunta.getChildren().addAll( contenidoPreguntaGrupos);


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

        opcionesLista.add("Lio Messi");
        opcionesLista.add("Manu Ginóbili");
        opcionesLista.add("Juan Martín del Potro");
        opcionesLista.add("Miguel Najdorf");
        opcionesLista.add("Hugo Conte");
        opcionesLista.add("José Meolans");

        //no toques lpm
        //niño toca, papa paga

        this.opciones = new VBox();
        opciones.setPrefHeight(panelOpciones.getPrefHeight());
        opciones.setPrefWidth(panelOpciones.getPrefWidth());
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(10);
        panelOpciones.getChildren().add(opciones);

        definirCantidadOpciones(opcionesLista);

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
            BotonGroupChoice opcion = new BotonGroupChoice(opcionesLista.get(i));
            opciones.getChildren().add(opcion);

        }

    }
}
