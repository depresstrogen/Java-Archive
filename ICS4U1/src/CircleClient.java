
public class CircleClient {
	public static void main(String[] args) {
		Circle spot = new Circle();
		
		spot.setRadius(3);
		System.out.println("Circle radius: " + spot.getRadius());
		System.out.println("Circle circumfrence: " + spot.circumference());
	}
}
