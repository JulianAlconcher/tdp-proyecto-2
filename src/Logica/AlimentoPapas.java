package Logica;

public class AlimentoPapas extends Alimento {

	
	public AlimentoPapas(int f,int c) {
		this.col=c;
		this.fila=f;
		this.puntaje=30;
		this.grafico=4;
		tamanio = 5;
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
