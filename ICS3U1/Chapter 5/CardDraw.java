/**
 * Riley Power
 * November 29 2019
 */
public class CardDraw {
  public static void main(String[] args) {
    int draw;
    String value = "", suit = "";
    draw = (int) (52 * Math.random());
    switch (draw % 13) {
      case 0:
        value = "Ace";
        break;
      case 10:
        value = "Jack";
        break;
      case 11:
        value = "Queen";
        break;
      case 12:
        value = "King";
        break;
      default:
        value = "" + (draw % 13 + 1);
    }
    switch (draw / 13) {
      case 0:
        suit = "spades";
        break;
      case 1:
        suit = "hearts";
        break;
      case 2:
        suit = "clubs";
        break;
      case 3:
        suit = "diamonds";
        break;
    }
    System.out.println("You were dealt card: " + draw);
    System.out.println("This is the " + value + " of " + suit + ".");
  } // Main
} // Draw Card