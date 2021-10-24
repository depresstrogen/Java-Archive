import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Statics extends JFrame{
	
	int screenTime = 5000; //Milliseconds
	boolean alive = true;
	Animate staticAnim;
	ScreenManager screenManager;
	private Image buffer;
	
	private DisplayMode allowedModes[] = {
			new DisplayMode(1920, 1080, 32, 144),
			new DisplayMode(1920, 1080, 32, 60),
			new DisplayMode(1280, 720, 32, 60)
	};
	
	public static void main(String[] args) {
		// Init Display
		Statics screen = new Statics();
		screen.run();
		
	}//main
	
	public void run() {
		setBackground(Color.blue);
		setForeground(Color.white);
		setFont(new Font ("Comic Sans MS", Font.PLAIN, 250));
		
		screenManager = new ScreenManager();
		
		try {
			DisplayMode displayMode = screenManager.findFirstCompatibleMode(allowedModes);
			screenManager.setFullScreen(displayMode);
			loadImages();
			animationLoop();
		}
		finally {
			screenManager.restoreScreen();
		}
	}//run
	
	Image testScreen = loadImage("images/Test.png");
	Image beach = loadImage("images/boich.jpg");
	
	public void loadImages () {
		Image static1 = loadImage("images/static/static1.png");
		Image static2 = loadImage("images/static/static2.png");
		Image static3 = loadImage("images/static/static3.png");
		Image static4 = loadImage("images/static/static4.png");
		Image static5 = loadImage("images/static/static5.png");
		Image static6 = loadImage("images/static/static6.png");
		Image static7 = loadImage("images/static/static7.png");
		Image static8 = loadImage("images/static/static8.png");
		Image static9 = loadImage("images/static/static9.png");
		Image static10 = loadImage("images/static/static10.png");
		Image static11 = loadImage("images/static/static11.png");
		
		staticAnim = new Animate();
		
		staticAnim.addFrame(static1, 50);
		staticAnim.addFrame(static2, 50);
		staticAnim.addFrame(static3, 50);
		staticAnim.addFrame(static4, 50);
		staticAnim.addFrame(static5, 50);
		staticAnim.addFrame(static6, 50);
		staticAnim.addFrame(static7, 50);
		staticAnim.addFrame(static8, 50);
		staticAnim.addFrame(static9, 50);
		staticAnim.addFrame(static10, 50);
		staticAnim.addFrame(static11, 50);
		
	}
	
	public Image loadImage(String file) {
		return new ImageIcon(file).getImage();
	}
	
	public void animationLoop() {
		long startTime = System.currentTimeMillis();
		long currentTime = startTime;
		
		while (currentTime < startTime + screenTime) {
			long timePassed = System.currentTimeMillis() - currentTime;
			currentTime += timePassed;
			
			staticAnim.update(timePassed);
			
			Graphics2D g = screenManager.getGraphics();
			draw(g);
			g.dispose();
			screenManager.update();
			try {
				 Thread.sleep(20);
				 }
			catch (InterruptedException ex) { 
				
			}
		}
	}
	
	
	public void draw(Graphics g) {
		g.drawImage(testScreen, 0, 0, null);
		g.drawImage(staticAnim.getImage(), 0, 0, null);
	}
	
}
