package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.entrega_1.ManoDePoker.CartaMasAlta;
import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;
import edu.fiuba.algo3.entrega_2.comodin.ActivacionProbabilidad;
import edu.fiuba.algo3.entrega_2.comodin.Comodin;
import edu.fiuba.algo3.entrega_2.Factory.FactoryDeMaso;
import edu.fiuba.algo3.entrega_2.comodin.Activacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.entrega_1.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.entrega_1.ManoDePoker.Par;
import edu.fiuba.algo3.entrega_2.comodin.ActivacionSiempre;
import edu.fiuba.algo3.entrega_2.comodin.ActivacionManoDePoker;
import java.util.ArrayList;
import java.util.List;

public class comodinTest {
    @Test

    // Verificar que al tener un comodín que sume 8 al multiplicador se aplique correctamente
    public void testComodinAplicaMultiplicadorCorrectamente() {
        List<Activacion> activaciones = new ArrayList<>();
        activaciones.add(new ActivacionSiempre());
        Comodin comodin = new Comodin("Comodín Multiplicador", "Suma 8 al multiplicador", 0, 8, activaciones);

        ManoDePoker cartaAlta = new CartaMasAlta(); // valor: 5 multiplicador:8
        Puntaje puntajeFinal = comodin.aplicarA(cartaAlta);
        Assertions.assertEquals(9, puntajeFinal.getMultiplicador());
    }


    @Test

    //Verificar que el jugador recibe un aumento correspondiente si tiene el comodín que aumenta el multiplicador por 3 si juega una escalera
    public void testComodinAplicaAumentoPorManoDePoker() {
        ManoDePoker par = new Par();
        List<Activacion> activaciones = new ArrayList<>();
        activaciones.add(new ActivacionManoDePoker(par));

        Comodin comodin = new Comodin("Comodín Multiplicador", "Suma 3 al multiplicador por Escalera", 0, 3,activaciones );

        ManoDePoker manoJugada = new Par(); // (10,2) -- 2 + 3 :  5 --> 10 * 5
        Puntaje puntajeFinal = comodin.aplicarA(manoJugada);
        Assertions.assertEquals(5, puntajeFinal.getMultiplicador());
    }


    //Verificar que el jugador si posee un comodin que suma 10 puntos por descarte, al descartar sume la cantidad correcta.

    @Test

    //Verificar que si el jugador posee un comodin que tiene chance 1 sobre 1000 de romperse se rompa correctamente.
    public void testComodinProbabilidadSeRompe() {
        List<Activacion> activaciones = new ArrayList<>();
        activaciones.add(new ActivacionProbabilidad(1000));

        Comodin comodin = new Comodin("Comodín Multiplicador", "Suma 3 al multiplicador por Escalera", 0, 3,activaciones );
        ManoDePoker manoJugada = new Par();

        Puntaje puntaje = manoJugada.calcularPuntaje();
        Puntaje puntajeFinal = comodin.aplicarA(manoJugada);

        Assertions.assertEquals(puntaje.calcularPuntaje(), puntajeFinal.calcularPuntaje());
    }

    @Test
    // El jugador activa un comodín con una combinación de efectos
    // bonus de mano jugada + puntaje aumentado + activación aleatoria
    //"descripcion": "x15  Mult. 1 en 6 de probabilidad y +100  fichas si la mano jugada contiene un trio",
    public void testComodinCombinacionesDeEfectos() {
        ManoDePoker par = new Par();
        List<Activacion> activaciones = new ArrayList<>();
        activaciones.add(new ActivacionProbabilidad(1));
        activaciones.add(new ActivacionManoDePoker(par));
        Comodin comodin = new Comodin("Comodín Combinado", "x15  Mult. 1 en 6 de probabilidad y +100  fichas si la mano jugada contiene un trio", 100, 15,activaciones );
        ManoDePoker manoJugada = new Par(); // (10,2) -

        Puntaje puntaje = manoJugada.calcularPuntaje();
        Puntaje puntajeFinal = comodin.aplicarA(manoJugada);
        // 100 +10 * 2 + 15
        Assertions.assertEquals(1870, puntajeFinal.calcularPuntaje());
    }

}
