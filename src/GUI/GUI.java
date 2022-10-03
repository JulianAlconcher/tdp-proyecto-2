package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Juego;
import javax.swing.JLabel;
import java.awt.Color;


public class GUI extends JFrame implements Runnable{

	private JPanel contentPane;
	private Juego miJuego;
	private JLabel lblCasilla;
	Thread hiloJuego;

	
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);

		miJuego = new Juego();

		contentPane.setLayout(new GridLayout(20,20));
		lblCasilla = new JLabel();
		lblCasilla.setBounds(100, 100, 4, 4);
		/*
		Celda c = miJuego.getGrilla().getCelda(0, 0);
		ImageIcon image = new ImageIcon("#.png");
		lblCasilla.setIcon(new ImageIcon("C:\\Users\\FRAVEGA\\Downloads\\Documents\\TDP\\p2-prueba\\src\\images\\#.png"));
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(lblCasilla.getWidth(), lblCasilla.getHeight(), Image.SCALE_DEFAULT)
				);
		contentPane.add(lblCasilla);


		for (int i = 0; i < miJuego.getCantFilas(); i++) {
			for(int j = 0; j < miJuego.getCantColu(); j++) {
				Celda c1 = miJuego.getGrilla().getCelda(i, j);
				ImageIcon imagen = c.getEntidadGrafica().getGrafico();
				lblCasilla.setIcon(image);
		
			}
		}
		 */
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
	
	
	
	
	
	
	
	