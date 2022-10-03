package Logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopJugadores implements Serializable {
	
	
	//Nombre del archivo que va a guardar el top de jugadores
	private static String file = "configuration.tdp";
	
	//Creo un comparador para ordenar a la cola de mejor jugador a peor jugador
	class playerComparator implements Comparator<Jugador>,Serializable{

		@Override
		public int compare(Jugador j1, Jugador j2) {
			if(j1.getPuntaje()<j2.getPuntaje())
				return 1;
			else if(j2.getPuntaje()<j1.getPuntaje())
				return -1;
			else return 0;
		}
	}
	
	private PriorityQueue<Jugador> misJugadores;
	
	public TopJugadores() {
		misJugadores = new PriorityQueue<Jugador>(5,new playerComparator()) ;
	}
	
	//Agrega un nuevo jugador a la cola.
	public void agregarJugador(Jugador j1) {
		misJugadores.add(j1);
	}
	
	
	public int getTamanio() {
		return misJugadores.size();
	}
	
	//Guarda en un archivo los top5 mejores jugadores ordenados de mejor a peor.
	public void guardar() throws Exception {
		FileOutputStream file = new FileOutputStream(TopJugadores.file);
	    ObjectOutputStream out = new ObjectOutputStream(file);
	    out.writeObject(misJugadores);
	    out.close();
	    file.close();
	}	
	
	public PriorityQueue<Jugador> leer() throws Exception {
	    FileInputStream file = new FileInputStream(TopJugadores.file);
	    ObjectInputStream in = new ObjectInputStream(file);
	    @SuppressWarnings("unchecked")
		PriorityQueue<Jugador> top = (PriorityQueue<Jugador>) in.readObject();
	    in.close();
	    file.close();
	    return top;
	}
}
