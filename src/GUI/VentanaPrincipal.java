package GUI;

public class VentanaPrincipal {
	
	public static void main(String[] args) {
		
		SplashScreen miSplashScreen = new SplashScreen(2000);
		
		miSplashScreen.initialize();
		
		
		GUI miGUI = new GUI();
		
		miGUI.setVisible(true);
		
		
		
	}
	

}
