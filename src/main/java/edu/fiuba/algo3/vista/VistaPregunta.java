package edu.fiuba.algo3.vista;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.concurrent.Flow;

import static java.lang.Math.floor;

public class VistaPregunta extends Scene {
    private FlowPane root;
    public VistaPregunta (double width, double height) {
        super(new FlowPane(), width, height);
        double margenAncho = width/32;
        double margenAlto = height/18;
        this.root = (FlowPane) this.getRoot();

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
        panelBotonesControl.getChildren().add(panelBotonResponder);

        FlowPane panelBotonesPoderes = new FlowPane();
        panelBotonesPoderes.setPrefHeight(panelBotonesControl.getPrefWidth() - panelBotonResponder.getPrefWidth());
        panelBotonesPoderes.setPrefWidth(panelBotonesControl.getPrefWidth());
        panelBotonesControl.getChildren().add(panelBotonesPoderes);


        // esto es propio de la pregunta VF.
        HBox opciones = new HBox();
        opciones.setPrefHeight(panelOpciones.getPrefHeight());
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(margenAncho);
        opciones.setPrefWidth(panelOpciones.getPrefWidth());
        panelOpciones.getChildren().add(opciones);

        ToggleButton opcion1 = new ToggleButton("Verdadero");
        ToggleButton opcion2 = new ToggleButton("Falso");
        opcion1.setPrefWidth(panelOpciones.getPrefWidth()/3);
        opcion2.setPrefWidth(panelOpciones.getPrefWidth()/3);
        establecerEstilo(opcion1);
        establecerEstilo(opcion2);
        cambiarTamanoFuente(opcion1,26);
        cambiarTamanoFuente(opcion2,26);
        opciones.getChildren().addAll(opcion1,opcion2);



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
