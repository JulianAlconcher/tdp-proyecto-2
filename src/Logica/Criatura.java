package Logica;

public class Criatura{
	private Celda[] celdas;
	private Celda cabeza;
	private int direccion; // 1 arriba, 2 derecha, 3 abajo, 4 izquierda

	public Criatura() {
		cabeza = new Celda(10,10);
		celdas = new Celda[10];
		celdas[0] = cabeza;
	}

	public Celda[] getCeldas() {
		return celdas;
	}

	public void setCeldas(Celda[] celdas) {
		this.celdas = celdas;
	}

	public Celda getCabeza() {
		return cabeza;
	}

	public void setCabeza(Celda cabeza) {
		this.cabeza = cabeza;
		celdas[0] = cabeza;
	}


	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}


	public void avanzar() {
		if ( direccion == 1 ) {
			cabeza.setCoordFila(cabeza.getCoordFila()+1);
			if( celdas.length > 1 ) {
				for (int i = 1; i < celdas.length; i++) {
					celdas[i].setCoords(celdas[i-1].getCoordFila(), celdas[i-1].getCoordColu());
				}
			}
		}
		else if ( direccion == 2 ) {
			cabeza.setCoordColu(cabeza.getCoordColu()+1);
			if( celdas.length > 1 ) {
				for (int i = 1; i < celdas.length; i++) {
					celdas[i].setCoords(celdas[i-1].getCoordFila(), celdas[i-1].getCoordColu());
				}
			}
		}
		else if ( direccion == 3 ) {
			cabeza.setCoordFila(cabeza.getCoordFila()-1);
			if( celdas.length > 1 ) {
				for (int i = 1; i < celdas.length; i++) {
					celdas[i].setCoords(celdas[i-1].getCoordFila(), celdas[i-1].getCoordColu());
				}
			}
		}
		else if ( direccion == 4 ) {
			cabeza.setCoordColu(cabeza.getCoordColu()-1);
			if( celdas.length > 1 ) {
				for (int i = 1; i < celdas.length; i++) {
					celdas[i].setCoords(celdas[i-1].getCoordFila(), celdas[i-1].getCoordColu());
				}
			}
		}
	}

	public void moverIzquierda() {

	}

	public void moverDerecha() {

	}
}
