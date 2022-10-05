package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Logica.Juego;

public class KeyHandler implements KeyListener {

	private Juego miJuego;
	public boolean upPressed,downPressed,leftPressed,rightPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getExtendedKeyCode();
		
		if(code == KeyEvent.VK_UP)
			upPressed = true;
		else if ( code == KeyEvent.VK_DOWN)
			downPressed = true;
		else if ( code == KeyEvent.VK_RIGHT)
			rightPressed = true;
		else if ( code == KeyEvent.VK_LEFT)
			leftPressed = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
