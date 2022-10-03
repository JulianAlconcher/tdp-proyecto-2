package Logica;

public class Celda {
	private Integer coordFila;
	private Integer coordColu;
	private Entidad entidad;
	private CeldaGrafica entidadGrafica;
	private Integer estado;

	public Celda(int fila, int columna) {
		this.coordFila = fila;
		this.coordColu = columna;
		this.entidad = new Entidad();
		this.entidadGrafica = new CeldaGrafica(entidad);
		this.estado = null;
	}

	public void setCoordFila(Integer v) {
		this.coordFila = v;
	}
	
	public void setCoordColu(Integer v) {
		this.coordColu = v;
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

	public CeldaGrafica getEntidadGrafica() {
		return entidadGrafica;
	}

	public void setEntidadGrafica(CeldaGrafica entidadGrafica) {
		this.entidadGrafica = entidadGrafica;
	}
}