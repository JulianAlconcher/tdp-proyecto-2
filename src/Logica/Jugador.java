package Logica;

import java.io.Serializable;

public class Jugador implements Serializable {

	private int puntaje;
	private String nombre;
	
	public Jugador(String n) {
		puntaje = 0;
		nombre = n;
	}
	
	public void aumentarPuntaje(int p) {
		puntaje+=p;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
}
