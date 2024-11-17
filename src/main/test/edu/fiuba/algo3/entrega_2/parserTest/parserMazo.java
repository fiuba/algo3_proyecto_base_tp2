package edu.fiuba.algo3.entrega_2.parserTest;

import edu.fiuba.algo3.entrega_1.carta.Carta;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class parserMazo{
    @Test
    public void test01SeParseaUnMazoYSeVerificaLaCantidadDeCartas(){
        Parser parserDeMazo = new parserMazo();

        List<Carta> cartas = parserDeMazo.generarCartas();

        Assertions.assertEquals(52, cartas.size());
    }
}
