import java.util.Scanner;
public class TPCalc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input the number of TP targets: ");
		int numTPs = sc.nextInt();
		sc.nextLine();
		System.out.print("Input position size (In coin): ");
		String sizeLength = sc.nextLine();
		double size = Double.parseDouble(sizeLength);
		int intSize = (int) size;
		
		int numSize = Double.toString(size).length();
		if (sizeLength.indexOf('.') == -1) {
			numSize -= 2;
		} else {
			numSize --;
		}
		System.out.print(numSize + "AA");
		int numLoops = (numTPs + 1) / 2;
		int arrCount = 0;
		double total = 0;
		double[] percents = new double[numTPs];
		double[] realNum = new double[numTPs];
		double multiplier = 0;
		for(int i = numLoops; i > 0; i--) {
			
			
			double percent = Math.sin(Math.toRadians(50 / i));
			double percentDiff = 1 - percent;
			double percentAdj = (percent / 1.9) + (percentDiff / 2) * 2;
			
			percents[i - 1] = percentAdj;
			percents[numTPs - i] = percentAdj;
			arrCount ++;
		}
		
		for (int i = 0; i < numTPs; i++) {
			total += percents[i];
		}
		
		multiplier = 100 / total;
		total = 0;
		
		//Convert to the currency you have
		for (int i = 0; i < numTPs; i++) {
			total += percents[i] * multiplier;
			double percentPos = percents[i] * multiplier;
			realNum[i] = size * percentPos / 100 ;
			System.out.println(size * percentPos / 100 );
		}
		double faketot = 0;
		for (int i = 0; i < numTPs; i++) {
			realNum[i] = (Math.round(realNum[i] * Math.pow(10, (numSize - 2))   )   ) / Math.pow(10, (numSize - 2));
			faketot += realNum[i];
			System.out.println(realNum[i]);
		}
		
		double fakeOffset = 100 - faketot;
		int ind = 0;
		System.out.println(faketot);
		
	}
}
