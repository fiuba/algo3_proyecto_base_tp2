package entrega1;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void test01JugadorPoseeCartasSuficientesEnElMazoParaEmpezarElJuego() {
        Jugador jugador = new Jugador();

        assertDoesNotThrow(jugador::repartirMano);
    }

    @Test
    public void test03JugadorPuedeJugarSuMano() {
        Jugador jugador = new Jugador();
        jugador.repartirMano();
        ArrayList<Poker> cartas = new ArrayList<>();
        cartas.add(new Poker(1, "A", 10, new Diamante()));
        cartas.add(new Poker(2, "7", 7, new Diamante()));

        Puntaje puntaje = jugador.jugarMano(cartas);

        assertTrue(puntaje.valor() > 0);
    }

    @Test
    public void test04JugarUnaManoCalculaElValorCorrespondiente() {
        Jugador jugador = new Jugador();
        jugador.repartirMano();
        ArrayList<Poker> cartas = new ArrayList<>();
        cartas.add(new Poker(1, "A", 10, new Diamante()));
        cartas.add(new Poker(2, "7", 7, new Diamante()));

        Puntaje puntaje = jugador.jugarMano(cartas);

        assertEquals(puntaje.valor(), 10);
    }

    @Test
    public void test05ElOrdenAfectaLaPuntuacionDeCartas() {
        fail("Test no implementado");
    }
}
