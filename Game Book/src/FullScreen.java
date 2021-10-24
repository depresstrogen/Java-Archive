import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class FullScreen extends JFrame{
	
	int screenTime = 5000; //Milliseconds
	private Image waterBottle, beach;
	
	public static void main(String[] args) {
		// Init Display
		DisplayMode displayMode;
		displayMode = new DisplayMode(1920,1080,32,60);
		FullScreen screen = new FullScreen();
		screen.run(displayMode);
		
	}//main
	
	public void run(DisplayMode displayMode) {
		setBackground(Color.blue);
		setForeground(Color.white);
		setFont(new Font ("Comic Sans MS", Font.PLAIN, 250));
		
		ScreenManager screenManager = new ScreenManager();
		
		try {
			screenManager.setFullScreen(displayMode);
			loadImages();
			try {
				Thread.sleep(screenTime);
			}
			catch (InterruptedException ex) {
			}
		}
		finally {
			screenManager.restoreScreen();
		}
	}//run
	
	public void loadImages () {
		waterBottle = loadImage("images/worter.png");
		beach = loadImage("images/boich.jpg");
	}
	
	public Image loadImage(String file) {
		return new ImageIcon(file).getImage();
	}
	
	public void paint (Graphics g) {
		//Anti Alias
		if (g instanceof Graphics2D) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		
		g.drawString("Pee Pee Poo Poo", 20, 600);
		g.drawImage(beach, 0 , 0, null);
		g.drawImage(waterBottle, 20 , 20, null);
		g.drawImage(waterBottle, 420 , 20, null);
		g.drawImage(waterBottle, 820 , 20, null);
		g.drawImage(waterBottle, 1220 , 20, null);
		g.drawImage(waterBottle, 1620 , 20, null);
	}
	
}
