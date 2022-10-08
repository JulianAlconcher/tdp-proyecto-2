package Logica;

public class Criatura extends Entidad{
	private Celda[] celdas;
	private Celda cabeza;
	private int direccion;

	public Criatura() {
		cabeza = new Celda(8,8);
		celdas = new Celda[3];
		celdas[0] = cabeza;
		celdas[1] = new Celda(cabeza.getCoordFila()+1,cabeza.getCoordColu());
		celdas[2] = new Celda(cabeza.getCoordFila()+2,cabeza.getCoordColu());
	}

	public Celda[] getCeldas() {
		return celdas;
	}
	public int getTamanio() {
		return celdas.length;
	}

	public void setCeldas(Celda[] celdas) {
		this.celdas = celdas;
	}
	
	public Celda getCeldaParticular(int p) {
		return celdas[p];
	}

	public Celda getCabeza() {
		return cabeza;
	}

	public void setCabeza(Celda cabeza) {
		this.cabeza = cabeza;
		celdas[0] = cabeza;
	}

	public Celda getCola() {
		return celdas[celdas.length-1];
	}
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	// 1 arriba, 2 derecha, -1 abajo, 4 izquierda
	public void avanzar(int d) {
		direccion = d;
		if ( d == 1 ) {
			int coorCabezaVieja = cabeza.getCoordFila();
			cabeza.setCoordFila(cabeza.getCoordFila()-1);
				for (int i = 1; i < celdas.length; i++) {
					celdas[i].setCoords(coorCabezaVieja-i+1,cabeza.getCoordColu());
					
			}
		}
		else if ( d == -1 ) {
			int coorCabezaVieja = cabeza.getCoordFila();
			cabeza.setCoordFila(cabeza.getCoordFila()+1);
				for (int i = 1; i < celdas.length; i++) {
					celdas[i].setCoords(coorCabezaVieja+i-1,cabeza.getCoordColu());
					celdas[i] = celdas[i-1];
			}
		}
	}

	public void moverDerecha() {
		int coorCabezaVieja = cabeza.getCoordColu();
		cabeza.setCoordColu(cabeza.getCoordColu()+1);
			for (int i = 1; i < celdas.length; i++) {
				celdas[i].setCoords(cabeza.getCoordFila(),coorCabezaVieja+i-1);
		}
	}

	public void moverIzquierda() {
		int coorCabezaVieja = cabeza.getCoordColu();
		cabeza.setCoordColu(cabeza.getCoordColu()-1);
			for (int i = 1; i < celdas.length; i++) {
				celdas[i].setCoords(cabeza.getCoordFila(),coorCabezaVieja-i+1);
		}
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
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
	public void visit(Criatura criatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Fondo fondo) {
		// TODO Auto-generated method stub
		
	}
}
