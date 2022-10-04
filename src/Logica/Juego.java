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
		try {
			miGrilla.cargarTablero("C:\\Users\\FRAVEGA\\Downloads\\Documents\\TDP\\tdp-proyecto-2\\src\\Nivel1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
