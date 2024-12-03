package edu.fiuba.algo3.entrega_3.RondaTestIntegrador;

import edu.fiuba.algo3.controllers.Factory.FactoryComodines;
import edu.fiuba.algo3.controllers.Factory.FactoryDeMaso;
import edu.fiuba.algo3.controllers.Factory.FactoryDeTarot;
import edu.fiuba.algo3.controllers.Factory.FactoryRondas;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mano.Mano;
import edu.fiuba.algo3.modelo.Mazo.Mazo;

import edu.fiuba.algo3.modelo.Modificable.Modificador;
import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Palo.Diamante;
import edu.fiuba.algo3.modelo.Palo.Pica;
import edu.fiuba.algo3.modelo.Palo.Trebol;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.ronda.Ronda;
import edu.fiuba.algo3.modelo.ronda.Tienda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

public class RondaTestIntegrador {
    FactoryComodines factoryComodines;
    FactoryDeMaso factoryDeMaso;
    FactoryDeTarot factoryDeTarot;
    FactoryRondas factoryRondas;
    FactoryComodines mockFactoryComodines;
    FactoryDeTarot mockFactoryDeTarot;
    FactoryDeMaso mockFactoryDeMaso;
    Mazo mockMazo;
    @BeforeEach
    public void setUp() {
        factoryComodines = new FactoryComodines("src/main/resources/comodines.json");
        factoryDeMaso = new FactoryDeMaso("src/main/resources/mazo.json");
        factoryDeTarot = new FactoryDeTarot("src/main/resources/tarots.json");
        factoryRondas = new FactoryRondas("src/main/resources/balatro.json", factoryDeTarot, factoryDeMaso, factoryComodines);

        mockFactoryComodines = Mockito.mock(FactoryComodines.class);
        mockFactoryDeTarot = Mockito.mock(FactoryDeTarot.class);
        mockFactoryDeMaso = Mockito.mock(FactoryDeMaso.class);

        Comodin comodin = factoryComodines.generarComodines().get(5);
        Comodin otroComodin = factoryComodines.generarComodines().get(4);
        List<Comodin> comodinesMock = List.of(comodin, otroComodin);
        Mockito.when(mockFactoryComodines.generarComodines()).thenReturn(comodinesMock);


        Tarot tarot = factoryDeTarot.generarTarots().get(5);
        Tarot otroTarot = factoryDeTarot.generarTarots().get(4);
        List<Tarot> tarotsMock = List.of(tarot, otroTarot);
        Mockito.when(mockFactoryDeTarot.generarTarots()).thenReturn(tarotsMock);

        Carta carta = new Carta(new Corazon(), 11, 10, 1);
        Mockito.when(mockFactoryDeMaso.generarCartas()).thenReturn(List.of(carta));

        List<Carta> cartasMock = List.of(carta);

        // Par 1: 7 de Corazón y 7 de Picas
        cartasMock.add(new Carta(new Corazon(), 7, 7, 1));
        cartasMock .add(new Carta(new Pica(), 7, 7, 1));

        // Par 2: 5 de Diamantes y 5 de Tréboles
        cartasMock .add(new Carta(new Diamante(), 5, 5, 1));
        cartasMock .add(new Carta(new Trebol(), 5, 5, 1));

        // Full: 3 cartas con 3 de Corazones, 3 de Picas y 3 de Tréboles
        cartasMock .add(new Carta(new Corazon(), 3, 3, 1));
        cartasMock .add(new Carta(new Pica(), 3, 3, 1));
        cartasMock .add(new Carta(new Trebol(), 3, 3, 1));

        // Cartas para descarte
        cartasMock .add(new Carta(new Corazon(), 9, 9, 1));
        cartasMock .add(new Carta(new Trebol(), 2, 2, 1));
        cartasMock .add(new Carta(new Diamante(), 11, 11, 1));
        cartasMock .add(new Carta(new Pica(), 13, 10, 1));

        Mazo mockMazo = Mockito.mock(Mazo.class);
        Mockito.when(mockMazo.generarCartas()).thenReturn(cartasMock);

    }

    @Test
    public void test01SeInstaciaUnaRondaYSeVeSiTieneDosTarots() throws IOException {

        List<Ronda> rondas = factoryRondas.generarRondas();

        Ronda ronda = rondas.get(0);

        List<Tarot> tarots = ronda.getTienda().obtenerTarots();

        Assertions.assertEquals(tarots.size(), 2);

    }

    @Test
    public void test02SePruebaQueLaTiendaTiene2Comodines() throws IOException {
        List<Ronda> rondas = factoryRondas.generarRondas();

        Ronda ronda = rondas.get(0);

        List<Comodin> comodines = ronda.getTienda().obtenerComodines();

        Assertions.assertEquals(comodines.size(), 2);
    }

     @Test
    public void test03SePruebaQueLaTiendaTiene1Cartas() throws IOException {
        List<Ronda> rondas = factoryRondas.generarRondas();

        Ronda ronda = rondas.get(0);

        List<Carta> cartas = ronda.getTienda().obtenerCartas();

        Carta carta = cartas.get(0);

        Carta cartaPrueba = new Carta(new Corazon(), 10, 10, 1);
        Assertions.assertEquals(carta, cartaPrueba);
     }

     @Test
    public void test04SeJuegan5ManosYSePasaLaRonda(){

        Tienda tienda = new Tienda(mockFactoryDeTarot.generarTarots(),mockFactoryComodines.generarComodines(), mockFactoryDeMaso.generarCartas());

        Jugador jugador = new Jugador("el pepe");

        Ronda ronda = new Ronda(tienda, 1, 3, 2, 500);

        ronda.asignarJugador(jugador);

        ronda.asignarMazo(mockMazo);

        Mano mano = ronda.repartirMano();

     }

}
