package Logica;

public abstract class Entidad implements Visitor{
		
    protected int grafico;
    
	public  void visit (Visitor visitor) {
	}
	
	public int getGrafico() {
		return grafico;
	}
	
	public abstract void accept(Visitor v);

}
