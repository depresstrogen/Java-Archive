
//Boiling Water
import java.util.Scanner;

public class one {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int b = sc.nextInt();

		int p = (5 * b) - 400;

		System.out.println(p);

		if (b < 100) {
			System.out.println(1);
		} else if (b > 100) {
			System.out.println(-1);
		} else {
			System.out.println(0);
		}

	}
}
