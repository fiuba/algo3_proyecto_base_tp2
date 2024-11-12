package edu.fiuba.algo3.modeloTest.juegoTest;

import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.naipes.carta.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ParTest {
    @Test
    public void test01UnaInstanciaDeParSiUnaListaDeCartasConDosCartasEsPar() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Trebol())));
        // Act
        boolean resulatado = juegoPar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test02UnaInstanciaDeParSiUnaListaDeCartasConCincoCartasEsPar() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(3, new Corazon()),
                new Carta(4, new Corazon()), new Carta(5, new Corazon())));
        // Act
        boolean resulatado = juegoPar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test03UnaInstanciaDeParSiUnaListaDeCartasConCincoCartasEsParAunqueHayaTrio() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(1, new Diamante()),
                new Carta(4, new Corazon()), new Carta(5, new Corazon())));
        // Act
        boolean resulatado = juegoPar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test04UnaInstanciaDeParSiUnaListaDeCartasConCincoCartasEsParAunqueHayaFullHouse() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(3, new Corazon()),
                new Carta(3, new Diamante()), new Carta(3, new Trebol())));
        // Act
        boolean resulatado = juegoPar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test05UnaInstanciaDeParSiUnaListaDeCartasConCincoCartasEsParAunqueHayaDoblePar() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(3, new Corazon()),
                new Carta(3, new Diamante()), new Carta(6, new Trebol())));
        // Act
        boolean resulatado = juegoPar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test06UnaInstanciaDeParSiUnaListaDeCartasVaciaNoEsPar() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>();
        // Act
        boolean resulatado = juegoPar.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test07UnaInstanciaDeParSiUnaListaDeCartasConUnaCartaNoEsPar() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of(new Carta(1, new Corazon())));
        // Act
        boolean resulatado = juegoPar.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test08UnaInstanciaDeParSiUnaListaDeCartasConMasDeCincoCartasEsPar() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Diamante()), new Carta(3, new Corazon()),
                new Carta(4, new Corazon()), new Carta(5, new Corazon()),
                new Carta(6, new Corazon()), new Carta(7, new Corazon())));
        // Act
        boolean resulatado = juegoPar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test09UnaInstanciaDeParDeUnaListaConCincoCartasDeDiferenteValorNoEsPar() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(2, new Pica()), new Carta(3, new Corazon()),
                new Carta(4, new Diamante()), new Carta(5, new Trebol())));
        // Act
        boolean resulatado = juegoPar.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test10UnaInstanciaDeParDeUnaListaDeCartasConDosCartaDevuelveElValorCorrecto() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Trebol())));
        int valorEsperado = 60;
        // Act
        int valorObtenido = juegoPar.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test11UnaInstanciaDeParDeUnaListaDeCartasConCincoCartasDevuelveElValorCorrecto() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(2, new Diamante()),
                new Carta(2, new Pica()), new Carta(3, new Corazon()),
                new Carta(4, new Corazon()), new Carta(5, new Corazon())));
        int valorEsperado = 52;
        // Act
        int valorObtenido = juegoPar.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test12UnaInstanciaDeParSiUnaListaDeCartasVaciaNDevueleElValorBaseDePar() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>();
        int valorEsperado = 20;
        // Act
        int valorObtenido = juegoPar.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test13UnaInstanciaDeParDeUnaListaDeCartasMasDeCincoCartasDevuelveElValorCorrecto() {
        // Arrange
        Par juegoPar = new Par();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(2, new Corazon()), new Carta(3, new Corazon()),
                new Carta(4, new Corazon()), new Carta(5, new Corazon()),
                new Carta(7, new Diamante()), new Carta(7, new Trebol())));
        int valorEsperado = 78;
        // Act
        int valorObtenido = juegoPar.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
}
