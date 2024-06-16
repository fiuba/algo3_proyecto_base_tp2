package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controladores.ControladorInicio;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import static java.lang.Math.floor;


public class VistaInicio extends Scene {

    private FlowPane root;
    private Stage stage;

    public VistaInicio(Stage stage, double width, double height) {
        super(new FlowPane(), width, height);
        this.root = (FlowPane) this.getRoot();
        this.stage = stage;

        // Crear el botón
        Button botonComenzar = new Button("Comenzar");
        botonComenzar.setOnAction(new ControladorInicio(this.stage));

        // Añadir el botón al root
        root.getChildren().add(botonComenzar);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
    }
}