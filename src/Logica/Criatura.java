package Logica;

public class Criatura{
	private Celda[] celdas;
	private Celda cabeza;
	private int direccion; // 1 arriba, 2 derecha, 3 abajo, 4 izquierda

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

	// 1 arriba, 2 derecha, 3 abajo, 4 izquierda
	public void avanzar(int d) {
		direccion = d;
		if ( d == 1 ) {
			int coorCabezaVieja = cabeza.getCoordFila();
			cabeza.setCoordFila(cabeza.getCoordFila()-1);
				for (int i = 1; i < celdas.length; i++) {
					celdas[i].setCoords(coorCabezaVieja-i+1,cabeza.getCoordColu());
			}
		}
		else if ( d == 2 ) {
			int coorCabezaVieja = cabeza.getCoordColu();
			cabeza.setCoordColu(cabeza.getCoordColu()+1);
				for (int i = 1; i < celdas.length; i++) {
					celdas[i].setCoords(coorCabezaVieja+i-1, cabeza.getCoordFila());
			}
		}
		else if ( d == 3 ) {
			int coorCabezaVieja = cabeza.getCoordFila();
			cabeza.setCoordFila(cabeza.getCoordFila()-1);
				for (int i = 1; i < celdas.length; i++) {
					celdas[i].setCoords(celdas[coorCabezaVieja+i-1].getCoordFila(), celdas[cabeza.getCoordColu()].getCoordColu());
			}
		}
		else if ( d == 4 ) {
			int coorCabezaVieja = cabeza.getCoordColu();
			cabeza.setCoordColu(cabeza.getCoordColu()-1);
				for (int i = 1; i < celdas.length; i++) {
					celdas[i].setCoords(celdas[coorCabezaVieja+i-1].getCoordFila(), celdas[cabeza.getCoordFila()].getCoordColu());
			}
		}
	}

	public void moverIzquierda() {

	}

	public void moverDerecha() {

	}
}
