import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Poker;
import edu.fiuba.algo3.modelo.Corazon;
import edu.fiuba.algo3.modelo.Palo;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PokerTest {
    @Test
    public void test01DadaUnaCartaQPuntua10(){
        Poker carta = new Poker(10,"Q",0,null);
        int puntajeEsperado = 10;
        int puntajeObtenido = carta.usar();
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
    @Test
    public void test01DadaUnaCartaDeDiamanteSabeIndicarSuPalo(){
        Palo palo = new Corazon();
        Poker carta = new Poker(10,"Q",0, palo);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}