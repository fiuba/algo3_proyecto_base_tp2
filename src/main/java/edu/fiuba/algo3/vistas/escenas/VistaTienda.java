package edu.fiuba.algo3.vistas.escenas;

import edu.fiuba.algo3.modelo.ronda.Tienda;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.ronda.Tienda;

import java.util.List;

public class VistaTienda extends Scene{
    private Stage stage;

    public VistaTienda(Stage stage, double width, double height, Tienda tienda) {
        super(new Pane(), width, height);
        this.stage = stage;
        List<Carta> cartas = tienda.obtenerCartas();
        List<Tarot> tarots = tienda.obtenerTarots();
        List<Comodin> comodins = tienda.obtenerComodines();

    }
}
