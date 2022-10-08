package Logica;

public class Pared extends Entidad{

	public void visit(MyVisitor visitor) {
		visitor.visit(this);
		
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
	
}
