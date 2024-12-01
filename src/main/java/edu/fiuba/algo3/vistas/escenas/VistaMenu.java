package main.java.edu.fiuba.algo3.vistas.escenas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class VistaMenu extends Scene {
    private Stage stage;

    public VistaMenuPrincipal(Stage stage, double width, double height) {
        //super(new Pane(), width, height);
        this.stage = stage;
        Pane root = (Pane) this.getRoot();

        BackgroundImage imagenFondo = new BackgroundImage(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/background.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondo = new Background(imagenFondo);
        root.setBackground(fondo);

        ImageView imagenJugar = new ImageView(new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/botonJugar.png"));
        Button botonjugar = new Button("", imagenJugar);
        botonjugar.setStyle("-fx-background-color: transparent;");
        botonjugar.setLayoutX(1280 - imagenJugar.getImage().getWidth()*6/5);
        botonjugar.setLayoutY(720/2 - imagenJugar.getImage().getHeight()/2);

        root.getChildren().add(botonjugar);
        botonjugar.setOnAction( e -> {
            stage.setScene(new VistaPartida(stage, 1280, 720));
        });
    }
}