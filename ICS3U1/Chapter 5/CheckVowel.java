/**
 * Riley Power
 * November 25 2019
 */
import java.util.Scanner;
public class CheckVowel {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String letter = sc.next();
    switch(letter.charAt(0)) {
      case 'a':
      case 'A':
      case 'e':
      case 'E':
      case 'i':
      case 'I':
      case 'o':
      case 'O':
      case 'u':
      case 'U':
        System.out.println("Vowel");
        break;
      default:
        System.out.println("Not Vowel");
    }
  }
}