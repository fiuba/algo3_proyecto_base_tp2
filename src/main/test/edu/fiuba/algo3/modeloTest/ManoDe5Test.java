package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.manoDe5.*;
import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.mano.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManoDe5Test {
    @Test
    public void test01AlCrearUnaManoDe5EstaDebeEstarVacia(){
        // Arrange
        ManoDe5 mano = new ManoDe5();
        int cantidadDeCartasEsperadas = 0;
        // Act
        int cantidadDeCartasObtenidas = mano.obtenerCantidadDeCartas();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test02AlAgregarCincoCartasALaManoDe5DeberiaTenerCincoCartas(){
        // Arrange
        ManoDe5 mano = new ManoDe5();
        int cantidadDeCartasEsperadas = 5;
        // Act
        for(int i = 1; i <= 5; i++) {
            mano.agregarCarta(new Carta(i, new Trebol()));
        }
        int cantidadDeCartasObtenidas = mano.obtenerCantidadDeCartas();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test03AlAgregarSeisCartasALaManoDe5DeberiaLanzarError(){
        // Arrange
        ManoDe5 mano = new ManoDe5();
        for(int i = 1; i <= 5; i++) {
            mano.agregarCarta(new Carta(i, new Trebol()));
        }
        // Act / Assert
        assertThrows(MaximoCartasSeleccionadasException.class, () -> {
            mano.agregarCarta(new Carta(6, new Trebol()));
        });
    }
    @Test
    public void test04AlAgregarCincoCartasALaManoDe5YQuitarUnaDeberianHaberCuatro(){
        // Arrange
        ManoDe5 mano = new ManoDe5();
        int cantidadDeCartasEsperadas = 4;
        for(int i = 1; i <= 4; i++) {
            mano.agregarCarta(new Carta(i, new Trebol()));
        }
        // Act
        Carta carta = new Carta(5, new Trebol());
        mano.agregarCarta(carta);
        mano.quitarCarta(carta);
        int cantidadDeCartasObtenidas = mano.obtenerCantidadDeCartas();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test05LanzaErrorSiSeQuiereQuitarUnaCartaQueNoEstaEnLaManoDe5(){
        // Arrange
        ManoDe5 mano = new ManoDe5();
        Carta cartaEnLaManoDe5 = new Carta(8, new Trebol());
        Carta cartaNoEstaEnLaManoDe5 = new Carta(7, new Trebol());
        mano.agregarCarta(cartaEnLaManoDe5);
        // Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            mano.quitarCarta(cartaNoEstaEnLaManoDe5);
        });
    }
    @Test
    public void test06LanzaErrorSiSeQuiereQuitarUnaCartaEnUnaManoDe5Vacia(){
        // Arrange
        ManoDe5 mano = new ManoDe5();
        // Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            mano.quitarCarta(new Carta(8, new Trebol()));
        });
    }
    @Test
    public void test07LanzaErrorSiSeQuiereQuitarUnaCartaQueYaSeQuito(){
        // Arrange
        ManoDe5 mano = new ManoDe5();
        Carta cartaEnLaManoDe5 = new Carta(8, new Trebol());
        mano.agregarCarta(cartaEnLaManoDe5);
        mano.quitarCarta(cartaEnLaManoDe5);
        // Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            mano.quitarCarta(cartaEnLaManoDe5);
        });
    }
    @Test
    public void test08UnaManoDe5PuedeQuitarUnaCartaSoloSabiendoSuNumeroYPalo() {
        // Arrange
        ManoDe5 mano = new ManoDe5();
        int cantidadDeCartasEsperadas = 0;
        mano.agregarCarta(new Carta(8, new Trebol()));
        // Act
        mano.quitarCarta(new Carta(8, new Trebol()));
        int cantidadDeCartasObtenidas = mano.obtenerCantidadDeCartas();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test09AlJugarUnaManoConUnaCartaDevuelveElValorDelPuntajeDeLaCarta() {
        // Arrange
        ManoDe5 mano = new ManoDe5();
        int valorEsperado = 10;
        mano.agregarCarta(new Carta(5, new Trebol()));
        // Act
        int valorObtenido = mano.jugarMano();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test09AlJugarUnaManoConCincoCartasDevuelveElValorDelPuntajeDeLaMano() {
        // Arrange
        ManoDe5 mano = new ManoDe5();
        int valorEsperado = 30;
        mano.agregarCarta(new Carta(5, new Trebol()));
        mano.agregarCarta(new Carta(7, new Diamante()));
        mano.agregarCarta(new Carta(3, new Corazon()));
        mano.agregarCarta(new Carta(1, new Pica()));
        mano.agregarCarta(new Carta(9, new Trebol()));
        // Act
        int valorObtenido = mano.jugarMano();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
}
