package Logica;

public class VisitorHandler implements Visitor{

	private boolean gameOver=false;
	private int puntaje = 0;
	
	@Override
	public void visit(Alimento alimento) {
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
		System.out.println("visitr de power UUUUUUUUUUPPPPP");
		
	}
	
	@Override
	public void visit(Criatura criatura) {
		gameOver = true;
		
	}

	public boolean getGameStatus() {
		return gameOver;
	}

	public void setGameStatus(boolean gameStatus) {
		this.gameOver = gameStatus;
	}

	@Override
	public void accept(Visitor v) {
		System.out.println("accept visitorHandler");
		
	}





	
}
