package edu.fiuba.algo3.entrega_1.jugadorTest;

import edu.fiuba.algo3.controllers.Factory.FactoryComodines;
import edu.fiuba.algo3.modelo.GeneradorDeCartas.GeneradorDeCartas;
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
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class jugadorTest {
    Mazo mazoMock;
    GeneradorDeCartas generadorDeCartas;
    FactoryComodines generadorDeComodines;
    List<Carta> manoMock;
    List<Comodin> comodinesMock;
    ManoDeComodines manoComodines;
    @BeforeEach
    void setUp() {
        List<Carta> mano = List.of(
                new Carta(new Corazon(), 7, 7, 1),  // Par 1
                new Carta(new Pica(), 7, 7, 1),    // Par 1
                new Carta(new Diamante(), 5, 5, 1),// Par 2
                new Carta(new Trebol(), 5, 5, 1),  // Par 2
                new Carta(new Corazon(), 9, 9, 1), // Descarte
                new Carta(new Trebol(), 2, 2, 1),  // Descarte
                new Carta(new Diamante(), 11, 11, 1), // Descarte
                new Carta(new Pica(), 13, 10, 1)   // Descarte
        );

        generadorDeComodines = new FactoryComodines("src/main/resources/comodines.json");
        List<Comodin> comodines = generadorDeComodines.generarComodines();
        manoComodines.guardar(comodines.get(5));
        manoComodines.guardar(comodines.get(7));
        Mazo mazoMock = Mockito.mock(Mazo.class);
        Mockito.when(mazoMock.generarCartas()).thenReturn(mano);
    }

    @Test
    public void test01AunJugadorSeLeDaUnaManoYArmaUnaJugada(){
        Mano mano = new Mano(mazoMock, 3, manoComodines);

        Jugador jugador = new Jugador("pepe");
        jugador.asignarMano(mano);

        

    }
}
