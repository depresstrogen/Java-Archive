import java.util.Scanner;
public class AA0Pro {
	public static void main(String[] args) {
		String currentName;
		String currentChar;
		String message = "";
		Scanner sc = new Scanner(System.in);
		int numNames = sc.nextInt();
		for (int i = 0; i <= numNames; i++) {
			currentName = sc.nextLine();
			for (int j = 0; j < currentName.length(); j++) {
				currentChar = currentName.substring(j, j + 1).toLowerCase();
				switch(currentChar) {
				case "a":
					message = "Hi! ";
					break;
				case "e":
					message = "Bye! ";
					break;
				case "i":
					message = "How are you? ";
					break;
				case "o":
					message = "Follow me! ";
					break;
				case "u":
					message = "Help! ";
					break;
				case "0":
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
					message = "Yes! ";
					break;
				default:
					break;
				}
				System.out.print(message);
				message = "";
			}
			System.out.println();
			message = "";
			currentName = "";
		}
	}
}
