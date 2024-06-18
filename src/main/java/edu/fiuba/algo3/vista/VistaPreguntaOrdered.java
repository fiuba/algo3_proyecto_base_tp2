package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.botones.BotonPoder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;

public class VistaPreguntaOrdered extends Scene {
    private FlowPane root;

    public VistaPreguntaOrdered(Stage stage, double width, double height) {
        super(new FlowPane(), width, height);
        double margenAncho = width / 32;
        double margenAlto = height / 18;
        this.root = (FlowPane) this.getRoot();
        BackgroundImage imagenFondo = new BackgroundImage(new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/background.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondo = new Background(imagenFondo);
        this.root.setBackground(fondo);
        this.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        FlowPane panelTableroJugadores = new FlowPane();
        panelTableroJugadores.setPrefHeight(height - 2 * margenAlto);
        panelTableroJugadores.setPrefWidth(floor(width / 3 - margenAncho));
        FlowPane.setMargin(panelTableroJugadores, new Insets(margenAlto, 0, margenAlto, margenAncho));
        this.root.getChildren().add(panelTableroJugadores);
        TableroJugadores tablero = new TableroJugadores(panelTableroJugadores.getPrefWidth(), panelTableroJugadores.getPrefHeight());
        panelTableroJugadores.getChildren().add(tablero);
        tablero.agregarJugador("agus", 666);
        tablero.agregarJugador("valen", 999);
        tablero.agregarJugador("nahu", 2);
        tablero.agregarJugador("pat", 3);
        tablero.agregarJugador("estebannnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", 12);
        tablero.resaltarSiguienteJugador();

        FlowPane panelPregunta = new FlowPane();
        panelPregunta.setPrefHeight(height);
        panelPregunta.setPrefWidth(floor(width * 2/3));
        this.root.getChildren().add(panelPregunta);

        // ESTO NO SE TOCA.
        Label textoPregunta = new Label("¿Ordene las siguientes superficies de juego de tenis de acuerdo a su velocidad, de LENTAS a RAPIDAS");
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

        ///modificado para entrega 3
        botonResponder.setOnAction(e -> {
            sonidoResponder.play();
        //    tablero.resaltarSiguienteJugador();
            VistaPreguntaMC vistaPregunta = new VistaPreguntaMC(stage.getScene().getWidth(), stage.getScene().getHeight());
            stage.setScene(vistaPregunta);

        });
        //fin modificado


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

        ToggleButton botonAnulador = new BotonPoder("anulador");
        ToggleButton botonExclusividad = new BotonPoder("exclusividad");
        poderes.getChildren().addAll(botonAnulador,botonExclusividad);

        // Define ListView for birds
        ObservableList<String> opciones = FXCollections.observableArrayList(
                "Carpeta sintética",
                "Cemento",
                "Polvo de Ladrillo Naranja"
        );
        ListView<String> listaOpciones = new ListView<>(opciones);

        listaOpciones.setCellFactory(param -> new BirdCell());
        listaOpciones.setPrefWidth(panelOpciones.getPrefWidth()-margenAncho*2);
        listaOpciones.setOnMouseExited(e -> listaOpciones.getSelectionModel().clearSelection());
        listaOpciones.setOnMouseDragExited(e -> listaOpciones.getSelectionModel().clearSelection());
        listaOpciones.setMaxHeight(opciones.size()*32*2.05);
        establecerEstilo(listaOpciones);
        cambiarTamanoFuente(listaOpciones,32);

        panelOpciones.getChildren().add(listaOpciones);
    }

    private class BirdCell extends ListCell<String> {
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                setText(item);
                setGraphic(null);
                setContentDisplay(ContentDisplay.TEXT_ONLY);
                setAlignment(Pos.CENTER); // Center text alignment
            }
        }

        public BirdCell() {
            ListCell<String> thisCell = this;

            setContentDisplay(ContentDisplay.TEXT_ONLY);
            setAlignment(Pos.CENTER);

            setOnDragDetected(event -> {
                if (getItem() == null) {
                    return;
                }

                Dragboard dragboard = startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(getItem());
                dragboard.setContent(content);

                event.consume();
            });

            setOnDragOver(event -> {
                if (event.getGestureSource() != thisCell && event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            });

            setOnDragEntered(event -> {
                if (event.getGestureSource() != thisCell && event.getDragboard().hasString()) {
                    setOpacity(0.3);
                }
            });

            setOnDragExited(event -> {
                if (event.getGestureSource() != thisCell && event.getDragboard().hasString()) {
                    setOpacity(1);
                }
            });

            setOnDragDropped(event -> {
                if (getItem() == null) {
                    return;
                }

                Dragboard db = event.getDragboard();
                boolean success = false;

                if (db.hasString()) {
                    ObservableList<String> items = getListView().getItems();
                    int draggedIdx = items.indexOf(db.getString());
                    int thisIdx = items.indexOf(getItem());

                    items.set(draggedIdx, getItem());
                    items.set(thisIdx, db.getString());

                    success = true;
                }
                event.setDropCompleted(success);

                event.consume();
            });

            setOnDragDone(DragEvent::consume);
        }
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
}
