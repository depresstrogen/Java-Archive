import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		int len = sc.nextInt();
		day--;
		int curCol = day;
		System.out.print("Sun Mon Tue Wed Thr Fri Sat\n");
		for (int i = 0; i < day; i++) {
			System.out.print("    ");
		}
		for (int i = 1; i <= len; i++) {
			String toArr = "";
			if (curCol == 7) {
				curCol = 0;
				System.out.println();
			}
			if (i < 10) {
				System.out.print("  ");
			} else {
				System.out.print(" ");
			}
			System.out.print(i);
			if (curCol != 6 && i != len) {
				System.out.print(" ");
			}
			curCol++;
			System.out.print(toArr);
		}
		System.out.println();
	}
}
