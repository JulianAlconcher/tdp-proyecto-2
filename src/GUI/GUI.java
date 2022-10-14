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
import javax.swing.JOptionPane;

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
	private final int velocidad = 150;
	public static JLabel label;
	public static int segundos=0,minutos=0;
	Thread hiloJuego;
	public static boolean iniciaHilo=true;
	private CeldaGrafica matrizGrafica[][]; 
	private KeyHandler keyH;
	private JButton btnTopJugadores;
	private boolean ready=false;
	private JLabel lblPerdiste,lblNivel;
	private JLabel lblPuntaje;
	private int puntajeActual;
	private Reloj miReloj;

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


		miJuego = new Juego();
		


		contentPane.setLayout(null);

		panelJuego = new JPanel();
		panelJuego.setBounds(8, 10, 551, 551);
	
		


		JButton btnNewButton = new JButton("JUGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego();
				btnNewButton.setFocusable(false);
			}
		});
		btnNewButton.setBounds(569, 492, 251, 69);
		contentPane.add(btnNewButton);

		btnTopJugadores = new JButton("TOP JUGADORES");
		btnTopJugadores.setBounds(569, 461, 251, 21);
		contentPane.add(btnTopJugadores);
		btnTopJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String message = miJuego.stringTopJugadores(miJuego.leer());
					System.out.println(miJuego.leer().size());
					JOptionPane.showMessageDialog(null, message);
					System.out.println("TOP JUGADORES: " + message);
				} catch (Exception e1) {
					String message = "Nadie ha jugado aun.";
					JOptionPane.showMessageDialog(null, message);
				}
				
				btnTopJugadores.setFocusable(false);
			}
		});
		
		
		lblPuntaje = new JLabel("PUNTAJE: null");
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setFont(new Font("Verdana", Font.BOLD, 20));
		lblPuntaje.setBounds(569, 168, 205, 21);
		contentPane.add(lblPuntaje);
		
		keyH = new KeyHandler();
		this.addKeyListener(keyH);
		this.setFocusable(true);

		
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

		lblPerdiste = new JLabel("¡PERDISTE!");
		lblPerdiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerdiste.setForeground(Color.WHITE);
		lblPerdiste.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPerdiste.setBounds(569, 326, 251, 58);
		contentPane.add(lblPerdiste);
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
				celdasG = miJuego.getGrilla().getCeldasGraficas();
				imagen = celdasG[miJuego.getGrilla().getCelda(i,j).getEntidad().getGrafico()].getGrafico();
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
			matrizGrafica[miJuego.getGrilla().getCriatura().getCabeza().getCoordFila()][miJuego.getGrilla().getCriatura().getCabeza().getCoordColu()].setIcon((celdasG[miJuego.getGrilla().getCriatura().getColor()+1].getGrafico()));                              
			matrizGrafica[fila][colu].setIcon(celdasG[miJuego.getGrilla().getCriatura().getColor()].getGrafico());

			if(miJuego.isEnMovimiento())
				despintarBloque(miJuego.getGrilla().getCriatura().getCola().getCoordFila(),miJuego.getGrilla().getCriatura().getCola().getCoordColu());
		}
	}

	public void despintarBloque(int f, int c) {
		CeldaGrafica[] celdasG = miJuego.getGrilla().getCeldasGraficas();
		matrizGrafica[f][c].setIcon(celdasG[0].getGrafico());	
	}


	public void aparicionEntidad(int f, int c, int imagen) {
		celdasG = miJuego.getGrilla().getCeldasGraficas();

		matrizGrafica[f][c].setIcon(celdasG[imagen].getGrafico());
	}
	
	public void iniciarHiloJuego() {
		
		contentPane.add(panelJuego);
		panelJuego.setBackground(Color.GRAY);
		panelJuego.setLayout(new GridLayout(miJuego.getCantFilas(), miJuego.getCantColu(), 0, 0));
		pintarMatrizG();
		pintarSnake();
		hiloJuego = new Thread (this);
		hiloJuego.start();

		
		JLabel lblImagenTitulo = new JLabel("");
		lblImagenTitulo.setBounds(569, 10, 251, 113);
		contentPane.add(lblImagenTitulo);
		ImageIcon icon= new ImageIcon(this.getClass().getResource("/imagenes/titulo.png"));
		lblImagenTitulo.setIcon(icon);
		
		lblNivel = new JLabel("Nivel: 1");
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setBounds(569, 272, 251, 58);
		contentPane.add(lblNivel);
		
	
	}

	public void pintarNuevoNivel() {
		miJuego.aumentarNivel();
		panelJuego = new JPanel();
		panelJuego.setBounds(8, 10, 551, 551);
		contentPane.add(panelJuego);
		panelJuego.setBackground(Color.GRAY);
		panelJuego.setLayout(new GridLayout(miJuego.getCantFilas(), miJuego.getCantColu(), 0, 0));
		matrizGrafica = new CeldaGrafica[20][20];
		pintarMatrizG();
	}

	@SuppressWarnings("static-access")
	public void run() {
		
		while(hiloJuego != null) {

			if(ready)
				update();
			
			pintarSnake();
			
			if(miJuego.getGrilla().getComio()) {
				int f = miJuego.getProximaEntidad().getCoordFila();
				int c = miJuego.getProximaEntidad().getCoordColu();
				aparicionEntidad(f, c,miJuego.getProximaEntidad().getEntidad().getGrafico());
				if(miJuego.getGrilla().getCantidadComidasRestantes()==0) {
					pintarNuevoNivel();
					lblNivel.setText("Nivel: " + miJuego.getNivelActual());
				}
			}
			if(miJuego.getNivelActual() == 5 && miJuego.getGrilla().getCantidadComidasRestantes() == 0) {
					panelJuego.setVisible(false);
					iniciaHilo=false;
					String message = "¡Felicitaciones! Has ganado.";
					JOptionPane.showMessageDialog(null, message);
					System.exit(0);
			}
			
			puntajeActual=miJuego.getJugador().getPuntaje();
			lblPuntaje.setText("PUNTAJE= "+ puntajeActual);
			try {hiloJuego.sleep(velocidad);} catch (InterruptedException e) {e.printStackTrace();}	

			if(miJuego.getGameStatus()) 
				GameOverVisual();			
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
	
	public void iniciarJuego() {
		String name = JOptionPane.showInputDialog("Ingrese su nombre por favor");
		JOptionPane.showMessageDialog(null, "Hola " + name);
		miJuego.getJugador().setNombre(name);
		miJuego.addJugador(miJuego.getJugador());
		ready = true;
		miReloj= new Reloj(label);
		miReloj.start();
	}
	
	public void GameOverVisual() {
		iniciaHilo=false;
		lblPerdiste.setVisible(true);
		hiloJuego = null;
	}
}







