package edu.fiuba.algo3.entrega_1.cartaTest;
import edu.fiuba.algo3.entrega_1.Palo.Corazon;
import edu.fiuba.algo3.entrega_1.Palo.Diamante;
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
            Palo corazon = new Corazon();
            Valor tres = new Tres();
            Valor cuatro = new Cuatro();

            Carta unaCarta = new Carta(corazon, tres);
            Carta otraCarta = new Carta(corazon, cuatro);

            Assertions.assertFalse(unaCarta.esMayor(otraCarta));
        }

        @Test
        public void test02SeInstancia2CartasDeMismoValorYDistintoPaloYSeComparanPorValor(){
            Palo corazon = new Corazon();
            Palo diamante = new Diamante();
            Valor tres = new Tres();
            Carta unaCarta = new Carta(corazon, tres);
            Carta otraCarta = new Carta(diamante, tres);

            Boolean comparacion = unaCarta.esMayor(otraCarta);

            Assertions.assertFalse(comparacion);

        }

        @Test
        void test03dosCartasDeMismoPaloSeComparar(){
            Palo corazon = new Corazon();
            Valor tres = new Tres();
            Valor cuatro = new Cuatro();

            Carta unaCarta = new Carta(corazon, tres);
            Carta otraCarta = new Carta(corazon, cuatro);

            Boolean comparacion = unaCarta.sonMismoPalo(otraCarta);

            Assertions.assertTrue(comparacion);
        }

    @Test
    void test04dosCartasDeDistintoPaloSeComparan(){

        Palo corazon = new Corazon();
        Palo diamante = new Diamante();
        Valor cuatro = new Cuatro();

        Carta unaCarta = new Carta(diamante, cuatro);
        Carta otraCarta = new Carta(corazon, cuatro);

        Boolean comparacion = unaCarta.sonMismoPalo(otraCarta);

        Assertions.assertFalse(comparacion);
    }

    @Test
    void test05dosCartasDeDistintoPaloYConMismoValorSeComparan(){
            Palo corazon = new Corazon();
            Valor tres = new Tres();

            Palo diamante = new Diamante();
            Carta unaCarta = new Carta(corazon, tres);
            Carta otraCarta = new Carta(diamante, tres);

            Boolean comparacion = unaCarta.esIgualA(otraCarta);

            Assertions.assertTrue(comparacion);
    }
}
