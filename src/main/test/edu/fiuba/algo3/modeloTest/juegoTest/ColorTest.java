package edu.fiuba.algo3.modeloTest.juegoTest;

import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.juego.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.carta.Carta;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {
    @Test
    public void test01UnaInstanciaDeColorSiUnaListaDeCartasConCincoCartasEsColor() {
        // Arrange
        Color juegoColor = new Color();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Trebol()),
                new Carta(2, new Trebol()), new Carta(3, new Trebol()),
                new Carta(4, new Trebol()), new Carta(5, new Trebol())));
        // Act
        boolean resulatado = juegoColor.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test02UnaInstanciaDeColorSiUnaListaDeCartasConSeisCartasNoEsColor() {
        // Arrange
        Color juegoColor = new Color();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Trebol()),
                new Carta(2, new Trebol()), new Carta(3, new Trebol()),
                new Carta(4, new Trebol()), new Carta(5, new Trebol()),
                new Carta(6, new Trebol())));
        // Act
        boolean resulatado = juegoColor.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test03UnaInstanciaDeColorReconoceQueNoEsColor() {
        // Arrange
        Color juegoColor = new Color();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(2, new Corazon()), new Carta(3, new Corazon()),
                new Carta(4, new Corazon()), new Carta(5, new Trebol())));
        // Act
        boolean resulatado = juegoColor.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test04UnaInstanciaDeColorSiUnaListaDeCartasVaciaNoEsColor() {
        // Arrange
        Color juegoColor = new Color();
        ArrayList<Carta> cartas = new ArrayList<>();
        // Act
        boolean resulatado = juegoColor.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test05UnaInstanciaDeColorDeUnaListaDeCartasConCincoCartasDelMismoColorDevuelveElValorCorrecto() {
        // Arrange
        Color juegoColor = new Color();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Pica()),
                new Carta(11, new Pica()), new Carta(12, new Pica()),
                new Carta(13, new Pica()), new Carta(1, new Pica())));
        int valorEsperado = 328;
        // Act
        int valorObtenido = juegoColor.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test06UnaInstanciaDeColorSiUnaListaDeCartasVaciaDevueleElValorBaseDeColor() {
        // Arrange
        Color juegoColor = new Color();
        ArrayList<Carta> cartas = new ArrayList<>();
        int valorEsperado = 140;
        // Act
        int valorObtenido = juegoColor.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
}
