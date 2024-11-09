package edu.fiuba.algo3.modeloTest.juegoTest;

import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.juego.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.carta.Carta;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EscaleraRealTest {
    @Test
    public void test01UnaInstanciaDeEscaleraRealSiUnaListaDeCartasConCincoCartasEsEscaleraReal() {
        // Arrange
        EscaleraReal juegoEscaleraReal = new EscaleraReal();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Trebol()),
                new Carta(10, new Trebol()), new Carta(11, new Trebol()),
                new Carta(12, new Trebol()), new Carta(13, new Trebol())));
        // Act
        boolean resulatado = juegoEscaleraReal.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test02UnaInstanciaDeEscaleraRealSiUnaListaDeCartasConSeisCartasNoEsEscaleraReal() {
        // Arrange
        EscaleraReal juegoEscaleraReal = new EscaleraReal();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Trebol()),
                new Carta(9, new Trebol()), new Carta(10, new Trebol()),
                new Carta(11, new Trebol()), new Carta(12, new Trebol()),
                new Carta(13, new Trebol())));
        // Act
        boolean resulatado = juegoEscaleraReal.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test03UnaInstanciaDeEscaleraRealReconoceQueNoEsEscaleraReal() {
        // Arrange
        EscaleraReal juegoEscaleraReal = new EscaleraReal();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(10, new Corazon()), new Carta(11, new Corazon()),
                new Carta(12, new Corazon()), new Carta(13, new Trebol())));
        // Act
        boolean resulatado = juegoEscaleraReal.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test04UnaInstanciaDeEscaleraRealSiUnaListaDeCartasVaciaNoEsEscaleraReal() {
        // Arrange
        EscaleraReal juegoEscaleraReal = new EscaleraReal();
        ArrayList<Carta> cartas = new ArrayList<>();
        // Act
        boolean resulatado = juegoEscaleraReal.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test05UnaInstanciaDeEscaleraRealDeUnaListaDeCartasConCincoCartasDelMismoColorYEnEscaleraDevuelveElValorCorrecto() {
        // Arrange
        EscaleraReal juegoEscaleraReal = new EscaleraReal();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Pica()),
                new Carta(13, new Pica()), new Carta(11, new Pica()),
                new Carta(12, new Pica()), new Carta(1, new Pica())));
        int valorEsperado = 1176;
        // Act
        int valorObtenido = juegoEscaleraReal.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test06UnaInstanciaDeEscaleraRealSiUnaListaDeCartasVaciaDevueleElValorBaseDeEscaleraReal() {
        // Arrange
        EscaleraReal juegoEscaleraReal = new EscaleraReal();
        ArrayList<Carta> cartas = new ArrayList<>();
        int valorEsperado = 800;
        // Act
        int valorObtenido = juegoEscaleraReal.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test07UnaInstanciaDeEscaleraRealDeUnaListaDeCartasConCincoCartasDelMismoColorYNoEnEscaleraRealSabeReconocerQueNoEsEscaleraReal() {
        // Arrange
        EscaleraReal juegoEscaleraReal = new EscaleraReal();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Pica()),
                new Carta(11, new Pica()), new Carta(12, new Pica()),
                new Carta(13, new Pica()), new Carta(9, new Pica())));
        // Act
        boolean resulatado = juegoEscaleraReal.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
}
