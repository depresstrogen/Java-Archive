import java.util.Scanner;
public class Triv {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		String answer = "yes";
		if (a + b <= c) {
			answer = "no";
		} else if (b + c <= a) {
			answer = "no";
		} else if (a + c <= b) {
			answer = "no";
		}
		System.out.println(answer);
	}
}
