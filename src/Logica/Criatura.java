package Logica;

public class Criatura {
	private Celda[] celdas;
	
	public Criatura() {
		setCeldas(new Celda[3]);
	}

	public Celda[] getCeldas() {
		return celdas;
	}

	public void setCeldas(Celda[] celdas) {
		this.celdas = celdas;
	}
	
}
