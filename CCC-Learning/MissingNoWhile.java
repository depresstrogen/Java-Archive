import java.util.Scanner;

public class MissingNoWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x ++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int total = 0;

			for (int i = 1; i <= n; i++) {
				total += i;
				
			}
			System.out.println(total);
			
			int difference = total - s;

			int ans = 0;
			int ansCount = 0;
			for (int i = 1; i <= n; i++) {
				for(int j = i; j <= n; j++) {
					if (j + i == difference && j != i) {
						System.out.print(j + " " + i + " ");
						ans = (j - i + 1) / 2;
						
						//System.out.println("  " + ((j + i - 1) / 2));
						ansCount++;
						i = difference + 1;
						j = difference + 1;
						
					}
				}
			}

			System.out.println(ans);
		}
	}
}