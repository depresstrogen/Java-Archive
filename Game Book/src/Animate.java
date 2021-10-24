import java.awt.Image;
import java.util.ArrayList;


public class Animate {
	private ArrayList frames;
	private int frameNum;
	private long currentTime;
	private long totalDuration;
	
	public Animate() {
		frames = new ArrayList();
		totalDuration = 0;
		start();
	}
	
	public synchronized void addFrame(Image image, long duration) {
		totalDuration += duration;
		frames.add(new AnimateFrame(image, totalDuration));
	}
	
	public synchronized void start() {
		currentTime = 0;
		frameNum = 0;
	}

	public synchronized void update(long elapsedTime) {
		if (frames.size() > 1) {
			currentTime += elapsedTime;
			if (currentTime > totalDuration) {
				currentTime = currentTime % totalDuration;
				frameNum = 0;
			}
			
			while (currentTime > getFrame(frameNum).endTime) {
				frameNum ++;
			}
		}
	}
	public synchronized Image getImage() {
		if (frames.size() == 0) {
			return null;
		} else {
			return getFrame(frameNum).image;
		}
	}
	
	private AnimateFrame getFrame(int i) {
		return (AnimateFrame)frames.get(i);
	}
	
}
