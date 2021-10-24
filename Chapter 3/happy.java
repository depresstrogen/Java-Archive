import java.util.Scanner;
public class happy {
  public static void main(String[] args) {
    Scanner sl = new Scanner (System.in);
    int count = 0, happy = 0, sad = 0;
    String input = sl.nextLine();
    sl.close();
    int num = input.length ();
    while (count < num - 2) {
      char lettera = input.charAt(count);
      char letterb = input.charAt(count + 1);
      char letterc = input.charAt(count + 2);
      String letters = "" + lettera + letterb + letterc;
      if (letters.equals(":-)")) {
        happy ++;
      } else if (letters.equals(":-(")) {
        sad ++;
      }
      System.out.print(letters + " ");
      count ++;
    }
    System.out.println("\n" + "# of sad faces is " + sad);
    System.out.println("# of happy faces is " + happy);
    if (happy != 0 || sad != 0) {
      if (happy > sad) {
        System.out.println("happy");
      } else if (happy < sad) {
        System.out.println("sad");
      } else {
        System.out.println("unsure");
      }
    }
    else {
      System.out.println("none");
    }
  }// Main
}// Class