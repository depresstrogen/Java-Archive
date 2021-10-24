
//Secret Instructions
import java.util.Scanner;

public class three {
	public static void main(String[] args) {
		boolean loopy = true;
		Scanner sc = new Scanner(System.in);
		String lastDir = "";
		do {
			int instruct = sc.nextInt();
			int numA = instruct / 10000;
			int numB = instruct / 1000 % 10;
			int steps = instruct % 1000;
			String dir = "";
			if (instruct == 99999) {
				loopy = false;
			} else {
				if (numA + numB == 0) {
					dir = lastDir;
				} else if ((numA + numB) % 2 == 0) {
					dir = "right";
					lastDir = dir;
				} else if ((numA + numB) % 2 == 1) {
					dir = "left";
					lastDir = dir;
				}
				System.out.println(dir + " " + steps);
			}
			
		} while (loopy);
	}
}
