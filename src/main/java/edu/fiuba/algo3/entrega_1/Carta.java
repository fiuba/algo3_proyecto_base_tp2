package edu.fiuba.algo3.entrega_1;

    public class Carta implements Modificable {
        private int valor;

        public Carta(int valor) {
            this.valor = valor;
        }

        @Override
        public void aplicarModificacion(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }

    }
