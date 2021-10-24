/**
 * Riley Power
 * December 4 2019
 */

public class Craps{
  public static void main(String[] args) {
    int rollA, rollB;
    boolean hardOrEasy = false;
    String name = "";
    rollA = (int) ((6 - 1 + 1) * Math.random() + 1);
    rollB = (int) ((6 - 1 + 1) * Math.random() + 1);
    
    rollA = 4;
    rollB = 6;
    
    switch (rollA + rollB) {
      case 2:
        name = "Snake eyes";
        break;
      case 3:
        name = "Ace-Deuce";
        break;
      case 4:
        name = "four";
        hardOrEasy = true;
        break;
      case 5:
        name = "Fever Five";
        break;
      case 6:
        name = "six";
        hardOrEasy = true;
        break;
      case 7:
        name = "Lucky Seven";
        break;
      case 8:
        name = "eight";
        hardOrEasy = true;
        break;
      case 9:
        name = "Nina";
        break;
      case 10:
        name = "ten";
        hardOrEasy = true;
        break;
      case 11:
        name = "Yo";
        break;
      case 12:
        name = "Boxcars";
        break;
    }
    if (hardOrEasy == true && rollA == rollB) {
      name = "Hard " + name;
    } else if (hardOrEasy == true) {
      name = "Easy " + name;
    }
    System.out.println(rollA + " and " + rollB + ": " + name);
  }// Main
}// Craps