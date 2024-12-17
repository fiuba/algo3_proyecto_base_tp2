package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Palo.Diamante;
import edu.fiuba.algo3.modelo.Palo.Pica;
import edu.fiuba.algo3.modelo.Palo.Trebol;
import edu.fiuba.algo3.modelo.carta.Carta;
import javafx.scene.image.Image;

import javax.swing.text.html.ImageView;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CartaVista {

    private ImageView imagen;
    private Carta carta;

    public CartaVista(Carta carta) {

        this.carta = carta;
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

    public Image obtenerImagenCarta() {
        String palo = compararPalos(this.carta);
        String valor = this.carta.obtenerNombre();
        String rutaImagen = "/images/Cartas/" + palo + "/" + valor + ".jpg";
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(rutaImagen)));
    }

    public Carta obtenerCarta() {
        return this.carta;
    }



}
