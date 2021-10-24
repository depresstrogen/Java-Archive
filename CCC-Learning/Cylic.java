import java.util.Scanner;
public class Cylic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String base = sc.nextLine();
		String cylic = sc.nextLine();
		String isCylic = "no";
		
		StringBuilder str = new StringBuilder(); 
		str.append(cylic);
		for(int i = 1; i <= cylic.length(); i++) {
			//System.out.println(str);
			
			if(base.indexOf(str.toString()) != -1) {
				isCylic = "yes";
				i = cylic.length();
			}
			
			str.setLength(0);
			str.append(cylic.substring(i));
			str.append(cylic.substring(0 , i));
		}
		
		System.out.println(isCylic);
		
	}

}
