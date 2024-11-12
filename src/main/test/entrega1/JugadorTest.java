package entrega1;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class JugadorTest {

    @Test
    public void test01JugadorPoseeCartasSuficientesEnElMazoParaEmpezarElJuego() {
        Jugador jugador = new Jugador(new Mazo());

        assertDoesNotThrow(jugador::repartirMano);
    }

    @Test
    public void test02JugadorObtiene0PuntosSiJuegaSinSeleccionarCartas() {
        Jugador jugador = new Jugador(new Mazo());
        jugador.repartirMano();

        // En el futuro, esto no estará permitido
        // Ya que es una jugada nula.
        int puntajeFinal = jugador.jugarMano();

        assertEquals(puntajeFinal, 0);
    }

    @Test
    public void test03JugadorPuedeJugarSuMano() {
        // Arrange
        List<Poker> cartas = Arrays.asList(
            new Poker(0, "A", 10, new Pica()),
            new Poker(0, "A", 10, new Diamante()),
            new Poker(0, "A", 10, new Trebol()),
            new Poker(0, "A", 10, new Corazon()),
            new Poker(0, "7", 7, new Pica()),
            new Poker(0, "7", 7, new Diamante()),
            new Poker(0, "7", 7, new Trebol()),
            new Poker(0, "7", 7, new Corazon())
        );
        AtomicInteger index = new AtomicInteger(0);

        Mazo mazoMock = Mockito.mock(Mazo.class);

        when(mazoMock.tomarCarta()).thenAnswer(new Answer<Carta>() {
            @Override
            public Carta answer(InvocationOnMock invocation) {
                int currentIndex = index.getAndIncrement();
                return cartas.get(currentIndex);
            }
        });

        Jugador jugador = new Jugador(mazoMock);
        jugador.repartirMano();

        // Par de Aces
        jugador.seleccionarCarta(cartas.get(0));
        jugador.seleccionarCarta(cartas.get(1));

        // Act
        int puntajeFinal = jugador.jugarMano();

        // Assert
        assertEquals(60, puntajeFinal);
    }

    @Test
    public void test05ElOrdenAfectaLaPuntuacionDeCartas() {
        // Arrange
        List<Poker> cartas = Arrays.asList(
                Mockito.mock(Poker.class),
                Mockito.mock(Poker.class),
                new Poker(0, "A", 10, new Trebol()),
                new Poker(0, "A", 10, new Corazon()),
                new Poker(0, "7", 7, new Pica()),
                new Poker(0, "7", 7, new Diamante()),
                new Poker(0, "7", 7, new Trebol()),
                new Poker(0, "7", 7, new Corazon())
        );
        InOrder inOrder = Mockito.inOrder(cartas.get(0), cartas.get(1));

        AtomicInteger index = new AtomicInteger(0);
        Mazo mazoMock = Mockito.mock(Mazo.class);
        when(mazoMock.tomarCarta()).thenAnswer(new Answer<Carta>() {
            @Override
            public Carta answer(InvocationOnMock invocation) {
                int currentIndex = index.getAndIncrement();
                return cartas.get(currentIndex);
            }
        });

        Jugador jugador = new Jugador(mazoMock);
        jugador.repartirMano();

        jugador.seleccionarCarta(cartas.get(0));
        jugador.seleccionarCarta(cartas.get(1));

        // Act
        jugador.jugarMano();

        // Assert
        inOrder.verify(cartas.get(0)).modificarPuntaje(any());
        inOrder.verify(cartas.get(1)).modificarPuntaje(any());
    }
}
