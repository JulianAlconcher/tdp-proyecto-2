package Logica;

public class PowerUp implements Entidad{

	@Override
	public void visit(MyVisitor visitor) {
		visitor.visit(this);
		
	}

	
}
