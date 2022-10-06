package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;

import Logica.Alimento;
import Logica.Celda;
import Logica.CeldaGrafica;
import Logica.Criatura;
import Logica.Entidad;
import Logica.Pared;
import Logica.PowerUp;

public class Grilla {

	private Celda tablero[][];
	private int cantFilas;
	private int cantColumnas;
	private CeldaGrafica[] celdasGraficas;
	private int mapaCeldasNumeros[][];
	private Criatura miCriatura;

	/**
	 * Constructor Grilla, crea una grilla de [filas][columnas] de tamaño
	 * @param filas: cantidad de filas
	 * @param columnas: cantidad de columnas
	 */
	public Grilla (int filas,int columnas) {
		this.cantColumnas = 20;
		this.cantFilas = 20;
		tablero = new Celda [filas][columnas];
		mapaCeldasNumeros = new int[filas][columnas];
		celdasGraficas = new CeldaGrafica[5];
		miCriatura = new Criatura();
		for (int i = 0; i < cantFilas; i++) {
			for(int j = 0; j < cantColumnas; j++) {
				tablero[i][j] = new Celda(i,j);
			}
		}  
		getImagenCelda();
		cargarMapa();

	}


	public Criatura getCriatura() {
		return miCriatura;
	}

	public void getImagenCelda() {


		celdasGraficas[0] = new CeldaGrafica();
		ImageIcon graficoFondo = new ImageIcon(this.getClass().getResource("/imagenes/F.jpg"));
		celdasGraficas[0].setGrafico(graficoFondo);

		celdasGraficas[1] = new CeldaGrafica();
		ImageIcon graficoPared = new ImageIcon(this.getClass().getResource("/imagenes/#.png"));
		celdasGraficas[1].setGrafico(graficoPared);

		celdasGraficas[2] = new CeldaGrafica();
		ImageIcon graficoAlimento = new ImageIcon(this.getClass().getResource("/imagenes/A.jpg"));
		celdasGraficas[2].setGrafico(graficoAlimento);

		celdasGraficas[3] = new CeldaGrafica();
		ImageIcon graficoPowerUp = new ImageIcon(this.getClass().getResource("/imagenes/P.jpg"));
		celdasGraficas[3].setGrafico(graficoPowerUp);

		celdasGraficas[4] = new CeldaGrafica();
		ImageIcon graficoSnake = new ImageIcon(this.getClass().getResource("/imagenes/MARIO.png"));
		celdasGraficas[4].setGrafico(graficoSnake);



	}
	public void cargarMapa() {

		try {

			InputStream is = Grilla.class.getClassLoader().getResourceAsStream("Nivel1.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int columna = 0;
			int fila = 0;

			while(columna < cantColumnas && fila < cantFilas) {
				String line = br.readLine();

				while(columna < cantColumnas) {
					String numeros[] = line.split(" ");
					int n = Integer.parseInt(numeros[columna]);
					mapaCeldasNumeros[fila][columna] = n;
					switch(n) {
						case 1 : {
							tablero[fila][columna].setEntidad(new Pared());
							tablero[fila][columna].setComestible(false);
						}
						break;
						case 2 : {
							tablero[fila][columna].setEntidad(new Alimento());
							tablero[fila][columna].setComestible(true);
						}
						break;
						case 3 : {
							tablero[fila][columna].setEntidad(new PowerUp());
							tablero[fila][columna].setComestible(true);
						}
						break;
						}
					columna++;
				}
				if(columna == cantColumnas) {
					columna = 0;
					fila++;
				}
			}
			br.close();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}


	public CeldaGrafica[] getCeldasGraficas() {
		return celdasGraficas;
	}

	/**
	 * Retorna la celda en la fila i, columna j
	 * @param i: fila
	 * @param j: columna
	 * @return Celda en i,j
	 */
	public Celda getCelda(int i,int j) {
		if (i < 0 || i >= getCantFilas() || j < 0 || j >= getCantColu()) {
			return null;
		}
		else {
			return tablero[i][j];
		}
	}
	public boolean equalsCeldas(Celda c1,Celda c2) {
		boolean retorno = false;




		return retorno;
	}
	/**
	 * Setea una Celda c en la posicion i,j de la grilla
	 * @param i: fila
	 * @param j: columna
	 * @param c: Celda a colocar
	 */
	public void setCelda(int i, int j, Celda c) {
		tablero[i][j] = c;
	}

	/**
	 * Carga el mapa pasado por archivo de texto
	 */

	/**
	 * @return Cantidad de filas de la Grilla
	 */
	public int getCantFilas() {
		return this.cantFilas;
	}

	/**
	 * @return Cantidad de columnas de la Grilla
	 */
	public int getCantColu() {
		return this.cantColumnas;
	}

	public int getNumeroMapa(int i,int j){
		return mapaCeldasNumeros[i][j];
	}
}
