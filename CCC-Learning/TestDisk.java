
public class TestDisk {
	public static void main(String[] args) {
		Disk floppy = new Disk(10, 0.02);
		
		System.out.println("Disk radius: " + floppy.getRadius());
		System.out.println("Disk area: " + floppy.area());
		System.out.println("Disk circumference: " + floppy.circumference());
		System.out.println("Disk Volume: " + floppy.volume());
	}
}
