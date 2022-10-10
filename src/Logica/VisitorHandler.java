package Logica;

public class VisitorHandler implements Visitor{

	private boolean gameOver=false;
	private int puntaje = 0;
	private boolean visitoComida=false;
	
	@Override
	public void visit(Alimento alimento) {
		visitoComida=true;
		puntaje += 50;
		System.out.println("visit alimentoooooooooooooo");
		
	}

	@Override
	public void visit(Pared pared) {
		gameOver = true;
		System.out.println("visitr de PAREEEED");
		
	}
	
	@Override
	public void visit(PowerUp powerUp) {
		visitoComida=true;
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

	public boolean getVisitoComida() {
		return visitoComida;
	}
	
	public void setVisitoComida(boolean visito) {
		this.visitoComida=visito;
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






	
}
