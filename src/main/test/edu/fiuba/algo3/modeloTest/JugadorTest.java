package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.mano.CartaNoEnManoException;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.manoDe5.MaximoCartasSeleccionadasException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void test01UnJugadorConUnaCartaEnSuManoPuedeSeleccionarla(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        mano.agregarCarta(new Carta(10, new Trebol()));
        jugador.establecerMano(mano);
        //Act / Assert
        assertDoesNotThrow(() -> jugador.elegirCarta(new Carta(10, new Trebol())));
    }
    @Test
    public void test02UnJugadorConUnaCartaEnSuManoPuedeSeleccionarlaYDeseleccionarla(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        mano.agregarCarta(new Carta(10, new Trebol()));
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(10, new Trebol()));
        //Act / Assert
        assertDoesNotThrow(() -> jugador.deseleccionarCarta(new Carta(10, new Trebol())));
    }
    @Test
    public void test03UnJugadorConUnaManoVaciaLanzaErrorSiSeleccionaUnaCarta(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        jugador.establecerMano(mano);
        //Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            jugador.elegirCarta(new Carta(10, new Trebol()));
        });
    }
    @Test
    public void test04UnJugadorConUnaManoVaciaLanzaErrorSiDeseleccionaUnaCarta(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        jugador.establecerMano(mano);
        //Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            jugador.deseleccionarCarta(new Carta(10, new Trebol()));
        });
    }
    @Test
    public void test05UnJugadorQueSeleccionoCincoCartasNoPuedeSeleccionarlUnaMas(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
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
    public void test06UnJugadorQueSeleccionoUnaCartaSeleccioanadaAlVolverlaASeleccionarLaDeselecciona(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        int cantidadDeCartasEsperadas = 0;
        mano.agregarCarta(new Carta(12, new Trebol()));
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(12, new Trebol()));
        // Act
        jugador.elegirCarta(new Carta(12, new Trebol()));
        int cantidadDeCartasObtenidas = jugador.obtenerCantidadDeCartasSeleccionadas();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test07UnJugadorQueSeleccionaUnCincoYJuegaLaManoTieneDiezDePuntaje(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        int puntajeEsperado = 10;
        mano.agregarCarta(new Carta(5, new Trebol()));
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(5, new Trebol()));
        // Act
        int puntajeObtenido = jugador.jugarMano();
        // Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
    @Test
    public void test08UnJugadorQueSeleccionaUnDiezYJuegaLaManoTieneQuinceDePuntaje(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        int puntajeEsperado = 15;
        mano.agregarCarta(new Carta(10, new Trebol()));
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(10, new Trebol()));
        // Act
        int puntajeObtenido = jugador.jugarMano();
        // Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
    @Test
    public void test09UnJugadorQueSeleccionaColorYJuegaLaManoTieneDoscientosYCuatroDePuntaje(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        int puntajeEsperado = 204;
        mano.agregarCarta(new Carta(1, new Trebol()));
        mano.agregarCarta(new Carta(2, new Trebol()));
        mano.agregarCarta(new Carta(3, new Trebol()));
        mano.agregarCarta(new Carta(4, new Trebol()));
        mano.agregarCarta(new Carta(6, new Trebol()));
        jugador.establecerMano(mano);
        jugador.elegirCarta(new Carta(1, new Trebol()));
        jugador.elegirCarta(new Carta(2, new Trebol()));
        jugador.elegirCarta(new Carta(3, new Trebol()));
        jugador.elegirCarta(new Carta(4, new Trebol()));
        jugador.elegirCarta(new Carta(6, new Trebol()));
        // Act
        int puntajeObtenido = jugador.jugarMano();
        // Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
    @Test
    public void test10UnJugadorQueSeLeEstableceUnaManoTieneSoloEsaMano(){
        //Arrange
        Jugador jugador = new Jugador();
        Mano mano = new Mano(8);
        mano.agregarCarta(new Carta(1, new Trebol()));
        mano.agregarCarta(new Carta(2, new Trebol()));
        jugador.establecerMano(mano);
        Mano mano2 = new Mano(8);
        mano2.agregarCarta(new Carta(3, new Trebol()));
        jugador.elegirCarta(new Carta(1, new Trebol()));
        jugador.elegirCarta(new Carta(2, new Trebol()));
        // Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            jugador.elegirCarta(new Carta(3, new Trebol()));
        });
    }

}
