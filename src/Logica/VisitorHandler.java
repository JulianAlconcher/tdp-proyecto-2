package Logica;

public class VisitorHandler implements Visitor{

	private boolean gameOver=false;
	private int puntaje = 0;
	private boolean visitoComestible=false;
	private boolean visitoPowerUp=false;
	private int color;

	
	@Override
	public void visit(Alimento alimento) {
		visitoComestible=true;
		puntaje += alimento.getPuntaje();
		System.out.println("visit alimentoooooooooooooo");
		
	}

	@Override
	public void visit(Pared pared) {
		gameOver = true;
		System.out.println("visitr de PAREEEED");
		
	}
	
	@Override
	public void visit(PowerUp powerUp) {
		visitoComestible=true;
		setVisitoPowerUp(true);
		setColor(powerUp.getPower());
		puntaje+=80;
		System.out.println("visitr de power UUUUUUUUUUPPPPP");
	}
	
	@Override
	public void visit(Criatura criatura) {
		gameOver = true;
		System.out.println("visite de CRIATURA");
		
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
		System.out.println("accept visitorHandler");
		
	}

	@Override
	public void visit(Fondo fondo) {
		// TODO Auto-generated method stub
		System.out.println("visist fondo");
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






	
}
