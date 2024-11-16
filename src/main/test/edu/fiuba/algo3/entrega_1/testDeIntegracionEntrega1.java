package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.entrega_1.GeneradorDeCartas.GeneradorDeCartas;
import edu.fiuba.algo3.entrega_1.Jugada.Jugada;
import edu.fiuba.algo3.entrega_1.Jugador.Jugador;
import edu.fiuba.algo3.entrega_1.Mano.Mano;
import edu.fiuba.algo3.entrega_1.Palo.Corazon;
import edu.fiuba.algo3.entrega_1.Palo.Diamante;
import edu.fiuba.algo3.entrega_1.Palo.Pica;
import edu.fiuba.algo3.entrega_1.Palo.Trebol;
import edu.fiuba.algo3.entrega_1.carta.Carta;
import static org.mockito.Mockito.*;
import edu.fiuba.algo3.entrega_1.Mazo.Mazo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class testDeIntegracionEntrega1{
    GeneradorDeCartas generadorDeCartas;
    Mazo mazo;
    Mano mano;
    List<Carta> cartaDePrueba = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        cartaDePrueba.add(new Carta(new Corazon(),2));
        cartaDePrueba.add(new Carta(new Corazon(),3));
        cartaDePrueba.add(new Carta(new Corazon(),4));
        cartaDePrueba.add(new Carta(new Diamante(),10));
        cartaDePrueba.add(new Carta(new Diamante(),11));
        cartaDePrueba.add(new Carta(new Trebol(),5));
        cartaDePrueba.add(new Carta(new Trebol(),6));
        cartaDePrueba.add(new Carta(new Pica(),7));

        mazo = Mockito.mock(Mazo.class);
        mano = new Mano(mazo);

        when(mazo.generarCartas()).thenReturn(cartaDePrueba);
    }
    @Test
        public void test01SeVerificaQueUnJugadorCuentaConCartasSuficientesParaIniciarElJuegoEnSuMaso() {
            Jugador jugador = new Jugador("Manuel");

            jugador.asignarMano(mano);

            assert(jugador.puedeJugar());

        }
    @Test
    public void test02UnJugadorJuegaUnaManoDelMazo(){
        Jugador jugador = new Jugador("Manuel");
        jugador.asignarMano(mano);
        List<Carta> cartasDePrueba = new ArrayList<>();
        cartasDePrueba.add(new Carta(new Corazon(),2));
        cartasDePrueba.add(new Carta(new Corazon(),3));
        Jugada jugada = jugador.armarJugada(cartasDePrueba);

        Assertions.assertEquals(20, jugada.jugar());

    }
    }