package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CeldaGrafica extends JLabel{
	
	
	private static final long serialVersionUID = 1L;
	private ImageIcon grafico;
	private String imagen;


	public CeldaGrafica() {
		
		this.imagen = "";
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
	
}
