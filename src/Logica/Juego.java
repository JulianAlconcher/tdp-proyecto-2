package Logica;

public class Juego {

	private Grilla miGrilla;
	private int cantFilas;
	private int cantColumnas;
	private Jugador miJugador;
	private boolean gameOver = false;
	private boolean enMovimiento = false;


	public Juego(String nombreJugador) {

		this.cantColumnas = 20;
		this.cantFilas = 20;
		this.miGrilla = new Grilla(cantFilas, cantColumnas);
		miGrilla.cargarMapa();
		miJugador = new Jugador(nombreJugador);
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
				    	
				     }
			}
			else 
				gameOver();
		}
	}

	public void gameOver() {
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
	
	public void nuevoNivel() {
		
	}
}


