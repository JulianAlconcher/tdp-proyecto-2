package Logica;

public abstract class Alimento extends Entidad {


	protected int puntaje;
	protected int tamanio;
	

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

		public void visit(PowerUp powerUp) {
		
		}

		public void visit(Alimento alimento) {
			
		}
		
		public void visit(Pared pared) {
			
		}
		
		public void visit(Fondo fondo) {
			
		}





}
