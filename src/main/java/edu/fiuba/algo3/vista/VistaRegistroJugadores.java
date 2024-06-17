package edu.fiuba.algo3.vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.shape.Polygon;


public class VistaRegistroJugadores extends Scene {
    private FlowPane root;
    private VBox boxjugadores;
    private TextField nombreJugador;
    private ObservableList<String> jugadores;

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
        this.boxjugadores = new VBox();

        //agregar usuario
        HBox agregarUsuario = new HBox();
        agregarUsuario.setOpaqueInsets(new Insets(height/3,0,0,0));
        Label textoCuadro = new Label("agregar jugador:");
        textoCuadro.setStyle("-fx-text-fill: black;" +
                        "-fx-font-family: 'Comic Sans MS';" +
                        "-fx-text-alignment: center;" +
                        "-fx-font-size: 32;");
        nombreJugador = new TextField();
        nombreJugador.setPrefWidth(width / 2 - margenAncho);
        nombreJugador.setStyle("-fx-text-fill: black;" +
                        "-fx-font-family: 'Comic Sans MS';" +
                        "-fx-text-alignment: center;" +
                        "-fx-font-size: 32;" +
                        "-fx-background-color: white;" +
                        "-fx-border-width: 4px;" +
                        "-fx-border-color: black;");
        nombreJugador.setOnAction(event -> agregarJugador());

        Button botonAgregar = new Button("+");
        botonAgregar.getStyleClass().add("custom-button");
        botonAgregar.setOnAction(event -> agregarJugador());

        Button botonQuitar = new Button("-");
        botonQuitar.getStyleClass().add("custom-button");
        botonQuitar.setOnAction(event -> quitarJugador());

        agregarUsuario.getChildren().addAll(nombreJugador, botonAgregar, botonQuitar);
        agregarUsuario.setSpacing(10);

        VBox primerColumna = new VBox();
        VBox segundaColumna = new VBox();

        primerColumna.setMinWidth(width / 3);

        primerColumna.setPadding(new Insets(margenAlto*3/2, margenAncho, margenAlto, margenAncho*3/2));
        segundaColumna.setPadding(new Insets(margenAlto, margenAncho, margenAlto, margenAncho));

        primerColumna.getChildren().addAll(boxjugadores);
        segundaColumna.getChildren().addAll(textoCuadro,agregarUsuario);

        this.root.getChildren().addAll(primerColumna,segundaColumna);

        Polygon flecha = new Polygon();
        flecha.getPoints().addAll(new Double[]{
                0.0, 5.0,
                20.0, 5.0,
                20.0, 0.0,
                30.0, 10.0,
                20.0, 20.0,
                20.0, 15.0,
                0.0, 15.0
                });
        this.root.getChildren().addAll(flecha);
    }

    private void agregarJugador() {
        String nombre = nombreJugador.getText().trim();
        if (!nombre.isEmpty()) {
            jugadores.add(nombre);
            nombreJugador.clear();

            Label jugadorLabel = new Label(nombre);
            jugadorLabel.setStyle("-fx-text-fill: black;" +
                    "-fx-font-family: 'Comic Sans MS';" +
                    "-fx-text-alignment: center;" +
                    "-fx-font-size: 32;" +
                    "-fx-padding: "+ boxjugadores.getPrefWidth()*1/8+"px;");

            this.boxjugadores.getChildren().add(jugadorLabel);
        }
    }

    private void quitarJugador() {
        if (!boxjugadores.getChildren().isEmpty()) {
            jugadores.remove(jugadores.size()-1);
            boxjugadores.getChildren().remove(boxjugadores.getChildren().size() - 1);
        }
    }
}
