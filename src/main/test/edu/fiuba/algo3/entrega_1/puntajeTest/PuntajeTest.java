package edu.fiuba.algo3.entrega_1.puntajeTest;
import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PuntajeTest {
    @Test
    void test01PuntajeConValor10YMultiplicador2Da20Puntos(){
        //assert
        Puntaje puntaje = new Puntaje(10,2);

        //act
        int puntajeObtenido = puntaje.calcularPuntaje(0);

        //assert
        assertEquals(20,puntajeObtenido);
    }

    @Test
    void test02ModificoMultiplicadorDeUnPuntaje(){
        //assert
        Puntaje puntaje = new Puntaje(10,2);

        //act
        puntaje.modificarMultiplicador(2);
        int puntajeObtenido = puntaje.calcularPuntaje(0);

        //assert
        assertEquals(40,puntajeObtenido);
    }

    @Test
    void test03ModificoValorDeUnPuntaje(){
        //assert
        Puntaje puntaje = new Puntaje(10,2);

        //act
        puntaje.modificarValor(5);
        int puntajeObtenido = puntaje.calcularPuntaje(0);

        //assert
        assertEquals(30,puntajeObtenido);
    }
}
