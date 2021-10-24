/**
 * Riley Power
 * December 12 2019
 */
import java.util.Scanner;
public class StringGang {
  public static void main(String[] args) {
    String phrase = "Your Mom";
    for (int i = phrase.length() - 1; i > 0; i --)
         System.out.print(phrase.charAt(i));
    System.out.println(phrase.length());
  }
}