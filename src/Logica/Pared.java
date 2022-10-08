package Logica;

public class Pared implements Entidad{

	@Override
	public void visit(MyVisitor visitor) {
		visitor.visit(this);
		
	}
	
}
