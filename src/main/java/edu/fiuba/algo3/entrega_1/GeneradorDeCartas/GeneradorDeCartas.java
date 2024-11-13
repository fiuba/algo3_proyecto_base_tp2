package edu.fiuba.algo3.entrega_1.GeneradorDeCartas;

import edu.fiuba.algo3.entrega_1.Palo.*;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GeneradorDeCartas {


    public GeneradorDeCartas(){};

    public List<Carta> generarCartas(Palo palo, int valorMin, int valorMax) {
        List<Carta> cartasGeneradas = new ArrayList<>();

        for (int i = 0; i < valorMax - 1 ; i++) {
            cartasGeneradas.add(new Carta(palo, valorMin + i));
        }

        return cartasGeneradas;
    }


    public List<Carta> generarMazo() {
        List<Carta> cartasGeneradas = this.generarCartas(new Corazon(),2,14);
        cartasGeneradas.addAll(this.generarCartas(new Diamante(), 2, 14));
        cartasGeneradas.addAll(this.generarCartas(new Pica(), 2, 14));
        cartasGeneradas.addAll(this.generarCartas(new Trebol(), 2, 14));
        return cartasGeneradas;
    }
}
