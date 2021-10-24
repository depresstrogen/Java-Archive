
//Silent Auction
import java.util.Scanner;

public class two {
	public static void main(String[] args) {
		String winName = "";
		int winBid = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String name = "";
		int bid = 0;
		for (int i = 0; i < n; i++) {
			name = sc.nextLine();
			 bid = Integer.parseInt(sc.nextLine());
			
			if (bid > winBid) {
				winBid = bid;
				winName = name;
			}
		}
		System.out.println(winName);
	}
}
