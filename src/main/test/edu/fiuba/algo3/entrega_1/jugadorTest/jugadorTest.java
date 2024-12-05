package edu.fiuba.algo3.entrega_1.jugadorTest;

import edu.fiuba.algo3.controllers.Factory.FactoryComodines;
import edu.fiuba.algo3.controllers.Factory.FactoryDeMaso;
import edu.fiuba.algo3.controllers.Factory.FactoryDeTarot;
import edu.fiuba.algo3.modelo.GeneradorDeCartas.GeneradorDeCartas;
import edu.fiuba.algo3.modelo.Jugada.Jugada;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mano.Mano;
import edu.fiuba.algo3.modelo.ManoDeComodines.ManoDeComodines;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.Palo.Corazon;
import edu.fiuba.algo3.modelo.Palo.Diamante;
import edu.fiuba.algo3.modelo.Palo.Pica;
import edu.fiuba.algo3.modelo.Palo.Trebol;
import edu.fiuba.algo3.modelo.Prooveedor.ProveedorDeCartas;
import edu.fiuba.algo3.modelo.Prooveedor.ProveedorDeComodines;
import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.manoDeTarots.ManoDeTarots;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class jugadorTest {

    FactoryComodines generadorDeComodines;
    FactoryDeTarot generadorDeTarots;
    List<Comodin> comodines;
    ManoDeComodines manoComodines;
    List<Carta> cartas;
    ManoDeTarots manoDeTarots;
    List<Tarot> tarots;

    @BeforeEach
    void setUp() {
       cartas = new ArrayList<>();

        cartas.add(new Carta(new Corazon(), 7, 7, 1));  // Par 1
        cartas.add(new Carta(new Pica(), 7, 7, 1));     // Par 1
        cartas.add(new Carta(new Diamante(), 5, 5, 1)); // Par 2
        cartas.add(new Carta(new Trebol(), 5, 5, 1));   // Par 2
        cartas.add(new Carta(new Corazon(), 9, 9, 1));  // Descarte
        cartas.add(new Carta(new Trebol(), 2, 2, 1));   // Descarte
        cartas.add(new Carta(new Diamante(), 11, 11, 1));// Descarte
        cartas.add(new Carta(new Pica(), 13, 10, 1));   // Descarte

        generadorDeTarots = new FactoryDeTarot("src/main/resources/tarots.json");
        generadorDeComodines = new FactoryComodines("src/main/resources/comodines.json");
        comodines = generadorDeComodines.generarComodines();
        tarots = generadorDeTarots.generarTarots();

        manoComodines = new ManoDeComodines();
        manoComodines.guardar(comodines.get(5));
        manoComodines.guardar(comodines.get(7));

        manoDeTarots = new ManoDeTarots();
        manoDeTarots.guardar(tarots.get(2));
        manoDeTarots.guardar(tarots.get(3));
    }

    @Test
    public void test01AunJugadorSeLeDaUnaManoYArmaUnaJugada(){

        Mazo mazoMockeado = Mockito.mock(Mazo.class);
        Mockito.when(mazoMockeado.generarCartas()).thenReturn(cartas);


        Mano mano = new Mano(mazoMockeado, 3, manoComodines);

        Jugador jugador = Jugador.CrearJugador("pepe");
        jugador.asignarMano(mano);
        List<Carta> cartasAJugar = jugador.verCartasEnMano();

        jugador.seleccionar(cartasAJugar.get(3));
        jugador.seleccionar(cartasAJugar.get(4));
        jugador.seleccionar(cartasAJugar.get(5));
        jugador.seleccionar(cartasAJugar.get(6));


        Assertions.assertEquals(88, jugador.jugarMano());
    }

    @Test
    public void test02UnJugadorSeJuega1TarotYJuegaLaJugada(){
        Mazo mazoMockeado = Mockito.mock(Mazo.class);
        Mockito.when(mazoMockeado.generarCartas()).thenReturn(cartas);
        Mano mano = new Mano(mazoMockeado, 3, manoComodines);

        Jugador jugador = Jugador.CrearJugador("pepe");
        jugador.asignarMano(mano);
        jugador.asignarTarots(manoDeTarots);

        List<Carta> cartasAJugar = jugador.verCartasEnMano();


        jugador.seleccionar(cartasAJugar.get(3));
        jugador.seleccionar(cartasAJugar.get(4));
        jugador.seleccionar(cartasAJugar.get(5));
        jugador.seleccionar(cartasAJugar.get(6));

        jugador.aplicarTarotAMano(tarots.get(2));

        Assertions.assertEquals(256, jugador.jugarMano());
    }


    @Test
    public void test03UnJugadorSeJuega1TarotACartaYJuegaLaJugada(){
        Mazo mazoMockeado = Mockito.mock(Mazo.class);
        Mockito.when(mazoMockeado.generarCartas()).thenReturn(cartas);
        Mano mano = new Mano(mazoMockeado, 3, manoComodines);

        Jugador jugador = Jugador.CrearJugador("pepe");
        jugador.asignarMano(mano);
        jugador.asignarTarots(manoDeTarots);

        List<Carta> cartasAJugar = jugador.verCartasEnMano();

        jugador.aplicarTarotACarta(tarots.get(3), cartasAJugar.get(3));
        jugador.seleccionar(cartasAJugar.get(3));
        jugador.seleccionar(cartasAJugar.get(4));
        jugador.seleccionar(cartasAJugar.get(5));
        jugador.seleccionar(cartasAJugar.get(6));



        Assertions.assertEquals(190, jugador.jugarMano());
    }

    @Test
    public void test04UnJugadorSeJuegaUnaJugadoConComodinesAplicables(){
        Mazo mazoMockeado = Mockito.mock(Mazo.class);
        Mockito.when(mazoMockeado.generarCartas()).thenReturn(cartas);

        ManoDeComodines manoDeComodinesEnEsteTest = new ManoDeComodines();
        manoDeComodinesEnEsteTest.guardar(comodines.get(0));
        manoDeComodinesEnEsteTest.guardar(comodines.get(1));
        Mano mano = new Mano(mazoMockeado, 3, manoDeComodinesEnEsteTest);

        Jugador jugador = Jugador.CrearJugador("pepe");
        jugador.asignarMano(mano);
        jugador.asignarTarots(manoDeTarots);

        List<Carta> cartasAJugar = jugador.verCartasEnMano();

        jugador.seleccionar(cartasAJugar.get(3));
        jugador.seleccionar(cartasAJugar.get(4));
        jugador.seleccionar(cartasAJugar.get(5));
        jugador.seleccionar(cartasAJugar.get(6));



        Assertions.assertEquals(1152, jugador.jugarMano());
    }

    @Test
    public void test05UnJugadorDescarta2CartasYDeUnDobleParPasaAUnFullHouse() {

        List<Carta> cartasADescartar = new ArrayList<>();
        cartasADescartar.add(cartas.get(4));
        cartasADescartar.add(cartas.get(5));
        cartasADescartar.add(cartas.get(6));

        Carta cartaTrio1 = new Carta(new Corazon(), 8, 8, 1);
        Carta cartaTrio2 = new Carta(new Trebol(), 8, 8, 1);
        Carta cartaTrio3 = new Carta(new Pica(), 8, 8, 1);
        List<Carta> cartasPostDescartar = new ArrayList<>();

        cartasPostDescartar.add(cartaTrio1);
        cartasPostDescartar.add(cartaTrio2);
        cartasPostDescartar.add(cartaTrio3);
        cartasPostDescartar.add(cartas.get(0));
        cartasPostDescartar.add(cartas.get(1));
        cartasPostDescartar.add(cartas.get(2));
        cartasPostDescartar.add(cartas.get(3));
        cartasPostDescartar.add(cartas.get(5));
        Mazo mazoSpy = Mockito.mock(Mazo.class);


        Mockito.when(mazoSpy.generarCartas()).thenReturn(cartas);
        Mockito.when(mazoSpy.repartirCartas()).thenReturn(cartasPostDescartar);

        Mano mano = new Mano(mazoSpy, 3, manoComodines);


        Jugador jugador = Jugador.CrearJugador("pepe");
        jugador.asignarMano(mano);


        List<Carta> cartasAJugar = jugador.verCartasEnMano();


        jugador.seleccionar(cartasADescartar.get(0));
        jugador.seleccionar(cartasADescartar.get(1));
        jugador.seleccionar(cartasADescartar.get(2));


        jugador.descartar();

        cartasAJugar = jugador.verCartasEnMano();
        jugador.seleccionar(cartaTrio1);
        jugador.seleccionar(cartaTrio2);
        jugador.seleccionar(cartaTrio3);
        jugador.seleccionar(cartasAJugar.get(3));
        jugador.seleccionar(cartasAJugar.get(4));


        Assertions.assertEquals(2496, jugador.jugarMano());
    }


}
