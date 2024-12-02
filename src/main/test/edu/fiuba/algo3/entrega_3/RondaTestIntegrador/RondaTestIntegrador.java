package edu.fiuba.algo3.entrega_3.RondaTestIntegrador;

import edu.fiuba.algo3.controllers.Factory.FactoryComodines;
import edu.fiuba.algo3.controllers.Factory.FactoryDeMaso;
import edu.fiuba.algo3.controllers.Factory.FactoryDeTarot;
import edu.fiuba.algo3.controllers.Factory.FactoryRondas;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mano.Mano;
import edu.fiuba.algo3.modelo.Mazo.Mazo;

import edu.fiuba.algo3.modelo.Modificable.Modificador;
import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class RondaTestIntegrador {
    FactoryComodines factoryComodines;
    FactoryDeMaso factoryDeMaso;
    FactoryDeTarot factoryDeTarot;
    FactoryRondas factoryRondas;
    @BeforeEach
    public void setUp() {
        factoryComodines = new FactoryComodines("src/main/resources/comodines.json");
        factoryDeMaso = new FactoryDeMaso("src/main/resources/mazo.json");
        factoryDeTarot = new FactoryDeTarot("src/main/resources/tarots.json");
        factoryRondas = new FactoryRondas("src/main/resources/balatro.json", factoryDeTarot, factoryDeMaso, factoryComodines);


    }

    @Test
    public void test01SeInstaciaUnaRondaYSeVeSiTieneDosTarots() throws IOException {

        List<Ronda> rondas = factoryRondas.generarRondas();

        Ronda ronda = rondas.get(0);

        List<Tarot> tarots = ronda.getTienda().obtenerTarots();

        Assertions.assertEquals(tarots.size(), 2);

    }

    @Test
    public void test02SePruebaQueLaTiendaTiene2Comodines() throws IOException {
        List<Ronda> rondas = factoryRondas.generarRondas();

        Ronda ronda = rondas.get(0);

        List<Comodin> comodines = ronda.getTienda().obtenerComodines();

        Assertions.assertEquals(comodines.size(), 2);
    }

     @Test
    public void test03SePruebaQueLaTiendaTiene1Cartas() throws IOException {
        List<Ronda> rondas = factoryRondas.generarRondas();

        Ronda ronda = rondas.get(0);

        List<Carta> cartas = ronda.getTienda().obtenerCartas();

        Carta carta = cartas.get(0);

        Carta cartaPrueba = new Carta(new Corazon(), 10, 10, 1);
        Assertions.assertEquals(carta, cartaPrueba);
     }

}
