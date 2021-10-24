import java.util.Scanner;
public class Prime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] primes = new int[200000];
		int tests = sc.nextInt();
		int numToCheck = 0;
		int testNum = 0;
		int currentNum = 2;
		int currentIndex = 0;
		boolean prime = true;
		int numsToCheck[] = new int[tests];
		for (int i = 0; i < tests; i++) {
			numsToCheck[i] = sc.nextInt();
		}
		for (int i = 0; i < tests; i++) {
			if (numsToCheck[i] > testNum) {
				testNum = numsToCheck[i];
			}
		}
		testNum = testNum * 2 + 1;
		for (int h = 2; h < 1000; h++) {
			for (int i = 2; i < currentNum; i ++) {
				if (currentNum % i == 0) {
					prime = false;
				}
			}
			if (prime == true) {
				primes[currentIndex] = currentNum;
				currentIndex ++;
			}
			prime = true;
			currentNum ++;
		}
		
		for (int g = 0; g < tests; g ++) {
			numToCheck = numsToCheck[g];
			currentNum = 2;
			currentIndex = 0;
			prime = true;
			
			for (int i = 0; i < currentIndex; i++) {
				for (int j = 0; j < currentIndex; j++) {
					if ((double)(primes[i] + primes[j]) / 2 == numToCheck) {
						System.out.println("" + primes[i] + " " + primes[j]);
						j = currentIndex;
						i = currentIndex;
					}
				}
			}
			
		}
		
	}
}
