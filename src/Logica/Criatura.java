package Logica;

import java.util.LinkedList;

public class Criatura extends Entidad{
	private LinkedList<Celda>celdas;
	private Celda cabeza;
	private int direccion;
	private Celda cola;
	private int color;
	
	

	public Criatura(int i, int j) {
		celdas = new LinkedList<Celda>();
		cabeza = new Celda(i,j);
		celdas.addFirst(cabeza);
		celdas.add(new Celda(i+1,j));
		celdas.add(new Celda(i+2,j));	
		cola = celdas.getLast();
		color=10;
	}

	public Celda getCola() {
		return cola;
	}
	
	public void aumentarCola(int i, int j,int cant) {
		Celda aumenta=new Celda(i,j);
		celdas.add(aumenta);
		cola=aumenta;
	}
	
	public int getTamanio() {
		return celdas.size();
	}

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

	//Para mover criatura cola pasa a ser cabeza. Devuelve ultima Celda de la Snake
	
	public void avanzar(Celda proxCel) {
		cola = celdas.removeLast();
		cola.setEntidad(new Fondo());
		cabeza = proxCel;
		proxCel.setEntidad(new Criatura(proxCel.getCoordFila(),proxCel.getCoordColu()));
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

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}
