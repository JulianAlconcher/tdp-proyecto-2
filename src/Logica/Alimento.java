package Logica;

public abstract class Alimento extends Entidad {

	//Cargamos en el constructor su celda involucrada 
	protected int fila;
	protected int col;
	protected int puntaje;
	protected int tamanio;
	
//		public Alimento() {
//		fila=f;
//		col=c;
//	}

		public int getTamanio() {
			return tamanio;
		}

		public void setTamanio(int tamanio) {
			this.tamanio = tamanio;
		}

		public abstract void visit(Criatura criatura);

		public void accept(Visitor v) {
			v.visit(this);
		}
		
		public int getPuntaje() {
			return this.puntaje;
		}

		public abstract void visit(PowerUp powerUp) ;

		public abstract void visit(Alimento alimento);
		
		public abstract void visit(Pared pared) ;
		
		public abstract void visit(Fondo fondo); 





}
