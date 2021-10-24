import java.util.Scanner;
public class PusheenJ2 {
  public static void main(String[] args) {
    Scanner sl = new Scanner (System.in);
    int count = 0;
    int errors = 0;
    String pusheen = "pusheen";
    String input = sl.nextLine();
    sl.close();
    int num = pusheen.length();
    while (count < num) {
      char inputletter = input.charAt(count);
      char pusheenletter = pusheen.charAt(count);
      if (inputletter != pusheenletter) {
       errors ++; 
      }
      count ++;
    }
    System.out.println(errors);
  }// Main
}// Class