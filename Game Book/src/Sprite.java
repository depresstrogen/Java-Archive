import java.awt.*;
public class Sprite {
	public Animate animation;
	// Coordinates
	public float x;
	public float y;
	//Velocity
	public float dx;
	public float dy;
	
	public Sprite(Animate animation) {
		this.animation = animation;
	}
	
	public void update(long elapsedTime) {
		x += dx * elapsedTime;
		y += dy * elapsedTime;
		animation.update(elapsedTime);
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public int getWidth() {
		return animation.getImage().getWidth(null);
	}
	
	public int getHeight() {
		return animation.getImage().getHeight(null);
	}
	
	public float getDX() {
		return dx;
	}
	
	public float getDY() {
		return dy;
	}
	
	public void setDX(float dx) {
		this.dx = dx;
	}
	
	public void setDY(float dy) {
		this.dy = dy;
	}
	
	public Image getImage() {
		return animation.getImage();
	}
}
