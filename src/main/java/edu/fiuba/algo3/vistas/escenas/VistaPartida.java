package main.java.edu.fiuba.algo3.vistas.escenas;

import java.lang.classfile.Label;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaPartida extends Scene{
    private FlowPane root;
    private String nombreJugador;

    public VistaPartida(Stage stage, double width, double height) {
        double margenAncho = width / 32;
        double margenAlto = height / 18;
        this.root = (FlowPane) this.getRoot();
        BackgroundImage imagenFondo = new BackgroundImage(
            new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/background.png"),
            BackgroundRepeat.REPEAT,
            BackgroundRepeat.REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT
        );
        Background fondo = new Background(imagenFondo);
        this.root.setBackground(fondo);
    
        Label textoAgregarJugador = new Label("Ingrese su nombre:");
        textoAgregarJugador.setStyle("-fx-text-fill: black;" +
                                      "-fx-font-family: 'Comic Sans MS';" +
                                      "-fx-text-alignment: center;" +
                                      "-fx-font-size: 24;");
    
        TextField fieldNombreJugador = new TextField();
        fieldNombreJugador.setPrefWidth(300);
        fieldNombreJugador.setStyle("-fx-text-fill: black;" +
                                     "-fx-font-family: 'Comic Sans MS';" +
                                     "-fx-text-alignment: center;" +
                                     "-fx-font-size: 20;" +
                                     "-fx-background-color: white;" +
                                     "-fx-border-width: 2px;" +
                                     "-fx-border-color: black;");
    
        Button botonJugar = new Button("Jugar");
        botonJugar.setPrefWidth(100);
        botonJugar.setStyle("-fx-font-family: 'Comic Sans MS';" +
                            "-fx-font-size: 16;" +
                            "-fx-background-color: #90caf9;" +
                            "-fx-text-fill: black;");
    
        botonJugar.setOnAction(event -> {
            String nombreJugador = fieldNombreJugador.getText().trim();
            if (!nombreJugador.isEmpty()) {
                System.out.println("Jugador agregado: " + nombreJugador);
                
                ControladorPartida controlador = new ControladorPartida(stage, nombreJugador);
                controlador.iniciarPartida();
            } else {
                System.out.println("El campo de nombre está vacío.");
            }
        });
    
        VBox contenedorIngresoNombre = new VBox(10);
        contenedorIngresoNombre.setAlignment(Pos.CENTER);
        contenedorIngresoNombre.getChildren().addAll(textoAgregarJugador, fieldNombreJugador, botonJugar);
    
        FlowPane rootPane = new FlowPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setPrefSize(600, 400);
        rootPane.getChildren().add(contenedorIngresoNombre);
    
        rootPane.setStyle("-fx-background-color: #f0f0f0;");
    
        this.root.getChildren().add(rootPane);
    }
    

}
