package Logica;

public class Celda {
	private Integer coordFila;
	private Integer coordColu;
	private Entidad entidad;
	private CeldaGrafica celdaGrafica;
	private Integer estado; //0 comible //1 no comible

	public Celda(int fila, int columna) {
		this.coordFila = fila;
		this.coordColu = columna;
		this.entidad = new Entidad();
		this.celdaGrafica = new CeldaGrafica();
		this.estado = null;
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
	
	public Integer getCoordFila() {
		return this.coordFila;
	}
	
	public Integer getCoordColu() {
		return this.coordColu;
	}
	
	public Integer getEstado() {
		return this.estado;
	}
	
	public void setEstado(Integer v) {
		this.estado  = v;
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