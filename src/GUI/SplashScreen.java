package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SplashScreen {

	private JFrame frame;
	private int duracion;

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public SplashScreen(int d) {
		duracion=d;
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 400);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 600, 400);
		frame.getContentPane().add(lblNewLabel);
		ImageIcon icon= new ImageIcon(this.getClass().getResource("/images/SS2.jpg"));
		lblNewLabel.setIcon(icon);
		
		frame.setVisible(true);
		 try { 
			 	Thread.sleep(duracion); 
		 } catch (Exception e) {}
		 frame.setVisible(false); 
	}
}

