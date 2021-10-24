
public class Coin {
	private int faceUp;
	
	public int flipCoin() {
		faceUp = (int)(Math.random() * 2);
		return faceUp;
	}
	
}
