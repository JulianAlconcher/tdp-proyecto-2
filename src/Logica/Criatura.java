package Logica;

import java.util.LinkedList;

public class Criatura extends Entidad{
	private LinkedList<Celda>celdas;
	private Celda cabeza;
	private int direccion;
	

	public Criatura(int i, int j) {
		celdas = new LinkedList<Celda>();
		cabeza = new Celda(i,j);
		celdas.addFirst(cabeza);
		celdas.add(new Celda(i+1,j));
		celdas.add(new Celda(i+2,j));
	}

	
	public int getTamanio() {
		return celdas.size();
	}

//	public void setCeldas(Celda[] celdas) {
//		this.celdas = celdas;
//	}
	
//	public Celda getCeldaParticular(int p) {
//		return celdas[p];
//	}

	public Celda getCabeza() {
		return cabeza;
	}
	
	
	public void setCabeza(Celda cabeza) {
		celdas.addFirst(cabeza);
	}

	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	//Para mover criatura cola pasa a ser cabeza.
	
//	public void avanzar(int d) {
//		direccion = d;
//		int i = 0;
//		if (d == 1 ) {
//			for(Celda c : celdas) {
//				
//			}
//		}
//	}
	
	public void avanzar(Celda proxCel) {
		Celda cola = celdas.removeLast();
		cola.setEntidad(new Fondo());
		cabeza = proxCel;
		//proxCel.setEntidad(new Criatura());
		celdas.addFirst(proxCel);
	}
//	 public void move(Cell nextCell) {
//	        Cell tail = snake.removeLast();
//	        tail.setCelltype("Empty");
//	        this.head = nextCell;
//	        nextCell.setCelltype("Snake");
//	        snake.addFirst(nextCell);
//
//	    }
	
	
	public LinkedList<Celda> getLista(){
		return celdas;
	}
	
	
	
	
	// 1 arriba, 2 derecha, -1 abajo, 4 izquierda
//	public void avanzar(int d) {
//		direccion = d;
//		if ( d == 1 ) {
//			int coorCabezaVieja = cabeza.getCoordFila();
//			cabeza.setCoordFila(cabeza.getCoordFila()-1);
//				for (int i = 1; i < celdas.length; i++) {
//					celdas[i].setCoords(coorCabezaVieja-i+1,cabeza.getCoordColu());
//					
//			}
//		}
//		else if ( d == -1 ) {
//			int coorCabezaVieja = cabeza.getCoordFila();
//			cabeza.setCoordFila(cabeza.getCoordFila()+1);
//				for (int i = 1; i < celdas.length; i++) {
//					celdas[i].setCoords(coorCabezaVieja+i-1,cabeza.getCoordColu());
//					celdas[i] = celdas[i-1];
//			}
//		}
//	}
//
//	public void moverDerecha() {
//		int coorCabezaVieja = cabeza.getCoordColu();
//		cabeza.setCoordColu(cabeza.getCoordColu()+1);
//			for (int i = 1; i < celdas.length; i++) {
//				celdas[i].setCoords(cabeza.getCoordFila(),coorCabezaVieja+i-1);
//		}
//	}
	
	
//
//	public void moverIzquierda() {
//		int coorCabezaVieja = cabeza.getCoordColu();
//		cabeza.setCoordColu(cabeza.getCoordColu()-1);
//			for (int i = 1; i < celdas.length; i++) {
//				celdas[i].setCoords(cabeza.getCoordFila(),coorCabezaVieja-i+1);
//		}
//	}

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
		System.out.println("visitor criatura");
		
	}

	@Override
	public void visit(Fondo fondo) {
		// TODO Auto-generated method stub
		
	}
}
