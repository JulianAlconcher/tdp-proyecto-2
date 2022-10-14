package Logica;

public abstract class Alimento extends Entidad {

	//Cargamos en el constructor su celda involucrada 
	protected int fila;
	protected int col;
	protected int puntaje;
	
//		public Alimento() {
//		fila=f;
//		col=c;
//	}

		public abstract void visit(Criatura criatura);

		public void accept(Visitor v) {
			v.visit(this);
		}
		
		public abstract int getPuntaje() ;

		public abstract void visit(PowerUp powerUp) ;

		public abstract void visit(Alimento alimento);
		
		public abstract void visit(Pared pared) ;
		
		public abstract void visit(Fondo fondo); 





}
