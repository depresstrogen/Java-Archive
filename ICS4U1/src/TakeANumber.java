import java.util.Scanner;
public class TakeANumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int currentNum = sc.nextInt();
		String type = "notStarted";
		int studentsLate = 0;
		int inLine = 0;
		boolean loopControl = true;
		while(loopControl) {
			type = sc.nextLine();
			if(type.equals("TAKE")) {
				currentNum ++;
				studentsLate ++;
				inLine ++;
				if (currentNum > 999) {
					currentNum = 1;
				}
			} else if (type.equals("SERVE")) {
				inLine --;
			} else if (type.equals("CLOSE")) {
				System.out.println(studentsLate + " " + inLine + " " + currentNum);
				studentsLate = 0;
				inLine = 0;
			} else if (type.equals("EOF")) {
				loopControl = false;
			}
		}
	}//Main
}//TakeANumber
