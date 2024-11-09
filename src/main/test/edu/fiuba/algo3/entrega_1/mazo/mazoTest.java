package edu.fiuba.algo3.entrega_1.mazo;


import org.junit.jupiter.api.Test;
public class mazoTest {
    @Test
        public void test01UnMazoSeInstanciaCon52Cartas(){
            Mazo mazo = new Mazo();  

            assert(mazo.cartasRestantes() == 52);
        }
}
