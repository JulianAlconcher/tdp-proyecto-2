package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import Logica.Alimento;
import Logica.Celda;
import Logica.CeldaGrafica;
import Logica.Entidad;
import Logica.Pared;
import Logica.PowerUp;

public class Grilla {

	private Celda tablero[][];
	private int cantFilas;
	private int cantColumnas;
	private LinkedList<CeldaGrafica> entidadesGraficas;

	/**
	 * Constructor Grilla, crea una grilla de [filas][columnas] de tamaño
	 * @param filas: cantidad de filas
	 * @param columnas: cantidad de columnas
	 */
	public Grilla (int filas,int columnas) {
		this.cantColumnas = 20;
		this.cantFilas = 20;
		tablero = new Celda [filas][columnas];

		for (int i = 0; i < cantFilas; i++) {
			for(int j = 0; j < cantColumnas; j++) {
				tablero[i][j] = new Celda(i,j,new Entidad());
				
			}
		}  
	
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
	 * Añade a la Grilla la entidad grafica pasada por parametro
	 * @param e: Entidad Grafica a añadir.
	 */
	public void agregarEntidadG(CeldaGrafica e) {
		this.entidadesGraficas.add(e);
	}
	
	/**
	 * Remueve de la Grilla la entidad grafica pasada por parametro
	 * @param e: Entidad Grafica a remover
	 */
	public void removerEntidadG(CeldaGrafica e) {
		this.entidadesGraficas.remove(e);
	}
	
	/**
	 * Carga el tablero mediante un archivo de texto
	 * @param nameArchivo: nombre del archivo de texto
	 * @return Grilla sera un nuevo tablero
	 * @throws IOException
	 */
	public Grilla cargarTablero(String nameArchivo) throws IOException {

		ArrayList<String> lineas = new ArrayList<String>();
		int ancho = 0;
		int alto = 0;

		//Lee cada linea del archivo en la  lista
		BufferedReader lector = new BufferedReader (new FileReader(nameArchivo));
		while (true) {
			String linea = lector.readLine();
			// no hay mas lineas a leer
			if (linea == null) {
				lector.close();	
				break;
			}

	
			if (linea.startsWith("/")) {
				lineas.add(linea);
				ancho = Math.max(ancho,linea.length());
			}
		}
		alto = lineas.size();

		Grilla nuevoTablero = new Grilla(20,20);

		for(int i = 0; i < alto;i++) {
			String linea = (String) lineas.get(i);
			for(int j = 0; j < linea.length(); j++) {
				Celda c = nuevoTablero.getCelda(i, j);
				char ch = linea.charAt(j);
				//chequea si el char representa una entidad
				int entidad = ch - 'A';
				if ( ch == '#' ) {
						c.setEntidad(new Pared());
						nuevoTablero.setCelda(i, j, c);
				
				} else if( ch == 'P') {
						c.setEntidad(new PowerUp());
						nuevoTablero.setCelda(i, j, c);
				}
				else if( ch == 'A') {
						c.setEntidad(new Alimento());
						nuevoTablero.setCelda(i, j, c);
				}
				else if( ch == ' ') {
					c.setEntidad(null);
					nuevoTablero.setCelda(i, j, c);
				}
			}
			
		}
		return nuevoTablero;
	}
	
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
}
