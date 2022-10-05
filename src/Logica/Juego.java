package Logica;

import java.io.IOException;

import GUI.Grilla;

public class Juego {
	private Grilla miGrilla;
	private int cantFilas;
	private int cantColumnas;
	@SuppressWarnings("unused")
	private Jugador miJugador;

	
	public Juego() {
		this.cantColumnas = 20;
		this.cantFilas = 20;
		this.miGrilla = new Grilla(cantFilas, cantColumnas);
		miGrilla.cargarMapa();
	}
	
	
	public int getCantFilas() {
		return this.cantFilas;
	}
	
	public int getCantColu() {
		return this.cantColumnas;
	}

	public Grilla getGrilla(){
		return miGrilla;
	}
	
}
