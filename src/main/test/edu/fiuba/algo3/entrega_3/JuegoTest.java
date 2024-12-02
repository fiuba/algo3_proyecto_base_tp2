package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.controllers.Factory.FactoryComodines;
import edu.fiuba.algo3.controllers.Factory.FactoryDeMaso;
import edu.fiuba.algo3.controllers.Factory.FactoryDeTarot;
import edu.fiuba.algo3.controllers.Factory.FactoryRondas;
import edu.fiuba.algo3.modelo.Balatro.Balatro;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import edu.fiuba.algo3.modelo.ronda.Tienda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JuegoTest {
    FactoryComodines factoryComodines;
    FactoryDeMaso factoryDeMaso;
    FactoryDeTarot factoryDeTarot;

    ArrayList<Tarot> tarots;
    ArrayList<Comodin> comodines;
    List<Carta> cartas;
    ArrayList<Ronda> rondas;
    @BeforeEach
    public void setUp() {
         factoryComodines = new FactoryComodines("src/main/resources/comodines.json");
         factoryDeMaso = new FactoryDeMaso("src/main/resources/mazo.json");
         factoryDeTarot = new FactoryDeTarot("src/main/resources/tarots.json");

        tarots = new ArrayList<Tarot>();
        comodines = new ArrayList<Comodin>();
        rondas = new ArrayList<Ronda>();
    }

    void test01juegoConUnaRondaDeUnaManoSinComodinesNiTarotYLaGano(){

        Tienda tienda = new Tienda(tarots,comodines,factoryDeMaso.generarCartas());
        Ronda ronda1 = new Ronda(tienda,1,1,3,0);
        rondas.add(ronda1);
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));
        cartas.add( new Carta(new Corazon(), 2,2,1));

        Mazo mazoMockeado = Mockito.mock(Mazo.class);
        Mockito.when(mazoMockeado.generarCartas()).then(invocation -> cartas);

        Balatro juego = new Balatro(rondas,mazoMockeado);

        Ronda rondaAJugar = juego.jugar();

       
    }

    /*

    @Test
    public void test01SeCreaUnJuegoConUnNombreYUnaTiendaInicial(){
        FactoryRondas factoryRondas = new FactoryRondas("src/main/resources/tarots.json", )
        List<Ronda> rondas  = factoryRondas.generarRondas();
        Ronda ronda =
        Juego juego = new Juego("sultanito", )
    }*/
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
