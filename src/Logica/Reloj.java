package Logica;

import javax.swing.JLabel;

import GUI.GUI;
public class Reloj extends Thread {

	private JLabel eti;
	protected int x;
	
	public Reloj(JLabel label) {
		this.eti=label;
	}

	public void run() {
		try {
			int x=0;
			while(GUI.iniciaHilo) {
				Thread.sleep(1000);
				ejecutarHiloCronometro(x);
				x++;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void ejecutarHiloCronometro(int x) {
		GUI.segundos++;
		
		
		if(GUI.segundos>59) {
			GUI.segundos=0;
			GUI.minutos++;
		}
		
		String textSeg=" ",textMin=" ";
		
		if(GUI.segundos<10) {
			textSeg="0"+GUI.segundos;
		}else {
			textSeg=""+GUI.segundos;
		}
		
		if(GUI.minutos<10) {
			textMin="0"+GUI.minutos;
		}else {
			textMin=""+GUI.minutos;
		}
		
		
		String reloj=textMin+":"+textSeg;
		
		eti.setText(reloj);
	}
}