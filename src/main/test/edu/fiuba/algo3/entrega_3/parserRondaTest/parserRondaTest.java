package edu.fiuba.algo3.entrega_3.parserRondaTest;
import edu.fiuba.algo3.controllers.Factory.FactoryDeMaso;
import edu.fiuba.algo3.controllers.Factory.FactoryDeTarot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import edu.fiuba.algo3.modelo.ronda.Ronda;
import edu.fiuba.algo3.controllers.Factory.FactoryRondas;
import edu.fiuba.algo3.modelo.ronda.Tienda;
import edu.fiuba.algo3.modelo.Tarot.Tarot;

public class parserRondaTest {
    @Test
    public void test01SeParseanLasRondasYSeComprueban(){
        List<Ronda> rondas = null;
        FactoryDeMaso factoryDeMaso = new FactoryDeMaso("src/main/resources/mazo.json");
        FactoryDeTarot factoryDeTarot = new FactoryDeTarot("src/main/resources/tarots.json");
        FactoryRondas factoryRondas = new FactoryRondas("src/main/resources/balatro.json",factoryDeTarot, factoryDeMaso );

        try {
            rondas = factoryRondas.generarRondas();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(8, rondas.size() );
    }

    @Test
    public void test02ParseamosRondasComprobamosTarots() {
        List<Ronda> rondas = null;
        FactoryDeMaso factoryDeMaso = new FactoryDeMaso("src/main/resources/mazo.json");
        FactoryDeTarot factoryDeTarot = new FactoryDeTarot("src/main/resources/tarots.json");
        FactoryRondas factoryRondas = new FactoryRondas("src/main/resources/balatro.json", factoryDeTarot, factoryDeMaso);

        try {
            rondas = factoryRondas.generarRondas();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Ronda ronda = rondas.get(0);
        Tienda tienda = ronda.getTienda();
        List<Tarot> tarots = tienda.obtenerTarots();
        Assertions.assertEquals(2, tarots.size());
    }

}