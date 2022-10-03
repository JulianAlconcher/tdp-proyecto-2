package Logica;

import java.util.PriorityQueue;

public class testerTopPlayers {

	
	public static void main(String[] args) {

		
		Jugador j1 = new Jugador("Juan"); 
		j1.aumentarPuntaje(234);
		
		Jugador j2 = new Jugador("Toto"); 
		j2.aumentarPuntaje(24);
		
		Jugador j3 = new Jugador("Alberto"); 
		j3.aumentarPuntaje(634);
		
		Jugador j4 = new Jugador("Tobi"); 
		j4.aumentarPuntaje(1634);
		
		Jugador j5 = new Jugador("Julian"); 
		j5.aumentarPuntaje(43212);
		
		Jugador j6 = new Jugador("Fran"); 
		j6.aumentarPuntaje(50);
		
		TopJugadores top5 = new TopJugadores();
	    

	    try {
	    	top5.agregarJugador(j1);
	    	top5.agregarJugador(j2);
	    	top5.agregarJugador(j3);
	    	top5.agregarJugador(j4);
	    	top5.agregarJugador(j5);
	    	
	    	top5.guardar();
	    	
		} catch (Exception e) {e.printStackTrace();}
	  
	    
		try {
			PriorityQueue<Jugador> nuevo = top5.leer();
			for(int i=0; i<5; i++) {
				System.out.println(nuevo.remove().getNombre());
			}
		} catch (Exception e) {e.printStackTrace();}	
	     
		
  }
	
}
