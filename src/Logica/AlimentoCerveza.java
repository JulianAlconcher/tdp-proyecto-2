package Logica;

public class AlimentoCerveza extends Alimento {

	
	public AlimentoCerveza(int f,int c) {
		this.col=c;
		this.fila=f;
		this.puntaje=25;
		this.grafico=6;
		tamanio = 2;
	}
	
	@Override
	public void visit(Criatura criatura) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visit(PowerUp powerUp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Alimento alimento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Pared pared) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Fondo fondo) {
		// TODO Auto-generated method stub
		
	}

}
