package edu.fiuba.algo3.entrega_1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarotTest {

    @Test
    public void testAplicarTarotACarta() {
        Carta carta = new Carta(5);
        Tarot tarot = new Tarot(10);

        tarot.aplicarA(carta);

        assertEquals(10, carta.getValor(), "El valor de la carta debe aumentar en 10.");
    }

    @Test
    public void testAplicarTarotAPuntaje() {
        Puntaje puntaje = new Puntaje(2, 3);
        Tarot tarot = new Tarot(4);

        tarot.aplicarA(puntaje);

        assertEquals(12, puntaje.getPuntaje(), "El puntaje debe aumentar en 10.");
    }
}