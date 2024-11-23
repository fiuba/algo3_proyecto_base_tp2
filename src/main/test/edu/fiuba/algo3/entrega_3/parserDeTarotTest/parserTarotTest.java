package edu.fiuba.algo3.entrega_3.parserDeTarotTest;

import com.tngtech.archunit.core.importer.resolvers.ClassResolver;
import edu.fiuba.algo3.controllers.Factory.FactoryDeTarot;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class parserTarotTest {
    @Test
    public void test01SeGeneranTodosLosTarotYSeCuentan(){
        FactoryDeTarot factory = new FactoryDeTarot("src/main/resources/tarots.json");

        List<Tarot> listaTarot = factory.generarTarots();

        Assertions.assertEquals(15, listaTarot.size());
    }
}
