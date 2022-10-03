package Logica;

import javax.swing.ImageIcon;

public class CeldaGrafica {
	private ImageIcon grafico;
	private String[] images;

	public CeldaGrafica(Entidad e) {
		this.images = new String[] {"/imagenes/#.png", "/imagenes/A.jpg", "/imagenes/P.jpg"} ;;
		this.grafico = new ImageIcon(images[e.getPosicion()]);
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
