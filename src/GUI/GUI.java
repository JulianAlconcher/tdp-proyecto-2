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
import java.awt.Dimension;

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
	private JLabel lblPuntaje;
	private int puntajeActual;
	private JButton btnReiniciar;
	protected CeldaGrafica[] celdasG;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/imagenes/logoSnake.png")));
		setTitle("SNAKE v1.1");
		//Setea a la GUI en el centro de la pantalla.
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);

		this.matrizGrafica = new CeldaGrafica[20][20];


		miJuego = new Juego("Alberto");
		


		contentPane.setLayout(null);

		panelJuego = new JPanel();
		panelJuego.setBounds(8, 10, 551, 551);
	

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

		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(569, 421, 251, 21);
		contentPane.add(btnReiniciar);
		btnReiniciar.setVisible(false);

		btnReiniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciarJuego();
			}

		});




		keyH = new KeyHandler();
		this.addKeyListener(keyH);
		this.setFocusable(true);


		JLabel lblTitulo = new JLabel("SNAKE");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(653, 10, 109, 51);
		contentPane.add(lblTitulo);

		JLabel lblTiempo = new JLabel("TIEMPO:");
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTiempo.setBounds(569, 216, 121, 32);
		contentPane.add(lblTiempo);

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

		lblPuntaje = new JLabel("PUNTAJE= "+ puntajeActual);
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setFont(new Font("Verdana", Font.BOLD, 20));
		lblPuntaje.setBounds(569, 58, 205, 21);
		contentPane.add(lblPuntaje);


		iniciarHiloJuego();
	}
	
	private void reiniciarJuego() {
		despintarSnake();
		panelJuego = new JPanel();
		panelJuego.setBounds(8, 10, 551, 551);
		contentPane.add(panelJuego);
		panelJuego.setBackground(Color.GRAY);
		panelJuego.setLayout(new GridLayout(miJuego.getCantFilas(), miJuego.getCantColu(), 0, 0));
		miJuego = new Juego("Alberto");
		matrizGrafica = new CeldaGrafica[20][20];
		pintarMatrizG();
		
		
		keyH = new KeyHandler();
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		btnReiniciar.setVisible(false);
		lblPerdiste.setVisible(false);
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
				celdasG = miJuego.getGrilla().getCeldasGraficas();
				imagen = celdasG[numeroCelda].getGrafico();
				matrizGrafica[i][j].setIcon(imagen);
				matrizGrafica[i][j].setBounds(i, j, 40, 40);
				panelJuego.add(matrizGrafica[i][j]);
			}
		}


	}
	

	
	public void pintarSnake() {

		for( Celda c : miJuego.getGrilla().getCriatura().getLista()) {
			int fila = c.getCoordFila();
			int colu = c.getCoordColu();
			celdasG = miJuego.getGrilla().getCeldasGraficas();
			matrizGrafica[miJuego.getGrilla().getCriatura().getLista().getLast().getCoordFila()][miJuego.getGrilla().getCriatura().getLista().getLast().getCoordColu()].setIcon(celdasG[0].getGrafico());
			matrizGrafica[miJuego.getGrilla().getCriatura().getCabeza().getCoordFila()][miJuego.getGrilla().getCriatura().getCabeza().getCoordColu()].setIcon(new ImageIcon(this.getClass().getResource("/imagenes/SnakeHead1.png")));
			matrizGrafica[fila][colu].setIcon(celdasG[4].getGrafico());

			if(miJuego.isEnMovimiento())
				despintarBloque(miJuego.getGrilla().getCriatura().getCola().getCoordFila(),miJuego.getGrilla().getCriatura().getCola().getCoordColu());
		}
	}
	
	private void despintarSnake() {
		for( Celda c : miJuego.getGrilla().getCriatura().getLista()) {
			int fila = c.getCoordFila();
			int colu = c.getCoordColu();
			celdasG = miJuego.getGrilla().getCeldasGraficas();
			matrizGrafica[miJuego.getGrilla().getCriatura().getLista().getLast().getCoordFila()][miJuego.getGrilla().getCriatura().getLista().getLast().getCoordColu()].setIcon(celdasG[0].getGrafico());
			matrizGrafica[fila][colu].setIcon(celdasG[0].getGrafico());
		}
	}

	public void despintarBloque(int f, int c) {
		CeldaGrafica[] celdasG = miJuego.getGrilla().getCeldasGraficas();
		matrizGrafica[f][c].setIcon(celdasG[0].getGrafico());	
	}


	public void iniciarHiloJuego() {
		contentPane.add(panelJuego);
		panelJuego.setBackground(Color.GRAY);
		panelJuego.setLayout(new GridLayout(miJuego.getCantFilas(), miJuego.getCantColu(), 0, 0));
		pintarMatrizG();
		pintarSnake();
		hiloJuego = new Thread (this);
		hiloJuego.start();
		Reloj miReloj= new Reloj(label);
		miReloj.start();
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
			puntajeActual=miJuego.getJugador().getPuntaje();
			lblPuntaje.setText("PUNTAJE= "+ puntajeActual);
			try {hiloJuego.sleep(150);} catch (InterruptedException e) {e.printStackTrace();}	

			if(miJuego.getGameStatus()) {
				btnReiniciar.setVisible(true);
				corriendo=false;
				iniciaHilo=false;
				lblPerdiste.setVisible(true);
				hiloJuego = null;
			}
		}
	}
	public void update() {


		if(!keyH.teclaOn()) {
			miJuego.mover(miJuego.getGrilla().getDireccion());
		}

		if(keyH.upPressed == true) {
			miJuego.mover(1);
		}
		if(keyH.downPressed == true){
			miJuego.mover(-1);
		}
		if(keyH.rightPressed == true ) {
			miJuego.mover(2);
		}
		if(keyH.leftPressed == true) {
			miJuego.mover(-2);
		}
	}
}







