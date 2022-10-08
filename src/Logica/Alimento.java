package Logica;

public class Alimento implements Entidad {

	@Override
	public void visit(MyVisitor visitor) {
		visitor.visit(this);
		
	}

}
