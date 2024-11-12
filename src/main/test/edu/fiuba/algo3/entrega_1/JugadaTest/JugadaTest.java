package edu.fiuba.algo3.entrega_1.JugadaTest;

import edu.fiuba.algo3.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.Palo.Corazones;
import edu.fiuba.algo3.entrega_1.Palo.Diamante;
import edu.fiuba.algo3.entrega_1.Palo.Palo;
import edu.fiuba.algo3.entrega_1.Valor.Cuatro;
import edu.fiuba.algo3.entrega_1.Valor.Tres;
import edu.fiuba.algo3.entrega_1.Valor.Dos;
import edu.fiuba.algo3.entrega_1.Valor.Valor;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;



public class JugadaTest {
    @Test
    void test01agregoDosCartasALaJugada(){
        //arrange
        Jugada jugada = new Jugada();
        Palo corazon = new Corazones();
        Valor tres = new Tres();
        Valor cuatro = new Cuatro();
        Carta otraCarta = new Carta(corazon, cuatro);
        Carta unaCarta = new Carta(corazon, tres);

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
        Palo corazon = new Corazones();
        Valor dos = new Dos();
        Carta carta = new Carta(corazon, dos);

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
        Palo corazon = new Corazones();
        Palo diamante = new Diamante();
        Valor dos = new Dos();
        Carta carta = new Carta(corazon, dos);
        Carta carta2 = new Carta(diamante,dos);

        //act
        jugada.seleccionar(carta);
        jugada.seleccionar(carta);
        int puntosObtenidos = jugada.jugar();

        //assert
        assertEquals(28,puntosObtenidos);
    }
}
