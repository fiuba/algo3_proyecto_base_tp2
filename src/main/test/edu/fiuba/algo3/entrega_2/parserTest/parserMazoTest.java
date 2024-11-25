package edu.fiuba.algo3.entrega_2.parserTest;

import edu.fiuba.algo3.modelo.Prooveedor.Proveedor;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.controllers.Factory.FactoryDeMaso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class parserMazoTest{
    @Test
    public void test01SeParseaUnMazoYSeVerificaLaCantidadDeCartas(){
        Proveedor factoryDeMazo = new FactoryDeMaso("src/main/resources/mazo.json");

        List<Carta> cartas = factoryDeMazo.generarCartas();

        Assertions.assertEquals(52, cartas.size());
    }
}
