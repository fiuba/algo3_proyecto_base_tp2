package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.mazo.Mazo;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.tarot.CambiadorDeMultiplicador;
import edu.fiuba.algo3.modelo.tarot.CambiadorDePuntos;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class casosDeUsoEntrega1Test {
    //Verificar que un jugador posea cartas suficientes para empezar el juego en su mazo.
    @Test
    public void test01UnJugadorTieneQueTenerCartasSuficientesParaArrancarElJuego() {
        //Arrange
        Jugador jugador = new Jugador();
        Mazo mazo = new Mazo();
        Mano mano = new Mano(8);
        mazo.repartirCartas(8, mano);
        jugador.establecerMano(mano);
        //Act
        boolean tieneCartas = (jugador.obtenerCantidadDeCartas() > 0);

        //Assert
        assertTrue(tieneCartas);
    }
    //Verificar que a un jugador se le reparten 8 cartas de su mazo.
    @Test
    public void test02AUnJugadorSeLeRepartenOchoCartasDeSuMazo() {
        //Arrange
        Jugador jugador = new Jugador();
        Mazo mazo = new Mazo();
        Mano mano = new Mano(8);
        mazo.repartirCartas(8, mano);
        jugador.establecerMano(mano);
        int cantidadDeCartasEsperadas = 8;

        //Act
        int cantidadDeCartasObtenidas = jugador.obtenerCantidadDeCartas();

        //Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    //Verificar que se puede jugar una mano de un mazo.
    @Test
    public void test03SePuedeJugarUnaManoDeUnMazo(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        for (int i = 1; i <= 8; i++) {
            mano.agregarCarta(new Carta(i, new Trebol()));
        }
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(5, new Trebol()));

        //Assert y Act
        assertDoesNotThrow(() -> jugador.jugarMano());
    }
    //Verificar que al jugar una mano, se aplique el valor correspondiente.
    @Test
    public void test04AlJugarUnaManoSeLeAplicaSuValorCorrespondiente(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        for (int i = 1; i <= 8; i++) {
            mano.agregarCarta(new Carta(i, new Trebol()));
        }
        jugador.establecerMano(mano);
        int puntajeEsperado = 920;
        jugador.elegirCarta(new Carta(5, new Trebol()));
        jugador.elegirCarta(new Carta(1, new Trebol()));
        jugador.elegirCarta(new Carta(2, new Trebol()));
        jugador.elegirCarta(new Carta(3, new Trebol()));
        jugador.elegirCarta(new Carta(4, new Trebol()));
        // Act
        int puntajeObtenido = jugador.jugarMano();
        // Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
    //Verificar que importe el orden en la puntuación de las cartas.
    @Test
    public void test05AlJugarUnaManoTrioElValorDebeSerDistintoAPrimeroCalcularElValorDelTrioYLaSumaDeLasCartasYLuegoSumarAmbosValores(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        mano.agregarCarta(new Carta(2, new Trebol()));
        mano.agregarCarta(new Carta(2, new Corazon()));
        mano.agregarCarta(new Carta(2, new Diamante()));
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(2, new Trebol()));
        jugador.elegirCarta(new Carta(2, new Corazon()));
        jugador.elegirCarta(new Carta(2, new Diamante()));
        int puntajeEsperado = 108;
        // Act
        Puntaje puntajeJuegoTrio = new Puntaje(30, 3);
        Puntaje puntajeCartasSuma = new Puntaje(6,1);
        int puntajeObtenido = puntajeJuegoTrio.calcularValor() + puntajeCartasSuma.calcularValor();
        // Assert
        assertNotEquals(puntajeObtenido, puntajeEsperado);
    }
    //Verificar que al modificar una carta al utilizar un tarot que cambia sus puntos por 10, se aplique el puntaje correcto en el mazo.
    @Test
    public void test06UnaCartaModificadaPorUnaCartaDeTarotDePuntosDeMas10ModificaComoPuntuaLaCarta(){
        // Arrange
        int valorEsperado = 132;
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        mano.agregarCarta(new Carta(2, new Diamante()));
        mano.agregarCarta(new Carta(2, new Corazon()));
        Carta cartaModificada = new Carta(2, new Trebol());
        Tarot tarot = new CambiadorDePuntos(10);
        cartaModificada.aplicarModificador(tarot);
        mano.agregarCarta(cartaModificada);
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(2, new Trebol()));
        jugador.elegirCarta(new Carta(2, new Corazon()));
        jugador.elegirCarta(new Carta(2, new Diamante()));
        // Act
        int valorObtenido = jugador.jugarMano();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    //Verificar que al modificar una carta utilizando un tarot que cambia su multiplicador a un x6 se aplique el valor correspondiente.
    @Test
    public void test07UnaCartaModificadaPorUnaCartaDeTarotDeMultiplicadorDePor6ModificaComoPunutuaLaCarta() {
        // Arrange
        int valorEsperado = 324;
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        mano.agregarCarta(new Carta(2, new Diamante()));
        mano.agregarCarta(new Carta(2, new Corazon()));
        Carta cartaModificada = new Carta(2, new Trebol());
        Tarot tarot = new CambiadorDeMultiplicador(6);
        cartaModificada.aplicarModificador(tarot);
        mano.agregarCarta(cartaModificada);
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(2, new Trebol()));
        jugador.elegirCarta(new Carta(2, new Corazon()));
        jugador.elegirCarta(new Carta(2, new Diamante()));
        // Act
        int valorObtenido = jugador.jugarMano();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
}
