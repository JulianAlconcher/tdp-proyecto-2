package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Logica.CeldaGrafica;
import Logica.Juego;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI extends JFrame implements Runnable{

	private JPanel contentPane;
	private JPanel panelJuego;
	private Juego miJuego;
	private JLabel lblCasilla;
	Thread hiloJuego;
	private CeldaGrafica matrizGrafica[][]; 


	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 611);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//		setResizable(false);

		setTitle("SNAKE BETA");


		this.matrizGrafica = new CeldaGrafica[20][20];



		miJuego = new Juego();


		contentPane.setLayout(null);

		panelJuego = new JPanel();
		panelJuego.setBounds(8, 10, 551, 551);
		contentPane.add(panelJuego);
		panelJuego.setBackground(Color.BLACK);
		panelJuego.setLayout(new GridLayout(miJuego.getCantFilas(), miJuego.getCantColu(), 0, 0));

			pintarMatrizG();
	}
	public void pintarMatrizG() {
		int fila = 0;
		int col = 0;
		int i = 0;
		int j = 0;
		
		while(col < miJuego.getCantColu() && fila < miJuego.getCantFilas()) {
			int numeroCelda = miJuego.getGrilla().getNumeroMapa(fila, col);
			CeldaGrafica[] celdasG = miJuego.getGrilla().getCeldasGraficas();
			ImageIcon imagen = celdasG[numeroCelda].getGrafico();
			matrizGrafica[fila][col] = celdasG[numeroCelda];
			panelJuego.add(matrizGrafica[fila][col]);
			fila++;
			col++;
		}
	}

	/**
	 * 
	 * 
	 */
	//	public void pintarMatrizG() {
	//		for(int i = 0; i < miJuego.getCantFilas(); i++) {
	//			for(int j = 0; j < miJuego.getCantColu(); j++) {
	//				
	//				int numeroCelda = miJuego.getGrilla().getNumeroMapa(i, j);
	//				CeldaGrafica[] celdasG = miJuego.getGrilla().getCeldasGraficas();
	//				
	//				matrizGrafica[i][j] = miJuego.getGrilla().getCelda(i, j).getCeldaGrafica();
	//				ImageIcon imagen = new ImageIcon();
	//				imagen = miJuego.getGrilla().getCelda(i, j).getCeldaGrafica().getGrafico();
	//			
	//				matrizGrafica[i][j].setIcon(celdasG[numeroCelda].getIcon());
	//				matrizGrafica[i][j].setBounds(i, j, 40, 40);
	//				panelJuego.add(matrizGrafica[i][j]);
	//			}
	//		}
	//	}



	public void iniciarHiloJuego() {
		hiloJuego = new Thread (this);
		hiloJuego.start();
	}


	public void run() {
		while(hiloJuego != null) {

			System.out.println("El loop del juego inicio");
			update();
			repaint();

		}
	}
	public void update() {

	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.fillRect(100, 100, 200, 200);
		g2.dispose();
	}

}







