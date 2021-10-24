import java.util.Scanner;
public class Booling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean not = false;
		String value = "";
		String input = "";
		do {
			input = sc.next();
			if (input.equals("not")) {
				not = !not;
			} else {
				value = input;
			}
		} while (value.equals(""));
		if (not == true) {
			if (value.equals("True")) {
				value = "False";
			} else if (value.equals("False")) {
				value = "True";
			}
		}
		System.out.println(value);
	}
}