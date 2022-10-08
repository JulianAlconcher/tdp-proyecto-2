package Logica;

public abstract class Entidad implements Visitor{

	public Visitor myVisitor;
	
	public void visit (Visitor visitor) {
		
	}
	
	public abstract void accept(Visitor v);

}
