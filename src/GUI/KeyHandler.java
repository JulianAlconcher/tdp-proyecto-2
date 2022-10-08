package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Logica.Juego;

public class KeyHandler implements KeyListener {

	public boolean upPressed,downPressed,leftPressed,rightPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getExtendedKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			upPressed = true;
			downPressed = false;
			rightPressed = false;
			leftPressed = false;
		}
		else if ( code == KeyEvent.VK_DOWN) {
			downPressed = true;
			upPressed = false;
			rightPressed = false;
			leftPressed = false;
		}
		else if ( code == KeyEvent.VK_RIGHT) {
			downPressed = false;
			upPressed = false;
			rightPressed = true;
			leftPressed = false;
		}
		else if ( code == KeyEvent.VK_LEFT) {
			downPressed = false;
			upPressed = false;
			rightPressed = false;
			leftPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
