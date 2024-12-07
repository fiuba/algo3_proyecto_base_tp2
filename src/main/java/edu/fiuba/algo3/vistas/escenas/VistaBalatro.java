package edu.fiuba.algo3.vistas.escenas;

import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Palo.Diamante;
import edu.fiuba.algo3.modelo.Palo.Pica;
import edu.fiuba.algo3.modelo.Palo.Trebol;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import edu.fiuba.algo3.modelo.ronda.Tienda;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class VistaBalatro extends Scene {
    private Stage stage;
    private BorderPane root;
    private Ronda ronda;
    private List<Carta> cartas;
    private List<Tarot> tarots;
    private List<Comodin> comodines;

    public VistaBalatro(Stage stage, double width, double height, Ronda ronda)  {
        super(new BorderPane(), width, height);
        this.stage = stage;
        this.root = (BorderPane) this.getRoot();
        this.ronda = ronda;

        Tienda tienda = ronda.getTienda();
        this.cartas = tienda.obtenerCartas();
        this.tarots = tienda.obtenerTarots();
        this.comodines = tienda.obtenerComodines();

        VBox playerInfo = new VBox(10);
            playerInfo.setStyle("-fx-background-color: #2B2B2B; -fx-padding: 10;");
            playerInfo.setAlignment(Pos.TOP_CENTER);

        Label scoreLabel = new Label("Puntos Necesarios: 200");
            scoreLabel.setTextFill(Color.WHITE);
            scoreLabel.setFont(new Font("Arial", 16));

        Label roundLabel = new Label("Ronda: 4 / 12");
            roundLabel.setTextFill(Color.WHITE);
            roundLabel.setFont(new Font("Arial", 16));

        Button optionsButton = new Button("Descartar");
            optionsButton.setStyle("-fx-background-color: #FF6600; -fx-text-fill: white;");

        playerInfo.getChildren().addAll(scoreLabel, roundLabel, optionsButton);

        HBox activeCards = new HBox(10);
            activeCards.setAlignment(Pos.CENTER);
            activeCards.setStyle("-fx-background-color: #4A148C; -fx-padding: 10;");

        actualizarInterfazCartas(activeCards);
            this.root.setTop(playerInfo);
            this.root.setCenter(activeCards);
            this.root.setPrefSize(width, height);
    }

    private String compararPalos(Carta carta){
        Map<String, Carta> palos = new HashMap<>();

        Carta corazon = new Carta(new Corazon(), 2, 2, 1);
        Carta pica = new Carta(new Pica(), 3, 3, 1);
        Carta trebol = new Carta(new Trebol(), 2, 2, 1);
        Carta diamante = new Carta(new Diamante(), 3, 3, 1);

        palos.put("corazones", corazon);
        palos.put("picas", pica);
        palos.put("trebol", trebol);
        palos.put("diamantes", diamante);

        for (Map.Entry<String, Carta> entry : palos.entrySet()) {
            if (carta.sonMismoPalo(entry.getValue())) {
                return entry.getKey();
            }
        }
        return "Palo desconocido";
    }

    private String obtenerDescripcionCarta(Object carta) {
        if (carta instanceof Carta) {
            return "Carta normal";
        } else if (carta instanceof Tarot) {
            return ((Tarot) carta).getDescripcion();
        } else if (carta instanceof Comodin) {
            return ((Comodin) carta).getDescripcion();
        }
        return "Descripción no disponible";
    }

    private Image obtenerImagenCarta(Carta carta) {
        String palo = compararPalos(carta);
        String valor = carta.obtenerNombre();
        String rutaImagen = "/images/Cartas/" + palo + "/" + valor + ".jpg";
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(rutaImagen)));
    }

    private Image obtenerImagenTarot(Tarot tarot) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/tarot.jpg")));
    }

    private Image obtenerImagenComodin(Comodin comodin) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/comodin.jpg")));
    }

    private void actualizarInterfazCartas(HBox contenedorCartas) {
        actualizarInterfaz(contenedorCartas, cartas, this::obtenerImagenCarta);
    }

    private void actualizarInterfazTarots(HBox contenedorTarots) {
        actualizarInterfaz(contenedorTarots, tarots, this::obtenerImagenTarot);
    }

    private void actualizarInterfazComodines(HBox contenedorComodines) {
        actualizarInterfaz(contenedorComodines, comodines, this::obtenerImagenComodin);
    }

    private <T> void actualizarInterfaz(HBox contenedor, List<T> elementos, Function<T, Image> obtenerImagen) {
        contenedor.getChildren().clear();

        for (T elemento : elementos) {
            Image imagen = obtenerImagen.apply(elemento);
            ImageView imagenElemento = new ImageView(imagen);;
            imagenElemento.setFitWidth(80);
            imagenElemento.setFitHeight(120);

            imagenElemento.setOnMouseEntered(event -> {
                imagenElemento.setTranslateY(-20);
                imagenElemento.setEffect(new DropShadow(10, Color.BLACK));
            });

            imagenElemento.setOnMouseExited(event -> {
                imagenElemento.setTranslateY(0);
                imagenElemento.setEffect(null);
            });

            contenedor.getChildren().add(imagenElemento);
        }
    }

}