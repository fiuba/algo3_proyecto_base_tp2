package edu.fiuba.algo3.modeloTest.tarotTest;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.tarot.SinTarot;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinTarotTest {
    @Test
    public void test01UnTarotSinTarotConUnPuntajeBaseDevuelveEsePuntaje() {
        // Arrange
        Tarot tarotSinTarot = new SinTarot();
        int valorEsperado = 100;
        // Act
        Puntaje puntajeBase = new Puntaje(100, 1);
        int valorObtenido = tarotSinTarot.obtenerPuntaje(puntajeBase).calcularValor();
        // Assert
        assertEquals(valorEsperado, valorObtenido);
    }
}
