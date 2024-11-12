package edu.fiuba.algo3.modeloTest.tarotTest;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.tarot.CambiadorDeMultiplicador;
import edu.fiuba.algo3.modelo.tarot.MultiplicadorInvalidoTarotException;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CambiadorDeMultiplicadorTest {
    @Test
    public void test01UnTarotCambiadorDeMultiplicadorDeOchoMultiplicadorConUnPuntajeBaseDeDosMultiplicadorDevuelveEsePuntajeModificado() {
        // Arrange
        Tarot tarotCambiadorDeMultiplicador = new CambiadorDeMultiplicador(8);
        int valorEsperado = 24;
        // Act
        Puntaje puntajeBase = new Puntaje(3, 2);
        int valorObtenido = tarotCambiadorDeMultiplicador.obtenerPuntaje(puntajeBase).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test02UnTarotCambiadorDeMultiplicadorDeTresMultiplicadorConUnPuntajeBaseDeTresMultiplicadorDevuelveEsePuntajeModificado() {
        // Arrange
        Tarot tarotCambiadorDeMultiplicador = new CambiadorDeMultiplicador(3);
        int valorEsperado = 12;
        // Act
        Puntaje puntajeBase = new Puntaje(4, 3);
        int valorObtenido = tarotCambiadorDeMultiplicador.obtenerPuntaje(puntajeBase).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test03UnTarotCambiadorDeMultiplicadorDeSieteMultiplicadorConUnPuntajeBaseDeCuatroMultiplicadorDevuelveEsePuntajeModificado() {
        // Arrange
        Tarot tarotCambiadorDeMultiplicador = new CambiadorDeMultiplicador(4);
        int valorEsperado = 8;
        // Act
        Puntaje puntajeBase = new Puntaje(2, 7);
        int valorObtenido = tarotCambiadorDeMultiplicador.obtenerPuntaje(puntajeBase).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test04UnTarotCambiadorDeMultiplicadorNoPuedeSerInstanciadoConMultiplicadorNegativos() {
        // Arrange / Act / Assert
        assertThrows(MultiplicadorInvalidoTarotException.class, () -> new CambiadorDeMultiplicador(-1));
    }
    @Test
    public void test05UnTarotCambiadorDeMultiplicadorNoPuedeSerInstanciadoIgualA0() {
        // Arrange / Act / Assert
        assertThrows(MultiplicadorInvalidoTarotException.class, () -> new CambiadorDeMultiplicador(0));
    }
}
