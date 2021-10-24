import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class SpriteTest extends JFrame{
	
	int screenTime = 5000; //Milliseconds
	boolean alive = true;
	ScreenManager screenManager;
	Sprite sprite;
	
	private DisplayMode allowedModes[] = {
			new DisplayMode(1920, 1080, 32, 144),
			new DisplayMode(1920, 1080, 32, 60),
			new DisplayMode(1280, 720, 32, 60)
	};
	
	public static void main(String[] args) {
		// Init Display
		SpriteTest screen = new SpriteTest();
		screen.run();
		
	}//main
	
	public void run() {
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
		Image dvd1 = loadImage("images/DVD/DVD1.png");
		Image dvd2 = loadImage("images/DVD/DVD2.png");
		Image dvd3 = loadImage("images/DVD/DVD3.png");
		Image dvd4 = loadImage("images/DVD/DVD4.png");
		Image dvd5 = loadImage("images/DVD/DVD5.png");
		Animate dvdAnim = new Animate();
		
		dvdAnim.addFrame(dvd1, 50);
		dvdAnim.addFrame(dvd2, 50);
		dvdAnim.addFrame(dvd3, 50);
		dvdAnim.addFrame(dvd4, 50);
		dvdAnim.addFrame(dvd5, 50);
		
		sprite = new Sprite(dvdAnim);
		sprite.setDX((float)0.2);
		sprite.setDY((float)0.2);
	}
	
	public Image loadImage(String file) {
		return new ImageIcon(file).getImage();
	}
	
	public void animationLoop() {
		long startTime = System.currentTimeMillis();
		long currentTime = startTime;
		
//		while (currentTime < startTime + screenTime) {
		while (true) {
			long timePassed = System.currentTimeMillis() - currentTime;
			currentTime += timePassed;
			
			update(timePassed);
			
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
	
	public void update(long elapsedTime) {
		if (sprite.getX() < 0) {
			sprite.setDX(Math.abs(sprite.getDX()));
		} else if (sprite.getX() + sprite.getWidth() >= screenManager.getWidth()) {
			sprite.setDX(-Math.abs(sprite.getDX()));
		}
		 
		if (sprite.getY() < 0) {
			sprite.setDY(Math.abs(sprite.getDY()));
		} else if (sprite.getY() + sprite.getHeight() >= screenManager.getHeight()) {
			sprite.setDY(-Math.abs(sprite.getDY()));
		}

		sprite.update(elapsedTime);
	}
		 
	public void draw(Graphics g) {
		g.drawImage(testScreen, 0, 0, null);
		g.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()), null);
	}
	
}
