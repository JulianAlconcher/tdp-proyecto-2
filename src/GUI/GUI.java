package GUI;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Celda;
import Logica.CeldaGrafica;
import Logica.Juego;
import Logica.Reloj;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class GUI extends JFrame implements Runnable{

	private JPanel contentPane;
	private JPanel panelJuego;
	private Juego miJuego;
	public static JLabel label;
	public static int segundos=0,minutos=0;
	Thread hiloJuego;
	public static boolean iniciaHilo=true;
	private CeldaGrafica matrizGrafica[][]; 
	private KeyHandler keyH;
	private JButton btnTopJugadores;
	private boolean corriendo=false;
	private JLabel lblPerdiste;
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 611);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/imagenes/Logo.png")));
		setTitle("SNAKE v1.0");

		this.matrizGrafica = new CeldaGrafica[20][20];
	

		miJuego = new Juego("Alberto");
		keyH = new KeyHandler();
		this.addKeyListener(keyH);
		this.setFocusable(true);


		contentPane.setLayout(null);

		panelJuego = new JPanel();
		panelJuego.setBounds(8, 10, 551, 551);
		contentPane.add(panelJuego);
		panelJuego.setBackground(Color.GRAY);
		panelJuego.setLayout(new GridLayout(miJuego.getCantFilas(), miJuego.getCantColu(), 0, 0));
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(569, 492, 251, 69);
		contentPane.add(btnNewButton);
		
		btnTopJugadores = new JButton("TOP JUGADORES");
		btnTopJugadores.setBounds(569, 461, 251, 21);
		contentPane.add(btnTopJugadores);
		
		JLabel lblNewLabel = new JLabel("SNAKE");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(653, 10, 109, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TIEMPO:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setBounds(569, 216, 121, 32);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("00:00");
	    label.setFont(new Font("Verdana", Font.BOLD, 20));
		label.setForeground(Color.WHITE);
		label.setBounds(700, 219, 109, 27);
		contentPane.add(label);
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnIniciar) {
					if (corriendo==false) {
						iniciaHilo=true;
						corriendo=true;
						iniciarHiloJuego();
					}
						
			}
			}
		}
		);
		btnIniciar.setBounds(581, 273, 85, 21);
		contentPane.add(btnIniciar);
		
		JButton btnDetener = new JButton("DETENER");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnDetener) {
					corriendo=false;
					iniciaHilo=false;
				}
			}
		});
		btnDetener.setBounds(689, 273, 85, 21);
		contentPane.add(btnDetener);
		
		lblPerdiste = new JLabel("PERDISTE!");
		lblPerdiste.setForeground(Color.WHITE);
		lblPerdiste.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPerdiste.setBounds(634, 326, 140, 32);
		contentPane.add(lblPerdiste);
		lblPerdiste.setVisible(false);
		
		
		pintarMatrizG();
		pintarSnake();
		iniciarHiloJuego();

	}
	/**
	 * Inicializa el mapa
	 */
	public void pintarMatrizG() {
		for(int i = 0; i < miJuego.getCantFilas(); i++) {
			for(int j = 0; j < miJuego.getCantColu(); j++) {
				
				matrizGrafica[i][j] = miJuego.getGrilla().getCelda(i, j).getCeldaGrafica();
				ImageIcon imagen = new ImageIcon();
				int numeroCelda = miJuego.getGrilla().getNumeroMapa(i, j);
				CeldaGrafica[] celdasG = miJuego.getGrilla().getCeldasGraficas();
				imagen = celdasG[numeroCelda].getGrafico();
				matrizGrafica[i][j].setIcon(imagen);
				matrizGrafica[i][j].setBounds(i, j, 40, 40);
				panelJuego.add(matrizGrafica[i][j]);
			}
		}
		
		
	}
	
	public void pintarSnake() {

		for(int j=0; j<miJuego.getGrilla().getCriatura().getTamanio(); j++) {
			Celda[] celdasSnake = miJuego.getGrilla().getCriatura().getCeldas();
			int fila = celdasSnake[j].getCoordFila();
			int colu = celdasSnake[j].getCoordColu();
			CeldaGrafica[] celdasG = miJuego.getGrilla().getCeldasGraficas();
			despintarBloque(miJuego.getGrilla().getCriatura().getCola().getCoordFila(),miJuego.getGrilla().getCriatura().getCola().getCoordColu());
			matrizGrafica[fila][colu].setIcon(celdasG[4].getGrafico());	
			
		}
		


	
	}
	
	public void despintarBloque(int f, int c) {
			CeldaGrafica[] celdasG = miJuego.getGrilla().getCeldasGraficas();
			matrizGrafica[f][c].setIcon(celdasG[0].getGrafico());
		
	}
//	matrizGrafica[celdasSnake[i]][coordColaColu].setIcon(celdasG[0].getGrafico());	
//	
//		int coordColaFila = miJuego.getGrilla().getCriatura().getCola().getCoordFila();
//		int coordColaColu = miJuego.getGrilla().getCriatura().getCola().getCoordColu();
//		CeldaGrafica[] celdasG = miJuego.getGrilla().getCeldasGraficas();
//		matrizGrafica[coordColaFila][coordColaColu].setIcon(celdasG[0].getGrafico());
		


	public void iniciarHiloJuego() {
		hiloJuego = new Thread (this);
		hiloJuego.start();

	}
	
	/**
	private void inciarHiloTimer() {
		if (iniciaHilo==true) {
		System.out.println("Hola");
		Reloj miReloj= new Reloj(label);
		miReloj.start();
		}
} */


	@SuppressWarnings("static-access")
	public void run() {
		while(hiloJuego != null) {
			update();
			pintarSnake();
			
			try {hiloJuego.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
			
//			if(miJuego.getGameStatus()) {
//				hiloJuego = null;
//				lblPerdiste.setVisible(true);
//				miReloj.pararReloj();
//			}
		}
	}
	public void update() {
		System.out.println("Entre al update");
		if(keyH.upPressed == true)
			miJuego.mover(1);
		else if(keyH.downPressed == true) 
			miJuego.mover(-1);
		else if(keyH.rightPressed == true)
			miJuego.mover(2);
		else if(keyH.leftPressed == true)
			miJuego.mover(-2);
	}
}







