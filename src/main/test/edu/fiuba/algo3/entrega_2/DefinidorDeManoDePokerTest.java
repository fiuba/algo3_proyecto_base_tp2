package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.entrega_1.ManoDePoker.EscaleraReal;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.entrega_1.Palo.Corazon;
import edu.fiuba.algo3.entrega_1.Palo.Palo;
import edu.fiuba.algo3.entrega_1.Palo.Pica;
import edu.fiuba.algo3.entrega_1.Palo.Trebol;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import edu.fiuba.algo3.entrega_1.definidorDeManoDePoker.DefinidorDeManoDePoker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinidorDeManoDePokerTest {
    @Test
    void test01seSeleccionaUnaEscaleraReal(){
        //arrange
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas.add(new Carta(new Corazon(),));
        //Palo palo, int valor, int puntajeBase, int multiplicador
        cartas.add(new Carta(new Corazon(),13));
        cartas.add(new Carta(new Pica(),12));
        cartas.add(new Carta(new Corazon(),11));
        cartas.add(new Carta(new Trebol(),10));

        ManoDePoker manoDePokerEsperada = new EscaleraReal();
        DefinidorDeManoDePoker definidor = new DefinidorDeManoDePoker();

        //act
        ManoDePoker manoDePokerObtenida = definidor.definirManoDePoker(cartas);

        //assert
        assertEquals(manoDePokerEsperada,manoDePokerObtenida);
    }
}
