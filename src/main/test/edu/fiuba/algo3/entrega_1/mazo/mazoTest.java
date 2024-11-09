package edu.fiuba.algo3.entrega_1.mazo;


import edu.fiuba.algo3.entrega_1.carta.Carta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class mazoTest {
    @Test
        public void test01UnMazoSeInstanciaCon52Cartas(){
            Mazo mazo = new Mazo();  

            assert(mazo.cartasRestantes() == 52);
        }

        @Test
        public void test02UnMazoReparte8Cartas(){
            Mazo mazo = new Mazo();

            List<Carta> cartas = mazo.repartir(8);

            Assertions.assertEquals(8, cartas.size());;
        }
}
