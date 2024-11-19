package edu.fiuba.algo3.entrega_1.Tarot;

import edu.fiuba.algo3.entrega_1.Modificable.Modificable;
import edu.fiuba.algo3.entrega_1.Puntaje.Puntaje;

public class Tarot {
        private Puntaje puntaje;

        public Tarot(int valor, int multiplicador) {
            this.puntaje = new Puntaje(valor, multiplicador);
        }
        public void aplicarA(Modificable modificable) {
            modificable.aplicarModificacion(this.puntaje);
        }
    }

