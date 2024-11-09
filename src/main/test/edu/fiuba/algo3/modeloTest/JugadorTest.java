package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.mano.CartaNoEnManoException;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void test01UnJugadorTiene0DePuntajeNiBienEsInstanciado(){
        //Arrange
        Jugador jugador = new Jugador();
        int valorEsperado = 0;

        //Act
        Puntaje puntaje = jugador.obtenerPuntaje();
        int valorObtenido = puntaje.calcularValor();

        //Assert
        assertEquals(valorObtenido, valorEsperado);
    }
    @Test
    public void test02UnJugadorConUnaCartaEnSuManoPuedeSeleccionarla(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(10, new Trebol()));
        jugador.establecerMano(mano);
        //Act / Assert
        assertDoesNotThrow(() -> jugador.elegirCarta(new Carta(10, new Trebol())));
    }
    @Test
    public void test03UnJugadorConUnaCartaEnSuManoPuedeSeleccionarlaYDeseleccionarla(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(10, new Trebol()));
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(10, new Trebol()));
        //Act / Assert
        assertDoesNotThrow(() -> jugador.deseleccionarCarta(new Carta(10, new Trebol())));
    }
    @Test
    public void test04UnJugadorConUnaManoVaciaLanzaErrorSiSeleccionaUnaCarta(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano();
        jugador.establecerMano(mano);
        //Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            jugador.elegirCarta(new Carta(10, new Trebol()));
        });
    }
    @Test
    public void test05UnJugadorConUnaManoVaciaLanzaErrorSiDeseleccionaUnaCarta(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano();
        jugador.establecerMano(mano);
        //Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            jugador.deseleccionarCarta(new Carta(10, new Trebol()));
        });
    }
    @Test
    public void test06UnJugadorQueSeleccionoCindoCartasNoPuedeSeleccionarlUnaMas(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano();
        for (int i = 1; i <= 6; i++) {
            mano.agregarCarta(new Carta(i, new Trebol()));
        }
        jugador.establecerMano(mano);
        //Act
        for (int i = 1; i <= 5; i++) {
            jugador.elegirCarta(new Carta(i, new Trebol()));
        }
        // Assert
        assertThrows(MaximoCartasSeleccionadasException.class, () -> {
            jugador.elegirCarta(new Carta(6, new Trebol()));;
        });
    }
    @Test
    public void test07UnJugadorQueSeleccionoUnaCartaSeleccioanadaCincoVecesNoLanzaError(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano();
        mano.agregarCarta(new Carta(12, new Trebol()));
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(12, new Trebol()));
        jugador.elegirCarta(new Carta(12, new Trebol()));
        jugador.elegirCarta(new Carta(12, new Trebol()));
        jugador.elegirCarta(new Carta(12, new Trebol()));
        jugador.elegirCarta(new Carta(12, new Trebol()));
        // Assert
        assertDoesNotThrow(() ->  jugador.elegirCarta(new Carta(12, new Trebol())));
    }
}
