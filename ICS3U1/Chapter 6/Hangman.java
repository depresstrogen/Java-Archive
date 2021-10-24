import java.util.Scanner;
public class Hangman {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String phrase = "NSFW PHRASE";
    String puzzle = "";
    String temp = "";
    int index = 0;
    int wrong = 0;
    Boolean complete = false;
    int start = 0;
    for (int i = 0; i < phrase.length(); i++) {
      if (phrase.charAt(i) >= 65 && phrase.charAt(i) <= 91) {
        puzzle += "-";
      } else {
        puzzle += phrase.charAt(i);
      }
    }
    System.out.println(puzzle);
    do {
      System.out.println("Guess a letter");
      String letter = sc.next().toUpperCase();
      char guess = letter.charAt(0);
      index = -1;
      while (phrase.indexOf(guess, index + 1) != -1) {
        index = phrase.indexOf(guess, index + 1);
        temp += puzzle.substring(start, index);
        temp += letter;
        temp += puzzle.substring(index + 1);
        puzzle = temp;
        temp = "";
      }
      if (phrase.indexOf(guess, index + 1) == -1) {
        wrong ++;
      }
      System.out.println(puzzle);
      if (puzzle.equals(phrase)) {
        complete = true;
        System.out.println("You Win");
      }
      if (wrong > 6) {
        complete = true;
        System.out.println("You lose \nThe phrase was: " + phrase);
      }
    }while(!complete);
  }
}