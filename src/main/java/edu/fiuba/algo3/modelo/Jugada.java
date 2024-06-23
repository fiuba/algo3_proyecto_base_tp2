package edu.fiuba.algo3.modelo;

public interface Jugada  {
    public void actualizarJugada(Pregunta pregunta);

    public void actualizarPuntos(int puntosNuevos);

    public void otorgarPuntos();

    public int getPuntaje();

    public PowerUp getPowerUp();

    public void seUsoPowerUp();

    public void registrarRespuesta(Respuestas respuestaJugador);

    public void registrarPowerUp(PowerUp powerUp);
}
