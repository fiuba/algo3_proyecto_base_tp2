package entrega1;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TarotTest {
    @Test
    public void test06AplicarTarotModificaElValorNumericoDeCarta() {
        Poker carta = new Poker(1, "7", 7, new Diamante());
        Tarot tarot = new TarotModificadorPuntos();

        tarot.modificar(carta);

        assertEquals(carta.calcularValor(), 10);
    }

    @Test
    public void test07AplicarTarotModificaElMultiplicadorDeCarta() {
        Poker carta = new Poker(1, "5", 5, new Diamante());
        Tarot tarot = new TarotModificadorMultiplicador();

        tarot.modificar(carta);

        // 5 * 6 = 30
        assertEquals(carta.calcularValor(), 30);
    }
}
