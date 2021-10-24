import java.util.Scanner;
public class NineNineSixSix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		char[] allowed = {'0', '1', '8'};
		char[][] flip = {{'6', '9'} , {'9', '6'}};
		
		int count = 0;
		
		for(int i = a; i <= b; i++) {
			String num = Integer.toString(i);
			
			boolean legit = false;
			int numHalf = (int) ((num.length() / 2.0) + 0.5);
			
			for (int j = 0; j < numHalf; j++) {
				legit = false;
				char left = num.charAt(j);
				char right = num.charAt(num.length() - j - 1);
				
				for(int g = 0; g < allowed.length; g++) {
					if(left == allowed[g] && right == allowed[g]) {
						legit = true;
					}
					//System.out.print("Allowed = " + legit + " ");
				}
				
				if (!legit) {
					for(int g = 0; g < flip.length; g++) {
						if(left == flip[0][g] && right == flip[1][g]) {
							legit = true;
						}
						
					}
					//System.out.print(" Flip = " + legit + " ");
					
				}
				
				if (!legit) {
					j = num.length();
				}
			}
			
			if(legit) {
				count ++;
			}
			//Prints every num
			//System.out.println(i + " " + legit);
		}
		System.out.println(count);
	}
}
