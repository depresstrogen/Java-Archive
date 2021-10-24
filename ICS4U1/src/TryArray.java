/**
 * 
 * @author Riley Power
 * @version November 23, 2020
 */
public class TryArray {
	public static void main(String[] args) {
		int [] numbers = new int[10];
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		
		System.out.println("Countdown");
		
		for(int i = numbers.length - 1; i >= 0; i--) {
			System.out.println(numbers[i]);
		}
		
		
//	Uncomment the following and it will count down in real time (i had nothing better to do)
		
//		long currentTime = System.currentTimeMillis();
//		long nextCount = System.currentTimeMillis() + 1000;
//		for(int i = numbers.length - 1; i >= 0; i--) {
//			while(currentTime < nextCount) {
//				currentTime = System.currentTimeMillis();
//			}
//			nextCount = System.currentTimeMillis() + 1000;
//			System.out.println(numbers[i] + " Seconds Remaining");
//		}
	}//Main
}//TryArray
