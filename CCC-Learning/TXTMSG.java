import java.util.Scanner;
public class TXTMSG {

	public static void main(String[] args) {
		String[] shortForm = { "CU", ":-)", ":-(", ";-)", ":-P", "(~.~)", "TA", "CCC", "CUZ", "TY", "YW", "TTYL" };
		String[] longForm = { "see you", "I'm happy", "I'm unhappy", "wink", "stick out my tongue", "sleepy",
				"totally awesome", "Canadian Computing Competition", "because", "thank-you", "you're welcome",
				"talk to you later"};
		
		Scanner sc = new Scanner(System.in);
		String msg;
		msg = sc.nextLine();
		while( msg.equals("TTYL") == false) {
			String print = null;
			for(int i = 0; i < shortForm.length; i++) {
				if (msg.equals(shortForm[i])) {
					print = longForm[i];
				}
			}
			if (print == null) {
				System.out.println(msg);
			} else {
				System.out.println(print);
			}
			msg = sc.nextLine();
		}
		System.out.println("talk to you later");
	}
}
