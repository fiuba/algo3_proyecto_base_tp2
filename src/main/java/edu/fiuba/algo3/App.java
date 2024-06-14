package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoHoot");

        StackPane layout = new StackPane();

        Label pregunta = new Label();
        pregunta.setText("cual es la población aproximada de uruguay?");

        pregunta.setStyle("-fx-background-color: white;" +
                " -fx-border-color: black;" +
                " -fx-border-width: 4px;" +
                " -fx-font-size: 52px;" +
                " -fx-text-fill: black;" +
                " -fx-padding: 25px;" +
                "-fx-font-family: 'Comic Sans MS';");
        pregunta.setWrapText(true);
        pregunta.setMaxWidth(1000);

        StackPane layoutP = new StackPane();
        layoutP.getChildren().add(pregunta);
        layout.getChildren().add(layoutP);
        layoutP.setAlignment(Pos.TOP_CENTER);
        layoutP.setPadding(new Insets(100, 0, 0, 0));

        Label jugador = new Label();
        jugador.setText("roberto");

        jugador.setStyle("-fx-background-color: white;" +
                " -fx-border-color: black;" +
                " -fx-border-width: 4px;" +
                " -fx-font-size: 32px;" +
                " -fx-text-fill: black;" +
                " -fx-text-alignment: center;" +
                " -fx-padding: 0px 20px;" +
                " -fx-font-family: 'Comic Sans MS';");
        jugador.setWrapText(true);

        StackPane layoutJ = new StackPane();
        layoutJ.getChildren().add(jugador);
        layoutP.getChildren().add(layoutJ);
        layoutJ.setAlignment(Pos.TOP_LEFT);
        layoutJ.setPadding(new Insets(-20, 0, 0, 20));


        // Crear dos ToggleButton para representar los switches
        ToggleButton opcion1 = new ToggleButton();
        ToggleButton opcion2 = new ToggleButton();

        // Establecer estilos para los switches
        opcion1.setStyle("-fx-background-color: white;" +
                " -fx-border-color: black;" +
                " -fx-border-width: 4px;" +
                " -fx-font-size: 52px;" +
                " -fx-text-fill: black;" +
                " -fx-text-alignment: center;" +
                " -fx-padding: 20px 20px;" +
                " -fx-font-family: 'Comic Sans MS';");
        opcion2.setStyle("-fx-background-color: white;" +
                " -fx-border-color: black;" +
                " -fx-border-width: 4px;" +
                " -fx-font-size: 52px;" +
                " -fx-text-fill: black;" +
                " -fx-text-alignment: center;" +
                " -fx-padding: 20px 20px;" +
                " -fx-font-family: 'Comic Sans MS';");

        // Añadir texto a los switches (opcional)
        opcion1.setText("12");
        opcion1.setPrefWidth(450);
        opcion1.setPrefHeight(125);
        opcion2.setText("3500000");
        opcion2.setPrefWidth(450);
        opcion2.setPrefHeight(125);

        // Contenedor para los switches
        VBox vbox = new VBox(20); // Espacio entre los switches
        vbox.setPadding(new Insets(0, 525, 20, 0));
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().addAll(opcion1, opcion2);

        layout.getChildren().add(vbox);

        // Crear dos ToggleButton para representar los switches
        ToggleButton opcion3 = new ToggleButton();
        ToggleButton opcion4 = new ToggleButton();

        // Establecer estilos para los switches
        opcion3.setStyle("-fx-background-color: white;" +
                " -fx-border-color: black;" +
                " -fx-border-width: 4px;" +
                " -fx-font-size: 52px;" +
                " -fx-text-fill: black;" +
                " -fx-text-alignment: center;" +
                " -fx-padding: 20px 20px;" +
                " -fx-font-family: 'Comic Sans MS';");
        opcion4.setStyle("-fx-background-color: white;" +
                " -fx-border-color: black;" +
                " -fx-border-width: 4px;" +
                " -fx-font-size: 40px;" +
                " -fx-text-fill: black;" +
                " -fx-text-alignment: center;" +
                " -fx-padding: 20px 20px;" +
                " -fx-font-family: 'Comic Sans MS';");

        // Añadir texto a los switches (opcional)
        opcion3.setText("0");
        opcion3.setPrefWidth(450);
        opcion3.setPrefHeight(125);
        opcion4.setText("todas las anteriores");
        opcion4.setPrefWidth(450);
        opcion4.setPrefHeight(125);

        // Contenedor para los switches
        VBox vbox2 = new VBox(20); // Espacio entre los switches
        vbox2.setPadding(new Insets(0, 0, 20, 525));
        vbox2.setAlignment(Pos.BOTTOM_CENTER);
        vbox2.getChildren().addAll(opcion3, opcion4);

        layout.getChildren().add(vbox2);



        ImageView imageR = new ImageView("https://i.imgur.com/ThjAo7d.png");
        Button botonResponder = new Button("",imageR);
        AudioClip sonidoR = new AudioClip("https://codeskulptor-demos.commondatastorage.googleapis.com/descent/gotitem.mp3");

        botonResponder.setOnAction(e -> {
            System.out.println("<< sonido >>");
            sonidoR.play();
        });

        StackPane layoutR = new StackPane();
        botonResponder.setStyle("-fx-background-color: transparent;");
        layoutR.setPadding(new Insets(0, 20, 0, 0));
        layoutR.setAlignment(Pos.CENTER_RIGHT);

        layout.getChildren().add(layoutR);
        layoutR.getChildren().add(botonResponder);


        ImageView imageA = new ImageView("https://i.imgur.com/4GOr8Ok.png");
        Button botonAnulador = new Button("",imageA);
        botonAnulador.setStyle("-fx-background-color: transparent;");
        ImageView imageE = new ImageView("https://i.imgur.com/Kn2z4qx.png");
        Button botonExclusividad = new Button("",imageE);
        botonExclusividad.setStyle("-fx-background-color: transparent;");
        ImageView imageD = new ImageView("https://i.imgur.com/w1Oxq6n.png");
        Button botonDuplicador = new Button("",imageD);
        botonDuplicador.setStyle("-fx-background-color: transparent;");
        ImageView imageT = new ImageView("https://i.imgur.com/clpEtQt.png");
        Button botonTriplicador = new Button("",imageT);
        botonTriplicador.setStyle("-fx-background-color: transparent;");

        botonTriplicador.setOnAction(e -> {
            System.out.println("<< sonido >>");
            sonidoR.play();
        });

        HBox layoutPoderes = new HBox(20);
        layoutPoderes.getChildren().addAll(botonAnulador,botonExclusividad,botonDuplicador,botonTriplicador);
        layoutPoderes.setAlignment(Pos.CENTER_LEFT);
        layoutPoderes.setPadding(new Insets(0, 0, 0, 50));

        layout.getChildren().add(layoutPoderes);

        Scene scene = new Scene(layout,1080, 720);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}