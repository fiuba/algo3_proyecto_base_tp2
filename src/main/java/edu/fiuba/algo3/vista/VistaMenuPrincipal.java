package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controladores.ControladorInicio;
import edu.fiuba.algo3.controladores.ControladorPrincipal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class VistaMenuPrincipal extends Scene {

    private FlowPane root;
    private ControladorPrincipal cp;

    public VistaMenuPrincipal(ControladorPrincipal cp, double width, double height) {
        super(new FlowPane(), width, height);
        this.root = (FlowPane) this.getRoot();
        this.cp = cp;

        // Crear el botón
        Button botonComenzar = new Button("Comenzar");
        botonComenzar.setOnAction(new ControladorInicio(cp.getStage()));

        // Añadir el botón al root
        root.getChildren().add(botonComenzar);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
    }
}