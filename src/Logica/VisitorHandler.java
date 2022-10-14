package Logica;

public class VisitorHandler implements Visitor{

	private boolean gameOver=false;
	private int puntaje = 0;
	private boolean visitoComestible=false;
	private boolean visitoPowerUp=false;
	private int color;
	private int tamanio;

	
	@Override
	public void visit(Alimento alimento) {
		visitoComestible=true;
		puntaje += alimento.getPuntaje();
		setTamanio(alimento.getTamanio());
		
	}

	@Override
	public void visit(Pared pared) {
		gameOver = true;
		
	}
	
	@Override
	public void visit(PowerUp powerUp) {
		visitoComestible=true;
		setVisitoPowerUp(true);
		setColor(powerUp.getPower());
		puntaje+=powerUp.getPuntaje();
		setTamanio(powerUp.getTamanio());
	}
	
	@Override
	public void visit(Criatura criatura) {
		gameOver = true;
		
	}

	/**
	 * Devuelve el estado del juego.
	 * True si perdio
	 * @return
	 */
	public boolean getGameStatus() {
		return gameOver;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int p) {
		this.puntaje=p;
	}
	
	public void sumarPuntaje(int p) {
		this.puntaje+=p;
	}
	
	public void setGameStatus(boolean gameStatus) {
		this.gameOver = gameStatus;
	}

	
	public boolean getVisitoComestible() {
		return visitoComestible;
	}
	
	public void setVisitoComestible(boolean visito) {
		this.visitoComestible=visito;
	}
	
	@Override
	public void accept(Visitor v) {
		
	}

	@Override
	public void visit(Fondo fondo) {
		// TODO Auto-generated method stub
	}

	public boolean getVisitoPowerUp() {
		return visitoPowerUp;
	}

	public void setVisitoPowerUp(boolean visitoPowerUp) {
		this.visitoPowerUp = visitoPowerUp;
	}
	

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}






	
}
