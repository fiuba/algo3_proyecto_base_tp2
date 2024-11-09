package edu.fiuba.algo3.modeloTest.juegoTest;

import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.juego.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.carta.Carta;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PokerTest {
    @Test
    public void test01UnaInstanciaDePokerSiUnaListaDeCartasConCuatroCartasEsPoker() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Trebol()), new Carta(10, new Pica()),
                new Carta(10, new Trebol())));
        // Act
        boolean resulatado = juegoPoker.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test02UnaInstanciaDePokerSiUnaListaDeCartasConCincoCartasEsPoker() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(1, new Diamante()),
                new Carta(1, new Trebol()), new Carta(5, new Corazon())));
        // Act
        boolean resulatado = juegoPoker.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test03UnaInstanciaDePokerReconoceQueNoEsPokerAunqueHayaCuatroPares() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(3, new Corazon()),
                new Carta(3, new Diamante()), new Carta(2, new Trebol()),
                new Carta(2, new Diamante()), new Carta(9, new Diamante()),
                new Carta(9, new Corazon())));
        // Act
        boolean resulatado = juegoPoker.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test04UnaInstanciaDePokerSiUnaListaDeCartasVaciaNoEsPoker() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>();
        // Act
        boolean resulatado = juegoPoker.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test05UnaInstanciaDePokerSiUnaListaDeCartasConTresCartaNoEsPoker() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>(List.of(new Carta(4, new Corazon()),
                new Carta(4, new Trebol()), new Carta(4, new Diamante())));
        // Act
        boolean resulatado = juegoPoker.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test06UnaInstanciaDePokerSiUnaListaDeCartasConMasDeCincoCartasEsPoker() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Diamante()), new Carta(10, new Pica()),
                new Carta(10, new Trebol()), new Carta(12, new Trebol()),
                new Carta(6, new Corazon()), new Carta(7, new Corazon())));
        // Act
        boolean resulatado = juegoPoker.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test07UnaInstanciaDePokerDeUnaListaConCincoCartasDeDiferenteValorNoEsPoker() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(2, new Pica()), new Carta(3, new Corazon()),
                new Carta(4, new Diamante()), new Carta(5, new Trebol())));
        // Act
        boolean resulatado = juegoPoker.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test08UnaInstanciaDePokerDeUnaListaDeCartasConCuatroCartaDevuelveElValorCorrecto() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Trebol()), new Carta(10, new Pica()),
                new Carta(10, new Diamante())));
        int valorEsperado = 700;
        // Act
        int valorObtenido = juegoPoker.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test09UnaInstanciaDePokerDeUnaListaDeCartasConCincoCartasDevuelveElValorCorrecto() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(2, new Diamante()),
                new Carta(2, new Pica()), new Carta(2, new Corazon()),
                new Carta(2, new Trebol()), new Carta(5, new Corazon())));
        int valorEsperado = 511;
        // Act
        int valorObtenido = juegoPoker.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test10UnaInstanciaDePokerSiUnaListaDeCartasVaciaDevueleElValorBaseDePoker() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>();
        int valorEsperado = 420;
        // Act
        int valorObtenido = juegoPoker.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test11UnaInstanciaDePokerDeUnaListaDeCartasMasDeCincoCartasDevuelveElValorCorrecto() {
        // Arrange
        Poker juegoPoker = new Poker();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(2, new Corazon()), new Carta(5, new Trebol()),
                new Carta(5, new Diamante()), new Carta(5, new Corazon()),
                new Carta(5, new Pica()), new Carta(7, new Trebol())));
        int valorEsperado = 630;
        // Act
        int valorObtenido = juegoPoker.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
}
