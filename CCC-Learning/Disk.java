
public class Disk extends Circle{
	private double thickness;
	
	public Disk(double r, double t) {
		super(r);
		thickness = t;
	}
	public void setThickness(double newThickness) {
		thickness = newThickness;;
	}
	
	public double getThickness() {
		return(thickness);
	}
	public double volume() {
		double v;
		v = super.area() * thickness;
		return(v);
	}
	
}
