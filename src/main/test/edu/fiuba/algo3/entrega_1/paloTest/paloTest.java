package edu.fiuba.algo3.entrega_1.paloTest;

import edu.fiuba.algo3.entrega_1.Palo.*;
import org.junit.jupiter.api.Test;

public class paloTest {
    @Test
    public void test01UnCorazonSeComparaConUnTrebol(){
        Palo corazon = new Corazones();
        Palo trebol = new Trebol();

        Boolean comparacion = corazon.sonMismoPalo(trebol);

        assert !comparacion;
    }
    @Test
    public void test02UnCorazonSeComparaConOtroCorazon(){
        Palo corazon = new Corazones();
        Palo corazon2 = new Corazones();

        Boolean comparacion = corazon.sonMismoPalo(corazon2);
        assert comparacion;
    }

    @Test
    public void test03UnDiamanteSeSeComparaConPicas(){
        Palo diamante = new Diamante();
        Palo pica = new Pica();

        Boolean comparacion = diamante.sonMismoPalo(pica);

        assert !comparacion;
    }
}
