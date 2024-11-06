package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class casosDeUsoEntrega1Test {
    @Test
    public void test01unJugadorTieneQueTenerCartasSuficientesParaArrancarElJuego() {
        //Arrange
        Jugador jugador = new Jugador();

        //Act
        boolean cantidadDeCartasMinimas = (jugador.mano.obtenerCartas().size() > 0);

        //Assert
        assertTrue(cantidadDeCartasMinimas);
    }

    @Test
    public void test02AUnJugadorSeLeRepartenOchoCartasDeSuMazo() {
        //Arrange
        Jugador jugador = new Jugador();

        //Act
        int cantidadDeCartas = jugador.mano.obtenerCartas().size();

        //Assert
        assertEquals(8, cantidadDeCartas);
    }

    @Test
    public void test03verificarQueSePuedeJugarUnaManoDeUnMazo(){
        //Arrange
        Jugador jugador = new Jugador();

        //Assert y Act
        assertDoesNotThrow(() -> jugador.tirarMano());
    }
}
