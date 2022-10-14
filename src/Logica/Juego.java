package Logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.PriorityQueue;

@SuppressWarnings("serial")
public class Juego implements Serializable{

	private Grilla miGrilla;
	private int cantFilas;
	private int cantColumnas;
	private Jugador miJugador;
	private boolean gameOver = false;
	private boolean enMovimiento = false;
	private PriorityQueue<Jugador> rankingOrdenado;
	private static String archivoRanking = "ranking.tdp";
	protected Celda proximaCeldaEntidad;
	protected int nivelActual;
	protected int comestiblesConsumidos;


	public Juego() {

		this.cantColumnas = 20;
		this.cantFilas = 20;
		this.miGrilla = new Grilla(cantFilas, cantColumnas,"Nivel1.txt");
		proximaCeldaEntidad = miGrilla.setProximoComestible();
		nivelActual = 1;
		comestiblesConsumidos = 0;
		miJugador = new Jugador(" ");
		nuevoRanking();
		
	}

	public void nuevoRanking(){
		
		try {
			rankingOrdenado=this.leer();
		} catch (Exception e) {
			rankingOrdenado= new PriorityQueue<Jugador>();
		}
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
			    if (vis.getVisitoComestible()) {
			    	if(vis.getVisitoPowerUp()) {
				    	 miGrilla.getCriatura().setColor(vis.getColor());
				     }
			    	miGrilla.getCriatura().aumentarCola(miGrilla.getCriatura().getCola().getCoordFila(),miGrilla.getCriatura().getCola().getCoordColu(), vis.getTamanio());
			    	miJugador.aumentarPuntaje(vis.getPuntaje());
			    	proximaCeldaEntidad = miGrilla.setProximoComestible();
			    	comestiblesConsumidos++;
			     }
			}
			else 
				gameOver();
		}else if(d == -1) { 
			Entidad e = miGrilla.getCelda(filaCabeza+1, coluCabeza).getEntidad(); 
			e.accept(vis);
			if(!vis.getGameStatus()) {
				miGrilla.getCriatura().avanzar(miGrilla.getCelda(miGrilla.getCriatura().getCabeza().getCoordFila()+1, miGrilla.getCriatura().getCabeza().getCoordColu()));
				 if (vis.getVisitoComestible()) {
					 if(vis.getVisitoPowerUp()) {
				    	 miGrilla.getCriatura().setColor(vis.getColor());
				     }
				    	miGrilla.getCriatura().aumentarCola(miGrilla.getCriatura().getCola().getCoordFila(),miGrilla.getCriatura().getCola().getCoordColu(), vis.getTamanio());
				    	miJugador.aumentarPuntaje(vis.getPuntaje());
				    	proximaCeldaEntidad = miGrilla.setProximoComestible();
				    	comestiblesConsumidos++;
				     }	
			}
			else 
				gameOver();

		}else if(d == 2) { 
			Entidad e = miGrilla.getCelda(filaCabeza, coluCabeza+1).getEntidad(); 
			e.accept(vis);
			if(!vis.getGameStatus()) {
				miGrilla.getCriatura().avanzar(miGrilla.getCelda(miGrilla.getCriatura().getCabeza().getCoordFila(), miGrilla.getCriatura().getCabeza().getCoordColu()+1));
				 if (vis.getVisitoComestible()) {
					     if(vis.getVisitoPowerUp()) {
					    	 miGrilla.getCriatura().setColor(vis.getColor());
					     }
				    	miGrilla.getCriatura().aumentarCola(miGrilla.getCriatura().getCola().getCoordFila(),miGrilla.getCriatura().getCola().getCoordColu(), vis.getTamanio());
				    	miJugador.aumentarPuntaje(vis.getPuntaje());
				    	proximaCeldaEntidad = miGrilla.setProximoComestible();
				    	comestiblesConsumidos++;
				     }
			}
			else 
				gameOver();
		} else if(d == -2) { 
			Entidad e = miGrilla.getCelda(filaCabeza, coluCabeza-1).getEntidad(); 
			e.accept(vis);
			if(!vis.getGameStatus()) {
				miGrilla.getCriatura().avanzar(miGrilla.getCelda(miGrilla.getCriatura().getCabeza().getCoordFila(), miGrilla.getCriatura().getCabeza().getCoordColu()-1));
				 if (vis.getVisitoComestible()) {
					 if(vis.getVisitoPowerUp()) {
				    	 miGrilla.getCriatura().setColor(vis.getColor());
				     }
				    	miGrilla.getCriatura().aumentarCola(miGrilla.getCriatura().getCola().getCoordFila(),miGrilla.getCriatura().getCola().getCoordColu(), vis.getTamanio());
				    	miJugador.aumentarPuntaje(vis.getPuntaje());
				    	proximaCeldaEntidad = miGrilla.setProximoComestible();
				    	comestiblesConsumidos++;
				    	
				     }
			}
			else 
				gameOver();
		}
	}
	
	public int getComestiblesConsumidos() {
		return comestiblesConsumidos;
	}

	public void setComestiblesConsumidos(int comestiblesConsumidos) {
		this.comestiblesConsumidos = comestiblesConsumidos;
	}

	public Celda getProximaEntidad() {
		return proximaCeldaEntidad;
	}

	public void gameOver() {
		try {
			this.guardar();
			System.out.println("Guardando...");
		} catch (Exception e) {e.printStackTrace();
		}
		gameOver = true;
		

	}

	public void aumentarNivel() {
		nivelActual++;
		this.miGrilla = new Grilla(cantFilas, cantColumnas,"Nivel" + nivelActual + ".txt");
		proximaCeldaEntidad = miGrilla.setProximoComestible();
		System.out.println("Nivel" + nivelActual + ".txt");
		
	}
	public boolean getGameStatus() {
		return gameOver;
	}


	public boolean isEnMovimiento() {
		return enMovimiento;
	}

	public void crearNuevoNivel() {
		
	}

	public void setEnMovimiento(boolean enMovimiento) {
		this.enMovimiento = enMovimiento;
	}

	public void addJugador(Jugador j) {
	rankingOrdenado.add(j);
    }
	
	public void guardar() throws Exception {
		FileOutputStream file = new FileOutputStream(Juego.archivoRanking);
	    ObjectOutputStream out = new ObjectOutputStream(file);
	    out.writeObject(rankingOrdenado);
	    out.close();
	    file.close();
	}
	
	public PriorityQueue<Jugador> leer() throws Exception {
	    FileInputStream file = new FileInputStream(Juego.archivoRanking);
	    ObjectInputStream in = new ObjectInputStream(file);
	    @SuppressWarnings("unchecked")
	    PriorityQueue<Jugador> top = (PriorityQueue<Jugador>) in.readObject();
	    in.close();
	    file.close();
	    return top;
	}
	
	public String stringTopJugadores(PriorityQueue<Jugador> r) {
		String retorno = "";
		int contador = 0;
		while(!r.isEmpty()) {
			contador++;
			Jugador aux = r.remove();
			retorno = (retorno + "Nombre: " + aux.getNombre() + " " + "Puntaje: " +  aux.getPuntaje());
			retorno = retorno +"\n" ;
			if(contador==5)
				break;
		}
		return retorno;
	}
	

}


