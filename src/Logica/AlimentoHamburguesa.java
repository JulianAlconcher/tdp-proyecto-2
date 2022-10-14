package Logica;

public class AlimentoHamburguesa extends Alimento {

	
	public AlimentoHamburguesa(int f,int c) {
		this.col=c;
		this.fila=f;
		this.puntaje=60;
		this.grafico=3;
		tamanio = 4;
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
