package Logica;

public class Alimento extends Entidad {



	
	@Override
	public void visit(Criatura criatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}

	public int getPuntaje() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void visit(PowerUp powerUp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Alimento alimento) {
		System.out.println("visist alimento");
	}

	@Override
	public void visit(Pared pared) {
		// TODO Auto-generated method stub
		
	}





}
