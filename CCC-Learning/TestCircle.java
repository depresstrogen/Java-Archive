
public class TestCircle {

	public static void main(String[] args) {
		Circle spot = new Circle(10);
		Circle dot = new Circle(69);
		System.out.println("Circle radius: " + spot.getRadius());
		System.out.println("Circle area: " + spot.area());
		System.out.println("Circle circumference: " + spot.circumference());
		System.out.println();
		System.out.println("Circle radius: " + dot.getRadius());
		System.out.println("Circle area: " + dot.area());
		System.out.println("Circle circumference: " + dot.circumference());
		Circle.printAreaFormula();
		System.out.println();
		if (spot.equals(dot)) {
			System.out.println("Same lol");
		} else {
			System.out.println("Not Stonks");
		}
		System.out.println(spot);
		System.out.println(dot);
	}

}
