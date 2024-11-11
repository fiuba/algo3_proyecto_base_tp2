package edu.fiuba.algo3.entrega_1.cartaTest;
import edu.fiuba.algo3.entrega_1.Palo.Corazones;
import edu.fiuba.algo3.entrega_1.Palo.Palo;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import edu.fiuba.algo3.entrega_1.Valor.Cuatro;
import edu.fiuba.algo3.entrega_1.Valor.Tres;
import edu.fiuba.algo3.entrega_1.Valor.Valor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class cartaTest {
    @Test
        public void test01SeInstanciaUn3DeCorazonesYSeLoComparaConUn4DeDeCorazones(){
            Palo corazon = new Corazones();
            Valor tres = new Tres();
            Valor cuatro = new Cuatro();

            Carta unaCarta = new Carta(corazon, tres);
            Carta otraCarta = new Carta(corazon, cuatro);

            Assertions.assertFalse(unaCarta.compararValor(otraCarta));
        }
}