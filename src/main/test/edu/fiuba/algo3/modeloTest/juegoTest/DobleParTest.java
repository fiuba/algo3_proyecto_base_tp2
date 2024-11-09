package edu.fiuba.algo3.modeloTest.juegoTest;

import edu.fiuba.algo3.modelo.carta.*;
import edu.fiuba.algo3.modelo.juego.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.carta.Carta;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DobleParTest {
    @Test
    public void test01UnaInstanciaDeDobleParSiUnaListaDeCartasConCuatroCartasEsDoblePar() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Trebol()), new Carta(12, new Corazon()),
                new Carta(12, new Trebol())));
        // Act
        boolean resulatado = juegoDoblePar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test02UnaInstanciaDeDobleParSiUnaListaDeCartasConCincoCartasEsDoblePar() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(3, new Diamante()),
                new Carta(3, new Trebol()), new Carta(5, new Corazon())));
        // Act
        boolean resulatado = juegoDoblePar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test03UnaInstanciaDeDobleParSiUnaListaDeCartasConCincoCartasEsDobleParAunqueHayaTrio() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(1, new Diamante()),
                new Carta(5, new Diamante()), new Carta(5, new Corazon())));
        // Act
        boolean resulatado = juegoDoblePar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test04UnaInstanciaDeDobleParSiUnaListaDeCartasConCincoCartasEsDobleParAunqueHayaFullHouse() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Pica()), new Carta(1, new Diamante()),
                new Carta(5, new Diamante()), new Carta(5, new Corazon())));
        // Act
        boolean resulatado = juegoDoblePar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test05UnaInstanciaDeDobleParSiUnaListaDeCartasVaciaNoEsDoblePar() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>();
        // Act
        boolean resulatado = juegoDoblePar.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test06UnaInstanciaDeDobleParSiUnaListaDeCartasConTresCartaDistintasYUnParNoEsDoblePar() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of(new Carta(1, new Corazon()),
                new Carta(1, new Trebol()), new Carta(1, new Pica()),
                new Carta(3, new Trebol()), new Carta(2, new Corazon())));
        // Act
        boolean resulatado = juegoDoblePar.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test07UnaInstanciaDeDobleParSiUnaListaDeCartasConTresCartaNoEsDoblePar() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of(new Carta(3, new Trebol()),
                new Carta(3, new Corazon()), new Carta(3, new Pica())));
        // Act
        boolean resulatado = juegoDoblePar.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test08UnaInstanciaDeDobleParSiUnaListaDeCartasCuatroCartasIgualesEsDoblePar() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Trebol()), new Carta(10, new Pica()),
                new Carta(10, new Diamante())));
        // Act
        boolean resulatado = juegoDoblePar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test09UnaInstanciaDeDobleParSiUnaListaDeCartasConMasDeCincoCartasEsDoblePar() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Diamante()), new Carta(3, new Corazon()),
                new Carta(3, new Pica()), new Carta(5, new Corazon()),
                new Carta(6, new Corazon()), new Carta(7, new Corazon())));
        // Act
        boolean resulatado = juegoDoblePar.sosJuego(cartas);
        // Assert
        assertTrue(resulatado);
    }
    @Test
    public void test10UnaInstanciaDeDobleParDeUnaListaConCincoCartasDeDiferenteValorNoEsDoblePar() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(2, new Pica()), new Carta(3, new Corazon()),
                new Carta(4, new Diamante()), new Carta(5, new Trebol())));
        // Act
        boolean resulatado = juegoDoblePar.sosJuego(cartas);
        // Assert
        assertFalse(resulatado);
    }
    @Test
    public void test11UnaInstanciaDeDobleParDeUnaListaDeCartasConCuatrCartaDevuelveElValorCorrecto() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(10, new Corazon()),
                new Carta(10, new Trebol()), new Carta(10, new Pica()),
                new Carta(10, new Diamante())));
        int valorEsperado = 120;
        // Act
        int valorObtenido = juegoDoblePar.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test12UnaInstanciaDeDobleParDeUnaListaDeCartasConCincoCartasDevuelveElValorCorrecto() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(2, new Diamante()),
                new Carta(2, new Pica()), new Carta(3, new Corazon()),
                new Carta(3, new Trebol()), new Carta(5, new Corazon())));
        int valorEsperado = 70;
        // Act
        int valorObtenido = juegoDoblePar.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test13UnaInstanciaDeDobleParSiUnaListaDeCartasVaciaNDevueleElValorBaseDeDoblePar() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>();
        int valorEsperado = 40;
        // Act
        int valorObtenido = juegoDoblePar.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test14UnaInstanciaDeDobleParDeUnaListaDeCartasMasDeCincoCartasDevuelveElValorCorrecto() {
        // Arrange
        DoblePar juegoDoblePar = new DoblePar();
        ArrayList<Carta> cartas = new ArrayList<>(List.of( new Carta(1, new Corazon()),
                new Carta(1, new Diamante()), new Carta(1, new Pica()),
                new Carta(7, new Pica()), new Carta(7, new Corazon()),
                new Carta(7, new Diamante()), new Carta(7, new Trebol())));
        int valorEsperado = 102;
        // Act
        int valorObtenido = juegoDoblePar.puntuarMano(cartas).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
}
