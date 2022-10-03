package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CeldaGrafica extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon grafico;
	private String[] images;

	public CeldaGrafica() {
		this.images = new String[] {"MARIO.png", "/imagenes/A.jpg", "/imagenes/P.jpg"} ;;
		this.grafico = new ImageIcon(images[0]);
	}

	public ImageIcon getGrafico() {
		return this.grafico;
	}
	
	public void setGrafico(ImageIcon grafico) {
		this.grafico = grafico;
	}
	
	public String[] getImagenes() {
		return images;
	}
	
	public void setImagenes(String[] imagenes) {
		this.images = imagenes;
	}
}
