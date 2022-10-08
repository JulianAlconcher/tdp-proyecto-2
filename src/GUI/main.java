package GUI;

public class main {
	
	public static void main (String[] args) {
		
		SplashScreen miSplashScreen =new SplashScreen(700);
		
		miSplashScreen.initialize();
		
		GUI miGUI= new GUI();
		
		miGUI.setVisible(true);
		
		
		
	}
	

}
