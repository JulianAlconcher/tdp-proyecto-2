package Logica;

public abstract class Entidad implements Visitor{
	
	public  void visit (Visitor visitor) {
	}
	
	public abstract void accept(Visitor v);

}
