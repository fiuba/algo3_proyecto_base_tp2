package edu.fiuba.algo3.entrega_1.JugadaTest;

import edu.fiuba.algo3.entrega_1.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.Palo.Corazon;
import edu.fiuba.algo3.entrega_1.Palo.Diamante;
import edu.fiuba.algo3.entrega_1.Palo.Palo;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;



public class JugadaTest {

    @Test
    void test01agregoDosCartasALaJugada(){
        //arrange
        Jugada jugada = new Jugada();
        Palo corazon = new Corazon();
        Carta otraCarta = new Carta(corazon, 4,4,1);
        Carta unaCarta = new Carta(corazon, 3,3,1);

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
        Palo corazon = new Corazon();
        Carta carta = new Carta(corazon, 2,2,1);

        //act
        jugada.seleccionar(carta);
        int puntosObtenidos = jugada.jugar();

        //assert
        assertEquals(7,puntosObtenidos);
    }

    @Test
    void test03seleccionoUn2DeCorazonesYUn2DeDiamanteParaJugarYDa28Puntos(){
        //arrange
        Jugada jugada = new Jugada();
        Palo corazon = new Corazon();
        Palo diamante = new Diamante();
        Carta carta = new Carta(corazon, 2,2,1);
        Carta carta2 = new Carta(diamante,2,2,1);

        //act
        jugada.seleccionar(carta);
        jugada.seleccionar(carta);
        int puntosObtenidos = jugada.jugar();

        //assert
        assertEquals(28,puntosObtenidos);
    }
}
