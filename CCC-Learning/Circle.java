
public class Circle {
	private double radius;
	public Circle() {
		radius = 1;
	}
	
	public Circle(double r) {
		radius = r;
	}
	
	public void setRadius(double newRadius) {
		radius = newRadius;
	}
	
	public double area() {
		double circleArea;
		circleArea = Math.PI * radius * radius;
		return(circleArea);
	}
	
	public double circumference() {
		double circumference;
		circumference = radius * Math.PI * 2;
		return(circumference);
	}
	
	public double getRadius() {
		return(radius);
	}
	
	public boolean equals(Object c) {
		Circle testObj = (Circle)c;
		
		if (testObj.getRadius() == radius) {
			return(true);
		} else {
			return(false);
		}
	}
	
	public String toString() {
		String circleString;
		
		circleString = ("Circle has radius " + radius);
		return(circleString);
	}
	
	public static void printAreaFormula() {
		System.out.println("The formula for the area of a circle is a = Pi*r*r");
	}
}
