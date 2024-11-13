package edu.fiuba.algo3.entrega_1.Tarot;

import edu.fiuba.algo3.entrega_1.Modificable.Modificable;

public class Tarot {
        private int valor;

        public Tarot(int valor) {
            this.valor = valor;
        }
        public void aplicarA(Modificable modificable) {
            modificable.aplicarModificacion(valor);
        }
    }

