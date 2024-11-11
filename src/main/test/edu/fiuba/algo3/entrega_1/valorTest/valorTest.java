package edu.fiuba.algo3.entrega_1.valorTest;

import edu.fiuba.algo3.entrega_1.Valor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class valorTest {
    @Test
    public void  test01SeCreaUnTresYSeComparaConUnCuatro(){
        Valor tres = new Tres();
        Valor cuatro = new Cuatro();

        Boolean comparacion = tres.compararValor(cuatro);

        Assertions.assertTrue(comparacion);
    }

    @Test
    public void  test02SeCreaUnCuatroYSeComparaConUnTres(){
        Valor tres = new Tres();
        Valor cuatro = new Cuatro();

        Boolean comparacion = cuatro.compararValor(tres);

        Assertions.assertFalse(comparacion);
    }
    @Test
    public void test03SeComparaUnAsConUnDos(){
        Valor dos = new Dos();
        Valor as = new As();

        Boolean comparacion = dos.compararValor(as);

        Assertions.assertTrue(comparacion);
    }

    @Test
    public void test04SeComparaUnAsConUnaKa(){
        Valor Ka = new Ka();
        Valor as = new As();

        Boolean comparacion = Ka.compararValor(as);

        Assertions.assertFalse(comparacion);
    }
}
