package Logica;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Jugador implements Comparable<Jugador>,Serializable {

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

	@Override
	public int compareTo(Jugador o) {
		Integer puntajeLocal = puntaje;
		return puntajeLocal.compareTo(o.getPuntaje());
	}
}
