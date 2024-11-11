package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.puntaje.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PuntajeTest {
    @Test
    public void test01AUnaInstaciaDePuntajeSeLePuedeSumarPuntosOtraInstaciaDePuntaje() {
        // Arrange
        Puntaje puntajeBase = new Puntaje(100, 1);
        Puntaje puntajeASumar = new Puntaje(50, 2);
        int valorEsperado = 150;
        //Act
        puntajeBase.sumarPuntos(puntajeASumar);
        int valorObtenido = puntajeBase.calcularValor();
        //Assert
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void test02UnPuntajeNoPuedeTenerPuntosNegativosAlInstanciarse() {
        //Arrange /Act / Assert
        assertThrows(PuntosInvalidosException.class, () -> {
            Puntaje puntaje = new Puntaje(-1, 1);
        });
    }
    @Test
    public void test03UnPuntajePuedeTenerPuntosIgualA0AlInstanciarse() {
        //Arrange /Act / Assert
        assertDoesNotThrow(() -> {
            Puntaje puntaje = new Puntaje(0, 1);
        });
    }
    @Test
    public void test04UnPuntajeNoPuedeTenerMultiplicadorNegativosAlInstanciarse() {
        //Arrange /Act / Assert
        assertThrows(MultiplicadorInvalidosException.class, () -> {
            Puntaje puntaje = new Puntaje(1, -1);
        });
    }
    @Test
    public void test05UnPuntajeNoPuedeTenerMultiplicadorIgualA0AlInstanciarse() {
        //Arrange /Act / Assert
        assertThrows(MultiplicadorInvalidosException.class, () -> {
            Puntaje puntaje = new Puntaje(1, 0);
        });
    }
    @Test
    public void test06AUnaInstaciaDePuntajeSeLePuedeSumarMultiplicadorOtraInstaciaDePuntaje() {
        // Arrange
        Puntaje puntajeBase = new Puntaje(1, 20);
        Puntaje puntajeASumar = new Puntaje(1, 30);
        int valorEsperado = 50;
        //Act
        puntajeBase.sumarMultiplicador(puntajeASumar);
        int valorObtenido = puntajeBase.calcularValor();
        //Assert
        assertEquals(valorEsperado, valorObtenido);
    }
}
