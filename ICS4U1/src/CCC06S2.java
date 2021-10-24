import java.util.Scanner;
public class CCC06S2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String decryptedMsg = sc.nextLine();
		String encryptedMsg = sc.nextLine();
		String unknownMsg = sc.nextLine();
		String solvedMsg = "";
		
		final int ASCII_A = 65;
		final int ASCII_SPACE = 32;
		
		char correctChar;
		char encryptedChar;
		
		
		//1-26 for letters, 27 for space
		char[] code = new char[27];
		
		
		for (int i = 0; i < decryptedMsg.length(); i++) {
			
			correctChar = decryptedMsg.charAt(i);
			encryptedChar = encryptedMsg.charAt(i);
			//if char is a space
			if (encryptedChar == 32) {
				code[code.length - 1] = encryptedChar;
			} else {
				code[encryptedChar - ASCII_A] = correctChar;
			}
		}
		
		for(int i = 0; i < unknownMsg.length(); i++) {
			
			encryptedChar = (char) (unknownMsg.charAt(i) - ASCII_A);
			
			correctChar = code[encryptedChar];
			if(correctChar == 0) {
				correctChar = '.';
			}
			
			solvedMsg = solvedMsg + correctChar;
		}
		
		System.out.println(solvedMsg);
		
	}
}
