package edu.fiuba.algo3.entregas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipamientos.Desequipado;
import edu.fiuba.algo3.modelo.afectantes.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoSemana1Test {
    @Test
    public void test01SeInicializaUnJugadorConLaEnergiaYElEquipamientoCorrecto() {
        int energiaInicial = 20;
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaInicial));
        Assertions.assertTrue(jugador.equipamientoGladiador() instanceof Desequipado); // Double dispatch ¿?
        //Chequear si es Novato ??
    }

    @Test
    public void test02JugadorSaleCorrectamenteDeLaCasillaInicial(){
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        int casillaEsperada = 1;

        jugador.avanzar();

        Assertions.assertEquals(casillaEsperada, jugador.getCasillaActual());
    }

    @Test
    public void test03UnJugadorSinEnergiaPierdeElTurno(){
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        Afectante fiera = new Fiera();
        int casillaInicial = 0;

        fiera.afectar(jugador);
        jugador.avanzar();

        Assertions.assertEquals(casillaInicial, jugador.getCasillaActual());
    }

    @Test
    public void test04AlRecibirComidaSuEnergiaIncrementaEnQuince() {
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        Afectante comida = new Comida();
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial + 15;

        comida.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test05AlRecibirUnPremioPorPrimeraVezRecibeUnCasco() {

    }

    @Test
    public void test06AlRecibirUnPremioPorTerceraVezObtieneEscudoYEspada() {
    }


    @Test
    public void test07AlHaberUnCombateConFieraSiTieneCascoPierdeQuincePuntosDeEnergia() {
    }

    @Test
    public void test08AlPasarOchoTurnosElGladiadorPasaDeNovatoAsemiSenior() {
    }

    @Test
    public void test09AlLlegarAlaMetaSinLaLlaveRetrocedeAlaMitadDeLasCasillas() {
    }

    @Test
    public void test10AlSerAtacadoPorUnaFieraYconTodoElEquipamientoNoPierdeEnergia() {
    }

    @Test
    public void test11AlTenerLaLlaveYrecibirOtroPremioNoCambiaNada() {
    }

    @Test
    public void test12AlPasarTreintaTurnosYnadieLlegaAlaMetaSeTerminoElJuego() {
    }
}
