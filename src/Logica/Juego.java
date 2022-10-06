package Logica;

import GUI.Grilla;

public class Juego {
	private Grilla miGrilla;
	private int cantFilas;
	private int cantColumnas;
	private Jugador miJugador;
	private boolean gameOver=false;
	

	
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
	
	public void mover(int d) {
		int filaCabeza = miGrilla.getCriatura().getCabeza().getCoordFila();
		int coluCabeza = miGrilla.getCriatura().getCabeza().getCoordColu();
			if(d == 1) { 
				if(miGrilla.getCelda(filaCabeza-1, coluCabeza).getComestible()) {
					miGrilla.getCriatura().avanzar(1);
				}
				else {
					System.out.println("Entre al GAME OVER");
					gameOver();}
			}
			else if(d==-1) {
				if(miGrilla.getCelda(filaCabeza+1, coluCabeza).getComestible()) {
					miGrilla.getCriatura().avanzar(-1);
					}
				else {
					System.out.println("Entre al GAME OVER");
					gameOver();}}
			else if(d==2) {
				if(miGrilla.getCelda(filaCabeza, coluCabeza+1).getComestible()) {
					miGrilla.getCriatura().moverDerecha();
					}
				else {
					System.out.println("Entre al GAME OVER");
					gameOver();}}
			else if(d==-2) {
				if(miGrilla.getCelda(filaCabeza, coluCabeza-1).getComestible()) {
					miGrilla.getCriatura().moverIzquierda();
					}
				else {
					System.out.println("Entre al GAME OVER");
					gameOver();}}
			
				
		}
	
	public void gameOver() {
		gameOver = true;
	}
	
	public boolean getGameStatus() {
		return gameOver;
	}
}
