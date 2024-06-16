package edu.fiuba.algo3.vista;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URI;
import java.util.concurrent.Flow;

import static java.lang.Math.floor;

public class VistaPregunta extends Scene {
    private FlowPane root;
    public VistaPregunta (double width, double height) {
        super(new FlowPane(), width, height);
        double margenAncho = width/32;
        double margenAlto = height/18;
        this.root = (FlowPane) this.getRoot();
        BackgroundImage imagenFondo = new BackgroundImage(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/vista/recursos/imagenes/background.png"),BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(imagenFondo);
        this.root.setBackground(fondo);

        FlowPane panelTableroJugadores = new FlowPane();
        panelTableroJugadores.setPrefHeight(height);
        panelTableroJugadores.setPrefWidth(floor(width/3));
        this.root.getChildren().add(panelTableroJugadores);

        FlowPane panelPregunta = new FlowPane();
        panelPregunta.setPrefHeight(height);
        panelPregunta.setPrefWidth(floor(width * 2/3));
        this.root.getChildren().add(panelPregunta);

        // ESTO NO SE TOCA.
        Label textoPregunta = new Label("El punto de ebullición del agua a 3300m del mar es 100 grados centígrados");
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

        ImageView imagenResponder = new ImageView(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/vista/recursos/imagenes/botonResponder.png"));
        Button botonResponder = new Button("", imagenResponder);
        botonResponder.setStyle("-fx-background-color: transparent;");
        panelBotonResponder.getChildren().add(botonResponder);
        File archivoSonidoResponder = new File(System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/vista/recursos/sonidos/responder.wav");
        Media mediaResponder = new Media(archivoSonidoResponder.toURI().toString());
        AudioClip sonidioResponder = new AudioClip(mediaResponder.getSource());
        botonResponder.setOnAction(e -> { sonidioResponder.play(); });

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

        // esto es propio de la pregunta VF.
        HBox opciones = new HBox();
        opciones.setPrefHeight(panelOpciones.getPrefHeight());
        opciones.setPrefWidth(panelOpciones.getPrefWidth());
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(margenAncho);
        panelOpciones.getChildren().add(opciones);

        RadioButton opcion1 = new RadioButton("Verdadero");
        RadioButton opcion2 = new RadioButton("Falso");
        ToggleGroup grupoOpciones = new ToggleGroup();
        opcion1.setToggleGroup(grupoOpciones);
        opcion2.setToggleGroup(grupoOpciones);
        opcion1.setPrefWidth(panelOpciones.getPrefWidth()/3);
        opcion2.setPrefWidth(panelOpciones.getPrefWidth()/3);
        establecerEstilo(opcion1);
        establecerEstilo(opcion2);
        cambiarTamanoFuente(opcion1,26);
        cambiarTamanoFuente(opcion2,26);
        opciones.getChildren().addAll(opcion1,opcion2);

        // como es una pregunta VF sin penalidad, se puede usar anulador o exclusividad


        ImageView imagenAnulador = new ImageView(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/vista/recursos/imagenes/botonAnulador.png"));
        ToggleButton botonAnulador = new ToggleButton("", imagenAnulador);
        botonAnulador.setStyle("-fx-background-color: transparent;");
        poderes.getChildren().add(botonAnulador);

        ImageView imagenDuplicador = new ImageView(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/vista/recursos/imagenes/botonDuplicador.png"));
        ToggleButton botonDuplicador = new ToggleButton("", imagenDuplicador);
        botonDuplicador.setStyle("-fx-background-color: transparent;");
        botonDuplicador.setDisable(true);
        poderes.getChildren().add(botonDuplicador);

        ImageView imagenTriplicador = new ImageView(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/vista/recursos/imagenes/botonTriplicador.png"));
        ToggleButton botonTriplicador = new ToggleButton("", imagenTriplicador);
        botonTriplicador.setStyle(

                ".toggle-button:selected {" +
                "    -fx-background-color: green;" +
                "    -fx-text-fill: white;" +
                "}" );
        poderes.getChildren().add(botonTriplicador);

    }

    private void establecerEstilo(Node nodo) {
        nodo.setStyle("-fx-background-color: white;" +
                "-fx-border-color: black;" +
                "-fx-border-width: 4px;" +
                "-fx-text-fill: black;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-text-alignment: center;");
    }

    private void cambiarTamanoFuente(Node nodo, int size) {
        String estiloAnterior = nodo.getStyle();
        nodo.setStyle(estiloAnterior + "-fx-font-size: "+size+";");
    }
}
