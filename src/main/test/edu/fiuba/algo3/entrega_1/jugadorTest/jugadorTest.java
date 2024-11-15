package edu.fiuba.algo3.entrega_1.jugadorTest;

import edu.fiuba.algo3.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.GeneradorDeCartas.GeneradorDeCartas;
import edu.fiuba.algo3.entrega_1.Jugador.Jugador;
import edu.fiuba.algo3.entrega_1.Mano.Mano;
import edu.fiuba.algo3.entrega_1.Palo.Diamante;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class jugadorTest {
    List<Carta> cartas;
    Carta unaCarta;
    Carta otraCarta;
    List<Carta> cartasAJugar;
    @BeforeEach
    void setUp() {
        GeneradorDeCartas generadorDeCartas = new GeneradorDeCartas();
         cartas = generadorDeCartas.generarCartas(new Diamante(), 2,9);
         unaCarta = cartas.get(0);
         otraCarta = cartas.get(1);
         cartasAJugar = new ArrayList<>();
         cartasAJugar.add(unaCarta);
         cartasAJugar.add(otraCarta);
    }

    @Test
    public void test01aUnJugadorSeLeAsignaUnaJugada(){
        Jugador unJugador = new Jugador("martin");
        Mano mano = new Mano(cartas);

        unJugador.asignarMano(mano);

        Assertions.assertTrue(unJugador.puedeJugar());
    }

    @Test
    public void test02aUnJugadorSelecciona2CartasParaUnaJugada(){
        Jugador unJugador = new Jugador("martin");
        Mano mano = new Mano(cartas);
        unJugador.asignarMano(mano);

        Jugada jugada = unJugador.armarJugada(cartasAJugar);

        Assertions.assertEquals(3, jugada.jugar());
    }
}
