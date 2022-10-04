package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CeldaGrafica extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon grafico;
	private String imagen;
	private Entidad entidad;
	private Pared pared;

	public CeldaGrafica(Entidad e) {
		
		this.imagen = "/imagenes/F.jpg";
		this.grafico = new ImageIcon(this.getClass().getResource(imagen));
	}

	public ImageIcon getGrafico() {
		return this.grafico;
	}
	
	public void setGrafico(ImageIcon grafico) {
		this.grafico = grafico;
	}
	
	public String getNombreImagen() {
		return imagen;
	}
	
	public void setNombreImagen(String nombreImagen) {
		this.imagen = nombreImagen;
	}
	
	public void setEntidad(Entidad e) {
		this.entidad = e;
	}
}
