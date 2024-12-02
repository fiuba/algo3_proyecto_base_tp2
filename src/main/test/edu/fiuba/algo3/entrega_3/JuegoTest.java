package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.controllers.Factory.FactoryComodines;
import edu.fiuba.algo3.controllers.Factory.FactoryDeMaso;
import edu.fiuba.algo3.controllers.Factory.FactoryDeTarot;
import edu.fiuba.algo3.controllers.Factory.FactoryRondas;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JuegoTest {
    FactoryComodines factoryComodines;
    FactoryDeMaso factoryDeMaso;
    FactoryDeTarot factoryDeTarot;
    @BeforeEach
    public void setUp() {
         factoryComodines = new FactoryComodines("src/main/resources/comodines.json");
         factoryDeMaso = new FactoryDeMaso("src/main/resources/mazo.json");
         factoryDeTarot = new FactoryDeTarot("src/main/resources/tarots.json");
    }

//
//    @Test
//    public void test01SeCreaUnJuegoConUnNombreYUnaRondaInicial() throws IOException {
//        FactoryRondas factoryRondas = new FactoryRondas("src/main/resources/tarots.json", )
//        List<Ronda> rondas  = factoryRondas.generarRondas();
//        Ronda ronda = rondas.get(0);
//
//        Juego juego = new Juego("sultanito", ronda);
//
//
//    }
}
