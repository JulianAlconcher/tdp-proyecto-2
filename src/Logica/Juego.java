package Logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Juego implements Serializable{

	private Grilla miGrilla;
	private int cantFilas;
	private int cantColumnas;
	private Jugador miJugador;
	private boolean gameOver = false;
	private boolean enMovimiento = false;
	private List<Jugador> ranking;
	private static String archivoRanking = "ranking.tdp";


	public Juego() {

		this.cantColumnas = 20;
		this.cantFilas = 20;
		this.miGrilla = new Grilla(cantFilas, cantColumnas);
		miGrilla.cargarMapa();
		miGrilla.setProximoComestible();
		miJugador = new Jugador(" ");
		ranking = new ArrayList<Jugador>();
		
	}

	
	public int getCantFilas() {
		return this.cantFilas;
	}
    
	public Jugador getJugador() {
		return this.miJugador;
	}
	
	public int getCantColu() {
		return this.cantColumnas;
	}

	public Grilla getGrilla(){
		return miGrilla;
	}

	public void mover(int d) {
		enMovimiento = true;
		int filaCabeza = miGrilla.getCriatura().getCabeza().getCoordFila();
		int coluCabeza = miGrilla.getCriatura().getCabeza().getCoordColu();
		VisitorHandler vis = new VisitorHandler();
		if(d == 1) { 
			Entidad e = miGrilla.getCelda(filaCabeza-1, coluCabeza).getEntidad(); 
			e.accept(vis);
			if(!vis.getGameStatus()) { 
				miGrilla.getCriatura().avanzar(miGrilla.getCelda(miGrilla.getCriatura().getCabeza().getCoordFila()-1, miGrilla.getCriatura().getCabeza().getCoordColu()));
			    if (vis.getVisitoComida()) {
			    	miJugador.aumentarPuntaje(vis.getPuntaje());
			    	miGrilla.getCriatura().aumentarCola(miGrilla.getCriatura().getCola().getCoordFila(),miGrilla.getCriatura().getCola().getCoordColu(), 1);
			    	miJugador.aumentarPuntaje(vis.getPuntaje());
			    	miGrilla.setProximoComestible();
			     }
			}
			else 
				gameOver();
		}else if(d == -1) { 
			Entidad e = miGrilla.getCelda(filaCabeza+1, coluCabeza).getEntidad(); 
			e.accept(vis);
			if(!vis.getGameStatus()) {
				miGrilla.getCriatura().avanzar(miGrilla.getCelda(miGrilla.getCriatura().getCabeza().getCoordFila()+1, miGrilla.getCriatura().getCabeza().getCoordColu()));
				 if (vis.getVisitoComida()) {
					 miJugador.aumentarPuntaje(vis.getPuntaje());
				    	miGrilla.getCriatura().aumentarCola(miGrilla.getCriatura().getCola().getCoordFila(),miGrilla.getCriatura().getCola().getCoordColu(), 1);
				    	miJugador.aumentarPuntaje(vis.getPuntaje());
				    	miGrilla.setProximoComestible();
				     }	
			}
			else 
				gameOver();

		}else if(d == 2) { 
			Entidad e = miGrilla.getCelda(filaCabeza, coluCabeza+1).getEntidad(); 
			e.accept(vis);
			if(!vis.getGameStatus()) {
				miGrilla.getCriatura().avanzar(miGrilla.getCelda(miGrilla.getCriatura().getCabeza().getCoordFila(), miGrilla.getCriatura().getCabeza().getCoordColu()+1));
				 if (vis.getVisitoComida()) {
					 miJugador.aumentarPuntaje(vis.getPuntaje());
				    	miGrilla.getCriatura().aumentarCola(miGrilla.getCriatura().getCola().getCoordFila(),miGrilla.getCriatura().getCola().getCoordColu(), 1);
				    	miJugador.aumentarPuntaje(vis.getPuntaje());
				    	miGrilla.setProximoComestible();
				     }
			}
			else 
				gameOver();
		} else if(d == -2) { 
			Entidad e = miGrilla.getCelda(filaCabeza, coluCabeza-1).getEntidad(); 
			e.accept(vis);
			if(!vis.getGameStatus()) {
				miGrilla.getCriatura().avanzar(miGrilla.getCelda(miGrilla.getCriatura().getCabeza().getCoordFila(), miGrilla.getCriatura().getCabeza().getCoordColu()-1));
				 if (vis.getVisitoComida()) {
					 miJugador.aumentarPuntaje(vis.getPuntaje());
				    	miGrilla.getCriatura().aumentarCola(miGrilla.getCriatura().getCola().getCoordFila(),miGrilla.getCriatura().getCola().getCoordColu(), 1);
				    	miJugador.aumentarPuntaje(vis.getPuntaje());
				    	miGrilla.setProximoComestible();
				    	
				     }
			}
			else 
				gameOver();
		}
	}

	public void gameOver() {
		try {
			this.guardar();
			System.out.println("Guardando...");
		} catch (Exception e) {e.printStackTrace();
		}
		gameOver = true;
		

	}

	public boolean getGameStatus() {
		return gameOver;
	}


	public boolean isEnMovimiento() {
		return enMovimiento;
	}


	public void setEnMovimiento(boolean enMovimiento) {
		this.enMovimiento = enMovimiento;
	}

	public void addJugador(Jugador j) {
		ranking.add(j);
	}
	
	public void guardar() throws Exception {
		FileOutputStream file = new FileOutputStream(Juego.archivoRanking);
	    ObjectOutputStream out = new ObjectOutputStream(file);
	    out.writeObject(ranking);
	    out.close();
	    file.close();
	}
	
	public ArrayList<Jugador> leer() throws Exception {
	    FileInputStream file = new FileInputStream(Juego.archivoRanking);
	    ObjectInputStream in = new ObjectInputStream(file);
	    @SuppressWarnings("unchecked")
	    ArrayList<Jugador> top = (ArrayList<Jugador>) in.readObject();
	    in.close();
	    file.close();
	    return top;
	}
	
	public String stringTopJugadores(ArrayList<Jugador> r) {
		String retorno = "";
		for(Jugador j: r) {
			retorno = (retorno + "Nombre: " + j.getNombre() + " " + "Puntaje: " +  j.getPuntaje());
			retorno = retorno +"\n" ;
		}
		return retorno;
	}

}


