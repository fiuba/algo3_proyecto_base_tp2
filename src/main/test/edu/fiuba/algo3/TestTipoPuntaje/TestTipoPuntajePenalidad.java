package edu.fiuba.algo3.TestTipoPuntaje;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTipoPuntajePenalidad {
    @Test
    public void test01EvaluarSiUnAnularEsValido(){
        boolean respuestaEsperada = true;
        TipoPuntaje tipoPuntaje = new Penalidad();
        PowerUp powerUp = new Anulador();

        assertEquals(tipoPuntaje.powerUpValido(powerUp), respuestaEsperada);
    }

    @Test
    public void test02EvaluarSiUnMultiplicadorEsValido(){
        boolean respuestaEsperada = true;
        TipoPuntaje tipoPuntaje = new Penalidad();
        PowerUp powerUp = new Multiplicador(2);

        assertEquals(tipoPuntaje.powerUpValido(powerUp), respuestaEsperada);
    }

    @Test
    public void test03EvaluarSiUnExclusividadEsValido(){
        boolean respuestaEsperada = false;
        TipoPuntaje tipoPuntaje = new Penalidad();
        PowerUp powerUp = new Exclusividad();

        assertEquals(tipoPuntaje.powerUpValido(powerUp), respuestaEsperada);
    }
}
