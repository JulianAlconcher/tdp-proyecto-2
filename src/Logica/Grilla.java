package Logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

public class Grilla{

	private Celda tablero[][];
	private int cantFilas;
	private int cantColumnas;
	private CeldaGrafica[] celdasGraficas;
	private int mapaCeldasNumeros[][];
	private Criatura miCriatura;
	private int direccion;
	private LinkedList<Celda> entidadesComestibles;
	protected boolean comio;
	
	/**
	 * Constructor Grilla, crea una grilla de [filas][columnas] de tamaño
	 * @param filas: cantidad de filas
	 * @param columnas: cantidad de columnas
	 */
	public Grilla (int filas,int columnas) {
		this.comio = false;
		this.cantColumnas = 20;
		this.cantFilas = 20;
		entidadesComestibles= new LinkedList<Celda>();
		System.out.println(entidadesComestibles.size());
		tablero = new Celda [filas][columnas];
		mapaCeldasNumeros = new int[filas][columnas];
		celdasGraficas = new CeldaGrafica[18];
		for (int i = 0; i < cantFilas; i++) {
			for(int j = 0; j < cantColumnas; j++) {
				tablero[i][j] = new Celda(i,j);
			}
		}  

		getImagenCelda();
		cargarMapa();
		setRandomDireccion();
		colocarCriatura();

	}

	public void colocarCriatura() {
		int fila = randomFilaCoord();
		int col = randomColCoord();
		miCriatura = new Criatura(fila,col);
		boolean posValida = false;
		while(!posValida)  {
			for(Celda e : miCriatura.getLista()) {
				if(!getCelda(e.getCoordFila(),e.getCoordColu()).getHabitable()) {
					System.out.println("Intenete colocar en fila: " + fila + "columna: " + col + "con direccion" + miCriatura.getDireccion());
					fila = randomFilaCoord();
					col = randomColCoord();
				}
				else
					posValida = true;
			}

		}
		miCriatura = new Criatura(fila,col);
		System.out.println("Criatura colocada en el lugar ( " + fila + " , " + col + ")");
	}

	/**
	 * Genera una posicion random para la fila.
	 * @return
	 */
	public int randomFilaCoord() {
		int randomNumF = ThreadLocalRandom.current().nextInt(6, 15);
		return randomNumF;
	}

	/**
	 * Genera una posicion random para la columna.
	 * @return
	 */
	public int randomColCoord() {
		int randomNumC = ThreadLocalRandom.current().nextInt(6, 15);
		return randomNumC;
	}
	public Criatura getCriatura() {
		return miCriatura;
	}

	public void getImagenCelda() {


		celdasGraficas[0] = new CeldaGrafica();
		ImageIcon graficoFondo = new ImageIcon(this.getClass().getResource("/imagenes/Fondo.png"));
		celdasGraficas[0].setGrafico(graficoFondo);

		celdasGraficas[1] = new CeldaGrafica();
		ImageIcon graficoPared = new ImageIcon(this.getClass().getResource("/imagenes/Piedra.png"));
		celdasGraficas[1].setGrafico(graficoPared);

		celdasGraficas[2] = new CeldaGrafica();
		ImageIcon graficoAlimentoPi = new ImageIcon(this.getClass().getResource("/imagenes/Pizza.png"));
		celdasGraficas[2].setGrafico(graficoAlimentoPi);

		celdasGraficas[3] = new CeldaGrafica();
		ImageIcon graficoAlimentoH = new ImageIcon(this.getClass().getResource("/imagenes/Burger.png"));
		celdasGraficas[3].setGrafico(graficoAlimentoH);

		celdasGraficas[4] = new CeldaGrafica();
		ImageIcon graficoAlimentoPa = new ImageIcon(this.getClass().getResource("/imagenes/Fries.png"));
		celdasGraficas[4].setGrafico(graficoAlimentoPa);

		celdasGraficas[5] = new CeldaGrafica();
		ImageIcon graficoAlimentoCo = new ImageIcon(this.getClass().getResource("/imagenes/Coke.png"));
		celdasGraficas[5].setGrafico(graficoAlimentoCo);

		celdasGraficas[6] = new CeldaGrafica();
		ImageIcon graficoAlimentoCe = new ImageIcon(this.getClass().getResource("/imagenes/Beer.png"));
		celdasGraficas[6].setGrafico(graficoAlimentoCe);

		celdasGraficas[7] = new CeldaGrafica();
		ImageIcon graficoPowerUpV = new ImageIcon(this.getClass().getResource("/imagenes/PowerUpVeneno.png"));
		celdasGraficas[7].setGrafico(graficoPowerUpV);

		celdasGraficas[8] = new CeldaGrafica();
		ImageIcon graficoPowerUpR = new ImageIcon(this.getClass().getResource("/imagenes/PowerUpRojo.png"));
		celdasGraficas[8].setGrafico(graficoPowerUpR);

		celdasGraficas[9] = new CeldaGrafica();
		ImageIcon graficoPowerUpD = new ImageIcon(this.getClass().getResource("/imagenes/PowerUpDorado.png"));
		celdasGraficas[9].setGrafico(graficoPowerUpD);

		celdasGraficas[10] = new CeldaGrafica();
		ImageIcon graficoSnakeA = new ImageIcon(this.getClass().getResource("/imagenes/SnakeColorChange1.png"));
		celdasGraficas[10].setGrafico(graficoSnakeA);

		celdasGraficas[11] = new CeldaGrafica();
		ImageIcon graficoSnakeCabezaA = new ImageIcon(this.getClass().getResource("/imagenes/SnakeHead1.png"));
		celdasGraficas[11].setGrafico(graficoSnakeCabezaA);

		celdasGraficas[12] = new CeldaGrafica();
		ImageIcon graficoSnakeV= new ImageIcon(this.getClass().getResource("/imagenes/SnakeColorChange2.png"));
		celdasGraficas[12].setGrafico(graficoSnakeV);

		celdasGraficas[13] = new CeldaGrafica();
		ImageIcon graficoSnakeCabezaV = new ImageIcon(this.getClass().getResource("/imagenes/SnakeHead2.png"));
		celdasGraficas[13].setGrafico(graficoSnakeCabezaV);

		celdasGraficas[14] = new CeldaGrafica();
		ImageIcon graficoSnakeR = new ImageIcon(this.getClass().getResource("/imagenes/SnakeColorChange3.png"));
		celdasGraficas[14].setGrafico(graficoSnakeR);

		celdasGraficas[15] = new CeldaGrafica();
		ImageIcon graficoSnakeCabezaR = new ImageIcon(this.getClass().getResource("/imagenes/SnakeHead3.png"));
		celdasGraficas[15].setGrafico(graficoSnakeCabezaR);

		celdasGraficas[16] = new CeldaGrafica();
		ImageIcon graficoSnakeD = new ImageIcon(this.getClass().getResource("/imagenes/SnakeColorChange4.png"));
		celdasGraficas[16].setGrafico(graficoSnakeD);

		celdasGraficas[17] = new CeldaGrafica();
		ImageIcon graficoSnakeCabezaD = new ImageIcon(this.getClass().getResource("/imagenes/SnakeHead4.png"));
		celdasGraficas[17].setGrafico(graficoSnakeCabezaD);


	}

	public Celda setProximoComestible() {
		comio = true;
		Celda prox = null;
		int randomComestible;
		
		if( entidadesComestibles.size() > 0 ) {
			if(entidadesComestibles.size() == 1)
				randomComestible = 0;
			else
				randomComestible = ThreadLocalRandom.current().nextInt(1, entidadesComestibles.size());

		


			prox = entidadesComestibles.remove(randomComestible);

			tablero[prox.getCoordFila()][prox.getCoordColu()] = prox;
		}
		System.out.println(entidadesComestibles.size());
		return prox;
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
					case 0 :
						tablero[fila][columna].setEntidad(new Fondo());
						break;

					case 1 : {
						tablero[fila][columna].setEntidad(new Pared());
						tablero[fila][columna].setHabitable(false);

					}
					break;
					case 2 : {
						//							tablero[fila][columna].setEntidad(new AlimentoPizza(fila,columna));
						//							tablero[fila][columna].setHabitable(false);
						Celda c = new Celda(fila,columna);
						c.setEntidad(new AlimentoPizza(fila,columna));
						entidadesComestibles.add(c);
						tablero[fila][columna].setEntidad(new Fondo());


					}
					break;
					case 3 : {
						Celda c = new Celda(fila,columna);
						c.setEntidad(new AlimentoHamburguesa(fila,columna));
						entidadesComestibles.add(c);
						tablero[fila][columna].setEntidad(new Fondo());

					}

					break;
					case 4 : {
						Celda c = new Celda(fila,columna);
						c.setEntidad(new AlimentoPapas(fila,columna));
						entidadesComestibles.add(c);
						tablero[fila][columna].setEntidad(new Fondo());
					}
					break;
					case 5 : {
						Celda c = new Celda(fila,columna);
						c.setEntidad(new AlimentoCoca(fila,columna));
						entidadesComestibles.add(c);
						tablero[fila][columna].setEntidad(new Fondo());

					}

					break;
					case 6 : {
						Celda c = new Celda(fila,columna);
						c.setEntidad(new AlimentoCerveza(fila,columna));
						entidadesComestibles.add(c);
						tablero[fila][columna].setEntidad(new Fondo());

					}

					break;
					case 7 : {
						Celda c = new Celda(fila,columna);
						c.setEntidad(new PowerUpVerde(fila,columna));
						entidadesComestibles.add(c);
						tablero[fila][columna].setEntidad(new Fondo());

					}
					break;
					case 8 : {
						Celda c = new Celda(fila,columna);
						c.setEntidad(new PowerUpRojo(fila,columna));
						entidadesComestibles.add(c);
						tablero[fila][columna].setEntidad(new Fondo());

					}

					break;
					case 9:{
						Celda c = new Celda(fila,columna);
						c.setEntidad(new PowerUpOro(fila,columna));
						entidadesComestibles.add(c);
						tablero[fila][columna].setEntidad(new Fondo());

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
	public int getDireccion() {
		return direccion;
	}

	/**
	 * Setea una direccion aleatoria por defecto.
	 */
	public void setRandomDireccion() {
		int[] direcciones = new int[]{1,-1,2,-2};
		int rnd = new Random().nextInt(direcciones.length);
		direccion =  direcciones[rnd];
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
	
	public boolean getComio() {
		return comio;
	}

	public void setComio(boolean comio) {
		this.comio = comio;
	}

}