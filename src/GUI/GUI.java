package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		setTitle("SNAKE BETA");
		

		this.matrizGrafica = new CeldaGrafica[20][20];
			
	
		
		miJuego = new Juego();
		
	
		contentPane.setLayout(null);
		
		panelJuego = new JPanel();
		panelJuego.setBounds(5, 7, 300, 300);
		contentPane.add(panelJuego);
		
		
		/**
		 * 
		 */
		matrizGrafica[5][5] = new JLabel();
		matrizGrafica[5][5].setIcon(new ImageIcon("C:\\Users\\FRAVEGA\\Downloads\\Documents\\TDP\\tdp-proyecto-2\\src\\imagenes\\MARIO.png"));
		matrizGrafica[5][5].setBounds(200,200,10,10);
		panelJuego.add(matrizGrafica[5][5]);
		
		for(int i = 0; i < miJuego.getCantFilas(); i++) {
			for(int j = 0; j < miJuego.getCantColu(); j++) {
				System.out.println("entro al for que crea la matriz grafica");
		
				matrizGrafica[i][j] = miJuego.getGrilla().getCelda(i, j).getCeldaGrafica();
				matrizGrafica[i][j].setIcon(miJuego.getGrilla().getCelda(i,j).getCeldaGrafica().getGrafico());
				matrizGrafica[i][j].setBounds(200,200,10,10);
				panelJuego.add(matrizGrafica[i][j]);
			}
		}

//		pintarMatrizG();
		
	}

	/**
	 * 
	 */
	public void pintarMatrizG() {
		for(int i = 0; i < miJuego.getCantFilas(); i++) {
			for(int j = 0; j < miJuego.getCantColu(); j++) {
				matrizGrafica[i][j].setIcon(new ImageIcon("imagenes/MARIO.png"));
//				matrizGrafica[i][j].setIcon(null);
				matrizGrafica[i][j].setBounds(i*100, j*100, 20, 20);
				matrizGrafica[i][j].setVisible(true);
				panelJuego.add(matrizGrafica[i][j]);
			}
		}
	}
 
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
	
	
	
	
	
	
	
	