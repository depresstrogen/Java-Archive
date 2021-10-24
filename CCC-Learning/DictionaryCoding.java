import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCoding {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int loops = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < loops; i++) {
			boolean emptyLine = false;
			ArrayList<String> dic = new ArrayList<String>();
			while (!emptyLine) {
				String line = sc.nextLine();
				String newLine = "";
				if (line.equals("")) {
					emptyLine = true;
					System.out.println();
				} else {
					line += ' ';
					while (line.indexOf(' ') != -1) {
						String word = "";
						word = line.substring(0, line.indexOf(' '));
						line = line.substring(line.indexOf(' ') + 1);

						boolean inDic = false;
						
						for (int j = 0; j < dic.size(); j++) {
							if (word.equals(dic.get(j))) {
								newLine += (j + 1) + " ";
								inDic = true;
								j = dic.size();
							}
						}
						
						if (!inDic) {
							dic.add(word);
							newLine += word + " ";

						}
					}

					System.out.println(newLine.substring(0, newLine.length() - 1));
				}
			}
			dic.clear();
		}
	}

	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
