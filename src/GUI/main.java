package GUI;

public class main {
	
	public static void main (String[] args) {
		
		SplashScreen miSplashScreen =new SplashScreen(100);
		
		miSplashScreen.initialize();
		
		
		GUI miGUI= new GUI();
		
		miGUI.setVisible(true);
		
		
		
	}
	

}
