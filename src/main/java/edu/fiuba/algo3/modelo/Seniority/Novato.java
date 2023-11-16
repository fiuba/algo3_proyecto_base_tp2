package edu.fiuba.algo3.modelo.Seniority;

public class Novato implements Seniority {
    public Seniority ascender(int turno) {
        if (turno == 8) {
            return new SemiSenior();
        }
        return this;
    }
}
