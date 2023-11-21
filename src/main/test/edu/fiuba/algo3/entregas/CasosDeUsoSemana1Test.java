package edu.fiuba.algo3.entregas;

import edu.fiuba.algo3.modelo.seniorities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipamientos.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoSemana1Test {
    @Test
    public void test01SeInicializaUnJugadorConLaEnergiaYElEquipamientoCorrecto() {

        int energiaInicial = 20;
        int energiaLuegoDeSerAtacado = 0;
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        Fiera fiera = new Fiera();

        // sigue arrange act y assert. A que costo ? je
        boolean jugadorAlCrearseTieneEnergiaInicial = jugador.energiaIgualA(energiaInicial);

        //Probamos el comportamiento de un Gladiador desequipado (asi se debe instanciar).
        fiera.afectar(jugador);

        Assertions.assertTrue(jugadorAlCrearseTieneEnergiaInicial);
        Assertions.assertTrue(jugador.energiaIgualA(energiaLuegoDeSerAtacado));
    }

    @Test
    public void test02JugadorSaleCorrectamenteDeLaCasillaInicial(){
        // REVISAR. EL MAPA DEBE MATRIZ

        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        int casillaInicial = 0;

        jugador.jugarTurno();

        Assertions.assertFalse(jugador.estaEnCasilla(casillaInicial));
    }

    @Test
    public void test03UnJugadorSinEnergiaPierdeElTurno(){
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        Afectante fiera = new Fiera();
        int casillaInicial = 0;  // TENEMOS QUE CAMBIAR POR COORDENADAS.
        int cantidadTurnosEsperado = 1;

        fiera.afectar(jugador);

        // Verificar que no pueda tirar el dado, y que turnos++.
        jugador.jugarTurno();

        Assertions.assertTrue(jugador.estaEnCasilla(casillaInicial));
        Assertions.assertTrue(jugador.tieneTurnosIgualA(cantidadTurnosEsperado));
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
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        Afectante mejorador = new MejorarEquipamiento();
        Fiera fiera = new Fiera();
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial - 15;

        mejorador.afectar(jugador);  // El jugador obtiene un casco.
        fiera.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test06AlRecibirUnPremioPorTerceraVezObtieneEscudoYEspada() {

        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        Afectante mejorador = new MejorarEquipamiento();
        Fiera fiera = new Fiera();
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial - 2;

        // El jugador obtiene un Escudo Y Espada.
        for (int i = 0; i < 3; i++) {
            mejorador.afectar(jugador);
        }

        fiera.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test07AlHaberUnCombateConFieraSiTieneCascoPierdeQuincePuntosDeEnergia() {
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        Afectante mejorador = new MejorarEquipamiento();
        Fiera fiera = new Fiera();
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial - 15;

        mejorador.afectar(jugador);  // El jugador obtiene un casco.
        fiera.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test08AlPasarOchoTurnosElGladiadorPasaDeNovatoASemiSenior() {
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        int energiaInicial = 20;
        int energiaEsperada= 25;
        for(int i = 0; i < 8; i++){
            jugador.jugarTurno();
        }
        // turnos =8 --> juagador pasa a SemiSenior

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test09AlLlegarAlaMetaSinLaLlaveRetrocedeAlaMitadDeLasCasillas() {
        //PREGUNTAR. Hay que hacer la logica de ganar.
    }

    @Test
    public void test10AlSerAtacadoPorUnaFieraYConTodoElEquipamientoNoPierdeEnergia() {
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        Afectante mejorador = new MejorarEquipamiento();
        Fiera fiera = new Fiera();
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial;

        // El jugador obtiene la llave
        for (int i = 0; i < 4; i++) {
            mejorador.afectar(jugador);
        }

        fiera.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test11AlTenerLaLlaveYrecibirOtroPremioNoCambiaNada() {
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);
        Afectante mejorador = new MejorarEquipamiento();
        Fiera fiera = new Fiera();
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial;

        // El jugador obtiene la llave
        for (int i = 0; i < 4; i++) {
            mejorador.afectar(jugador);
        }

        mejorador.afectar(jugador); //No recibe nada

        fiera.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test12AlPasarTreintaTurnosYnadieLlegaAlaMetaSeTerminoElJuego() {
        // Logica de ganar.
    }
}
