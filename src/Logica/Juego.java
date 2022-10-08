package Logica;

import GUI.Grilla;

public class Juego {
    private Grilla miGrilla;
    private int cantFilas;
    private int cantColumnas;
    private Jugador miJugador;
    private boolean gameOver=false;
    private VisitorHandler myVisitorHandler;


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

    public int getCantColu() {
        return this.cantColumnas;
    }

    public Grilla getGrilla(){
        return miGrilla;
    }

    public void mover(int d) {
        int filaCabeza = miGrilla.getCriatura().getCabeza().getCoordFila();
        int coluCabeza = miGrilla.getCriatura().getCabeza().getCoordColu();
        VisitorHandler vis = new VisitorHandler();

        if(d == 1 ) { 
            Entidad e = miGrilla.getCelda(filaCabeza-1, coluCabeza).getEntidad(); 
            e.accept(vis);
            if(!vis.getGameStatus())
                miGrilla.getCriatura().avanzar(d);
            else 
                gameOver();


        }
        if(d == -1 ) { 
            Entidad e = miGrilla.getCelda(filaCabeza+1, coluCabeza).getEntidad(); 
            e.accept(vis);
            if(!vis.getGameStatus())
                miGrilla.getCriatura().avanzar(d);

            else 
                gameOver();
        }

        if (d==2) {
            Entidad e = miGrilla.getCelda(filaCabeza, coluCabeza+1).getEntidad(); 
            e.accept(vis);
            if(!vis.getGameStatus())
                miGrilla.getCriatura().moverDerecha();
            else  
                gameOver(); 
        }
        
        if(d==-2) {
            Entidad e = miGrilla.getCelda(filaCabeza, coluCabeza-1).getEntidad(); 
            e.accept(vis);
            if(!vis.getGameStatus())
                miGrilla.getCriatura().moverIzquierda();
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
}