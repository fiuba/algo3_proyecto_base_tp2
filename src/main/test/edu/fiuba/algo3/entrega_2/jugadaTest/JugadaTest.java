package edu.fiuba.algo3.entrega_2.jugadaTest;


import edu.fiuba.algo3.entrega_1.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.ManoDePoker.CartaMasAlta;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.entrega_1.ManoDePoker.Par;
import edu.fiuba.algo3.entrega_1.Palo.Corazon;
import edu.fiuba.algo3.entrega_1.Palo.Diamante;
import edu.fiuba.algo3.entrega_1.Palo.Pica;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JugadaTest {
    @Test
    void test01agregoDosCartasALaJugada(){
        //arrange
        Jugada jugada = new Jugada();
        Carta otraCarta = new Carta(new Corazon(), 4,4,1);
        Carta unaCarta = new Carta(new Corazon(), 3,3,1);

        //act
        jugada.seleccionar(unaCarta);
        jugada.seleccionar(otraCarta);

        //assert
        assertEquals(2,jugada.cantidadDeCartas());
    }

    @Test
    void test02juegoLaJugadaConUnaCartaConValor2YDevuelve7Puntos(){
        //arrange
        Jugada jugada = new Jugada();
        Carta carta = new Carta(new Corazon(), 2,2,1);;

        //act
        jugada.seleccionar(carta);
        ManoDePoker manoObtenida = jugada.jugar();
        int puntosObtenidos = manoObtenida.calcularPuntaje();

        //assert
        assertEquals(7,puntosObtenidos);
    }

    @Test
    void test03seleccionoUn2DeCorazonesYUn2DeDiamanteParaJugarYDa28Puntos(){
        //arrange
        Jugada jugada = new Jugada();
        Carta carta = new Carta(new Corazon(), 2,2,1);
        Carta carta2 = new Carta(new Diamante(),2,2,1);

        //act
        jugada.seleccionar(carta);
        jugada.seleccionar(carta2);
        ManoDePoker manoObtenida = jugada.jugar();
        int puntosObtenidos = manoObtenida.calcularPuntaje();

        //assert
        assertEquals(28,puntosObtenidos);
    }

    @Test
    void test04seleccionoUn2DeCorazonesYJugadaTieneComoManoDePokerCartaMasAlta(){
        //arrange
        Jugada jugada = new Jugada();
        Carta carta = new Carta(new Corazon(), 2,2,1);
        ManoDePoker manoEsperada = new CartaMasAlta();

        //act
        jugada.seleccionar(carta);

        //assert
        assertTrue(jugada.tieneMano(manoEsperada));
    }
    @Test
    void test05seleccionoUn2DeCorazonesYLuegoUn2DePicasYJugadaTieneComoManoDePokerPar(){
        //arrange
        Jugada jugada = new Jugada();
        Carta carta = new Carta(new Corazon(), 2,2,1);
        Carta otraCarta = new Carta(new Pica(), 2,2,1);
        ManoDePoker manoEsperada = new Par();

        //act
        jugada.seleccionar(carta);
        jugada.seleccionar(otraCarta);

        //assert
        assertTrue(jugada.tieneMano(manoEsperada));
    }
    @Test
    void test06seleccionoUn2DeCorazonesYUn2DePicasYDeseleccionoYJugadaTieneComoManoDePokerCartaMasAlta(){
        //arrange
        Jugada jugada = new Jugada();
        Carta carta = new Carta(new Corazon(), 2,2,1);
        Carta otraCarta = new Carta(new Pica(), 2,2,1);
        ManoDePoker manoEsperada = new CartaMasAlta();

        //act
        jugada.seleccionar(carta);
        jugada.seleccionar(otraCarta);
        jugada.deseleccionar(carta);

        //assert
        assertTrue(jugada.tieneMano(manoEsperada));
    }

}
