package edu.fiuba.algo3.modeloTest.juegoTest;

import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.juego.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.carta.Carta;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrioTest {
    @Test
    public void test01UnaInstanciaDeTrioSiUnaListaDeCartasConTresCartasEsTrio() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Trebol()), new Carta(10, new Pica())));
        // Act
        boolean resulatado = juegoTrio.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test02UnaInstanciaDeTrioSiUnaListaDeCartasConCincoCartasEsTrio() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(1, new Diamante()),
                new Carta(4, new Corazon()), new Carta(5, new Corazon())));
        // Act
        boolean resulatado = juegoTrio.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test03UnaInstanciaDeTrioSiUnaListaDeCartasConCincoCartasEsTrioAunqueHayaCuatroIguales() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(4, new Corazon()),
                new Carta(4, new Pica()), new Carta(4, new Diamante()),
                new Carta(4, new Trebol()), new Carta(5, new Corazon())));
        // Act
        boolean resulatado = juegoTrio.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test04UnaInstanciaDeTrioSiUnaListaDeCartasConCincoCartasEsTrioAunqueHayaFullHouse() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(3, new Corazon()),
                new Carta(3, new Diamante()), new Carta(3, new Trebol())));
        // Act
        boolean resulatado = juegoTrio.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test05UnaInstanciaDeTrioReconoceQueNoEsTrioAunqueHayaTresPares() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(3, new Corazon()),
                new Carta(3, new Diamante()), new Carta(4, new Trebol()),
                new Carta(4, new Diamante())));
        // Act
        boolean resulatado = juegoTrio.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test06UnaInstanciaDeTrioSiUnaListaDeCartasVaciaNoEsTrio() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>();
        // Act
        boolean resulatado = juegoTrio.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test07UnaInstanciaDeTrioSiUnaListaDeCartasConDosCartaNoEsTrio() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of(new Carta(4, new Corazon()),
                new Carta(4, new Corazon())));
        // Act
        boolean resulatado = juegoTrio.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test08UnaInstanciaDeTrioSiUnaListaDeCartasConMasDeCincoCartasEsTrio() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Diamante()), new Carta(12, new Pica()),
                new Carta(12, new Corazon()), new Carta(12, new Trebol()),
                new Carta(6, new Corazon()), new Carta(7, new Corazon())));
        // Act
        boolean resulatado = juegoTrio.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test09UnaInstanciaDeTrioDeUnaListaConCincoCartasDeDiferenteValorNoEsTrio() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(2, new Pica()), new Carta(3, new Corazon()),
                new Carta(4, new Diamante()), new Carta(5, new Trebol())));
        // Act
        boolean resulatado = juegoTrio.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test10UnaInstanciaDeTrioDeUnaListaDeCartasConTresCartaDevuelveElValorCorrecto() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Trebol()), new Carta(10, new Pica())));
        int valorEsperado = 180;
        // Act
        int valorObtenido = juegoTrio.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test11UnaInstanciaDeTrioDeUnaListaDeCartasConCincoCartasDevuelveElValorCorrecto() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(2, new Diamante()),
                new Carta(2, new Pica()), new Carta(2, new Corazon()),
                new Carta(4, new Corazon()), new Carta(5, new Corazon())));
        int valorEsperado = 135;
        // Act
        int valorObtenido = juegoTrio.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test12UnaInstanciaDeTrioSiUnaListaDeCartasVaciaNDevueleElValorBaseDeTrio() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>();
        int valorEsperado = 90;
        // Act
        int valorObtenido = juegoTrio.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test13UnaInstanciaDeTrioDeUnaListaDeCartasMasDeCincoCartasDevuelveElValorCorrecto() {
        // Arrange
        Trio juegoTrio = new Trio();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(2, new Corazon()), new Carta(5, new Trebol()),
                new Carta(5, new Diamante()), new Carta(5, new Corazon()),
                new Carta(7, new Diamante()), new Carta(7, new Trebol())));
        int valorEsperado = 186;
        // Act
        int valorObtenido = juegoTrio.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
}
