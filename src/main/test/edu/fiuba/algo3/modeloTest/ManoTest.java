package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.mano.*;
import edu.fiuba.algo3.modelo.carta.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManoTest {
    @Test
    public void test01AlCrearUnaManoEstaDebeEstarVacia(){
        // Arrange
        Mano mano = new Mano(8);
        int cantidadDeCartasEsperadas = 0;
        // Act
        int cantidadDeCartasObtenidas = mano.obtenerCantidadDeCartas();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test02AlAgregarOchoCartasALaManoDeberiaTenerOchoCartas(){
        // Arrange
        Mano mano = new Mano(8);
        int cantidadDeCartasEsperadas = 8;
        // Act
        for(int i = 1; i <= 8; i++) {
            mano.agregarCarta(new Carta(i, new Trebol()));
        }
        int cantidadDeCartasObtenidas = mano.obtenerCantidadDeCartas();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test03AlAgregarNueveCartasALaManoDeberiaLanzarError(){
        // Arrange
        Mano mano = new Mano(8);
        for(int i = 1; i <= 8; i++) {
            mano.agregarCarta(new Carta(i, new Trebol()));
        }
        // Act / Assert
        assertThrows(ManoLlenaException.class, () -> {
            mano.agregarCarta(new Carta(9, new Trebol()));
        });
    }
    @Test
    public void test04AlAgregarOchoCartasALaManoYQuitarUnaDeberianHaber7(){
        // Arrange
        Mano mano = new Mano(8);
        int cantidadDeCartasEsperadas = 7;
        for(int i = 1; i <= 7; i++) {
            mano.agregarCarta(new Carta(i, new Trebol()));
        }
        // Act
        Carta carta = new Carta(8, new Trebol());
        mano.agregarCarta(carta);
        mano.quitarCarta(carta);
        int cantidadDeCartasObtenidas = mano.obtenerCantidadDeCartas();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test05LanzaErrorSiSeQuiereQuitarUnaCartaQueNoEstaEnLaMano(){
        // Arrange
        Mano mano = new Mano(8);
        Carta cartaEnLaMano = new Carta(8, new Trebol());
        Carta cartaNoEstaEnLaMano = new Carta(7, new Trebol());
        mano.agregarCarta(cartaEnLaMano);
        // Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            mano.quitarCarta(cartaNoEstaEnLaMano);
        });
    }
    @Test
    public void test06LanzaErrorSiSeQuiereQuitarUnaCartaEnUnaManoVacia(){
        // Arrange
        Mano mano = new Mano(8);
        // Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            mano.quitarCarta(new Carta(8, new Trebol()));
        });
    }
    @Test
    public void test07LanzaErrorSiSeQuiereQuitarUnaCartaQueYaSeQuito(){
        // Arrange
        Mano mano = new Mano(8);
        Carta cartaEnLaMano = new Carta(8, new Trebol());
        mano.agregarCarta(cartaEnLaMano);
        mano.quitarCarta(cartaEnLaMano);
        // Act / Assert
        assertThrows(CartaNoEnManoException.class, () -> {
            mano.quitarCarta(cartaEnLaMano);
        });
    }
    @Test
    public void test08UnaManoPuedeQuitarUnaCartaSoloSabiendoSuNumeroYPalo() {
        // Arrange
        Mano mano = new Mano(8);
        int cantidadDeCartasEsperadas = 0;
        mano.agregarCarta(new Carta(8, new Trebol()));
        // Act
        mano.quitarCarta(new Carta(8, new Trebol()));
        int cantidadDeCartasObtenidas = mano.obtenerCantidadDeCartas();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
    @Test
    public void test09AlAgregarleOchoCartasIgualesDeberianHaberOchoCartasEnLaMano() {
        // Arrange
        Mano mano = new Mano(8);
        int cantidadDeCartasEsperadas = 8;
        // Act
        for (int i = 1; i <= 8; i++) {
            mano.agregarCarta(new Carta(i, new Trebol()));
        }
        int cantidadDeCartasObtenidas = mano.obtenerCantidadDeCartas();
        // Assert
        assertEquals(cantidadDeCartasEsperadas, cantidadDeCartasObtenidas);
    }
}
