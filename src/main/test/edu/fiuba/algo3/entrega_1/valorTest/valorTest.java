package edu.fiuba.algo3.entrega_1.valorTest;

import edu.fiuba.algo3.entrega_1.Valor.Cuatro;
import edu.fiuba.algo3.entrega_1.Valor.Tres;
import edu.fiuba.algo3.entrega_1.Valor.Valor;
import org.junit.jupiter.api.Test;

public class valorTest {
    @Test
    public void  test01SeCreaUnTresYSeComparaConUnCuatro(){
        Valor tres = new Tres();
        Valor cuatro = new Cuatro();

        Boolean comparacion = tres.compararValor(cuatro);

        assert comparacion;
    }

    @Test
    public void  test02SeCreaUnCuatroYSeComparaConUnTres(){
        Valor tres = new Tres();
        Valor cuatro = new Cuatro();

        Boolean comparacion = cuatro.compararValor(tres);

        assert !comparacion;
    }


}
