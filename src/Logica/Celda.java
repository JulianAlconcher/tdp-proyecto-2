package Logica;

public class Celda {
	private Integer coordFila;
	private Integer coordColu;
	private Entidad entidad;
	private CeldaGrafica celdaGrafica;
	private boolean comestible; 

	public Celda(int fila, int columna) {
		this.coordFila = fila;
		this.coordColu = columna;
		this.entidad = null;
		this.celdaGrafica = new CeldaGrafica();
		this.comestible = true;
	}

	public void setCoordFila(Integer v) {
		this.coordFila = v;
	}
	
	public void setCoordColu(Integer v) {
		this.coordColu = v;
	}
	
	public void setCoords(int i, int j) {
		this.coordFila = i;
		this.coordColu = j;
	}
	
	public int getCoordFila() {
		return this.coordFila;
	}
	
	public int getCoordColu() {
		return this.coordColu;
	}
	
	public boolean getComestible() {
		return this.comestible;
	}
	
	public void setComestible(boolean c) {
		this.comestible  = c;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public void setCelda(Integer fila,Integer colu, CeldaGrafica imag) {

	}

	public CeldaGrafica getCeldaGrafica() {
		return celdaGrafica;
	}

	public void setCeldaGrafica(CeldaGrafica entidadGrafica) {
		this.celdaGrafica = entidadGrafica;
	}

	

	
}