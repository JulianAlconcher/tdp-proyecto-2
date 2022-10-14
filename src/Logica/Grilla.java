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

	/**
	 * Constructor Grilla, crea una grilla de [filas][columnas] de tamaño
	 * @param filas: cantidad de filas
	 * @param columnas: cantidad de columnas
	 */
	public Grilla (int filas,int columnas) {
		this.cantColumnas = 20;
		this.cantFilas = 20;
		entidadesComestibles= new LinkedList<Celda>();
		System.out.println(entidadesComestibles.size());
		tablero = new Celda [filas][columnas];
		mapaCeldasNumeros = new int[filas][columnas];
		celdasGraficas = new CeldaGrafica[5];
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
		ImageIcon graficoFondo = new ImageIcon(this.getClass().getResource("/imagenes/Fondoe.png"));
		celdasGraficas[0].setGrafico(graficoFondo);

		celdasGraficas[1] = new CeldaGrafica();
		ImageIcon graficoPared = new ImageIcon(this.getClass().getResource("/imagenes/Piedra.png"));
		celdasGraficas[1].setGrafico(graficoPared);

		celdasGraficas[2] = new CeldaGrafica();
		ImageIcon graficoAlimento = new ImageIcon(this.getClass().getResource("/imagenes/Pizza.png"));
		celdasGraficas[2].setGrafico(graficoAlimento);

		celdasGraficas[3] = new CeldaGrafica();
		ImageIcon graficoPowerUp = new ImageIcon(this.getClass().getResource("/imagenes/powerUp.png"));
		celdasGraficas[3].setGrafico(graficoPowerUp);

		celdasGraficas[4] = new CeldaGrafica();
		ImageIcon graficoSnake = new ImageIcon(this.getClass().getResource("/imagenes/SnakeColorChange4.png"));
		celdasGraficas[4].setGrafico(graficoSnake);



	}
	
	public void setProximoComestible() {
		Celda prox = null;
		int randomComestible = ThreadLocalRandom.current().nextInt(1, entidadesComestibles.size());
		System.out.println(entidadesComestibles.size());
		prox = entidadesComestibles.remove(randomComestible);
		tablero[prox.getCoordFila()][prox.getCoordColu()] = prox;
		
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
							//tablero[fila][columna].setEntidad(new AlimentoPizza(fila,columna));
							Celda nueva = new Celda(fila,columna);
							Entidad nuevaEn = new AlimentoPizza();
							nueva.setEntidad(nuevaEn);
							entidadesComestibles.add(nueva);
							tablero[fila][columna].setEntidad(new Fondo());
						
						}
						break;
						case 3 : {
							tablero[fila][columna].setEntidad(new PowerUp(fila,columna));
							tablero[fila][columna].setHabitable(false);
			
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
}