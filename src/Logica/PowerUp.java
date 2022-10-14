package Logica;

public abstract class PowerUp extends Entidad{

     protected int fila;
     protected int col;
     protected int power;
     protected int puntaje;
     protected final int tamanio=3;
	
	public int getTamanio() {
		return tamanio;
	}

	public int getPower() {
		return power;
	}
	
	@Override
	public void visit(Criatura criatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}

	@Override
	public void visit(PowerUp powerUp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Alimento alimento) {
		// TODO Auto-generated method stub
		
	}

	public int getPuntaje() {
		return this.puntaje;
	}
	@Override
	public void visit(Pared pared) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Fondo fondo) {
		// TODO Auto-generated method stub
		
	}





	
}
