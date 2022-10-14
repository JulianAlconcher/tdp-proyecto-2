package Logica;

public abstract class PowerUp extends Entidad{

     int fila;
     int col;
     int power;
     int puntaje;
	
//	public PowerUp(int f, int c) {
//		fila=f;
//		col=c;
//		grafico=3;
//		// TODO Auto-generated constructor stub
//	}

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

	@Override
	public void visit(Pared pared) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Fondo fondo) {
		// TODO Auto-generated method stub
		
	}





	
}
