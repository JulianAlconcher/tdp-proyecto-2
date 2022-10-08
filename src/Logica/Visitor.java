package Logica;

public interface Visitor {

	public void visit(PowerUp powerUp);

	public void visit(Alimento alimento);

	public void visit(Pared pared);
	
	public void visit(Criatura criatura);
	
	public void visit(Fondo fondo);
	
	public void accept(Visitor v);
	

	

}
