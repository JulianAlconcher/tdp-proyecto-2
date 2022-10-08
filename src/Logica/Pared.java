package Logica;

public class Pared extends Entidad{

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
	public void visit(Criatura criatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}

	




}
