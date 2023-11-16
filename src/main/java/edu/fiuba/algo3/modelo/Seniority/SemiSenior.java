package edu.fiuba.algo3.modelo.Seniority;

public class SemiSenior implements Seniority {
    public Seniority ascender(int turno) {
        if (turno == 12) {
            return new Senior();
        }
        return this;
    }
}
